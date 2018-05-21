-- data.sql


insert into car_type(car_type_id,name) values (1,'Gas');
insert into car_type(car_type_id,name) values (2,'Diesel');
insert into car_type(car_type_id,name) values (3,'Electric');
insert into car_type(car_type_id,name) values (4,'Hybrid');
insert into car_type(name) values ('Others');


insert into service_type(name) values ("Oil change");
insert into service_type(name) values ("Tire rotation");
insert into service_type(name) values ("Filter change");
insert into service_type(name) values ("Full brake check");


insert into car(make, model, madeyear,odometer, car_type_id) values("Honda","CR-V",2017,45000,1);


insert into service_record(service_date, car_id) values('2018-04-20',1);

insert into servicerecord_servicetype(service_record_id, service_type_id) values(1,1);
insert into servicerecord_servicetype(service_record_id, service_type_id) values(1,3);


insert into cartype_servicetype values(1,1);
insert into cartype_servicetype values(1,2);
insert into cartype_servicetype values(1,3);