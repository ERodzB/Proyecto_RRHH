/*--------------------------------------Procedimiento para crear un Nuevo Puesto---------------------------------------------------*/
create procedure NuevoPuesto
	@Codigo_Puesto int,
	@Nombre_Puesto varchar(50),
	@Descripcion_Puesto varchar(100)
as
begin
		insert into Puesto	
		(
			Codigo_Puesto,
			Nombre_Puesto,
			Descripcion_Puesto
		)
		values(
		@Codigo_Puesto,
		@Nombre_Puesto,
		@Descripcion_Puesto
		)
end

/*--------------------------------------Procedimiento para Crear un nuevo Empleado---------------------------------------------------*/
create procedure NuevoEmpleado
	@Codigo_Empleado varchar(50),
	@Nombre_Empleado varchar(50), 
	@Apellido_Empleado varchar(50),
	@Genero_Empleado varchar(20),
	@Correo_Empleado varchar(50),
	@Codigo_PuestoF int,
	@Sueldo_Empleado money,
	@Fecha_Contratacion_Empleado date
as
begin
	insert into Empleado
	(
	Codigo_Empleado ,
	Nombre_Empleado , 
	Apellido_Empleado,
	Genero_Empleado ,
	Correo_Empleado,
	Codigo_PuestoF ,
	Sueldo_Empleado,
	Fecha_Contratacion_Empleado ,
	Estado_Empleado
	)
	values
	(
		@Codigo_Empleado ,
		@Nombre_Empleado , 
		@Apellido_Empleado,
		@Genero_Empleado ,
		@Correo_Empleado,
		@Codigo_PuestoF ,
		@Sueldo_Empleado,
		@Fecha_Contratacion_Empleado ,
		'Contratado'
	)
end
GO

/*--------------------------------------Procedimiento para la Creacion de Un nuevo Usuario------------------------------------------*/

create procedure CreacionUsuario
	@Codigo_Usuario varchar(50),
	@Password_Usuario as varchar(100),
	@Nivel_Autoridad_Usuario as varchar(20)
	as
	begin

	insert into Usuario
	(
		Codigo_Usuario,
		Password_Usuario,
		Nivel_Autoridad_Usuario,
		Codigo_EmpleadoF
	)
	values
	(
		@Codigo_Usuario,
		@Password_Usuario,
		@Nivel_Autoridad_Usuario,
		@Codigo_Usuario
	)
	end

/*--------------------------------------------Procedimiento de Consultas Generales------------------------------------------------------*/
create procedure ConsultaGeneral
		@TipoConsulta as varchar(50)
	as
	if @TipoConsulta='Empleado'
		Begin
			select * from Empleado
		end
	if @TipoConsulta='Usuario'
		Begin
			select * from Usuario
		end
	if @TipoConsulta='Puesto'
		Begin
			select * from Puesto
		end

/*--------------------------------------------Procedimiento de Consulta a Empleado Especifico--------------------------------------*/
create procedure ConsultaEmpleado
	@Codigo_Empleado as varchar(50)
as
begin
	Select E.Nombre_Empleado, E.Apellido_Empleado,E.Genero_Empleado,P.Nombre_Puesto,E.Sueldo_Empleado,E.Correo_Empleado,
	E.Fecha_Contratacion_Empleado, E.Fecha_Despido_Empleado,E.Estado_Empleado
	 from Empleado E 
	 inner join Puesto P on P.Codigo_Puesto=E.Codigo_PuestoF 
	 where E.Codigo_Empleado = @Codigo_Empleado
end
/*--------------------------------------------Procedimiento de Modificacion de Empleado------------------------------------------*/
create procedure ModificarEmpleado
	@Codigo_Empleado varchar(50),
	@Nombre_Empleado varchar(50), 
	@Apellido_Empleado varchar(50),
	@Genero_Empleado varchar(20),
	@Codigo_PuestoF int,
	@Sueldo_Empleado money,
	@Correo_Empleado varchar(50),
	@Fecha_Contratacion_Empleado as date,
	@Fecha_Despido_Empleado as date,
	@Estado_Empleado as varchar(50)
	
	
as
if @Estado_Empleado='Contratado'
	begin
		update Empleado 
		set  Nombre_Empleado =@Nombre_Empleado,
		Apellido_Empleado = @Apellido_Empleado,
		Genero_Empleado = @Genero_Empleado,
		Correo_Empleado = @Correo_Empleado,
		Codigo_PuestoF = @Codigo_PuestoF,
		Sueldo_Empleado = @Sueldo_Empleado,
		Fecha_Contratacion_Empleado =@Fecha_Contratacion_Empleado,
		Fecha_Despido_Empleado =null,
		Comentario_Empleado = NULL,
		Estado_Empleado = @Estado_Empleado
		where Empleado.Codigo_Empleado = @Codigo_Empleado
	end
if @Estado_Empleado='Despedido'
	begin
	update Empleado 
		set  Nombre_Empleado =@Nombre_Empleado,
		Apellido_Empleado = @Apellido_Empleado,
		Genero_Empleado = @Genero_Empleado,
		Correo_Empleado = @Correo_Empleado,
		Codigo_PuestoF = @Codigo_PuestoF,
		Sueldo_Empleado = @Sueldo_Empleado,
		Fecha_Contratacion_Empleado =@Fecha_Contratacion_Empleado,		
		Estado_Empleado = @Estado_Empleado		
		where Empleado.Codigo_Empleado = @Codigo_Empleado
	end
	
/*--------------------------------------------Procedimiento de Ingreso con login------------------------------------------------*/
create procedure Ingreso
	@Codigo_Usuario as varchar(50),
	@Password_Usuario as varchar(100)

as
	begin
		select U.Nivel_Autoridad_Usuario from Usuario U
		where U.Codigo_Usuario=@Codigo_Usuario and U.Password_Usuario=@Password_Usuario
	end
	
--------------------------------------------Procedimiento de Modificacion de Contraseña------------------------------------------*/
create procedure CambiarContrasena
	@Usuario_Actual as varchar(50),
	@Password_Usuar as varchar(50), 
	@New_Password_Usuar as varchar(50)

as
	begin
		update Usuario
		set  Password_Usuario = @New_Password_Usuar
		where Usuario.Codigo_Usuario = @Usuario_Actual and Password_Usuario = @Password_Usuar
	end


/*--------------------------------------------Procedimiento de Olvido de Contraseña------------------------------------------*/
create procedure OlvidarContrasena
	@Usuario_Actual as varchar(50)

as
	begin
		update Usuario
		set  Password_Usuario = 'AAA111'
		where Usuario.Codigo_Usuario = @Usuario_Actual
	end
/*--------------------------------------------------Procedimiento del bono-------------------------------------------------------*/

Create procedure AgregarBono
	@Bono_Empleado money,
	@Codigo_Empleado varchar(50)
as
	begin
	Update Empleado
	set Bono_Empleado = @Bono_Empleado
	where Empleado.Codigo_Empleado = @Codigo_Empleado
end
/*--------------------------------------------------Procedimiento de Despido/Renuncia-------------------------------------------------------*/
create procedure Ultimatum
	@Codigo_Empleado as varchar(50),
	@Comentario_Empleado as varchar(300),
	@Fecha_Despido_Empleado as date,
	@Prestacion_Empleado as float
as
	if @Prestacion_Empleado=0.5
	begin
		update Empleado 
		set Comentario_Empleado=@Comentario_Empleado,
		Fecha_Despido_Empleado=@Fecha_Despido_Empleado,
		Prestacion_Empleado=@Prestacion_Empleado*Sueldo_Empleado,
		Estado_Empleado='Despedido'
		where Codigo_Empleado=@Codigo_Empleado
	end
	if @Prestacion_Empleado=0.1
	begin
		update Empleado 
		set Comentario_Empleado=@Comentario_Empleado,
		Fecha_Despido_Empleado=@Fecha_Despido_Empleado,
		Prestacion_Empleado=Sueldo_Empleado,
		Estado_Empleado='Despedido'
		where Codigo_Empleado=@Codigo_Empleado
	end

/*---------------------------------------------Procedimiento de carga de combobox------------------------------------------------*/

create procedure CargaCombobox
as
begin
select Codigo_Puesto, Nombre_Puesto from  Puesto
end

/*-------------------------------------------Procedimiento valida Puesto----------------------------------------------*/

create procedure ValidaPuesto
	@Nombre_Puesto as varchar(50)
as
	begin
		select * from Puesto where Nombre_Puesto=@Nombre_Puesto
	end
/*---------------------------------------------Procedimiento de Cargar Puesto----------------------------------------*/
create procedure CargaPuesto
	@Codigo_Empleado as varchar(50)
as
	begin
		select E.Codigo_PuestoF from Empleado E
		where E.Codigo_Empleado=@Codigo_Empleado
	end