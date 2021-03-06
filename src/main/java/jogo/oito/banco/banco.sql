CREATE TABLE jogador (
	id SERIAL NOT NULL,
	nome VARCHAR(255) NOT NULL,
	login VARCHAR(255) UNIQUE NOT NULL,
	senha VARCHAR(255) NOT NULL
);

ALTER TABLE jogador ADD PRIMARY KEY (id);

CREATE TABLE partida (
	id SERIAL NOT NULL,
	jogador_id INTEGER NOT NULL,
	movimentos INTEGER NOT NULL DEFAULT 0
);

ALTER TABLE partida ADD CONSTRAINT FK_partida_jogador
FOREIGN KEY (jogador_id) REFERENCES jogador (id)
ON UPDATE NO ACTION
ON DELETE NO ACTION;