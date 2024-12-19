create table topicos(
        id bigint not null auto_increment,
        titulo varchar(100) not null,
        descripcion LONGTEXT not null,
        fecha datetime not null,
        id_curso bigint not null,
        id_estudiante bigint not null,

        primary key(id),
        constraint fk_topicos_id_curso foreign key(id_curso) references cursos(id),
        constraint fk_topicos_id_estudiante foreign key(id_estudiante) references estudiantes(id)
        );
