create table estudiantes(
        idEstudiante bigint not null auto_increment,
        nombre varchar(100) not null,
        email varchar(100) not null unique,
        fechaRegistro datetime not null,
        idCurso bigint not null,

        primary key(idEstudiante),
        constraint fk_estudiantes_idCurso foreign key(idCurso) references cursos(idCurso)
        );