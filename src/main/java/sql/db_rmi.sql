create database db_rmi;

use db_rmi;

create table medicos( 
	id int auto_increment primary key, 
	crm int not null, 
	cpf varchar(64) not null, 
	nome varchar(64) not null, 
	especialidade varchar(127), 
	email varchar(64) not null,
	senha varchar(64) not null);
	
create table pacientes(
	id int auto_increment primary key,
	nome varchar(64) not null,
	cpf varchar(16) not null,
	dataNasc varchar(16) not null,
	rg varchar(16) not null,
	sexo varchar(16) not null,
	estadoCivil varchar(16) not null,
	endereco varchar(127) not null,
	telefone varchar(32) not null,
	queixa_principal text,
	alergia varchar(255),
	doenca varchar(255),
	cirurgia varchar(127),
	tipo_sanguineo varchar(16),
	gestante varchar(16),
	usa_medicamentos varchar(16),
	diagnostico text,
	receita text,
	idMedico int not null,
	foreign key(idMedico) references medicos(id)
	
);
