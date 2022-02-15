set schema 'imdb';

alter table movie
    drop column reviews_avarage;

alter table movie
    add reviews_avarage decimal;

select avg(rating), movie_id
from reviews
group by movie_id;

drop function reviews_avarage_f() cascade;

create function reviews_avarage_f()
    returns trigger
    language plpgsql
as
$$
begin
    update imdb.movie
    set reviews_avarage = round(
            (select avg(rating)
             from imdb.reviews
             where movie_id = new.movie_id
             group by movie_id), 2
        )
    where movie_id = new.movie_id;

    return new;

end;
$$;

create trigger reviews_avarage_trigger
    after insert
    on imdb.reviews
    for each row
execute procedure reviews_avarage_f();


