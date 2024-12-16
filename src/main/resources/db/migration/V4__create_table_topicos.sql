create table topicos(
        idTopico bigint not null auto_increment,
        titulo varchar(100) not null,
        descripcion LONGTEXT not null,
        fechaCreacion datetime not null,
        idCurso bigint not null,
        idEstudiante bigint not null,

        primary key(idTopico),
        constraint fk_topicos_idCurso foreign key(idCurso) references cursos(idCurso),
        constraint fk_topicos_idEstudiante foreign key(idEstudiante) references estudiantes(idEstudiante)
        );
