#
# Arquivo de criação do banco de dados
# Alunos: Jonatha Cardoso e Márcio Landvoigt
#

CREATE TABLE campeonatos (
id SERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
edicao VARCHAR(10) NOT NULL,
patrocinador VARCHAR(50),
campeao VARCHAR(50) NOT NULL,
viceCampeao VARCHAR(50) NOT NULL,
qtdeParticipantes INTEGER NOT NULL,
qtdeFases INTEGER,
qtdePartidas INTEGER,
qtdeGols INTEGER,
mediaPublico INTEGER,
pontosCorridos BOOLEAN NOT NULL,
turnoReturno BOOLEAN NOT NULL,
formulaFraga BOOLEAN NOT NULL,
faseGrupos BOOLEAN NOT NULL,
eliminatorias BOOLEAN NOT NULL,
mediaGols FLOAT,
mediaRenda FLOAT,
dataInicio DATE NOT NULL,
dataFinal DATE NOT NULL,
PRIMARY KEY (id)
);