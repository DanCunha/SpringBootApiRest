insert into usuario(nome, email, senha) values('Aluno','aluno@gmail.com','$2a$10$IHzWfr9M3QnBb5M2.THtNeL6eghtHZGxRPR36UIDfFXEY16a99ptq');
insert into usuario(nome, email, senha) values('Moderador','moderador@gmail.com','$2a$10$IHzWfr9M3QnBb5M2.THtNeL6eghtHZGxRPR36UIDfFXEY16a99ptq');

insert into perfil(id, nome) values(1, 'ROLE_ALUNO');
insert into perfil(id, nome) values(2, 'ROLE_MODERADOR');

insert into usuario_perfis(usuario_id, perfis_id) values(1,1);
insert into usuario_perfis(usuario_id, perfis_id) values(2,2);

insert into curso(nome, categoria) values('Spring Boot','Programação');
insert into curso(nome, categoria) values('Html 5','Front-end');

insert into topico(titulo,mensagem,data_criacao,status,autor_id,curso_id) values('Dúvida','Erro ao criar projeto','2019-08-07','NAO_RESPONDIDO',1,1);
insert into topico(titulo,mensagem,data_criacao,status,autor_id,curso_id) values('Dúvida','Projeto não compila','2019-08-07','NAO_RESPONDIDO',1,1);
insert into topico(titulo,mensagem,data_criacao,status,autor_id,curso_id) values('Dúvida','Projeto Bugado','2019-08-07','NAO_RESPONDIDO',1,1);
insert into topico(titulo,mensagem,data_criacao,status,autor_id,curso_id) values('Dúvida','Erro catastrofico','2019-08-07','NAO_RESPONDIDO',1,1);
insert into topico(titulo,mensagem,data_criacao,status,autor_id,curso_id) values('Dúvida','Tag HTML','2019-08-07','NAO_RESPONDIDO',1,2);
insert into topico(titulo,mensagem,data_criacao,status,autor_id,curso_id) values('Dúvida','Erro no html','2019-08-07','NAO_RESPONDIDO',1,2);