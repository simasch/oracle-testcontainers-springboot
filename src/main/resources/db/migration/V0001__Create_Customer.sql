create sequence customer_seq start with 1000 increment by 50;
grant select on customer_seq to demouser;
create synonym demouser.customer_seq for customer_seq;

create table customer
(
    id            number(19)    not null,
    version       number(19)    not null,
    first_name    varchar(100),
    last_name     varchar(100),
    created_date  timestamp,
    picture       varchar2(200) not null,

    firm_id       number(19),

    primary key (id)
);
grant select, insert, update, delete on customer to demouser;
create synonym demouser.customer for customer;

create sequence firm_seq start with 1000 increment by 50;
grant select on firm_seq to demouser;
create synonym demouser.firm_seq for firm_seq;

create table firm
(
    id         number(19)   not null,
    version    number(19)   not null,
    name       varchar2(100),
    address_id number(19)   not null,

    primary key (id)
);
grant select, insert, update, delete on firm to demouser;
create synonym demouser.firm for firm;

create sequence address_seq start with 1000 increment by 50;
grant select on address_seq to demouser;
create synonym demouser.address_seq for address_seq;

create table address
(
    id          number(19)    not null,
    version     number(19)    not null,
    street      varchar2(100) not null,
    postal_code varchar2(10)  not null,
    city        varchar2(100) not null,

    primary key (id)
);
grant select, insert, update, delete on address to demouser;
create synonym demouser.address for address;

alter table firm
    add constraint fk_firm_address foreign key (address_id) references address (id);

alter table customer
    add constraint fk_customer_firm foreign key (firm_id) references firm (id);
