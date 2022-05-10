#!/usr/local/bin/bash


# TODO set bucket name
# TODO add validation for variables needed when service is going public
# TODO is there no problem of having same domain and subdomain in test and prod cluster?

# -------------CONFIG---------------
# name should contain prefix "wag-"
CONFIG_SERVICE_NAME=wag-content-service
CONFIG_BOUNDED_CONTEXT=cms

CONFIG_USES_SERVICEDB=true
CONFIG_USES_GRAYLOG=true
CONFIG_USES_REDIS=true
CONFIG_USES_OTHER_SERVICE=true
CONFIG_USES_S3_BUCKET=true

# REQUIRED IF CONFIG_USES_S3 BUCKET IS SET TO TRUE
CONFIG_TEST_S3_BUCKET_NAME="imageserverbucket-test"
CONFIG_PROD_S3_BUCKET_NAME="imageserverbucket"


#REQUIRED IF CONFIG_USES_OTHER_SERVICE IS SET TO TRUE. SPECIFY USED SERVICES AND IT'S DOMAINS IN FOLLOWING FORMAT: 
# 'service_1_name=service1domain|service2name=service-2-domain|service3name=service-3domain'
CONFIG_USED_SERVICES='authservice=authservice.wag.tools|frontendservice=frontend.wag.tools'

CONFIG_SERVICE_HEALTHCHECK_ENDPOINT=/contentservice/healthcheck

CONFIG_CLOUDFLARE_SUBDOMAIN="content-service"

CONFIG_IS_PUBLIC=true

# -------------DEFAULT VARS USED BY THE SCRIPT---------------
VAR_IMAGE_NAME=${CONFIG_SERVICE_NAME}

# SECRETS-DO NOT PUSH INTO github
VAR_CLOUDFLARE_EMAIL=email
VAR_CLOUDFLARE_API_KEY=password

VAR_CLUSTER_ID=main

VAR_TEST_AWS_ACCOUNT_ID=964371087206
VAR_PROD_AWS_ACCOUNT_ID=533026789209

VAR_TEST_REPLICAS_NUMBER=1
VAR_PROD_REPLICAS_NUMBER=3

VAR_CLOUDFLARE_DOMAIN=wag.tools

VAR_REGION=eu-central-1

VAR_SERVICEDB_NAME=service_db
VAR_SERVICEDB_DOMAIN_NAME=servicedb.main.local
VAR_SERVICEDB_PORT=3306

VAR_GRAYLOG_NAME=graylog
VAR_GRAYLOG_DOMAIN_NAME=logging.whiteaway.com
VAR_GRAYLOG_PORT=12201

VAR_REDIS_TEST_VPC_ID=\"vpc-0f3ce1762789e41dc\"
VAR_REDIS_PROD_VPC_ID=\"vpc-0bcddff35d32be4b1\"
VAR_REDIS_TEST_SUBNET_IDS=[\"subnet-087a41e3e6f193601\",\"subnet-0959a46ca7b5ca017\"]
VAR_REDIS_PROD_SUBNET_IDS=[\"subnet-0d6dc22c830f4c2a3\",\"subnet-09b298c228604ed1f\"]
VAR_REDIS_CLUSTER_NAME=${CONFIG_SERVICE_NAME}-redis-cluster

VAR_REDIS_NAME=redis
VAR_REDIS_DOMAIN_NAME=aws_elasticache_cluster.${VAR_REDIS_CLUSTER_NAME}.cluster_address
VAR_REDIS_PORT=6379

VAR_SERVICE_NAME=service
VAR_SERVICE_DOMAIN_NAME=
VAR_SERVICE_PORT=80

VAR_S3_BUCKET_NAME=s3_bucket
VAR_S3_BUCKET_PORT=443
VAR_S3_BUCKET_DOMAIN_NAME="{aws_s3_bucket.s3_bucket.bucket}.s3.{var.region}.amazonaws.com"

# -------------DEFAULT VERSIONS---------------
VAR_TERRAFORM_PROVIDER_AWS_VERSION="~> 3.70.0"
VAR_TERRAFORM_PROVIDER_CLOUDFLARE_VERSION="~> 3.10.1"
VAR_TERRAFORM_REQURED_PROVIDERS_VERSION=">= 0.14"

VAR_TERRAFORM_KUBERNETES_MODULE_VERION=v1.1.10
VAR_TERRAFORM_EGRESS_MODULE_VERSION=v1.1.0

# specify separator between elements for string array
IFS='|'

# -------------INPUT VALIDATION---------------
if [ "$CONFIG_IS_PUBLIC" = true ]; then
  if [ -z "$VAR_CLOUDFLARE_DOMAIN" ]; then
    printf '%s\n' "The cloudflare domain and subdomain variable is required if service is public" >&2
  exit 1   
  fi

  if [ -z "$CONFIG_CLOUDFLARE_SUBDOMAIN" ]; then
    printf '%s\n' "The cloudflare domain and subdomain variable is required if service is public" >&2
  exit 1   
  fi
fi

mkdir infrastructure
cd infrastructure

touch .gitignore
cat << 'EOF' > ./.gitignore
terraform.tfvars
terraform
EOF

mkdir common

cd common

# -------------PROVIDERS.TF CREATION---------------
touch providers.tf
cat << EOF > providers.tf
provider "cloudflare" {
  email   = var.cloudflare_email
  api_key = var.cloudflare_api_key
}
EOF

# -------------VERSIONS.TF CREATION---------------
touch versions.tf

cat << EOF > versions.tf
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "${VAR_TERRAFORM_PROVIDER_AWS_VERSION}"
    }
    cloudflare = {
      source  = "cloudflare/cloudflare"
      version = "${VAR_TERRAFORM_PROVIDER_CLOUDFLARE_VERSION}"
    }
  }
  required_version = "${VAR_TERRAFORM_REQURED_PROVIDERS_VERSION}"
}

EOF

# -------------K8 FILE CREATION---------------
createK8file() {

  ifPublicCode() {
      if [ "$CONFIG_IS_PUBLIC" = true ]; then
  cat <<EOF
public                = true
  cloudflare_domain     = "${VAR_CLOUDFLARE_DOMAIN}"
  cloudflare_subdomain  = "$CONFIG_CLOUDFLARE_SUBDOMAIN"
EOF
      fi
  }

touch k8.tf

  cat << EOF >> k8.tf 
locals {
  service_name = "${CONFIG_SERVICE_NAME}"
  bounded_context = "${CONFIG_BOUNDED_CONTEXT}"
  cluster_id      = "${VAR_CLUSTER_ID}"
}

data "aws_eks_cluster" "cluster" {
  name = local.cluster_id
}

data "aws_eks_cluster_auth" "cluster" {
  name = local.cluster_id
}

provider "kubernetes" {
  host                   = data.aws_eks_cluster.cluster.endpoint
  cluster_ca_certificate = base64decode(data.aws_eks_cluster.cluster.certificate_authority[0].data)
  token                  = data.aws_eks_cluster_auth.cluster.token
}

module "service" {
  source                = "git@github.com:whiteaway/infrastructure-terraform-modules.git//kubernetes_service?ref=kubernetes_service-${VAR_TERRAFORM_KUBERNETES_MODULE_VERION}"
  liveness_path         = "${CONFIG_SERVICE_HEALTHCHECK_ENDPOINT}"
  name                  = local.service_name
  bounded_context       = local.bounded_context
  container_image       = "\${var.account_id}.dkr.ecr.\${var.region}.amazonaws.com/\${aws_ecr_repository.${VAR_IMAGE_NAME//-/_}_ecr.name}:\${var.image_tag}"
  replicas              = var.replicas_number
  $(ifPublicCode)
}
EOF

  addEgress() {
    eval name="$1"
    eval domain_name="$2"
    eval port="$3"

    cat << EOF >> k8.tf

module "allow_${name}" {
  source      = "git@github.com:whiteaway/infrastructure-terraform-modules.git//network-policy-egress?ref=network-policy-egress-${VAR_TERRAFORM_EGRESS_MODULE_VERSION}"
  policy_name = "\${local.service_name}-allow-${name//_/-}"
  bc          = local.bounded_context
  egress_fqdn = ${domain_name}
  egress_ports= [${port}]
  labels      = { app = local.service_name }
}
EOF
}


# -------------ADDITIONAL EGRESSES GENERATION---------------
# You have to use '\"' if you want to wrap the variable into quotes. I couldn't find a better way how to do this.
  if [ "$CONFIG_USES_SERVICEDB" = true ] ; then addEgress ${VAR_SERVICEDB_NAME} '\"'$VAR_SERVICEDB_DOMAIN_NAME'\"' ${VAR_SERVICEDB_PORT}; fi
  if [ "$CONFIG_USES_GRAYLOG" = true ] ; then addEgress ${VAR_GRAYLOG_NAME} '\"'$VAR_GRAYLOG_DOMAIN_NAME'\"' ${VAR_GRAYLOG_PORT}; fi
  if [ "$CONFIG_USES_REDIS" = true ] ; then addEgress ${VAR_REDIS_NAME} $VAR_REDIS_DOMAIN_NAME ${VAR_REDIS_PORT}; fi
  if [ "$CONFIG_USES_S3_BUCKET" = true ] ; then addEgress ${VAR_S3_BUCKET_NAME} "${VAR_S3_BUCKET_DOMAIN_NAME}" ${VAR_S3_BUCKET_PORT}; fi
  if [ "$CONFIG_USES_OTHER_SERVICE" = true ] ; then
    for pair in $CONFIG_USED_SERVICES
    do
      IFS== read name domain  <<< "$pair"
      addEgress "$name" "var.${name}_dns" "80"; 
    done 
  fi

# -------------CREATE S3 BUCKET IF USED---------------
createBucket() {
touch s3.tf


cat << EOF >> s3.tf
resource "aws_s3_bucket" "${VAR_S3_BUCKET_NAME//-/_}" {
  bucket = var.${VAR_S3_BUCKET_NAME}

  tags = {
    Name        = "${VAR_S3_BUCKET_NAME}"
    app         = "${CONFIG_SERVICE_NAME}"
  }
}
EOF
}
  if [ "$CONFIG_USES_S3_BUCKET" = true ] ; then createBucket; fi
}

createK8file

# -------------REDIS CREATION---------------
if [ "$CONFIG_USES_REDIS" = true ] ; then 
 touch redis.tf
 CLUSTER_NAME="${VAR_REDIS_CLUSTER_NAME}"
 cat << EOF >> redis.tf
locals {
  cluster_name = "\${local.service_name}-redis-cluster"
}

resource "aws_security_group" "${CLUSTER_NAME}-sg" {
  name_prefix = "\${local.cluster_name}-sg"
  vpc_id      = var.vpc_id

  ingress {
    from_port   = 6379
    to_port     = 6379
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    app   = local.service_name
    Name  = "\${local.cluster_name}-sg"
  }
}

resource "aws_elasticache_subnet_group" "${CLUSTER_NAME}-subnet-group" {
  name       = "\${local.cluster_name}-subnet-group"
  subnet_ids = var.subnet_ids
}

resource "aws_elasticache_cluster" "${CLUSTER_NAME}" {
  cluster_id           =  local.cluster_name
  engine               = "redis"
  node_type            = "cache.t3.micro"
  num_cache_nodes      = 1
  parameter_group_name = "default.redis3.2"
  engine_version       = "3.2.10"
  port                 = 6379
  subnet_group_name    = aws_elasticache_subnet_group.${CLUSTER_NAME}-subnet-group.name
  security_group_ids   = [aws_security_group.${CLUSTER_NAME}-sg.id]
  tags = {
    app  = local.service_name
    Name = local.cluster_name
  }
}

EOF
fi


# -------------ECR CREATION---------------
createEcrTf() {
  touch ecr.tf

  cat << EOF >> ecr.tf
resource "aws_ecr_repository" "${VAR_IMAGE_NAME//-/_}_ecr" {
  name                 = "${VAR_IMAGE_NAME}"
  image_tag_mutability = "MUTABLE"

  image_scanning_configuration {
    scan_on_push = true
  }
}
EOF
}

createEcrTf

# -------------PROD AND TEST FOLDER CREATION---------------
touch variables.tf

addVariable () {
  variable=$1
  echo "variable \"${variable}\" {}"
}

checkOtherVariablesFile() {
  if [ $CONFIG_USES_S3_BUCKET = true ]; then addVariable "${VAR_S3_BUCKET_NAME}"; fi
  if [[ $CONFIG_USES_REDIS = true ]]; then addVariable "vpc_id"; addVariable "subnet_ids";fi
    for pair in $CONFIG_USED_SERVICES
    do
      IFS== read name domain  <<< "$pair"
      addVariable "${name}_dns"; 
    done 
}

cat << EOF >> variables.tf
variable "account_id" {}
variable "image_tag" {}
variable "cloudflare_email" {}
variable "cloudflare_api_key" {}
variable "region" {}
variable "replicas_number" {} 
$(checkOtherVariablesFile)
EOF

cd ..

# -------------PROD AND TEST FOLDER CREATION---------------
createFolder () {
 environment=$1
 
 mkdir $environment
 cd $environment
# -------------SIMLINKS CREATION---------------
 ln -s ../common/providers.tf providers.tf
 ln -s ../common/versions.tf versions.tf
 ln -s ../common/k8.tf k8.tf
 ln -s ../common/variables.tf variables.tf
 ln -s ../common/ecr.tf ecr.tf
 $(if [ $CONFIG_USES_S3_BUCKET = true ]; then ln -s ../common/s3.tf s3.tf; fi)
 $(if [ $CONFIG_USES_REDIS = true ]; then ln -s ../common/redis.tf redis.tf; fi)
 

# -------------AUTO.TFVARS FILE CREATION---------------
touch ${environment}.auto.tfvars

checkOtherVars() {
  if [[ ${CONFIG_USES_S3_BUCKET} = true ]]; then
    if [ ${environment} = "prod" ]; then 
      echo "$VAR_S3_BUCKET_NAME       = \"${CONFIG_PROD_S3_BUCKET_NAME}\"";
    else
      echo "$VAR_S3_BUCKET_NAME       = \"${CONFIG_TEST_S3_BUCKET_NAME}\"";
    fi
  fi

  if [[ ${CONFIG_USES_REDIS} = true ]]; then
    if [ ${environment} = "prod" ]; then 
      echo "vpc_id          = ${VAR_REDIS_PROD_VPC_ID}";
      echo "subnet_ids      = ${VAR_REDIS_PROD_SUBNET_IDS}";
    else
      echo "vpc_id          = ${VAR_REDIS_TEST_VPC_ID}";
      echo "subnet_ids      = ${VAR_REDIS_TEST_SUBNET_IDS}";
    fi
  fi
  for pair in $CONFIG_USED_SERVICES
    do
      IFS== read name domain  <<< "$pair"
      echo ""$name"_dns          = $domain";
    done 
}

cat << EOF > ${environment}.auto.tfvars
account_id      = "$(if [ ${environment} = "prod" ]; then echo ${VAR_PROD_AWS_ACCOUNT_ID}; else echo ${VAR_TEST_AWS_ACCOUNT_ID}; fi)"
region          = "${VAR_REGION}"
replicas_number = "$(if [ ${environment} = "prod" ]; then echo ${VAR_PROD_REPLICAS_NUMBER}; else echo ${VAR_TEST_REPLICAS_NUMBER}; fi)"
$(checkOtherVars)
EOF

# -------------MAIN.TF CREATION---------------
touch main.tf

cat << EOF > main.tf
terraform {
  backend "s3" {
    encrypt        = true
    bucket         = "wag-terraform-state$( if [ ${environment} = "test" ]; then echo "-test"; fi)"
    region         = "${VAR_REGION}"
    profile        = "wag-${environment}"
    dynamodb_table = "terraform-state-lock"
    key            = "$( if [ ${environment} = "prod" ]; then echo "tfstate/"; fi)${CONFIG_SERVICE_NAME}"
  }
}

provider "aws" {
  region  = "${VAR_REGION}"
  profile = "wag-${environment}"
}
EOF

# -------------TERRAFORM.TFVARS CREATION---------------
touch terraform.tfvars
 
cat << EOF > terraform.tfvars
cloudflare_email = "${VAR_CLOUDFLARE_EMAIL}"
cloudflare_api_key= "${VAR_CLOUDFLARE_API_KEY}"
EOF

cd ..
}

createFolder test
createFolder prod
