create table cursos(
        id_curso bigint not null auto_increment,
        nombreCurso varchar(100) not null,
        descripcion LONGTEXT not null,

        primary key(id_curso)
        );


