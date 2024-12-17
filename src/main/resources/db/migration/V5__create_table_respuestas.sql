create table respuestas(
        id bigint not null auto_increment,
        contenido LONGTEXT not null,
        fecha datetime not null,
        id_estudiante bigint not null,
        id_instructor bigint not null,
        id_topico bigint not null,

        primary key(id),
        constraint fk_respuestas_id_estudiante foreign key(id_estudiante) references estudiantes(id),
        constraint fk_respuestas_id_instructor foreign key(id_instructor) references instructores(id),
        constraint fk_respuestas_id_topico foreign key(id_topico) references topicos(id)
        );
