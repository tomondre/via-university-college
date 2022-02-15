Create schema imdb;
set schema 'imdb';

CREATE DOMAIN username_t VARCHAR(30) NOT NULL CHECK (LENGTH(VALUE) >= 6);

CREATE DOMAIN gender_t CHAR NOT NULL CHECK (value in ('F', 'M', 'O'));

Create domain status_t varchar not null check ( value in('released', 'completed', 'post-production', 'filming', 'announce'));

Create domain prod_year_t int check ( value between 1800 and 2021);

Create domain rating_t int not null check ( value between 1 and 5 );

Create table movie
(
    movie_id int PRIMARY KEY,
    title    varchar(200) NOT NULL,
    prod_year prod_year_t,
    status status_t

);

create table "user"(
    name  varchar(100) not null,
    username username_t PRIMARY KEY,
    email varchar(150) unique not null ,
    password varchar(30) not null
);

create table follows(
    username username_t,
    follows_user username_t,
    PRIMARY KEY (username, follows_user),
    FOREIGN KEY (username) references "user"(username) on delete cascade on update cascade,
    FOREIGN KEY (follows_user) references "user"(username) on delete cascade on update cascade
);

CREATE TABLE reviews(
    username username_t,
    movie_id int,
    rating rating_t,
    comment varchar(500),
    PRIMARY KEY (username, movie_id),
    FOREIGN KEY (username) references "user"(username) on delete set null on update cascade ,
    FOREIGN KEY (movie_id) references movie(movie_id) on delete cascade on update cascade

);

Create table prod_company(
    id serial not null Primary Key ,
    name varchar(100) not null ,
    country varchar(30)

);

create table produced_by(
    movie_id int,
    company_id int,
    PRIMARY KEY (movie_id, company_id),
    FOREIGN KEY (movie_id) references movie(movie_id) on delete set null on update cascade,
    FOREIGN KEY (company_id) references prod_company(id) on delete set null on update cascade
);


create table img(
    url varchar (200) primary key not null,
    description varchar(500),
    movie_id int,
    FOREIGN KEY (movie_id) references movie(movie_id) on delete set null on update cascade
);

Create table person(
    id serial not null Primary Key ,
    name varchar(100),
    dob date,
    gender gender_t,
    pob varchar(50),
    biography text
);

create table person_role(
    person_id int not null PRIMARY KEY,
    nr_movies int,
    role varchar(20),
    FOREIGN KEY (person_id) references person(id) on delete cascade on update cascade
);

create table participates(
    person_id int not null,
    movie_id int not null,
    Primary Key (person_id, movie_id),
    FOREIGN KEY (person_id) references person(id) on delete set null on update cascade,
    FOREIGN KEY (movie_id) references movie(movie_id) on delete set null on update cascade
);

create table associated_to(
    url varchar (200) not null ,
    person_id int not null,
    PRIMARY KEY (url, person_id),
    FOREIGN KEY (url)references img(url) on delete cascade on update cascade ,
    FOREIGN KEY (person_id) references person(id) on delete set null on update cascade
);




