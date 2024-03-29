USE [RecursosHumanos]
GO
INSERT [dbo].[Puesto] ([Codigo_Puesto], [Nombre_Puesto], [Descripcion_Puesto]) VALUES (1, N'Administrador de Software', N'Conoce el Software de la empresa en su Totalidad')
INSERT [dbo].[Puesto] ([Codigo_Puesto], [Nombre_Puesto], [Descripcion_Puesto]) VALUES (2, N'Consultor', N'Consultrar el sistema para auditoria')
GO
INSERT [dbo].[Genero] ([Codigo_Genero], [Nombre_Genero]) VALUES (1, N'Masculino')
INSERT [dbo].[Genero] ([Codigo_Genero], [Nombre_Genero]) VALUES (2, N'Femenino')
INSERT [dbo].[Genero] ([Codigo_Genero], [Nombre_Genero]) VALUES (3, N'Otros')
GO
INSERT [dbo].[Estado] ([Codigo_Estado], [Nombre_Estado]) VALUES (1, N'Activo')
INSERT [dbo].[Estado] ([Codigo_Estado], [Nombre_Estado]) VALUES (2, N'Inactivo')
GO
INSERT [dbo].[Empleado] ([Codigo_Empleado], [Nombre_Empleado], [Correo_Empleado], [Sueldo_Empleado], [Direccion_Empleado], [Codigo_GeneroF], [Codigo_PuestoF], [Codigo_EstadoF]) VALUES (N'0301199901357', N'Eric Isaac Rodriguez Bonilla', N'honduras.eric@gmail.com', 15000.0000, N'Col. Brisas de Altamira', 1, 1, 2)
INSERT [dbo].[Empleado] ([Codigo_Empleado], [Nombre_Empleado], [Correo_Empleado], [Sueldo_Empleado], [Direccion_Empleado], [Codigo_GeneroF], [Codigo_PuestoF], [Codigo_EstadoF]) VALUES (N'0801199802725', N'Jorge Eduardo Salgado Romero', N'jesalgadoromero26@gmail.com', 15000.0000, N'Colonia Bella Oriente', 1, 1, 2)
INSERT [dbo].[Empleado] ([Codigo_Empleado], [Nombre_Empleado], [Correo_Empleado], [Sueldo_Empleado], [Direccion_Empleado], [Codigo_GeneroF], [Codigo_PuestoF], [Codigo_EstadoF]) VALUES (N'0801199810682', N'Stephan Marcel Duarte Peña', N'stephan.1998@outlook.com', 15000.0000, N'Colonia Altos de Toncontin', 2, 1, 1)
INSERT [dbo].[Empleado] ([Codigo_Empleado], [Nombre_Empleado], [Correo_Empleado], [Sueldo_Empleado], [Direccion_Empleado], [Codigo_GeneroF], [Codigo_PuestoF], [Codigo_EstadoF]) VALUES (N'0801199902932', N'Alessandro Yamir Torres', N'algo@gmail.com', 15000.0000, N'Colonia', 1, 2, 1)
INSERT [dbo].[Empleado] ([Codigo_Empleado], [Nombre_Empleado], [Correo_Empleado], [Sueldo_Empleado], [Direccion_Empleado], [Codigo_GeneroF], [Codigo_PuestoF], [Codigo_EstadoF]) VALUES (N'0801199919518', N'Anthony Wylberth Rodriguez Thompson', N'awrodriguezt@gmail.com', 15000.0000, N'Residencial Plaza', 1, 1, 1)
GO
INSERT [dbo].[Acceso] ([Codigo_Acceso], [Nombre_Acceso], [Descripcion_Acceso]) VALUES (1, N'Administrador de Sistema de Software', N'Manejo Completo del Programa')
INSERT [dbo].[Acceso] ([Codigo_Acceso], [Nombre_Acceso], [Descripcion_Acceso]) VALUES (2, N'Nivel Alto', N'Permisos Sobre el Sistema Nivel Alto')
INSERT [dbo].[Acceso] ([Codigo_Acceso], [Nombre_Acceso], [Descripcion_Acceso]) VALUES (3, N'Nivel Medio', N'Permisos Sobre el Sistema Nivel Medio')
INSERT [dbo].[Acceso] ([Codigo_Acceso], [Nombre_Acceso], [Descripcion_Acceso]) VALUES (4, N'Nivel Bajo', N'Permisos Sobre el Sistema Nivel Bajo')
GO
INSERT [dbo].[Usuario] ([Codigo_Usuario], [Password_Usuario], [Ultimo_Acceso_Usuario], [Codigo_AccesoF], [Codigo_EstadoF]) VALUES (N'BUF', CONVERT(varchar(50),HASHBYTES('MD5','1'),2), CAST(N'2019-07-21' AS Date), 1, 1)
INSERT [dbo].[Usuario] ([Codigo_Usuario], [Password_Usuario], [Ultimo_Acceso_Usuario], [Codigo_AccesoF], [Codigo_EstadoF]) VALUES (N'ebonilla', CONVERT(varchar(50),HASHBYTES('MD5','1'),2), CAST(N'2019-07-21' AS Date), 1, 1)
INSERT [dbo].[Usuario] ([Codigo_Usuario], [Password_Usuario], [Ultimo_Acceso_Usuario], [Codigo_AccesoF], [Codigo_EstadoF]) VALUES (N'ayamir',CONVERT(varchar(50),HASHBYTES('MD5','1'),2), NULL, 4, 2)
INSERT [dbo].[Usuario] ([Codigo_Usuario], [Password_Usuario], [Ultimo_Acceso_Usuario], [Codigo_AccesoF], [Codigo_EstadoF]) VALUES (N'esalgado',CONVERT(varchar(50),HASHBYTES('MD5','1'),2), CAST(N'2019-07-21' AS Date), 2, 1)
INSERT [dbo].[Usuario] ([Codigo_Usuario], [Password_Usuario], [Ultimo_Acceso_Usuario], [Codigo_AccesoF], [Codigo_EstadoF]) VALUES (N'sduarte', CONVERT(varchar(50),HASHBYTES('MD5','1'),2), NULL, 3, 1)
GO
INSERT [dbo].[Evento] ([Codigo_Evento], [Nombre_Evento], [Descripcion_Evento]) VALUES (1, N'Contratacion', N'Contratacion de Empleado')
INSERT [dbo].[Evento] ([Codigo_Evento], [Nombre_Evento], [Descripcion_Evento]) VALUES (2, N'Bono', N'Asignacion de Bono')
INSERT [dbo].[Evento] ([Codigo_Evento], [Nombre_Evento], [Descripcion_Evento]) VALUES (3, N'Despido', N'Despido de Empleado')
INSERT [dbo].[Evento] ([Codigo_Evento], [Nombre_Evento], [Descripcion_Evento]) VALUES (4, N'Prestaciones', N'Asignacion de Prestaciones')
GO
INSERT [dbo].[Evento_Empleado] ([Codigo_EventoF], [Codigo_EmpleadoF], [Creador_Evento], [Monto_Evento], [Fecha_Evento]) VALUES (1, N'0301199901357', N'0301199901357', 15000.0000, CAST(N'2019-07-18' AS Date))
INSERT [dbo].[Evento_Empleado] ([Codigo_EventoF], [Codigo_EmpleadoF], [Creador_Evento], [Monto_Evento], [Fecha_Evento]) VALUES (1, N'0801199802725', N'0301199901357', 15000.0000, CAST(N'2019-07-18' AS Date))
INSERT [dbo].[Evento_Empleado] ([Codigo_EventoF], [Codigo_EmpleadoF], [Creador_Evento], [Monto_Evento], [Fecha_Evento]) VALUES (1, N'0801199810682', N'0301199901357', 15000.0000, CAST(N'2019-07-18' AS Date))
INSERT [dbo].[Evento_Empleado] ([Codigo_EventoF], [Codigo_EmpleadoF], [Creador_Evento], [Monto_Evento], [Fecha_Evento]) VALUES (1, N'0801199902932', N'0301199901357', 15000.0000, CAST(N'2019-07-18' AS Date))
INSERT [dbo].[Evento_Empleado] ([Codigo_EventoF], [Codigo_EmpleadoF], [Creador_Evento], [Monto_Evento], [Fecha_Evento]) VALUES (1, N'0801199919518', N'0301199901357', 15000.0000, CAST(N'2019-07-18' AS Date))
GO
INSERT [dbo].[Empleado_Usuario] ([Codigo_EmpleadoF], [Codigo_UsuarioF], [Creador_Usuario]) VALUES (N'0301199901357', N'BUF', N'0301199901357')
INSERT [dbo].[Empleado_Usuario] ([Codigo_EmpleadoF], [Codigo_UsuarioF], [Creador_Usuario]) VALUES (N'0301199901357', N'ebonilla', N'0301199901357')
INSERT [dbo].[Empleado_Usuario] ([Codigo_EmpleadoF], [Codigo_UsuarioF], [Creador_Usuario]) VALUES (N'0801199802725', N'esalgado', N'0301199901357')
INSERT [dbo].[Empleado_Usuario] ([Codigo_EmpleadoF], [Codigo_UsuarioF], [Creador_Usuario]) VALUES (N'0801199810682', N'sduarte', N'0801199802725')
INSERT [dbo].[Empleado_Usuario] ([Codigo_EmpleadoF], [Codigo_UsuarioF], [Creador_Usuario]) VALUES (N'0801199902932', N'ayamir', N'0801199802725')
GO
