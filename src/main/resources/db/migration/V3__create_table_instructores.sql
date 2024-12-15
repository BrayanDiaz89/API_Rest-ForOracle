create table instructores(
        id_instructor bigint not null auto_increment,
        nombre varchar(100) not null,
        email varchar(100) not null unique,
        fechaRegistro datetime not null,
        id_curso bigint not null,

        primary key(id_instructor),
        constraint fk_instructores_id_curso foreign key(id_curso) references cursos(id_curso)
        );