DELETE FROM planeta;
DELETE FROM lua;

insert into planeta VALUES ((SELECT PLANETA_SEQ.nextval FROM DUAL),'Mercurio',22.50);
insert into planeta VALUES ((SELECT PLANETA_SEQ.nextval FROM DUAL),'Venus',22.50);
insert into planeta VALUES ((SELECT PLANETA_SEQ.nextval FROM DUAL),'Terra',22.50);
insert into planeta VALUES ((SELECT PLANETA_SEQ.nextval FROM DUAL),'Marte',22.50);


insert into planeta VALUES (999999,'TESTE',22.50);

insert into lua VALUES (999999,(SELECT MAX(ID) FROM planeta),'TESTE LUA',11.500);