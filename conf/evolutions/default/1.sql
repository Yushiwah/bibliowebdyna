# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table livre (
  id                            bigint auto_increment not null,
  titre                         varchar(255),
  auteur                        varchar(255),
  description                   varchar(255),
  categorie                     varchar(255),
  constraint pk_livre primary key (id)
);

create table person (
  id                            bigint auto_increment not null,
  firstname                     varchar(255),
  name                          varchar(255),
  age                           integer not null,
  constraint pk_person primary key (id)
);


# --- !Downs

drop table if exists livre;

drop table if exists person;

