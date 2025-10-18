-- INSERÇÃO DE CURSOS

INSERT INTO tb_course (name, workload) VALUES ('Análise e Desenvolvimento de Sistemas', 1800); -- ID 1
INSERT INTO tb_course (name, workload) VALUES ('Engenharia de Software', 2400); -- ID 2
INSERT INTO tb_course (name, workload) VALUES ('Ciência de Dados', 1500);      -- ID 3

-- INSERÇÃO DE ALUNOS
-- tb_student (registration_number, name, course_id)

INSERT INTO tb_student (registration_number, name, course_id) VALUES (1001, 'Caio', 1);
INSERT INTO tb_student (registration_number, name, course_id) VALUES (1002, 'Maria Eduarda', 1);
INSERT INTO tb_student (registration_number, name, course_id) VALUES (2001, 'João Victor', 2);