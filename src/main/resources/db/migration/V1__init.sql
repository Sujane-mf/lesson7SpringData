create table products
(
    id    bigserial primary key,
    title varchar(255),
    price int,
    cart_id int
);

insert into products(title,price)
values
('Milk', 5),
('Water', 2),
('Bread', 3),
('Eggs', 4),
('Meat', 25),
('Fish', 15),
('Carrot', 1),
('Tomato', 6);
-- ('Cucumber', 4),
-- ('Eggplant', 7),
-- ('Pepper', 8),
-- ('Potato', 3),
-- ('Plate', 9),
-- ('Cup', 6),
-- ('Fork', 3),
-- ('Spoon', 2),
-- ('Knife', 7),
-- ('Book', 12),
-- ('Paper', 2),
-- ('Vodka', 30);

CREATE TABLE carts (id bigserial PRIMARY KEY, product_id bigint, foreign key (product_id) references products(id));
insert into carts(product_id)
values (1);

create table users
(
    id         bigserial primary key,
    username   varchar(30) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into users (username, password, email)
values ('user', '$2a$12$DWPTwr0vtViveYvRGCovtOqteyWJg8LiiKqUREKGF5IzHY3Niwlwe', 'user@gmail.com'),
       ('admin', '$2a$12$DWPTwr0vtViveYvRGCovtOqteyWJg8LiiKqUREKGF5IzHY3Niwlwe', 'admin@gmail.com');

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

CREATE TABLE users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);