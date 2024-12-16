create table cursos(
        idCurso bigint not null auto_increment,
        nombre varchar(100) not null,
        descripcion LONGTEXT not null,

        primary key(idCurso)
        );


