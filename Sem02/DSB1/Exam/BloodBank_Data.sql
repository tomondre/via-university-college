SET SCHEMA 'blood_bank';

INSERT INTO donor(cpr, name, house_number, street, city, postal_code, phone, blood_type, last_reminder)
VALUES ('1234567890', 'Peter Petersen', 21, 'Gade', 'Horsens', 8700, '4545454545', 'A-', '2021-6-1');

INSERT INTO donor (cpr, name, house_number, street, city, postal_code, phone, blood_type, last_reminder)
VALUES ('1010101010', 'Marek Mareksen', 11, 'Gade', 'Kolding', 6000, '4534128934', '0-', '2021-6-2');


INSERT INTO blood_donations(date, amount, blood_percent, donor_cpr)
VALUES ('2021-5-28', 400, 10, 1010101010);

INSERT INTO blood_donations(date, amount, blood_percent, donor_cpr)
VALUES ('2021-5-27', 300, 11, 1234567890);


INSERT INTO staff(initials, cpr, name, house_number, street, city, postal_code, phone, hire_date, position)
VALUES ('ABA', 1234565321, 'Alex Aleksen', 45, 'Gamlegade', 'Horsens', 8700, '12321234523', '2021-1-1', 'nurse');

INSERT INTO staff(initials, cpr, name, house_number, street, city, postal_code, phone, hire_date, position)
VALUES ('CDA', 9090221212, 'Henrik Henriksen', 65, 'nygade', 'Horsens', 8700, '9383838383', '2021-4-1', 'bioanalytic');

INSERT INTO staff(initials, cpr, name, house_number, street, city, postal_code, phone, hire_date, position)
VALUES ('ABS', 1111111111, 'Henrik Henriksen', 65, 'nygade', 'Horsens', 8700, '9383838383', '2021-4-1', 'nurse');


INSERT INTO managed_by(collected_by_nurse_initials, donation_id, verified_by_nurse_initials)
VALUES ('ABA', 1, 'ABS');

INSERT INTO managed_by(collected_by_nurse_initials, donation_id, verified_by_nurse_initials)
VALUES ('ABA', 2, 'ABS');