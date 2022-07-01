create table products
(
    id    bigserial primary key,
    title varchar(255),
    price int
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