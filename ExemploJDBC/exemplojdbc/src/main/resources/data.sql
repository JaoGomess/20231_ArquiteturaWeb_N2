CREATE TABLE USUARIO(
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    SENHA VARCHAR(100) NOT NULL
);

INSERT INTO USUARIO(
    NOME,
    EMAIL,
    SENHA
) VALUES (
    'Rafael Moreno',
    'Rafael.Moreno@teste.com',
    '123321'
);