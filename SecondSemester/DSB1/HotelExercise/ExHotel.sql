set schema 'hotel';

select *
FROM hotel;

select *
from hotel
where city = 'London';

select guestname, guestaddress
from hotel,
     guest,
     booking
where city = 'London'
  and guest.guestno = booking.guestno
  and booking.hotelno = hotel.hotelno
order by guestname;

select *
from room
where price < 40.0
  and type in ('Family', 'Double')
order by price asc;

select *
from booking
where dateto is null;

select count(*)
from hotel;

select avg(price)
from room;

select sum(price)
from room
where type = 'Double';

select count(guest)
from guest,
     booking
where datefrom between '2014-08-01' and '2014-09-01'
  and guest.guestno = booking.guestno;

select price, type
from room,
     hotel
where hotelname = 'Grosvenor Hotel'
  and room.hotelno = hotel.hotelno;

select guest
from booking,
     guest,
     hotel
where CURRENT_DATE BETWEEN dateFrom AND dateTo
  and hotel.hotelname = 'Grosvenor Hotel'
  and hotel.hotelno = booking.hotelno
  and booking.guestno = guest.guestno;

--Our not working solution
-- select type, price, hotelname, guestname from room, guest, hotel, booking
-- where room.hotelno = hotel.hotelno and
--       booking.hotelno = hotel.hotelno and
--       booking.guestno = guest.guestno and
--       room.roomno = booking.roomno and
--       hotel.hotelname = 'Grosvenor Hotel';

SELECT Room.*, Guest.guestName
FROM Hotel
         JOIN Room ON Hotel.hotelNo = Room.hotelNo
         LEFT JOIN Booking ON Room.hotelNo = Booking.hotelNo AND Room.roomNo = Booking.roomNo
         LEFT JOIN Guest ON Guest.guestNo = Booking.guestNo
WHERE hotelname = 'Grosvenor Hotel';

select room, booking
from room
         join booking on room.roomno = booking.roomno
         join hotel on room.hotelno = hotel.hotelno
where CURRENT_DATE BETWEEN dateFrom AND dateTo
  and hotel.hotelname = 'Grosvenor Hotel';

select room, booking
from room
         join hotel on room.hotelno = hotel.hotelno
         left join booking on room.roomno = booking.roomno
     where hotel.hotelname = 'Grosvenor Hotel' and
           select hotel()
           CURRENT_DATE not BETWEEN dateFrom AND dateTo;