DROP TABLE planeta;
DROP TABLE lua;

create TABLE planeta
(
   id             number(18) primary key,
   nome           varchar(30) not null,
   diametro       number(18,3) not null
);

create TABLE lua
(
   id             number(18) primary key,
   id_planeta     number(18) not null ,
   nome           varchar(30) not null,
   diametro       number(18,3) not null
);

ALTER TABLE lua
ADD FOREIGN KEY (id_planeta) REFERENCES planeta(id);
