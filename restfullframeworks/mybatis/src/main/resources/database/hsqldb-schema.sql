
create table person (
    id int not null,
    name varchar(80) null,
    address varchar(100) not null,
    phone varchar(80) null,
    constraint pk_person primary key (id)
);
