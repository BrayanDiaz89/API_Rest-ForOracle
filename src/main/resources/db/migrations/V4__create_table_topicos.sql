create table topicos(
        id_topico bigint not null auto_increment,
        titulo varchar(100) not null,
        descripcion LONGTEXT not null,
        fechaCreacion datetime not null,

        primary key(id_topico),
        constraint fk_id_curso_topico foreign key(id_curso) references cursos(id_curso),
        constraint fk_id_estudiante_topico foreign key(id_estudiante) references estudiantes(id_estudiante)
        );
