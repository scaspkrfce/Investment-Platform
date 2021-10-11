INSERT INTO company (company_id,company_name, address, city, state, NIT, email) 
VALUES (1,'SC','CLL','Bogotá','Bogotá D.C','12345','sc@sc.org');

INSERT INTO project (project_id, project_name, project_description, project_rating) 
VALUES (1,'Takeaway App','Eat at home',9);

INSERT INTO category (category_id, category_name) VALUES (1, 'Apps');

INSERT INTO category (category_id, category_name) VALUES (2, 'Inteligencia Artificial');

INSERT INTO category (category_id, category_name) VALUES (3, 'Videojuegos');

INSERT INTO projectxcategory (projectXRole_id, project_id, category_id)
VALUES (1, 1, 1);
INSERT INTO projectxcategory (projectXRole_id, project_id, category_id)
VALUES (2, 1, 2);

INSERT INTO role (role_id, role_name) VALUES (10, 'Administrator'), (20, 'Entrepreneur'),
(25, 'Investor')