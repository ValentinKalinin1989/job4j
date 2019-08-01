create database car_factory;

create table frame(
    id serial primary key,
    type varchar(10)
);

create table engine(
    id serial primary key,
    name varchar(10),
    type_fuel varchar(10),
    power int,
    numb_of_cylinders int
);

create table transmission(
    id serial primary key,
    name varchar(10),
    type_transmis varchar(10),
    number_of_gear int
);

create table car(
    id serial primary key not null ,
    name varchar(20) not null,
    type_frame_id int references frame(id) not null ,
    name_engine_id int references engine(id) not null,
    name_transm_id int references transmission(id) not null
);

insert into frame (type) values ('sedan');
insert into frame (type) values ('hatchback');
insert into frame (type) values ('SUV');
insert into frame (type) values ('pickup');
insert into frame (type) values ('wagon');

insert into engine (name, type_fuel, power, numb_of_cylinders)
values ('MMREG41','gasoline',100,4);
insert into engine (name, type_fuel, power, numb_of_cylinders)
values ('MMREG62','gasoline',140,6);
insert into engine (name, type_fuel, power, numb_of_cylinders)
values ('MMREG83','gasoline',180,8);
insert into engine (name, type_fuel, power, numb_of_cylinders)
values ('MMREG84','gasoline',190,8);
insert into engine (name, type_fuel, power, numb_of_cylinders)
values ('MMRED41','diesel',160,4);
insert into engine (name, type_fuel, power, numb_of_cylinders)
values ('MMRED62','diesel',180,6);
insert into engine (name, type_fuel, power, numb_of_cylinders)
values ('MMRED83','diesel',200,8);

insert into transmission(name, type_transmis, number_of_gear)
values ('AK5', 'AKPP', 4);
insert into transmission(name, type_transmis, number_of_gear)
values ('AK6', 'AKPP', 5);
insert into transmission(name, type_transmis, number_of_gear)
values ('CV', 'CVT', 0);
insert into transmission(name, type_transmis, number_of_gear)
values ('MK4', 'MKPP', 4);
insert into transmission(name, type_transmis, number_of_gear)
values ('MK5', 'MKPP', 5);

insert into car(name, type_frame_id, name_engine_id, name_transm_id)
values ('Тойота Кукурузер', 1, 2, 1);
insert into car(name, type_frame_id, name_engine_id, name_transm_id)
values ('Ниссан Кошкай', 1, 1, 1);
insert into car(name, type_frame_id, name_engine_id, name_transm_id)
values ('Шевроле Ланос', 3, 3, 2);
insert into car(name, type_frame_id, name_engine_id, name_transm_id)
values ('ВАЗ 666', 3, 3, 2);
insert into car(name, type_frame_id, name_engine_id, name_transm_id)
values ('Чайнамоб Рай', 3, 3, 2);

---список всех машин и все привязанные к ним детали
select c.name, f.type, e.name, t.name from car as c
inner join frame as f on f.id = c.name_transm_id
inner join engine as e on e.id = c.name_engine_id
inner join transmission as t on t.id = c.name_transm_id;

--детали, которые не используются в машине, кузова, двигатели, коробки передач
--не используемые кузова
select f.type
from car as c right outer join frame as f on f.id = c.name_transm_id
where c.id is null;

--не используемые двигатели
select e.name
from car as c right outer join engine as e on e.id = c.name_engine_id
where c.id is null;


--не используемые коробки передач
select t.name
from car as c right outer join transmission as t on t.id = c.name_transm_id
where c.id is null;