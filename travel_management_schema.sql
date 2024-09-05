create database travelmanagementsystem;

use travelmanagementsystem;

create table account(
                        username varchar(20),
                        name varchar(20),
                        password varchar(20),
                        security varchar(100),
                        answer varchar(50)
);


create table bookpackage(
                            username varchar(20) unique,
                            package varchar(100),
                            person varchar(10),
                            id varchar(20),
                            number varchar(20),
                            phone varchar(30),
                            price varchar(50)

);


create table bookhotel(
                          username varchar(20) unique,
                          hotel varchar(100),
                          person varchar(10),
                          day varchar(10),
                          ac varchar(10),
                          food varchar(10),
                          id varchar(20),
                          number varchar(20),
                          phone varchar(30),
                          price varchar(50)

);


create table customer(
                         username varchar(20) unique,
                         id varchar(20),
                         number varchar(20),
                         name varchar(30),
                         gender varchar(20),
                         country varchar(30),
                         address varchar(200),
                         phone varchar(30),
                         email varchar(30)

);