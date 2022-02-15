set schema 'goodreads';


select page_count
from book
where title = 'City in the Sky';

select count(*)
from book
where publisher = 'Faolan''s Pen Publishing Inc.';

SELECT title, avg_rating, isbn
from book;

SELECT title, avg_rating, isbn
from book
where isbn is not null;

select count(author)
from author
where middle_name is null;

select title
from book
where title like '%City%';

select count(book)
from book
where year_published = 2019
  and avg_rating between 3.8 and 4.1;

select sum(page_count), year_published
from book
group by year_published
order by year_published desc;

select count(book) as books_counted, binding_type
from book
group by binding_type
order by count(book) desc;

select author
from author
where author_id = 43;

select title, avg_rating
from book
order by avg_rating desc;

select count(book)
from book
where shelf = 'to-read';

select first_name, middle_name, last_name
from author,
     book
where title = 'The Summer Dragon (The Evertide,  #1)'
  and author.author_id = book.author_id;

select count(book)
from book
where shelf = 'read';

select genre, count(genre)
from book_genre
group by genre;

select count(book)
from book
where isbn is null;

select title, first_name, last_name
from book,
     author,
     co_authors
where book.book_id = co_authors.book_id
  and co_authors.author_id = author.author_id;


select title, page_count
from book
where shelf = 'read'
  and book.page_count is not null
order by page_count desc
limit 1;

select author_id, count(*) as tmp
from book
where shelf = 'read'
group by author_id
order by tmp desc
limit 1;

select count(title) as num_of_books, author.first_name
from book,
     author
where book.author_id = author.author_id and shelf = 'read'
group by book.author_id, author.author_id
order by num_of_books desc
limit 1;

insert into author(first_name, middle_name, last_name, author_id)
values ('Laurits', 'Ivan', 'Andersen', 239);

update author set last_name = 'Anesen' where author_id = 239;

insert into book(book_id, publisher,  title, shelf, author_id)
values ('A2451645', null, 'best book', 'to-read', 239);

delete from book where title = 'best book';

delete from author where author_id = 239;