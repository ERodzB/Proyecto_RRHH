USE master
GO
create database RecursosHumanos
GO
use  RecursosHumanos
GO
Create table Puesto
(
	Codigo_Puesto int primary key not null,
	Nombre_Puesto varchar(100) not null,
	Descripcion_Puesto varchar(200) not null
)
GO
create table Genero(
	Codigo_Genero int primary key not null,
	Nombre_Genero varchar(50) not null
)
GO
create table Estado(
	Codigo_Estado int primary key,
	Nombre_Estado varchar(50) not null
)
GO
create table Evento(
	Codigo_Evento int primary key,
	Nombre_Evento varchar(50) not null,
	Descripcion_Evento varchar(100) not null,
)
GO
create table Empleado
(
	Codigo_Empleado varchar(50) primary key not null,
	Nombre_Empleado varchar(200) not null,
	Correo_Empleado varchar(100) not null,
	Sueldo_Empleado money not null,
	Direccion_Empleado varchar(100) not null,
	Codigo_GeneroF int foreign key references Genero(Codigo_Genero) not null,
	Codigo_PuestoF int foreign key references Puesto(Codigo_Puesto) not null,
	Codigo_EstadoF int foreign key references Estado(Codigo_Estado) not null,
)
GO
create table Evento_Empleado(
	Codigo_EventoF int foreign key references Evento(Codigo_Evento) not null,
	Codigo_EmpleadoF varchar(50) foreign key references Empleado(Codigo_Empleado) not null,
	Creador_Evento varchar(200) not null,
	Monto_Evento money not null,
	Fecha_Evento date not null
)
GO
create table Acceso(
	Codigo_Acceso int primary key not null,
	Nombre_Acceso varchar(100) not null,
	Descripcion_Acceso varchar(200) not null
)
GO
create table Usuario
(
	Codigo_Usuario varchar(50) primary key not null,
	Password_Usuario varchar(100) not null,
	Ultimo_Acceso_Usuario date,
	Codigo_AccesoF int foreign key references Acceso(Codigo_Acceso) not null,
	Codigo_EstadoF int foreign key references Estado(Codigo_Estado) not null
)
GO
create table Empleado_Usuario(
	Codigo_EmpleadoF varchar(50) foreign key references Empleado(Codigo_Empleado) not null,
	Codigo_UsuarioF varchar(50) foreign key references Usuario(Codigo_Usuario) not null,
	Creador_Usuario varchar(200) not null
)
GO

