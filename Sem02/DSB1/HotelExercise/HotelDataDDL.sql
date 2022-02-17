DROP SCHEMA IF EXISTS hotel CASCADE;
CREATE SCHEMA hotel;
SET SCHEMA 'hotel';

CREATE TABLE Hotel (
  hotelNo SERIAL PRIMARY KEY,
  hotelName VARCHAR(40) NOT NULL,
  city VARCHAR(40) NOT NULL
  );

CREATE TABLE Room (
  roomNo INT NOT NULL CHECK(roomNo >= 0),
  hotelNo INT NOT NULL,
  type VARCHAR(10) NOT NULL CHECK(type IN ('Family', 'Single', 'Double', 'Suite')),
  price FLOAT NOT NULL CHECK(price > 0),
  PRIMARY KEY (roomNo, hotelNo),
  FOREIGN KEY(hotelNo) REFERENCES Hotel(hotelNo) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
  );

CREATE TABLE Guest (
  guestNo SERIAL PRIMARY KEY,
  guestName VARCHAR(60) NOT NULL,
  guestAddress VARCHAR(60) NOT NULL
  );

CREATE TABLE Booking (
  hotelNo INT,
  guestNo INT,
  dateFrom DATE,
  dateTo DATE,
  roomNo INT NOT NULL,
  PRIMARY KEY(hotelNo, guestNo, dateFrom),
  FOREIGN KEY(hotelNo, roomNo) REFERENCES Room(hotelNo, roomNo) ON DELETE SET NULL DEFERRABLE INITIALLY DEFERRED,
  FOREIGN KEY(guestNo) REFERENCES Guest(guestNo) ON DELETE CASCADE DEFERRABLE INITIALLY DEFERRED
  );

INSERT INTO Guest (guestNo, guestName, guestAddress) VALUES
  (1, 'Donald Duck', 'Webfoot Walk 1313'),
  (2, 'Homer Simpson', '742 Evergreen Terrace'),
  (3, 'Paris Hilton', '1234 Sunset Boulevard, Los Angeles, CA 90028'),
  (4, 'Donald Trump', '1600 Pennsylvania Avenue, Washington DC');

INSERT INTO Hotel (hotelName, city) VALUES
  ('Grosvenor Hotel', 'London'),
  ('Hilton', 'Paris'),
  ('Ritz', 'London'),
  ('Hilton', 'London');

INSERT INTO Room (roomNo, hotelNo, type, price) VALUES
  (101, 1, 'Single', 23.75),
  (102, 1, 'Single', 23.75),
  (103, 1, 'Double', 32.95),
  (601, 1, 'Family', 42.75),
  (602, 1, 'Suite', 123.75),
  (603, 1, 'Suite', 213.95),
  (101, 2, 'Single', 223.75),
  (102, 2, 'Double', 323.75),
  (103, 2, 'Family', 513.95),
  (601, 2, 'Suite', 523.75),
  (602, 2, 'Suite', 723.75),
  (603, 2, 'Suite', 1313.95),
  (601, 3, 'Suite', 1523.75),
  (602, 3, 'Suite', 1723.75),
  (603, 3, 'Suite', 2313.95);

  INSERT INTO Booking (hotelNo, guestNo, dateFrom, dateTo, roomNo) VALUES
  (1, 1, '2014-04-13', '2014-04-15', 101),
  (1, 1, '2014-07-13', '2014-07-20', 102),
  (1, 2, '2014-03-16', '2014-03-20', 103),
  (2, 3, '2014-04-01', '2014-07-31', 603),
  (3, 4, '2014-01-01', '2014-06-01', 603);

INSERT INTO Booking (hotelNo, guestNo, dateFrom, dateTo, roomNo)
VALUES (1, 1, '2016-04-13', NULL, 101);


