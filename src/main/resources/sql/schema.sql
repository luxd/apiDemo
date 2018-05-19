-- schema.sql

drop table car if exists;
 
    drop table car_type if exists;
 
    drop table cartype_servicetype if exists;
 
    drop table person if exists;
 
    drop table service_record if exists;
 
    drop table service_type if exists;
 
--    drop sequence if exists hibernate_sequence;
 
--    create sequence hibernate_sequence start with 1 increment by 1;
 
    create table car (
        car_id bigint not null,
        make varchar(30) not null,
        makeyear integer not null,
        odometer integer not null,
        car_type_id bigint,
        primary key (car_id)
    );
 
    create table car_type (
        car_type_id bigint not null,
        name varchar(30) not null,
        primary key (car_type_id)
    );
 
    create table cartype_servicetype (
        carType_id bigint not null,
        serviceType_id bigint not null
    );
 
    create table person (
        id integer not null,
        dateOfBirth timestamp,
        firstName varchar(255),
        lastName varchar(255),
        placeOfBirth varchar(255),
        primary key (id)
    );
 
    create table service_record (
        id bigint not null,
        service_date date not null,
        car_id bigint,
        service_type_id bigint,
        primary key (id)
    );
 
    create table service_type (
        service_type_id bigint not null,
        name varchar(30) not null,
        primary key (service_type_id)
    );
 
    alter table car 
        add constraint FKggtv0dpqfowlhobef4e9qrdlm 
        foreign key (car_type_id) 
        references car_type;
 
    alter table cartype_servicetype 
        add constraint FKbi1rp6a1361nr16ktgue78uue 
        foreign key (serviceType_id) 
        references service_type;
 
    alter table cartype_servicetype 
        add constraint FK7l7v7dfiislyioubt0ssuo8tj 
        foreign key (carType_id) 
        references car_type;
 
    alter table service_record 
        add constraint FKlxu1oqsf3d9axsuicumw56r1q 
        foreign key (car_id) 
        references car;
 
    alter table service_record 
        add constraint FKeuiffojfywxt1i18xt34cehgj 
        foreign key (service_type_id) 
        references service_type;