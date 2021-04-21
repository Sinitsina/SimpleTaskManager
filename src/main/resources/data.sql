DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users(
    id serial not null primary key,
    name varchar(100) not null);

insert into users (name) values ('Иван');
insert into users (name) values ('Мария');
insert into users (name) values ('Тихомир');
insert into users (name) values ('Петр');

DROP TABLE IF EXISTS task CASCADE;

CREATE TABLE task(
                      id serial not null primary key,
                      task_date date not null,
                      name varchar(1000) not null,
                      user_id bigint constraint task_user_id_fkey
                              references users);

ALTER SEQUENCE task_id_seq RESTART WITH 101;

insert into task (task_date, name, user_id) values ('2017-05-06', 'Согласовать документы пакет документов от Плановой К.T. до 05.06', '1');
insert into task (task_date, name, user_id) values ('2018-04-12', 'Подписать решение комиссии ВПК до 04.12', '2');
insert into task (task_date, name, user_id) values ('2018-05-06', 'Проверить отклонение до 05.12', '1');
insert into task (task_date, name, user_id) values ('2018-06-07', 'Согласовать документы финансового отдела', '1');
insert into task (task_date, name, user_id) values ('2018-07-06', 'Утвердить решение ГРБС', '2');
insert into task (task_date, name, user_id) values ('2018-07-12', 'Отправить зам. Министра на итоговое согласование', '3');
insert into task (task_date, name, user_id) values ('2018-08-06', 'Поставить подпись от имени Парамонова Е. А. (ушел в отпуск)', '2');
insert into task (task_date, name, user_id) values ('2018-09-22', 'Отправить от лица заявителя Кириллова Л. Г', '3');
insert into task (task_date, name, user_id) values ('2018-10-09', 'Согласовать постановление МЭР по проекту “Фотон”', '1');
insert into task (task_date, name, user_id) values ('2018-10-15', 'Подписать решение МинФин от 10.09', '4');
insert into task (task_date, name, user_id) values ('2019-01-16', 'Отправить решение от 10.15 на доработку', '4');
