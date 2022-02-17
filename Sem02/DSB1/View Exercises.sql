set schema 'hotel';

create view booked_rooms_view as
select *
from guest;

create view Ex1_1 as
select guestname, b.roomno
from guest
         join booking b on b.guestno = guest.guestno
         left join room r on b.roomno = r.roomno;

create view Ex1_2 as
select booking, type
from booking
         join room on booking.roomno = room.roomno
where type = 'Single';

create view Ex1_3 as
select *
from booking
where booking.dateto IS NULL;

create view Ex1_4 as
select room, hotelname
from room
         join hotel h on room.hotelno = h.hotelno
where hotelname = 'Hilton';

set schema 'imdb';

create view ex2 as
select title, prod_year, (select ) from movie, reviews
group by title, prod_year, rating;

