---
hide:
 - navigation
---

# Supervised learning Problem
* Y - Dependent variable - outcome measurement
* X - Independent variables - input variables
* Regression problem - Y is quantitative
* Classification - Y takes in a finite unordered set
* Training data - observations of the measurements that are used for training the data
## Objectives
* Accurately predict unseen test cases
* Understand which inputs affect the outcome and how
* Assess the quality of our prediction and inferences
# Unsupervised Learning
* No outcome variable, just a set of predictors - features - measured on a set of samples
* Difficult to know how well we are doing
* Different from supervised learning, but can be useful for it
# The netflix problem
* Sparse training data - 98%
* Objective is to predict rating for set of 1 milion customer-movie pairs that are missing in the data
* It is both supervised and unsupervised learning. We can create the missing training data with supervised learning and then user it to train unsupervised model

# Machine Learning vs Statistical Learning
* Machine Learning is a subfield of Artificial Intelligence
* Statistical learning is a subfield of statistics
* There is much overlap - both fields focus on supervised and unsupervised problems
	* Machine Learning problem jas a greater emphasis on a large scale applications and prediction accuracy
	* Statistical learning emphasizes models and their interpretability and precision and uncertainty
* The distinction is very blurred

# Notation
* X = (x1, x2, x3)
* Y = f(X) + e
* e captures measurement errors and other discrepancies
* f(x) is used to make predictions of T at new points X = x

# Regression function
* We can understand which components of X = (x1, x2, ..., xn) are important explaining Y and which are irrelevant
* Depending of complexity of f, we may be able to understand how each component of $X_k$ of X affects Y
$$
f(4)=E(Y|X=4)
$$
* Means expected value of Y given X = 4
* The ideal f(x) is called the regression function
* The regression function is also defined for vector X
$$
f(x) = f(x1, x2, x3) = E(Y|X_1 = x_1, X_2 = x_2, X_3 = x_3)
$$
* Ideal or optimal predictor of Y with regard to mean-squared prediction error: f(x) = E(Y|X = x) is the function that minimizess E[(Y - g (X)^2 | X=x)] over all function g at all points X=x
* e=Y-f(x) is irreductible error - even if we knew f(x) we would still make errors in prediction, since at each X = x there is typically a distribution of possible Y values

## p-Value
* 

## Bias
* Degree to which model's prediction differ from the true values of the underlying function that generated the data
* It can lead to underfitting, where the model is too simple and fails to capture the complexity of the data, result in poor performance on both the training data and testing data
* Low value good, high value bad

## Variance
* Degree to which a model's predictions vary for different training sets or samples of data
* It can lead to overfitting, where the model is too complex and fits the noise of the data
* Resulting in good performance on training data but poor results on test data
* Low value good, high value bad

# How to estimate f
## K-Neighbours
* Often we do not have any data point on a specific X exactly
* Therefore we cannot compute E(Y|X=x)!
* Therefore we can use k-neighbourhood method that allows us to find the y based on a average of number of closest points
* Nearest neighbour can be lousy when p is large - curse of dimensionality - nearest enghbours tendo the be far away in high dimensions
* We need reasonable fraction of N values of $y_i$ to abring the average the variance down e.g. 10%

## Parametric approach vs non-parametric
* These are two main approaches for choosing machine learning models

#### Parametric
* Assumes that data follows specific distribution and that parameters can be estimated from the data
* Examples
	* Linear Regression
	* Quadratic Regression
* Steps
	1. We make assumption about the functional form or shape of f - for example linear
	2. Second, we estimate the parameters by fitting the model to training data
* They
	* are well-established
	* having well-understood properties
	* can lead to more accurate predicitions
	* are sensitive to violations of the assumptions of the data distribution

### Non-Parametric
* Makes no assumptions of the underlying distribution of the data
* Do not rely on estimating specific parameters
* Thery rely on data drive algorithms to model the relationship between input and output variables
* Examples
	* Decision trees
	* K-nearest neighbours
* They
	* are more flexible
	* require large sample sizes to achieve accuracy
	* are harder to interpret and explain
	* are more prone to overfitting

## Assesing Model Accuracy
* MSE
	* Is used to compute accuraccy
	* Average Squared Error
	* $MSE_Tr=Ave_ieTr[y_i-f(x_i)]^2$
* Used for both training data and test data
* It is important to compute both to see what is the difference in MSE for training and validation data - this way we can see what is MSE for data that has not been seen by the model

# Classification Problems
* The response variable Y is qualitative - email is one of from the list - e.g. \[spam, non-spam\]
* The goals are to
	* Build a classifier that assigns a class label from C to a future unlabeled observation X
	* Assess the uncertainity in each classification
	* Understand the roles of the different predictors among $X = (X_1, X_2, ..., X_p)$
## Bayes Optimal Classifier
* Suposse the K elements in C are numbered 1, 2, ..., K
* Let p_k = Pr(y=k|X=x), k = 1, 2, ... K
* These are conditional class probabilities at x
$C(x) = j if p_j(x) = max(p_1(x), p_2(x), ..., p(x))$
* Nearest-neighbour averaging can be used as before
* Also, breaks down as dimension grows
* However C(x) is less than on pk,k = 1,...,K

## Nearest Neighbour Method
* Nearest Neighnout method can be used as before
* This breaks down as dimension


# Linear Regression
* Simple approach to supervised learning
* Assumes dependence of Y on X1, X2, X3,...,Xp is linear
* True regression functions are never linear
* It is extremely useful conceptually and practically
* We assume $Y=\beta_0 + \beta_1X + \epsilon$
* Where $\beta_0$ and $\beta_1$ are two unknown constants that represents intercept and slope - parameters
* $y$^ indicates prediction of Y on teh basis of X = x - hat symbol denotes an estimated value
* Residual: $e_i = y_i - \hat{y_i}$  - respresents i th residual
* Residual Sum of Squares: $RSS=e^2_1 + e^2_2 + ... + e^2_n$
* RSS = MSE / degrees of freedom

# Hypothesis Testing
* Standard erros can be used ot perform hypothesis tests on the coefficients
* The most common hypothesis test involves testing the null hypothesis of
	* $H_0$ - There is not relationship between X and Y versus alternative hypothesis
	* $H_A$ - Alternative Hypothesis - There  is some relationship between X and Y
* Matematically, the above corresponds to
	* $H_0:\beta_1=0$ 
	* $H_A: \beta_1 \neq  0$  

# Forward Selection
* Here we care about the models with the lowest RSS
1. Begin with null model - model that contains an intercept but no predictors
2. Fit *p* simple linear regression and add to the null model the variable that results in the lowest RSS
3. Add to that model variables that results in the lowest RSS amongst all two-variable models
4. Continue until some stopping rule is satisfied - for example when all remaining variables have p-value above some threshold
# Backward Selection
* Here we care about the p-value of predictors
1. Start with all variables in the model
2. Remove variable with the largest p-value, that is the variable least statistically significant
3. New p-1 variable model is fit and the variable with the largest p-value is removed
4. Continue until stopping rule is reached - for instance we may stop when all remaining variables have significant p-value by some significance threshold

# Differences between forward and backward
* Forward
	* Starts with empty set of features
	* Searches through all possible subsets of features that contain already selected features
	* More efficient if number of samples is much larger
* Backward
	* Starts with all available features
	* Searches through all possible subsets of features that do not contain the features that have been removed
	* More efficient if the number of features is small

# Qualitative Predictors
## Binary
* Example - investigate differences in credit card balance between males and gemales, ignroing the other variables
* New variable is created - x_i=1 if i th person is female, 0 if the i th person is male
![[Pasted image 20230422191848.png]]


## Predictors with more than two levels
* Create additional dummy variables - for ethnicity we creat two dummy variables
* x_i1 { 1 if i th person is Asian, 0 if i th person is not Asian
* x_i2 { 1 if i th person is not Causian, 0 if i th person is not Caucasian
![[Pasted image 20230422191902.png]]
* Result
![[Pasted image 20230422192916.png]]

# Interactions between qualitative and quantitative variables
![[Pasted image 20230422193048.png]]

# Outliers
* Point, for which $y_i$ is far from the value predicted by the model

# High Leverage points
* Obervation with high leverage has an unusual value for $x_i$

# Classification
* The goal is to predict a values that is part of unordered set C
* Example: 
	* eye color e { borw, blue, green }
	* email e { spam, ham }
* Given a feature vector X and qualitative response Y, the goal is to build function C(X) that take as input the feature vector X and predicts its value for Y
* Often we are more interested in estimating that X belongs to each category in C

## Linear Regression
* Linear regression might produce probabilities less than 0 or bigger than one - but we need value between 0 and 1

## Logistic Regression
* Expands Linear regression to result in values between 0 and 1, by using eurlers number
![[Pasted image 20230422203919.png]]
![[Pasted image 20230422203927.png]]
* We can use maximum likelihood to estimate the parameters
* ![[Pasted image 20230422204037.png]]
# Logistic regression
* The method used for the analysing dataset, in which there are one of more independent variables that determine the outcome - mostly binary, but can also output to multiple classes
* Supervised learning technique
### Binary prediction
* The output variable represents 0 / 1 in binary prediction
* Used to predict probability of result being 0 or 1
* Uses logistic function to model the relationship between independent variables and probability of the outcome
* Uses logistic function to output the probability of the result being 0 or 1
* Logistic function uses an S - shaped line that predicts two maximum values
* Estimates the coefficients of the independent variables (inputs) to predict the probability of the outcome (output). The coefficients represents one-unit change in the corresponding independent variable
* The mostly used threshold for prediction is 0.5 >= y  => e.g. - if the probability is bigger than 0.5, we say that the predicted class is 1, else 0
### Multinomial Regression
* Supervised learning technique that is commonly used in machine learning for multi-class classification task
* The output (dependent variable) is a categorical with three or more unordered levels - not ordinal
* Not ordinal outcomes - the outcome does not have a meaningful level/of ordering
* The outcomes of the variables can be
	* Continous: age, height, weight, temperature, time, blood pressure
	* Discrete: Number of children, number of pets, number of cars
	* Categorical: Gender, race, education level, occupation
* The method is used to calculate the log odds of each outcome in category. These log odds are then transformed into probability scores using the softmax function, which ensures that the probabilities for all outcome categories sum to 1
# Discriminant Analysis
* Statistical technique used for classification and prediction og categorical outcome based on a set of continuous or categorical predictor variables
* Aims to find relationships between
* Two main subcategories
	* Linear Discriminant Analysis (LDA)
	* Quadratic discriminant analysis
|                 | Linear Discriminant Analysis (LDA)         | Quadratic Discriminant Analysis (QDA)         |
|-----------------|--------------------------------------------|----------------------------------------------|
| Input data type  | Continuous                                 | Continuous                                   |
| Number of classes| Can handle multiple classes                | Can handle multiple classes                  |
| Assumptions      | Assumes equal covariance matrix for classes| Allows for different covariance matrix for each class |
| Decision boundary| Linear                                     | Non-linear                                   |
| Computation      | Simpler and faster than QDA                | More computationally expensive than LDA       |
| Overfitting      | Less prone to overfitting                   | More prone to overfitting                     |
| Applications     | Good for large datasets with few features  | Good for small datasets with complex features |

## Assumptions
* LDA
	* Assumes that the input data follows the multivariate normal distribution () with the same covariance matrix for all classes
	* The shape of the distribution is the same for all classes and the only difference is the location of the mean
* QDA
	* Each class to have its own covariance matrix
	* Assumes that the covariance matrices are different for each class
	* Can capture more complex relationships between the input variables and the target classes, but requires more data to estimate the covariance matrix accurately

# Naive Bayes
* Probabilistic machine learning algorithm based on Bayes theorem
* Used widely for classification problems, mainly for text classification and spam filtering
* The main idea is to predict the probability of a particular class (or label), given set of features using Bayes theorem
* Bayes theorem
	* States that the probability of a hypothesis given some observed evidence is proportinal to the probability of the evidence given the hypothesis, multiplied by the prior probability of the hypothesis
	* Uses two main pieces of information:
		1. Prior probability of the class, which is our estimate of how likely it is for a particular class to occur before we've seen any of the observed features
		2. The probability of observing the features, given the class - this is also called the likelihood
	* These two probabilities are multiplied together, and as a result, we get the probability of class
* Makes strong assumption that the features are independent of each other, given the class level
$$P(\text{class} \mid \text{data}) = \frac{P(\text{data} \mid \text{class}) P(\text{class})}{P(\text{data})}$$



# Commands
## Preparation
* `library()` - Loads library from the internet. Often times the lin needs to be installed beforehand
* `set.seed(1)` - Sets the random number generation seed to one - used for preparing the environment in one way
* `sample(index1, index2)` - Used for random sampling. Often used to split data to training and validation model
* `poly()` - used for creating second order polynomial models - `poly(x, 2)` returns quadratic, and `poly(x, 3)` returns cubic
* `boot()` - returns the coefficient estimations

## Information
* `?<summary>` - Used for loading documentation of specific command
* `summary()` - returns a summary of results of different model fitting functions
* `mean()` - used for finding a mean of variables
* `plot(x, y)` - used for creating statistical visualisations of data
* `cov()` - returns a covariance of the vectors
* `var()` -  returns a variance of the vectors

## Models
* `lm(function, data, subset)` - Used for the fitting linear model to the data
* `glm()` - used for fitting linear models. If the family parameter is not set, the fitted model will be linear regression. If the family argument is set to binomial, the fit will be logistic





