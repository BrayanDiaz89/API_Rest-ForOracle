create table respuestas(
        idRespuesta bigint not null auto_increment,
        contenido LONGTEXT not null,
        fechaCreacion datetime not null,
        idEstudiante bigint not null,
        idInstructor bigint not null,
        idTopico bigint not null,

        primary key(idRespuesta),
        constraint fk_respuestas_idEstudiante foreign key(idEstudiante) references estudiantes(idEstudiante),
        constraint fk_respuestas_idInstructor foreign key(idInstructor) references instructores(idInstructor),
        constraint fk_respuestas_idTopico foreign key(idTopico) references topicos(idTopico)
        );
