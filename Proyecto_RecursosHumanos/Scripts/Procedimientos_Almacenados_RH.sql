use RecursosHumanos
GO
/*----------------------------Procedimiento de Inicio Sesion --------------------------------*/
create procedure InicioSesion
	@Codigo_Usuario varchar(50),
	@Password_Usuario varchar(100)
	as
	begin
		select u.Codigo_AccesoF,u.Ultimo_Acceso_Usuario, SUBSTRING(e.Nombre_Empleado,0,PATINDEX('% %',e.Nombre_Empleado)) as 'Nombre_Empleado', e.Codigo_Empleado, u.Codigo_EstadoF from Usuario u
		inner join Empleado_Usuario eu ON eu.Codigo_UsuarioF=u.Codigo_Usuario
		inner join Empleado e on e.Codigo_Empleado = eu.Codigo_EmpleadoF
		where u.Codigo_Usuario=@Codigo_Usuario and u.Password_Usuario=CONVERT(varchar(50),HASHBYTES('MD5',@Password_Usuario),2)
	end
	begin
		update Usuario
		set Ultimo_Acceso_Usuario=GETDATE()
		where Codigo_Usuario =@Codigo_Usuario and Password_Usuario=CONVERT(varchar(50),HASHBYTES('MD5',@Password_Usuario),2)
	end
GO

/*-----------------------------------------------------------------------------------------------*/
create procedure CreacionUsuario
	@Codigo_Empleado varchar(50),
	@codigo_usuario varchar(50),
	@pw varchar(100),
	@codigo_acceso int,                
	@codigo_estado int,
	@Creador_Usuario varchar(200)          
	as
	begin
		insert into Usuario(Codigo_Usuario, Password_Usuario, Codigo_AccesoF, Codigo_EstadoF)
		values (@codigo_usuario, CONVERT(varchar(50),HASHBYTES('MD5',@pw),2), @codigo_acceso, @codigo_estado)
		insert into Empleado_Usuario values(@Codigo_Empleado,@codigo_usuario, @Creador_Usuario)
	end
GO
/*-----------------------------------Validacion Usuario------------------------------------------------------*/
create procedure RevisarUsuario
 @Codigo_Usuario varchar(50)
 as
 begin
	select count(*) from Usuario
	where Codigo_Usuario=@Codigo_Usuario
end
Go

/*----------------------Modificar Usuario---------------------------------*/
create procedure ModificarUsuario
@Cod_Usuario varchar(50),
@Cod_Acceso int,
@Cod_Estado int
as
begin
	update Usuario
	set
	Codigo_Usuario=@Cod_Usuario, 
	Codigo_AccesoF = @Cod_Acceso,
	Codigo_EstadoF = @Cod_Estado
	where Codigo_Usuario = @Cod_Usuario
	update Empleado_Usuario
	set
	Codigo_UsuarioF=@Cod_Usuario
	where Codigo_UsuarioF=@Cod_Usuario
end
GO
/*---------------------------------Cargar Usuario----------------------------------------------------------*/
create procedure CargarUsuario
as
begin
	select u.Codigo_Usuario'Nombre Usuario', e.Nombre_Empleado'Empleado' from Usuario u
	inner join Empleado_Usuario eu on eu.Codigo_UsuarioF=u.Codigo_Usuario
	inner join Empleado e on e.Codigo_Empleado=eu.Codigo_EmpleadoF
end
go
--Antigua Password
create procedure AntiguaPassword
	@Codigo_Usuario varchar(50),
	@Password_Usuario varchar(100)
	as
	begin
		select COUNT(*) from Usuario u
		where u.Codigo_Usuario=@Codigo_Usuario and u.Password_Usuario=CONVERT(varchar(50),HASHBYTES('MD5',@Password_Usuario),2)
	end
GO
--Cambiar Password
create procedure CambiarPassword
	@Codigo_Usuario varchar(50),
	@Password_Usuario varchar(100)
	as
	begin
		update Usuario
		set Password_Usuario=CONVERT(varchar(50),HASHBYTES('MD5',@Password_Usuario),2)
		where Codigo_Usuario=@Codigo_Usuario
	END
GO
/*-------Cargar Empleado Sin Usuarios-------*/
create procedure EmpleadoSinUser
as
begin
	select  e.Codigo_Empleado,e.Nombre_Empleado from Empleado e
	left join Empleado_Usuario eu on e.Codigo_Empleado=eu.Codigo_EmpleadoF
	group by e.Codigo_Empleado,e.Nombre_Empleado
	having COUNT(eu.Codigo_UsuarioF)=0
end
go
/*--------------Cargar tabla----------------*/
create procedure CargarTabla
as
begin
	select u.Codigo_Usuario'Nombre de Usuario', a.Nombre_Acceso'Tipo de Acceso', e.Nombre_Estado'Estado' from Usuario u
	Inner join Acceso a on u.Codigo_AccesoF = a.Codigo_Acceso
	inner join Estado e on u.Codigo_EstadoF = e.Codigo_Estado
end
GO


/*-------------------Carga Combobox----------------------*/
create Procedure CargaCmbAcceso
as
begin
	select a.Nombre_Acceso from Acceso a
end
GO
create Procedure CargaCmbEstado
as
begin
	select e.Nombre_Estado from Estado e
end
GO
/*-------------------Vista Datos Personales Empleados----------------------*/
create procedure CargarDGVEmpleados
as
begin
select e.Nombre_Empleado,e.Correo_Empleado,cast(e.Sueldo_Empleado as decimal(10,2)),e.Direccion_Empleado,g.Nombre_Genero from Empleado e
inner join Genero g on e.Codigo_GeneroF = g.Codigo_Genero
inner join Puesto p on e.Codigo_PuestoF = p.Codigo_Puesto
inner join Estado es on e.Codigo_PuestoF = es.Codigo_Estado
end
go
/*-------------------Datso Generales Empleados----------------------*/
create procedure DVGEmpleadoDGenerales
as
begin
select e.Codigo_Empleado,e.Nombre_Empleado,
p.Nombre_Puesto,es.Nombre_Estado from Empleado e
inner join Puesto p on e.Codigo_PuestoF = p.Codigo_Puesto
inner join Estado es on e.Codigo_PuestoF = es.Codigo_Estado
end
GO
/*------------------Combobox Generos----------------------*/
go
Create Procedure [dbo].[CargaCmbGenero]
as
begin
	select g.Nombre_Genero from Genero g
end
go
/*-------------------ComboboxPuestos----------------------*/
Create Procedure [dbo].[CargaCmbPuesto]
as
begin
	select p.Nombre_Puesto from Puesto p
end
go
/*-------------------Filtrado de EMpleados----------------------*/
create procedure filtroEmpleados
@vista as int,
@filtro as varchar(50),
@filtrox as int
as
begin
	if(@vista=0)
		begin
		if(@filtro='Puesto')

			begin
				select e.Codigo_Empleado,e.Nombre_Empleado,
				p.Nombre_Puesto,es.Nombre_Estado from Empleado e
				inner join Puesto p on e.Codigo_PuestoF = p.Codigo_Puesto
				inner join Estado es on e.Codigo_EstadoF = es.Codigo_Estado
				where e.Codigo_PuestoF=@filtrox
			end

		if(@filtro='Estado')

		begin
			select e.Codigo_Empleado,e.Nombre_Empleado,
			p.Nombre_Puesto,es.Nombre_Estado from Empleado e
			inner join Puesto p on e.Codigo_PuestoF = p.Codigo_Puesto
			inner join Estado es on e.Codigo_EstadoF = es.Codigo_Estado
			where e.Codigo_EstadoF=@filtrox;
		end

		end

		if(@vista=1)
		begin
			select e.Nombre_Empleado,e.Correo_Empleado,cast(e.Sueldo_Empleado as decimal(10,2)),e.Direccion_Empleado,g.Nombre_Genero from Empleado e
			inner join Genero g on e.Codigo_GeneroF = g.Codigo_Genero
			inner join Puesto p on e.Codigo_PuestoF = p.Codigo_Puesto
			inner join Estado es on e.Codigo_EstadoF = es.Codigo_Estado
			where e.Codigo_GeneroF=@filtrox;
		end

end
go
/*-------------------Filtrado Usuarios----------------------*/
create procedure CargarDatosUsuarios
@nivel as int,
@filtro as varchar(50),
@filtrox as int
as
begin
	if(@nivel=1)
	begin
	if(@filtro='nada')
			select u.Codigo_Usuario,u.Password_Usuario,ep.Nombre_Empleado,a.Nombre_Acceso,e.Nombre_Estado from Usuario u
			inner join Acceso a on u.Codigo_AccesoF = a.Codigo_Acceso
			inner join Estado e on u.Codigo_EstadoF = e.Codigo_Estado
			inner join Empleado_Usuario eu on u.Codigo_Usuario = eu.Codigo_UsuarioF
			inner join Empleado ep on eu.Codigo_EmpleadoF = ep.Codigo_Empleado
		if(@filtro='Acceso')
			select u.Codigo_Usuario,u.Password_Usuario,ep.Nombre_Empleado,a.Nombre_Acceso,e.Nombre_Estado from Usuario u
			inner join Acceso a on u.Codigo_AccesoF = a.Codigo_Acceso
			inner join Estado e on u.Codigo_EstadoF = e.Codigo_Estado
			inner join Empleado_Usuario eu on u.Codigo_Usuario = eu.Codigo_UsuarioF
			inner join Empleado ep on eu.Codigo_EmpleadoF = ep.Codigo_Empleado
			where u.Codigo_AccesoF=@filtrox
		if(@filtro='Estado')
			select u.Codigo_Usuario,u.Password_Usuario,ep.Nombre_Empleado,a.Nombre_Acceso,e.Nombre_Estado from Usuario u
			inner join Acceso a on u.Codigo_AccesoF = a.Codigo_Acceso
			inner join Estado e on u.Codigo_EstadoF = e.Codigo_Estado
			inner join Empleado_Usuario eu on u.Codigo_Usuario = eu.Codigo_UsuarioF
			inner join Empleado ep on eu.Codigo_EmpleadoF = ep.Codigo_Empleado
			where u.Codigo_EstadoF=@filtrox
	end
	if(@nivel=2)
	begin
		if(@filtro='nada')
			select u.Codigo_Usuario,ep.Nombre_Empleado,e.Nombre_Estado from Usuario u
			inner join Acceso a on u.Codigo_AccesoF = a.Codigo_Acceso
			inner join Estado e on u.Codigo_EstadoF = e.Codigo_Estado
			inner join Empleado_Usuario eu on u.Codigo_Usuario = eu.Codigo_UsuarioF
			inner join Empleado ep on eu.Codigo_EmpleadoF = ep.Codigo_Empleado
		if(@filtro='Estado')
			select u.Codigo_Usuario,ep.Nombre_Empleado,e.Nombre_Estado from Usuario u
			inner join Acceso a on u.Codigo_AccesoF = a.Codigo_Acceso
			inner join Estado e on u.Codigo_EstadoF = e.Codigo_Estado
			inner join Empleado_Usuario eu on u.Codigo_Usuario = eu.Codigo_UsuarioF
			inner join Empleado ep on eu.Codigo_EmpleadoF = ep.Codigo_Empleado
			where u.Codigo_EstadoF=@filtrox;
	end
end
GO
/****-------------------------------Cambio Contraseña-------------------------------------------------*/
create procedure ValidacionContra
	@Codigo_Usuario varchar(50),
	@Correo_Empleado varchar(100)
	as
	begin
		select COUNT(*) from Usuario u
		inner join Empleado_Usuario eu on u.Codigo_Usuario=eu.Codigo_UsuarioF
		inner join Empleado e on e.Codigo_Empleado=eu.Codigo_EmpleadoF
		where u.Codigo_Usuario=@Codigo_Usuario and e.Correo_Empleado=@Correo_Empleado
	end
	go
-- Actualizacion de Contraseña
create procedure UpdatePassword
	@Codigo_Usuario varchar(50),
	@Password varchar(100)
	as
	begin
		Update Usuario
		set Password_Usuario= CONVERT(varchar(100),HASHBYTES('MD5',@Password),2)
		where  Codigo_Usuario=@Codigo_Usuario
	end
	GO
--Obtener Contra
create procedure ObtenerPass
	@Codigo_Usuario varchar(50)
	as
	begin
		select CAST(DATEPART(SECOND,getdate()) as nvarchar)+SUBSTRING(REVERSE(Codigo_Usuario),0,4)+CAST(DATEPART(DAYOFYEAR,GETDATE()) as nvarchar) from Usuario where Codigo_Usuario=@Codigo_Usuario
	end
	GO
--Validacion Empleado
create procedure ValidacionEmpleado
	@Codigo_Empleado varchar(50)
	as
	begin
		select count(*) from Empleado
		where Codigo_Empleado=@Codigo_Empleado
	end
	GO
--Nuevo Empleado
create procedure NuevoEmpleado
	@Codigo_Empleado varchar(50),
	@Nombre_Empleado varchar(200),
	@Correo_Empleado varchar(100),
	@Sueldo_Empleado money,
	@Direccion_Empleado varchar(100),
	@Genero int,
	@Puesto int,
	@Creador_Evento varchar(200)
	as
	begin
		insert [dbo].[Empleado]
		values(@Codigo_Empleado,@Nombre_Empleado,@Correo_Empleado,@Sueldo_Empleado,@Direccion_Empleado,@Genero,
		@Puesto,1)
		insert[dbo].[Evento_Empleado]
		values(1,@Codigo_Empleado,@Creador_Evento,@Sueldo_Empleado,GETDATE())
	end
	GO
