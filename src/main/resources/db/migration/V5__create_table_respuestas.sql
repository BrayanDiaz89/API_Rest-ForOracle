create table respuestas(
        id_respuesta bigint not null auto_increment,
        contenido LONGTEXT not null,
        fechaCreacion datetime not null,
        id_estudiante bigint not null,
        id_instructor bigint not null,
        id_topico bigint not null,

        primary key(id_respuesta),
        constraint fk_respuestas_id_estudiante foreign key(id_estudiante) references estudiantes(id_estudiante),
        constraint fk_respuestas_id_instructor foreign key(id_instructor) references instructores(id_instructor),
        constraint fk_respuestas_id_topico foreign key(id_topico) references topicos(id_topico)
        );
