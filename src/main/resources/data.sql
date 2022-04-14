INSERT INTO USERS(name, email, password) VALUES('Aluno', 'aluno@email.com', '$2a$10$k/.zmEjFU29CBMcFHtk66Omsxe3LLyp03RpMPhTV8tNb.IztHEB/q');

INSERT INTO COURSES(name, category) VALUES('Spring Boot', 'Programação');
INSERT INTO COURSES(name, category) VALUES('ReactJS', 'Front-end');

INSERT INTO TOPICS(title, message, created_at, status, author_id, course_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPICS(title, message, created_at, status, author_id, course_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPICS(title, message, created_at, status, author_id, course_id) VALUES('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 2);
