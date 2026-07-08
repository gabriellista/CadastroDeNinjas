-- Migrations para adicionar a coluna Rank na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);