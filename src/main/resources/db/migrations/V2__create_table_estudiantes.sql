create table estudiantes(
        id_estudiante bigint not null auto_increment,
        nombre varchar(100) not null,
        email varchar(100) not null unique,
        fechaRegistro datetime not null,

        primary key(id_estudiante),
        constraint fk_id_curso_estudiante foreign key(id_curso) references cursos(id_curso)
        );