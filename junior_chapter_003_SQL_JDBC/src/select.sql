--заданные таблицы
--product(id, name, type_id, expired_date, price)
--type(id, name)

--Написать запрос получение всех продуктов с типом "СЫР"
select *from product as p
inner join type as t on p.type_id = t.id
where t.name = 'СЫР';

--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select *from product as p
where p.name like '%мороженное%';

--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select *from product as p
where p.expired_date between now() and now() + interval '1 month';

--Написать запрос, который выводит самый дорогой продукт.
select *from product as p
where p.price = max(p.price);

--Написать запрос, который выводит количество всех продуктов определенного типа.
select count(*) from product as p
inner join type as t on p.type_id = t.id
where t.name = 'протеин';

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select *from product as p
inner join type as t on p.type_id = t.id
where t.name = 'СЫР' and t.name = 'МОЛОКО';

--Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select t.name from product as p
inner join type as t on p.type_id = t.id
group by t.name having count (t.name) < 10;

--Вывести все продукты и их тип.
select t.name, p.name from product as p
inner join type as t on p.type_id = t.id;