create table instructores(
        idInstructor bigint not null auto_increment,
        nombre varchar(100) not null,
        email varchar(100) not null unique,
        fechaRegistro datetime not null,
        idCurso bigint not null,

        primary key(idInstructor),
        constraint fk_instructores_idCurso foreign key(idCurso) references cursos(idCurso)
        );