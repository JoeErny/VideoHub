INSERT INTO sample (id, data) VALUES (1, 'Test Init Data on Start');
INSERT INTO category (id, label) VALUES (1,'sport');
INSERT INTO video (id, title, link, category_id) VALUES (1, 'Martin à la salle de muscu', 'https://www.youtube.com/watch?v=CUS1TJeWtNQ', 1);
INSERT INTO video (id, title, link, category_id) VALUES (2, 'Martin à la salle de muscu episode 2', 'https://www.youtube.com/watch?v=CUS1TJeWtNQ', 1);
INSERT INTO user (id, name, firstname, mail) VALUES (1,'Schultz',  'Maaartin', 'maaaaaaaaartin@matin');
INSERT INTO order_table (id, date, price, user_id, video_id) VALUES (1,Now(),  20, 1, 1);

