
-- sequence seq_doc_t_documento

create sequence seq_doc_t_documento INCREMENT 1 MINVALUE 1 START 1;

-- DROP TABLE doc_d_formato_documento;

CREATE TABLE doc_d_formato_documento
(
  id_formato_documento integer NOT NULL,
  cod_formato_documento character varying(20) NOT NULL,
  descr_formato_documento character varying(20) NOT NULL,
  CONSTRAINT doc_d_formato_documento_pkey PRIMARY KEY (id_formato_documento)
)
WITH (
  OIDS=FALSE
);

-- DROP TABLE doc_d_tipo_documento;

CREATE TABLE doc_d_tipo_documento
(
  id_tipo_documento integer NOT NULL,
  cod_tipo_documento character varying(30),
  descr_tipo_documento character varying(50),
  root_folder character varying(50),
  id_formato_documento integer NOT NULL,
  CONSTRAINT doc_d_tipo_documento_pkey PRIMARY KEY (id_tipo_documento),
  CONSTRAINT doc_d_tipo_documento_id_formato_documento_fkey FOREIGN KEY (id_formato_documento)
      REFERENCES doc_d_formato_documento (id_formato_documento) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- DROP TABLE doc_d_tipo_fornitore;

CREATE TABLE doc_d_tipo_fornitore
(
  id_tipo_fornitore integer NOT NULL,
  cod_tipo_fornitore character varying(20) NOT NULL,
  descr_tipo_fornitore character varying(20) NOT NULL,
  repository character varying(100),
  username character varying(30) NOT NULL,
  password character varying(30) NOT NULL,
  CONSTRAINT doc_d_tipo_fornitore_pkey PRIMARY KEY (id_tipo_fornitore)
)
WITH (
  OIDS=FALSE
);

-- DROP SEQUENCE doc_t_documento_id_documento_seq;

CREATE SEQUENCE doc_t_documento_id_documento_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


-- DROP TABLE doc_t_documento;

CREATE TABLE doc_t_documento
(
  id_documento bigint NOT NULL DEFAULT nextval('seq_doc_t_documento'::regclass),
  id_tipo_documento integer NOT NULL,
  identificativo_archiviazione character varying(50),
  identificativo_fornitore character varying(50),
  nome_file character varying(50),
  CONSTRAINT doc_t_documento_pkey PRIMARY KEY (id_documento),
  CONSTRAINT doc_t_documento_id_tipo_documento_fkey FOREIGN KEY (id_tipo_documento)
      REFERENCES doc_d_tipo_documento (id_tipo_documento) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- DROP TABLE doc_t_fruitore;

CREATE TABLE doc_t_fruitore
(
  id_fruitore numeric(10,0) NOT NULL,
  cod_fruitore character varying(10) NOT NULL,
  descr_fruitore character varying(50) NOT NULL,
  username character varying(20) NOT NULL,
  password character varying(20) NOT NULL,
  id_tipo_fornitore integer NOT NULL,
  CONSTRAINT doc_t_fruitore_pkey PRIMARY KEY (id_fruitore),
  CONSTRAINT doc_t_fruitore_id_tipo_fornitore_fkey FOREIGN KEY (id_tipo_fornitore)
      REFERENCES doc_d_tipo_fornitore (id_tipo_fornitore) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);



INSERT INTO doc_d_formato_documento (id_formato_documento,cod_formato_documento,descr_formato_documento) VALUES (1,'CARTACEO','Documento cartaceo');
INSERT INTO doc_d_formato_documento (id_formato_documento,cod_formato_documento,descr_formato_documento) VALUES (2,'DIGITALE','Documento digitale');

INSERT INTO doc_d_tipo_documento (id_tipo_documento,cod_tipo_documento,descr_tipo_documento,root_folder,id_formato_documento) VALUES (1,'TEST_DOC','Documento di test','junit',2);

INSERT INTO doc_d_tipo_fornitore (id_tipo_fornitore,cod_tipo_fornitore,descr_tipo_fornitore,repository,username,password) VALUES (1,'INDEX','Index','primary','admin@formadoc','formadoc');
INSERT INTO doc_t_fruitore (id_fruitore,cod_fruitore,descr_fruitore,username,password,id_tipo_fornitore) VALUES (1,'JUNIT','Fruitore di test','junit','mypass',1);
