set schema 'imdb';

insert into movie(movie_id, title, prod_year, status)
values (1, 'The Bourne Ultimatum', 2007, 'released');
insert into movie(movie_id, title, prod_year, status)
values (2, 'Jason Bourne', 2016, 'released');
insert into movie(movie_id, title, prod_year, status)
values (3, 'The Hunger Games', 2012, 'released');
insert into movie(movie_id, title, prod_year, status)
values (4, 'The Great Gatsby', 2013, 'released');
insert into movie(movie_id, title, prod_year, status)
values (5, 'Borat', 2006, 'completed');

insert into prod_company(id, name, country)
values (1, 'Paramount', 'France');
insert into prod_company(id, name, country)
values (2, 'Universal Pictures', 'USA');
insert into prod_company(id, name, country)
values (3, 'Motion Picture Beta', 'Germany');
insert into prod_company(id, name, country)
values (4, 'The Kennedy/Marshall Company', 'USA');
insert into prod_company(id, name, country)
values (5, 'Ludlum Entertainment', 'USA');
insert into prod_company(id, name, country)
values (6, 'KanZaman Services', 'Spain');
insert into prod_company(id, name, country)
values (7, 'Perfect World Picture', 'USA');
insert into prod_company(id, name, country)
values (8, 'Captivate Entertainment', 'USA');
insert into prod_company(id, name, country)
values (9, 'Pearl Street Films', 'USA');
insert into prod_company(id, name, country)
values (10, 'Lionsgate', 'USA');
insert into prod_company(id, name, country)
values (11, 'Color Force', 'USA');
insert into prod_company(id, name, country)
values (12, 'Warner Bros', 'USA');
insert into prod_company(id, name, country)
values (13, 'Red Wagon Entertainment', 'USA');
insert into prod_company(id, name, country)
values (14, 'Everyman Pictures', 'USA');
insert into prod_company(id, name, country)
values (15, 'Dune Entertainment', 'USA');
insert into prod_company(id, name, country)
values (16, 'One America', 'USA');


insert into produced_by(movie_id, company_id)
values (1, 2);
insert into produced_by(movie_id, company_id)
values (1, 4);
insert into produced_by(movie_id, company_id)
values (1, 5);
insert into produced_by(movie_id, company_id)
values (1, 6);
insert into produced_by(movie_id, company_id)
values (2, 2);
insert into produced_by(movie_id, company_id)
values (2, 4);
insert into produced_by(movie_id, company_id)
values (2, 7);
insert into produced_by(movie_id, company_id)
values (2, 8);
insert into produced_by(movie_id, company_id)
values (2, 9);
insert into produced_by(movie_id, company_id)
values (3, 10);
insert into produced_by(movie_id, company_id)
values (3, 11);
insert into produced_by(movie_id, company_id)
values (4, 12);
insert into produced_by(movie_id, company_id)
values (4, 13);
insert into produced_by(movie_id, company_id)
values (5, 14);
insert into produced_by(movie_id, company_id)
values (5, 15);
insert into produced_by(movie_id, company_id)
values (5, 16);

insert into "user"(name, username, email, password)
values ('Peter Peterson', 'peter1', 'peter@yahoo.com', '2021');
insert into "user"(name, username, email, password)
values ('Tomas Ondrejka', 'anonymous', 'tomas.ondrejka@gmail.com', '123');
insert into "user"(name, username, email, password)
values ('Khaled Hammoun', 'Khaled', '275241@via.dk', 'CamelCase');
insert into "user"(name, username, email, password)
values ('Eliza Manciu', 'ElizaM', '204590@via.dk', 'Khaled');
insert into "user"(name, username, email, password)
values ('Tabita Varlan', 'Tabita', 'tabita.varlan@gmail.com', 'Alice');

insert into follows(username, follows_user)
values ('peter1', 'anonymous');
insert into follows(username, follows_user)
values ('anonymous', 'Khaled');
insert into follows(username, follows_user)
values ('anonymous', 'ElizaM');
insert into follows(username, follows_user)
values ('Khaled', 'anonymous');
insert into follows(username, follows_user)
values ('Khaled', 'ElizaM');
insert into follows(username, follows_user)
values ('Khaled', 'peter1');
insert into follows(username, follows_user)
values ('ElizaM', 'peter1');
insert into follows(username, follows_user)
values ('ElizaM', 'Khaled');
insert into follows(username, follows_user)
values ('Tabita', 'anonymous');

insert into reviews(username, movie_id, rating, comment)
values ('anonymous', 5, 5, 'Very nice');
insert into reviews(username, movie_id, rating, comment)
values ('Tabita', 4, 4, 'Depressing');
insert into reviews(username, movie_id, rating, comment)
values ('ElizaM', 1, 2, 'Not that good');
insert into reviews(username, movie_id, rating, comment)
values ('Khaled', 1, 3, 'Too much action');
insert into reviews(username, movie_id, rating, comment)
values ('Khaled', 2, 4, 'Better than The Bourne Ultimatum');

insert into person(name, dob, gender, pob, biography)
values ('Paul Greengrass', '13/08/1955', 'M', 'Cheam, Surrey, England, UK',
        'Paul Greengrass started his filmmaking career with a super 8 camera he found in his art room in secondary school.');

insert into person_role(person_id, role)
values (1, 'director');

insert into participates(person_id, movie_id)
values (1, 1);

insert into person(name, dob, gender, pob, biography)
values ('Tony Gilroy', '11/09/1956', 'M', 'Manhattan, New York City, New York, USA',
        'Tony Gilroy was born in Manhattan, New York, New York, USA; and raised in upstate New York. His father, Frank D. Gilroy, was a Pulitzer Prize winning playwright, director, and screenwriter.');
insert into person_role(person_id, role)
values (2, 'writer');

insert into participates(person_id, movie_id)
values (2, 1);


insert into person(name, dob, gender, pob, biography)
values ('Matt Damon', '08/10/1970', 'M', 'Boston, Massachusetts, USA',
        'Matthew Paige Damon was born on October 8, 1970, in Boston, Massachusetts, to Kent Damon, a stockbroker, realtor and tax preparer, and Nancy Carlsson-Paige, an early childhood education professor at Lesley University. Matt has an older brother, Kyle, a sculptor.');
insert into person_role(person_id, nr_movies, role)
values (3, 88, 'actor');

insert into participates(person_id, movie_id)
values (3, 1);
insert into participates(person_id, movie_id)
values (3, 2);

insert into person(name, dob, gender, pob, biography)
values ('Julia Stiles', '28/03/1981', 'F', 'New York City, New York, USA',
        'Lovely, slim-eyed blonde Julia (O''Hara) Stiles, of Irish, English and German heritage, was born on March 28, 1981 in New York City, the outgoing daughter and eldest of three children of a Greenwich Village artist mother.');
insert into person_role(person_id, nr_movies, role)
values (4, 59, 'actor');

insert into participates(person_id, movie_id)
values (4, 1);
insert into participates(person_id, movie_id)
values (4, 2);

-- New data--

insert into participates (person_id, movie_id)
values (1, 2);


insert into person (id, name, dob, gender, pob, biography)
values (5, 'Vincent Cassel', '23--11-1966', 'M', 'Paris, France',
        'Blue-eyed Vincent Cassel was born in Paris to a leading actor father, Jean-Pierre Cassel, and a journalist mother, Sabine Litique.');

insert into person_role (person_id, nr_movies, role)
values (5, 93, 'actor');

insert into participates (person_id, movie_id)
values (5, 2);


insert into person (id, name, dob, gender, pob, biography)
values (6, 'Christopher Rouse', '28-11-1958', 'M', 'Los Angeles, California, USA',
        'Christopher Rouse was born on November 28, 1958 in Los Angeles, California, USA as Christopher Russell Rouse. He is known for his work on The Bourne Ultimatum (2007), Captain Phillips (2013) and United 93 (2006).');

insert into person_role (person_id, nr_movies, role)
values (6, 27, 'Editor');

insert into participates (person_id, movie_id)
values (6,2);


insert into img(url, description, movie_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm56072192/?context=default',
        'Matt Damon and Paul Greengrass in The Bourne Ultimatum (2007)', 1);

insert into associated_to(url, person_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm56072192/?context=default', 3);

insert into associated_to(url, person_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm56072192/?context=default', 1);


insert into img (url, description, movie_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm223844352/?context=default',
        'Matt Damon and Paul Greengrass in The Bourne Ultimatum (2007)', 1);

insert into associated_to (url, person_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm223844352/?context=default', 3);


insert into associated_to (url, person_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm223844352/?context=default', 1);

insert into img (url, description, movie_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm374839296/?context=default',
        'Matt Damon and Paul Greengrass in The Bourne Ultimatum (2007)', 1);

insert into associated_to (url, person_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm374839296/?context=default', 3);

insert into associated_to (url, person_id)
values ('https://www.imdb.com/title/tt0440963/mediaviewer/rm374839296/?context=default', 1);

insert into img (url, description, movie_id)
values ('https://www.imdb.com/title/tt4196776/mediaviewer/rm3166470657/?context=default', 'Jason Bourne (2016)', 2);

insert into associated_to (url, person_id)
values ('https://www.imdb.com/title/tt4196776/mediaviewer/rm3166470657/?context=default', 3);

