delete from product;
commit;

delete from category;
commit;

insert into category (id, name) values (10000, 'mercearia');
insert into category (id, name) values (20000, 'acougue');
insert into category (id, name) values (30000, 'ferramentas');
insert into category (id, name) values (40000, 'papelaria');
insert into category (id, name) values (50000, 'derivados');

insert into product(id, name, price, category_id) values (1000, 'arroz', 10.7, 10000);
insert into product(id, name, price, category_id) values (2000, 'feijao', 8.9, 10000);
insert into product(id, name, price, category_id) values (3000, 'farinha', 5.32, 10000);
insert into product(id, name, price, category_id) values (4000, 'farina de rosca', 1.83, 10000);
insert into product(id, name, price, category_id) values (5000, 'doce', 17.9, 10000);

insert into product(id, name, price, category_id) values (8000, 'peito', 22.59, 20000);
insert into product(id, name, price, category_id) values (9000, 'coxao', 13.43, 20000);
insert into product(id, name, price, category_id) values (10000, 'frango', 39.88, 20000);
insert into product(id, name, price, category_id) values (11000, 'coxa e sobrecoxa', 21.99, 20000);