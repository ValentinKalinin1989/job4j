--заданные таблицы
CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);
--решения задач
--1) Retrieve in a single query:
-- names of all persons that are NOT in the company with id = 5
SELECT person.name FROM person WHERE person.company_id != 5;
-- company name for each person
SELECT c.name, p.name FROM person AS p LEFT JOIN company AS c
ON c.id = p.company_id;
--2) Select the name of the company with the maximum number of persons + number of persons in this company
SELECT company.name, r.cnt FROM company
RIGHT JOIN (SELECT company_id, COUNT(company_id) cnt FROM person GROUP BY company_id) AS r
ON company.id = r.company_id
WHERE cnt = (SELECT MAX(cnt) FROM (SELECT company_id, COUNT(company_id) cnt FROM person GROUP BY company_id) as f);