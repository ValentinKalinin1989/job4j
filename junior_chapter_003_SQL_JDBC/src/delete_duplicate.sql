--создание временной таблицы
CREATE TEMPORARY TABLE temp AS
( SELECT MIN(id) as id
  FROM cities
  GROUP BY name);
--удаление дубликатов
DELETE FROM cities
WHERE cities.id NOT IN
( SELECT id FROM temp );
