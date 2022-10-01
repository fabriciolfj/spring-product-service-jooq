create table category(
id bigserial not null,
name varchar(255) not null,
constraint pk_category primary key (id)
);

create table product(
id bigserial not null,
name varchar(255) not null,
price numeric(15,4) not null,
category_id bigint not null,
constraint pk_product primary key (id),
constraint fk_category_prod foreign key (category_id) references category (id)
)