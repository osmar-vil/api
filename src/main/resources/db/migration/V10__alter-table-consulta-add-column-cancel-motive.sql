alter table consultas add is_cancel tinyint not null default 0;
alter table consultas add motive varchar(255) null;