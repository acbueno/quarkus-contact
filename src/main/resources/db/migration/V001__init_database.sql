
create table address (
  id bigint not null auto_increment,
  id_contact bigint,
  city varchar(255),
  neighborhood varchar(255),
  note varchar(255),
  number varchar(255),
  zip_code varchar(255),
  primary key (id)
) engine = InnoDB;
create table contact (
  id bigint not null auto_increment,
  alias varchar(255),
  name varchar(255),
  primary key (id)
) engine = InnoDB;
create table phone (
  id bigint not null auto_increment,
  id_contact bigint,
  number varchar(255),
  phoneType enum (
    'CELL', 'RESIDENTIAL', 'BUSINESS'
  ),
  primary key (id)
) engine = InnoDB;
alter table
  address
add
  constraint FKrjam991vvsulj591rgdn1f1ou foreign key (id_contact) references contact (id);
alter table
  phone
add
  constraint FKfya6yl5mgjm86ftdt6ss84l5q foreign key (id_contact) references contact (id);
