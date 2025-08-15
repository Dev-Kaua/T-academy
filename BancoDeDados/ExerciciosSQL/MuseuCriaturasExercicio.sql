CREATE DATABASE MuseuDeCriaturas;

use MuseuDeCriaturas ;

create table criatura(
	idCriatura INT primary key not null auto_increment, 
    nome varchar(45),
    descrição text,
    origem text,
    idade_criatura int not null
);

create table exposicao(
	idExposicao INT primary key not null auto_increment,
    nome varchar(45),
    
);