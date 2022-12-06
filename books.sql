create table Books(
id int primary key,
copies int,
author_name varchar(20),
bookName varchar(20));

insert into Books
values(101, 45, "Natalia", "Hello"),
(102, 300, "Neah", "Dune"),
(103, 9000, "Nico", "World Maps"),
(104, 9087, "Bob", "Algebra and Analysis"),
(105, 5, "Sujata", "Be Bold");

select * from books;