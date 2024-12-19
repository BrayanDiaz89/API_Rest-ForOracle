alter table cursos add activo tinyint;
update cursos set activo = 1;

alter table estudiantes add activo tinyint;

alter table instructores add activo tinyint;

alter table topicos add noResuelto tinyint;