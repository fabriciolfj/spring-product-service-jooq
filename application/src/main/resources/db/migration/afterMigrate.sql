delete from product;
commit;

delete from category;
commit;

insert into category (id, name) values (1, 'mercearia');
insert into category (id, name) values (2, 'acougue');

insert into product(id, name, price, category_id) values (1, 'arroz', 10.7, 1);
insert into product(id, name, price, category_id) values (2, 'feijao', 8.9, 1);
insert into product(id, name, price, category_id) values (3, 'farinha', 5.32, 1);
insert into product(id, name, price, category_id) values (4, 'farina de rosca', 1.83, 1);
insert into product(id, name, price, category_id) values (5, 'doce', 17.9, 1);

insert into product(id, name, price, category_id) values (8, 'peito', 22.59, 2);
insert into product(id, name, price, category_id) values (9, 'coxao', 13.43, 2);
insert into product(id, name, price, category_id) values (10, 'frango', 39.88, 2);
insert into product(id, name, price, category_id) values (11, 'coxa e sobrecoxa', 21.99, 2);