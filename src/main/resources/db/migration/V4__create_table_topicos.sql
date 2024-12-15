create table topicos(
        id_topico bigint not null auto_increment,
        titulo varchar(100) not null,
        descripcion LONGTEXT not null,
        fechaCreacion datetime not null,
        id_curso bigint not null,
        id_estudiante bigint not null,

        primary key(id_topico),
        constraint fk_topicos_id_curso foreign key(id_curso) references cursos(id_curso),
        constraint fk_topicos_id_estudiante foreign key(id_estudiante) references estudiantes(id_estudiante)
        );
