insert into tab_acessorio (codigo, descricao) values (1, 'Direção hidráulica');
insert into tab_acessorio (codigo, descricao) values (2, 'Alarme');
insert into tab_acessorio (codigo, descricao) values (3, 'Ar condicionado');
insert into tab_acessorio (codigo, descricao) values (4, 'Bancos de couro');

insert into tab_proprietario (codigo, nome, telefone_proprietario) values (1,'Fernando Martins','34 9 1111 1111');
insert into tab_proprietario (codigo, nome, telefone_proprietario) values (2, 'Isabela Santos', '34 9 2222 2222');
insert into tab_proprietario (codigo, nome, telefone_proprietario) values (3, 'Ulisses Silva', '34 9 3333 3333');

insert into tab_veiculo (codigo, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, proprietario_codigo ) values (1, 'Fiat', 'Toro', 2020, 2020, 107000, 'DIESEL', sysdate(), 1);
insert into tab_veiculo (codigo, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, proprietario_codigo) values (2, 'Ford', 'Fiesta', 2019, 2019, 42000, 'GASOLINA', sysdate(),2);
insert into tab_veiculo (codigo, fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, proprietario_codigo) values (3, 'VW', 'Gol', 2019, 2020, 35000, 'BICOMBUSTIVEL', sysdate(),3);

insert into tab_veiculo_acessorio (veiculo_codigo, acessorio_codigo) values (1, 1);
insert into tab_veiculo_acessorio (veiculo_codigo, acessorio_codigo) values (1, 2);
insert into tab_veiculo_acessorio (veiculo_codigo, acessorio_codigo) values (1, 3);
insert into tab_veiculo_acessorio (veiculo_codigo, acessorio_codigo) values (1, 4);

insert into tab_pessoa (codigo, nome, bloqueado, limite_credito, renda_mensal, tipo) values (1, 'Mariana Aguilar', false, 10000, 5000, 'C');
insert into tab_pessoa (codigo, nome, bloqueado, limite_credito, renda_mensal, tipo) values (2, 'Douglas Montes', false, 8000, 4500, 'C');