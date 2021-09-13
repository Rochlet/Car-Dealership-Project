drop database if exists CarDealershipDB;
create database CarDealershipDB;
use CarDealershipDB;
create table manufacturers(
	manufacturer_id int auto_increment,
		constraint pk_manufacturers primary key (manufacturer_id),
	make varchar(50) not null,
    model varchar(50) not null
);
create table colors(
	color_id int auto_increment,
		constraint pk_colors primary key (color_id),
	color varchar(10) not null
);
create table body_styles(
	body_style_id int auto_increment, 
		constraint pk_body_styles primary key (body_style_id),
	body_style varchar(10) not null
);
create table roles(
	role_id int auto_increment,
		constraint pk_roles primary key(role_id),
	company_role varchar(50) not null
);
create table puchase_types(
	purchase_type_id int auto_increment,
		constraint pk_purchase_types primary key(purchase_type_id),
	purchase_type varchar(50) not null
);
create table vehicles(
	vehicle_id int auto_increment,
		constraint pk_vehicles primary key(vehicle_id),
	vin varchar(17) not null,
    manufacturer_id int not null,
		constraint fk_manufacturers foreign key(manufacturer_id) references manufacturers(manufacturer_id),
	photo varchar(100) not null,
    descrption text not null,
    mileage int not null,
    sales_price dec(9,2) not null,
    msrp dec(9,2) not null,
    automatic boolean not null,
    color_id int not null,
		constraint fk_colors foreign key(color_id) references colors(color_id),
	vehicle_year int not null,
    body_style_id int not null,
		constraint fk_body_styles foreign key(body_style_id) references body_styles(body_style_id),
	used boolean not null
);
create table specials(
	special_id int auto_increment,
		constraint pk_specials primary key (special_id),
	special_start_date date not null,
    special_end_date date not null,
    vehicle_id int not null,
		constraint fk_vehicles foreign key(vehicle_id) references vehicles(vehicle_id),
	discount dec(5,2) not null,
    title varchar(50) not null,
    special_description text
);
create table users(
	user_id int auto_increment,
		constraint pk_users primary key(user_id),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    user_email varchar(100) not null,
    password varchar(50) not null,
    role_id int not null,
		constraint fk_roles foreign key(role_id) references roles(role_id)
);
create table messages(
	message_id int auto_increment,
		constraint pk_messages primary key(message_id),
	user_id int not null,
		constraint fk_users foreign key(user_id) references users(user_id),
	message text not null
);
create table purchases(
	purchase_id int auto_increment,
		constraint pk_purchases primary key(purchase_id),
	customer_name varchar(100) not null,
    phone_number varchar(15) not null,
    street varchar(100) not null,
    city varchar(50) not null,
    state varchar(2) not null,
    zip varchar(5) not null,
    purchase_type_id int not null,
		constraint fk_purchase_types foreign key(purchase_type_id) references puchase_types(purchase_type_id),
	user_id int not null,
		constraint fk_users2 foreign key(user_id) references users(user_id),
	vehicle_id int not null,
		constraint fk_vehicles2 foreign key(vehicle_id) references vehicles(vehicle_id),
	purchase_price dec(9,2) not null,
    purchase_date date not null
);
