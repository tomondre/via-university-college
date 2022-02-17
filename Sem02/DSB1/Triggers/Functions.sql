set schema 'hotel';


--Exercise 1

drop function name_uppercase() cascade;

create function name_uppercase()
    returns trigger
    language plpgsql
as
$$
begin
    new.hotelname = upper(new.hotelname);
    return new;
end;
$$;

create trigger hotelname_uppercase
    before insert or update
    on hotel.hotel
    for each row
execute procedure name_uppercase();


--Exercise 2

drop function hotelno() cascade;

create function hotelno()
    returns trigger
    language plpgsql
as
$$
begin
    if new.hotelno is distinct from old.hotelno then
        raise exception 'Exception - forbidden updating hotelno of a room';
    end if;
    return new;
end;
$$;

create trigger hotelno_room_change_check
    before update
    on hotel.room
    for each row
execute procedure hotelno();

--Exercise 3

alter table room
    add version integer;

update room
set version = 0;

drop function version_update cascade;

create function version_update()
    returns trigger
    language plpgsql
as
$$
begin
    if new.price is distinct from old.price then
        new.version = old.version + 1;
    end if;
    return new;
end;
$$;

create trigger version_update_trigger
    before update
    on hotel.room
    for each row
execute procedure version_update();

-- Exercise 4

drop function guestid_update_in_booking cascade;

create function guestid_update_in_booking()
    returns trigger
    language plpgsql
as
$$
begin
    if new.guestno is distinct from old.guestno then
        update booking set guestno = new.guestno where guestno = old.guestno;
    end if;
    return new;
end;
$$;

create trigger guest_id_trigger
    before update
    on hotel.guest
    for each row
execute procedure guestid_update_in_booking();

update guest set guestno = 1234 where guestname = 'Donald Duck';

-- Exercise 5

set schema 'imdb';

