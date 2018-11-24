drop database  if exists Empresa; 

create database Empresa;

use Empresa;


create table tipoUsuario(
id_tipo int(11) primary key,
nomTipo varchar(45),
Config boolean,
AddMesa boolean,
ConfigPre boolean,
ModifPro boolean
);
create table Usuarios(
idUser int primary key  auto_increment,
Usuario char(5) Unique,
pwdUser varchar(45),
Correo varchar(45),
nomUser varchar(45),
apeUser varchar(60),
last_Sesion varchar(30),
time_SignIn varchar(30),
id_tipo int(11) ,
foreign key (id_tipo) references tipoUsuario(id_tipo)
);
create table TipoMesa(
idTipo int(11) primary key,
nomTipo varchar(40)
);
create table NumMesa(
idMesa char(5) not null,
numMesa int(11) primary key,
numSillas int(11) default 4,
estado int(11),
foreign key (estado) references TipoMesa(idTipo)
);

create table TipoProductos(
idTipo_Pro int(11) primary key,
nomTip_pro varchar(45)
);
create table Productos(
idTipo_Pro int(11),
CodPro char(5) primary key ,
nomPro varchar(45),
stock int(11),
precio double,
foreign key(idTipo_Pro) references TipoProductos(idTipo_Pro)
);
create table menu(
idMenu int(11) primary key,
nomMenu varchar(45),
foreign key (idMenu) references TipoProductos(idTipo_Pro)
);
create table Bebidas(
idBebida int(11) primary key,
nomBebida varchar(45),
foreign key (idBebida) references TipoProductos(idTipo_Pro)
);
create table Extras(
idExtras int(11) primary key,
nomExtras varchar(45),
foreign key (idExtras) references TipoProductos(idTipo_Pro)
);
create table Clientes(
idCliente int(11) primary key auto_increment,
CodCli char(5) unique,
dniCli int(8) ,
nomCli varchar(45),
apeCli varchar(65),
telefono int(9),
numMesa int(11),
estado  int(11),
foreign key (numMesa) references NumMesa(numMesa),
foreign key (estado) references TipoMesa(idTipo)
);
create table Platillos(
idVentaMenu int(11) primary key auto_increment,
numVenta varchar(45),
nomExtras varchar(45),
cant int(11) default 1,
idCli int(11),
tipo char(5),
foreign key (tipo) references Productos(CodPRo),
foreign key (idCli) references Clientes(idCliente)
);

#drop table TipoMesa;
#drop table nummesa;
#drop table Productos;
#drop table Clientes;
#drop table Platillos;
#drop table Usuarios;

select*from tipoUsuario;
select*from Usuarios;
select*from NumMesa;
select*from TipoMesa;
select*from TipoProductos;
select*from Productos;
select*from Clientes;




#select*from tb_Usuario where Usuario = ? and pwdUser= ?
#drop database tb_Usuario

#por defecto

insert into tipoUsuario values(0,'Usuario',false,false,false,false);
insert into tipoUsuario values(1,'Administrador',false,false,false,false);

insert into TipoMesa values(0,'libre');
insert into TipoMesa values(1,'Disponible');
insert into TipoMesa values(2,'Completo');

insert into TipoProductos values(0,'Menú');
insert into TipoProductos values(1,'Bebidas');
insert into TipoProductos values(2,'Extras');





#select numMesa from Ventas.NumMesa;

#insert into clientes values(default,'cli0001',12345678,'yo noses','yoqese ds',123456789,1);






#insert into tb_Usuario (usuario,pwdUser) values('admin','admin')


/*DELIMITER $$
DROP PROCEDURE IF EXISTs ejemp$$
CREATE PROCEDURE PRIVE()
BEGIN
	select*from tipoUsuario;
END $$
DELIMITER ;
CALL PRIVE;
*/
select*from NumMesa;
#DELETE FROM NumMesa where numMesa >0 ;
DELIMITER $$
DROP PROCEDURE IF EXISTs add_mesa $$
CREATE PROCEDURE add_mesa(cod varchar(11),num int(11),sillas INT(11),estado int(11))
begin
	INSERT INTO NumMesa VALUES(cod,num,sillas,estado);
end $$
delimiter ;
CALL add_mesa('m0001',1,4,1);
CALL add_mesa('m0002',2,4,2);
CALL add_mesa('m0003',3,4,1);
CALL add_mesa('m0004',4,4,0);

DELIMITER $$
DROP PROCEDURE IF EXISTs num_mesa $$
create procedure num_mesa(num int(11))
begin
	select (numSillas) from NumMesa where numMesa=num;
end $$
delimiter ;
call num_mesa (1);

select*from productos;
delimiter $$
DROP PROCEDURE IF EXISTs add_producto $$
create procedure add_producto(tipo int(11),cod char(5),nom varchar(45),stock int(11),precio double)
begin
	insert into productos  values (tipo,cod,nom,stock,precio);
end $$
delimiter ;
call add_producto(2,'P0001','ceviche',5,25.0);

select*from Clientes;
delimiter $$
create procedure add_cliente(cod char(5),dni int(8),nom varchar(45),apell varchar(65),fono int(9),mesa int(11) ,est int(11))
begin
	insert into Clientes values(null,cod,dni,nom,apell,fono,mesa,est);
end $$
delimiter ;

select*from usuarios;
drop procedure  add_cliente;
call add_cliente('Cl111',12345678,'nombre cli','apellido cli',123456789,1,2);
delimiter $$
create procedure add_usuario(usr char(5),pw varchar(45),email varchar(50),nom varchar(45),ape varchar(60), d varchar(30),t varchar(30), priv int(11))
begin
	insert into usuarios values(null,usr,pw,email,nom,ape,d,t,priv);
end $$
delimiter ;
call add_usuario('UCLI','password()','correo@gmail.com','wil klinghton','incautipa flores','23/11/2018 s','8:18 pm',1);