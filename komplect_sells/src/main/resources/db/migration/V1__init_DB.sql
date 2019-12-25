create sequence hibernate_sequence start 1 increment 1;

create table part (
    id int8 not null,
    date_time date,
    name varchar(255) not null ,
    part_number varchar(255) not null ,
    price float8,
    quantity int4,
    supplier_id int8,
    primary key (id)
                  );

    create table supplier (
        id int8 not null,
        contact_name varchar(255),
        email varchar(255),
        index float8,
        name varchar(255) not null ,
        phone_number varchar(255),
        primary key (id)
                          );

    create table user_role (
        user_id int8 not null,
        roles varchar(255)
                           );

    create table usr (
        id int8 not null,
        activation_code varchar(255),
        active boolean not null,
        email varchar(255),
        password varchar(255) not null ,
        username varchar(255) not null ,
        primary key (id)
                     );

    alter table if exists part
        add constraint part_fk
            foreign key (supplier_id) references supplier;

    alter table if exists user_role
        add constraint user_role_fk
            foreign key (user_id) references usr;
