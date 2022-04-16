INSERT INTO company (company_id,company_name, address, city, state, NIT, email) 
VALUES (1,'SC','CLL','Bogotá','Bogotá D.C','12345','sc@sc.org');


INSERT INTO project (project_id, project_name, project_description, project_rating) 
VALUES (1,'Desarrollo de un software educativo sobre las regiones geográficas humanas de Colombia para niños de tercero a cuarto grado de primaria',
'Software para que los niños aprendan de manera didáctica y divertida la cultura, religión y densidad demográfica, encontrando imágenes con relación a estos temas para una mayor compresión.',
8);

INSERT INTO project (project_id, project_name, project_description, project_rating) 
VALUES (2,'Desarrollo de aplicación móvil para el aprendizaje de braille en docentes',
'Aplicación móvil para el sistema operativo android que tenga como propósito la enseñanza del lenguaje braille en abecedario latino que se encuentre enfocada hacia los docentes.',
8);

INSERT INTO project (project_id, project_name, project_description, project_rating) 
VALUES (3,'Plataforma digital para ayudar a la atención de los pacientes del centro de salud de la trinidad',
'Consiste en desarrollar un aplicativo web que contenga una sección donde las personas puedan hacer valoraciones en línea, noticias respecto al centro de salud y agendamiento en línea de la atención.',
8);

INSERT INTO project (project_id, project_name, project_description, project_rating) 
VALUES (4,'Implementación de minería de datos para el estudio predictivo de la deserción estudiantil en la carrera de ingeniería de sistemas de la universidad de Cundinamarca sede Fusagasugá',
'Implementar minería de datos para el desarrollo del estudio predictivo de la deserción estudiantil correspondiente a la carrera ingeniería de sistemas en la universidad de Cundinamarca.',
8);

INSERT INTO project (project_id, project_name, project_description, project_rating) 
VALUES (5,'Predicción del dólar estadounidense, euro y Bitcoin a través de series temporales y técnicas de Deep Learning',
'El proyecto consiste en el uso de series temporales para realizar estimaciones sobre los precios del euro, bitcoin y el dólar estadounidense a través del uso de técnicas de Deep Learning como lo son los modelos de LSTM y GRU.',
8);

INSERT INTO project (project_id, project_name, project_description, project_rating) 
VALUES (6,'Fortalecer los recursos educativos digitales (RED) de la comprensión lectora de los estudiantes de grado 5º de la Institución Educativa Departamental Kirpalamar del municipio de Arbeláez',
'Teniendo de referente la influencia de las tics en la mejora de la comprensión lectora en los niños del grado 5° en el centro educativo rural piedragorda del municipio de San Vicente Ferrer en el departamento de Antioquia.',
8);


INSERT INTO category (category_id, category_name) VALUES (1, 'Apps');

INSERT INTO category (category_id, category_name) VALUES (2, 'Educación');

INSERT INTO category (category_id, category_name) VALUES (3, 'Gestión');

INSERT INTO category (category_id, category_name) VALUES (4, 'Inteligencia Artificial');

INSERT INTO category (category_id, category_name) VALUES (5, 'Paginas Web');

INSERT INTO category (category_id, category_name) VALUES (6, 'Videojuegos');


INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (1, 1, 2);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (2, 1, 6);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (3, 2, 1);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (4, 2, 2);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (5, 3, 3);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (6, 3, 5);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (7, 4, 2);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (8, 4, 4);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (9, 5, 4);

INSERT INTO projectxcategory (project_x_category_id, project_id, category_id)
VALUES (10, 5, 5);


INSERT INTO role (role_id, role_name) VALUES (10, 'Administrator'), (20, 'Entrepreneur'),
(25, 'Investor');


INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (100,'Santiago', 'Castro', 'scaspkrfce@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 3133333, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (1, 100, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (100, 'Director General', 'Consejo Directivo', 'Termino Indefinido', 10000000, '', '2021-09-04', 1000706054);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (2001,'John', 'Doe', 'nn@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 3133334, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (2, 2001, 20);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1000,'Valentina', 'Medina', 'vmd@gmail.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 3133336, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (3, 1000, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1000, 'Director de Tecnología', 'Consejo Directivo', 'Termino Indefinido', 7000000, '', '2021-09-07', 100023024);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1001,'Felipe', 'Mendez', 'Fmendez@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 3133335, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (4, 1001, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1001, 'Jefe de Front-End', 'T.I.', 'Termino Indefinido', 5500000, '', '2021-09-06', 1000706024);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1002,'Lorena', 'Rojas', 'redlor@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 315123242, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (5, 1002, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1002, 'Analista de Requisitos', 'T.I.', 'Termino Indefinido', 2500000, '', '2021-09-14', 12314344);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1003,'Juan', 'Rincon', 'rincon@gmail.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 3154328, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (6, 1003, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1003, 'Programador Front-End', 'T.I.', 'Termino Idenfinido', 2400000, '', '2021-09-09', 100439054);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1004,'Sofia', 'Polanco', 'polo@gmail.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 31524432, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (7, 1004, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1004, 'Jefe de Back-End', 'T.I.', 'Termino Fijo', 5500000, '', '2021-09-10', 1204373054);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1005,'Alanna', 'Trujillo', 'trujillo@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 315242132, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (8, 1005, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1005, 'Programador Back-End', 'T.I.', 'Termino Fijo', 2400000, '', '2021-09-11', 123233054);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1006,'Mario', 'Ruiz', 'maru@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 31523542, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (9, 1006, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1006, 'Jefe de Arquitectura T.I.', 'T.I.', 'Termino Indefinido', 5500000, '', '2021-09-12', 123233434);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1007,'Sebastian', 'Guerrero', 'guerrerin@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 315123542, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (10, 1007, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1007, 'Arquitecto TI', 'T.I.', 'Termino Aprendizaje', 2400000, '', '2021-09-03', 12352434);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1100,'Valentina', 'Vargas', 'vvargas@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 318343542, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (11, 1100, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1100, 'Director de Recursos Humanos', 'Consejo Directivo', 'Termino Indefinido', 7000000, '', '2021-09-13', 10323434);



INSERT INTO user (user_id, first_name, surname, email, password_hash, phone_number, enabled)
VALUES (1200,'Julian', 'Espitia', 'jespitia@outlook.com', '$s0$41010$ct9jbGk03J2pK9NEG+ZA2w==$Xm3YZxGEREFo//3fkT4oNA7Bs4WzqvA9pDPpqlhz5HM=', 318343542, true);

INSERT INTO userXRole (user_x_role_id, user_id, role_id)
VALUES (12, 1200, 10);

INSERT INTO administrator (admin_id, job_title, department, contract_type, salary, educational_background, hiring_date, document)
VALUES (1200, 'Director de Marketing', 'Consejo Directivo', 'Termino Indefinido', 7000000, '', '2021-09-10', 10323434);
