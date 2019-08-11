create database  database_items;

create table comments (
    id serial primary key,
    comment varchar(2000)
);

create table attachs (
    id serial primary key,
    attachs_desk varchar(2000)
);

create table item (
    id serial primary key,
    description varchar(2000),
    comment_id int references comments(id)
);

create table category (
    id serial primary key,
    category_desk varchar(2000),
    item_id int references item(id)
);

create table state (
    id serial primary key,
    state_desk varchar(2000),
    item_id int references item(id)
);

create table users (
    id serial primary key,
    name varchar(2000),
    item_id int references item(id)
);
create table role (
    id serial primary key,
    info varchar(2000),
    user_id int references users(id)
);

create table rules (
    id serial primary key,
    rule varchar(2000)
);

create table role_rules (
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id)
);

insert into comments(comment) values ('first comment');
insert into comments(comment) values ('second comment');
insert into attachs(attachs_desk) values ('attachs description');
insert into item(description, comment_id) values ('item1', 1);
insert into item(description, comment_id) values ('item2', 2);
insert into category(category_desk, item_id) values ('category description', 1);
insert into state(state_desk, item_id) values ('state description', 2);
insert into users(name, item_id) values ('vell', 1);
insert into role(info, user_id) values ('info description',2);
insert into rules(rule) values ('rule description');
insert into role_rules(role_id, rules_id) values (1, 1);

//user - role = many-to-one
//role - rules = many-to-many
//item - user = many-to-one
//item - comments = one-to-many
//item - attachs = one-to-many
//item - category = many-to-one
//item - state = many-to-one