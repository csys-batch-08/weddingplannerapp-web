--User details
CREATE TABLE user_details
(user_id INT DEFAULT user_seq_id.NEXTVAL,
user_role varchar2(20) DEFAULT 'customer',
user_name VARCHAR2(30) NOT NULL,
mobile_number NUMBER NOT NULL,UNIQUE(mobile_number),
city VARCHAR2(100) NOT NULL,
email_id VARCHAR2(50)  NOT NULL,UNIQUE(email_id) ,
password VARCHAR2(20) NOT NULL,
user_Wallet NUMBER DEFAULT '500000',
CONSTRAINT PK_user_details PRIMARY KEY(user_id) );
insert into user_details(user_role,user_name,mobile_number,city,email_id,password,user_Wallet)values('admin','karthika',9626834983,'chennai','karthika@gmail.com','Karthika@123',0);
select * from user_details;
alter table user_details modify user_wallet number default '0';
update user_details set user_role='admin' where user_id=3031;
delete from user_details where user_id=3032;
CREATE SEQUENCE user_seq_id INCREMENT BY 1 START WITH 3031;
--drop sequence user_seq_id;
alter table  bookdetails add bookimages varchar2(5000);


---venue details
CREATE TABLE venue_details
(venue_id INT DEFAULT venue_seq_id.NEXTVAL ,
venue_name VARCHAR2(50) NOT NULL,
venue_area VARCHAR2(100) NOT NULL,
venue_city varchar2(50) NOT NULL,
Venue_type VARCHAR2(100) NOT NULL,
venue_vendor_name VARCHAR2(50) NOT NULL,
contact_number NUMBER NOT NULL,
venue_package NUMBER(10,2) NOT NULL,
check_availability VARCHAR2(10) NOT NULL, 
CONSTRAINT PK_venue_details PRIMARY KEY(venue_id));
CREATE SEQUENCE venue_seq_id INCREMENT BY 1 START WITH 1011; 
SELECT
    *
FROM venue_details;
update venue_details set check_availability ='yes'  where venue_name ='Star Marriage hall';
update venue_details set venue_vendor_name='swetha',contact_number=9856345678,venue_package=80000 where venue_name='Rina Venue';

update venue_details set venue_name='Rina Venue' where venue_id=1114;
truncate table venue_details;
commit;
update venue_details set check_availability='yes' where venue_name='MK mahal';
alter table  venue_details add venue_images varchar2(500);
update venue_details set venue_images='https://thumbs.dreamstime.com/z/wedding-banquet-hall-deluxe-34676247.jpg' where venue_id=1031;
drop sequence venue_seq_id;
insert into venue_details (venue_name,venue_address,venue_city,venue_type,venue_vendor_name,contact_number,venue_package)values('Blue Bay Beach Resort','Avadi','chennai',
'Banquet Halls','priya',9876543210,80000.00);
alter table venue_details rename column venue_address to venue_area;
--service details
CREATE TABLE Service_details
(service_id INT DEFAULT service_seq_id.NEXTVAL,
service_name VARCHAR2(50) NOT NULL,
service_package NUMBER(10,2) NOT NULL,
ratings INT  DEFAULT '0',
CONSTRAINT PK_service_details PRIMARY KEY(service_id));
CREATE SEQUENCE service_seq_id INCREMENT BY 1 START WITH 2021;
select * from service_details; 
insert into service_details (service_name,service_package)values('photography',50000);
insert into service_details (service_name,service_package)values('Decoration',60000);
alter table  service_details add Availability varchar2(50) DEFAULT 'yes';
update service_details set availability='yes' where service_name='Decoration';
update service_details set service_package=? where service_name=?;
commit;
--delete from service_details where service_id=2128;
update service_details set service_name='Reception Decoration' where service_id=2132;

select * from service_details;
select * from venue_details where venue_package<150000;
--truncate table service_details;
alter table service_details add service_type_images varchar2(500);
update service_details set service_type_images='Mehandi.jpg' where service_id=2121;
select distinct service_type,service_type_images from service_details ;
---
--booking venue
CREATE TABLE booking_venues
(venue_booking_id INT DEFAULT bookvenue_seq_id.NEXTVAL,
user_id INT NOT NULL,
venue_id INT NOT NULL,
venue_name VARCHAR2(50) NOT NULL,
no_of_guest INT NOT NULL,
function_time VARCHAR2(30) NOT NULL,
booking_date timestamp default current_timestamp,
event_date DATE NOT NULL,
venue_package NUMBER(10,2) NOT NULL,
CONSTRAINT PK_booking_venues PRIMARY KEY(venue_booking_id),
CONSTRAINT FK_booking_venues_user_details FOREIGN KEY (user_id) REFERENCES user_details(user_id),
CONSTRAINT FK_booking_venues_venue_details FOREIGN KEY (venue_id) REFERENCES venue_details(venue_id));
alter table booking_venues modify booking_date date;
alter table  booking_services add  status varchar2(100) default 'booked';
select * from booking_venues;
alter table booking_venues add advance_amount number(10,2);
select venue_booking_id from booking_venues where user_Id=3032 and event_date='27-01-22';
select floor((event_date)- to_date(sysdate)) as no_of_days from booking_services where service_booking_id=5134;

update booking_services set status='booked' where user_id=3032  ;
--truncate table booking_venues;

CREATE SEQUENCE bookvenue_seq_id INCREMENT BY 1 START WITH 4041;

select * from booking_venues;
delete from booking_venues where venue_id=1011;
--booking services
select * from booking_venues where venue_name='blue bay resort' and to_char(event_date,'yyyy-mm-dd')='2022-01-21';

CREATE TABLE booking_services
(service_booking_id INT DEFAULT bookservice_seq_id.NEXTVAL,
user_id INT NOT NULL,
service_id INT NOT NULL,
service_name varchar2(50) NOT NULL,
booking_date DATE default SYSDATE,
event_date DATE NOT NULL,
service_package NUMBER(10,2) NOT NULL,
CONSTRAINT PK_booking_services PRIMARY KEY(service_booking_id),
CONSTRAINT FK_booking_services_user_details FOREIGN KEY (user_id) REFERENCES user_details(user_id),
CONSTRAINT FK_booking_services_service_details FOREIGN KEY (service_id) REFERENCES service_details(service_id));
select * from booking_services;
--truncate table booking_services;
select booking_date from booking_services where user_id=3032;

--truncate table booking_services;

delete from booking_services where service_name='Decoration' and event_date='14-01-22';

CREATE SEQUENCE bookservice_seq_id INCREMENT BY 1 START WITH 5051; 
drop table booking_services;
drop sequence bookservice_seq_id;

CREATE TABLE rating_details(rating_id INT DEFAULT rating_seq_id.NEXTVAL,user_id int NOT NULL,
service_name varchar2(30) NOT NULL,
rating INT NOT NULL ,
CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES user_details(user_id));
select * from rating_details;
--truncate table rating_details;
--alter table rating_details add review varchar2(1000);
--drop table rating_details;
CREATE SEQUENCE rating_seq_id INCREMENT BY 1 START WITH 1; 

delete from rating_details where rating_id=63;
--drop table rating_details;


select * from venue_details where lower(venue_city) like 'che%';
select count(service_name) from booking_services where user_id=3032 group by user_id,service_name;
select trunc(avg(rating),2) from rating_details where service_name ='Decoration';
drop sequence bookservice_seq_id;
--drop table user_details;
--drop table venue_details;
--drop table Service_details;
--drop table booking_venues;
--drop table booking_services;
select * from booking_details;

select * from user_details;

update venue_details set check_availabilty='No' where venue_name='Riya Venue';