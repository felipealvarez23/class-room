INSERT INTO class_rooms(id,description,teacher_name) VALUES (1,'Clase de Mate','Lilianita');
INSERT INTO class_rooms(id,description,teacher_name) VALUES (2,'Clase de Lenguaje','Fernando');
INSERT INTO class_rooms(id,description,teacher_name) VALUES (3,'Clase de tecnologia','Jose');
INSERT INTO virtual_rooms(id,url,active,password,class_room_id) VALUES (1,'http://zoom.com/zer2w33',1,'AB1234',1);
INSERT INTO virtual_rooms(id,url,active,password,class_room_id) VALUES (2,'http://zoom.com/ñNmjuy3',1,'9Z8641',2);
INSERT INTO virtual_rooms(id,url,active,password,class_room_id) VALUES (3,'http://zoom.com/zer2w33',1,'LordSponge',3);
INSERT INTO scheduling(id,day_of_week,hour,class_room_id) VALUES (1,0,'08:00',1);
INSERT INTO scheduling(id,day_of_week,hour,class_room_id) VALUES (2,1,'08:00',2);
INSERT INTO scheduling(id,day_of_week,hour,class_room_id) VALUES (3,1,'08:00',3);

