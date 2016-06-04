--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: atividades; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE atividades (
    id integer NOT NULL,
    descricao character varying(255) NOT NULL,
    obs character varying(45) NOT NULL,
    ativo boolean DEFAULT true NOT NULL
);


ALTER TABLE atividades OWNER TO postgres;

--
-- Name: atividades_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE atividades_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE atividades_id_seq OWNER TO postgres;

--
-- Name: atividades_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE atividades_id_seq OWNED BY atividades.id;


--
-- Name: atividades_locais; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE atividades_locais (
    id integer NOT NULL,
    ref_atividade integer NOT NULL,
    ref_local integer NOT NULL,
    hr_ini time without time zone NOT NULL,
    hr_fim time without time zone NOT NULL,
    valor numeric NOT NULL
);


ALTER TABLE atividades_locais OWNER TO postgres;

--
-- Name: atividades_locais_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE atividades_locais_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE atividades_locais_id_seq OWNER TO postgres;

--
-- Name: atividades_locais_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE atividades_locais_id_seq OWNED BY atividades_locais.id;


--
-- Name: atividades_rotas_turistas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE atividades_rotas_turistas (
    id integer NOT NULL,
    ref_rota_turista integer NOT NULL,
    ref_atividade integer NOT NULL,
    valor numeric
);


ALTER TABLE atividades_rotas_turistas OWNER TO postgres;

--
-- Name: atividades_rotas_turistas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE atividades_rotas_turistas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE atividades_rotas_turistas_id_seq OWNER TO postgres;

--
-- Name: atividades_rotas_turistas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE atividades_rotas_turistas_id_seq OWNED BY atividades_rotas_turistas.id;


--
-- Name: formas_pagamentos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE formas_pagamentos (
    id integer NOT NULL,
    ativo boolean DEFAULT true NOT NULL,
    descricao character varying(255) NOT NULL
);


ALTER TABLE formas_pagamentos OWNER TO postgres;

--
-- Name: formas_pagamentos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE formas_pagamentos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE formas_pagamentos_id_seq OWNER TO postgres;

--
-- Name: formas_pagamentos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE formas_pagamentos_id_seq OWNED BY formas_pagamentos.id;


--
-- Name: locais; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE locais (
    id integer NOT NULL,
    ativo boolean DEFAULT true NOT NULL,
    descricao character varying(255) NOT NULL,
    ref_tipo_local integer NOT NULL,
    obs text
);


ALTER TABLE locais OWNER TO postgres;

--
-- Name: locais_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE locais_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE locais_id_seq OWNER TO postgres;

--
-- Name: locais_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE locais_id_seq OWNED BY locais.id;


--
-- Name: locais_rotas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE locais_rotas (
    id integer NOT NULL,
    ref_local integer NOT NULL,
    ref_rota integer NOT NULL,
    dt_rota date NOT NULL
);


ALTER TABLE locais_rotas OWNER TO postgres;

--
-- Name: locais_rotas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE locais_rotas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE locais_rotas_id_seq OWNER TO postgres;

--
-- Name: locais_rotas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE locais_rotas_id_seq OWNED BY locais_rotas.id;


--
-- Name: parcelas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parcelas (
    id integer NOT NULL,
    valor_estimado numeric NOT NULL,
    status_pagamento character(1),
    valor_realizado numeric,
    dt_pagamento date,
    dt_vencimento date NOT NULL,
    parcela integer NOT NULL
);


ALTER TABLE parcelas OWNER TO postgres;

--
-- Name: parcelas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parcelas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE parcelas_id_seq OWNER TO postgres;

--
-- Name: parcelas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parcelas_id_seq OWNED BY parcelas.id;


--
-- Name: parcelas_rotas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parcelas_rotas (
    id integer NOT NULL,
    ref_rota_turista integer NOT NULL,
    ref_parcela integer NOT NULL
);


ALTER TABLE parcelas_rotas OWNER TO postgres;

--
-- Name: parcelas_rotas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parcelas_rotas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE parcelas_rotas_id_seq OWNER TO postgres;

--
-- Name: parcelas_rotas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parcelas_rotas_id_seq OWNED BY parcelas_rotas.id;


--
-- Name: pessoas_fisicas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pessoas_fisicas (
    id integer NOT NULL,
    nome character varying(255) NOT NULL,
    cpf character(11) NOT NULL,
    ativo boolean DEFAULT true NOT NULL,
    dt_nascimento date NOT NULL,
    sexo character(1) NOT NULL,
    email character varying(255),
    telefone character varying(255)
);


ALTER TABLE pessoas_fisicas OWNER TO postgres;

--
-- Name: pessoas_fisicas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pessoas_fisicas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pessoas_fisicas_id_seq OWNER TO postgres;

--
-- Name: pessoas_fisicas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pessoas_fisicas_id_seq OWNED BY pessoas_fisicas.id;


--
-- Name: rotas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rotas (
    id integer NOT NULL,
    ativo boolean NOT NULL,
    descricao character varying(255) NOT NULL,
    dt_inicio date NOT NULL,
    dt_fim date,
    obs text,
    valor numeric(10,2) NOT NULL,
    vagas integer
);


ALTER TABLE rotas OWNER TO postgres;

--
-- Name: rotas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rotas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rotas_id_seq OWNER TO postgres;

--
-- Name: rotas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rotas_id_seq OWNED BY rotas.id;


--
-- Name: rotas_turistas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rotas_turistas (
    id integer NOT NULL,
    ref_turista integer NOT NULL,
    ref_rota integer NOT NULL,
    status character(1) NOT NULL,
    dt_inscricao date NOT NULL,
    valor_total numeric NOT NULL,
    status_pagamento character(1),
    valor_rota numeric NOT NULL,
    total_parcelas integer NOT NULL,
    ref_forma_pagamento integer NOT NULL
);


ALTER TABLE rotas_turistas OWNER TO postgres;

--
-- Name: rotas_turistas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rotas_turistas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rotas_turistas_id_seq OWNER TO postgres;

--
-- Name: rotas_turistas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rotas_turistas_id_seq OWNED BY rotas_turistas.id;


--
-- Name: tipos_locais; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipos_locais (
    id integer NOT NULL,
    ativo boolean DEFAULT true NOT NULL,
    descricao character varying(255) NOT NULL
);


ALTER TABLE tipos_locais OWNER TO postgres;

--
-- Name: tipos_locais_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipos_locais_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipos_locais_id_seq OWNER TO postgres;

--
-- Name: tipos_locais_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipos_locais_id_seq OWNED BY tipos_locais.id;


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuarios (
    id integer NOT NULL,
    login character varying(255) NOT NULL,
    senha character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    ativo boolean DEFAULT true NOT NULL
);


ALTER TABLE usuarios OWNER TO postgres;

--
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuarios_id_seq OWNER TO postgres;

--
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuarios_id_seq OWNED BY usuarios.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY atividades ALTER COLUMN id SET DEFAULT nextval('atividades_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY atividades_locais ALTER COLUMN id SET DEFAULT nextval('atividades_locais_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY atividades_rotas_turistas ALTER COLUMN id SET DEFAULT nextval('atividades_rotas_turistas_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY formas_pagamentos ALTER COLUMN id SET DEFAULT nextval('formas_pagamentos_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY locais ALTER COLUMN id SET DEFAULT nextval('locais_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY locais_rotas ALTER COLUMN id SET DEFAULT nextval('locais_rotas_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parcelas ALTER COLUMN id SET DEFAULT nextval('parcelas_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parcelas_rotas ALTER COLUMN id SET DEFAULT nextval('parcelas_rotas_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pessoas_fisicas ALTER COLUMN id SET DEFAULT nextval('pessoas_fisicas_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotas ALTER COLUMN id SET DEFAULT nextval('rotas_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotas_turistas ALTER COLUMN id SET DEFAULT nextval('rotas_turistas_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipos_locais ALTER COLUMN id SET DEFAULT nextval('tipos_locais_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios ALTER COLUMN id SET DEFAULT nextval('usuarios_id_seq'::regclass);


--
-- Name: atividades_locais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY atividades_locais
    ADD CONSTRAINT atividades_locais_pkey PRIMARY KEY (id);


--
-- Name: atividades_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY atividades
    ADD CONSTRAINT atividades_pkey PRIMARY KEY (id);


--
-- Name: atividades_rotas_turistas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY atividades_rotas_turistas
    ADD CONSTRAINT atividades_rotas_turistas_pkey PRIMARY KEY (id);


--
-- Name: formas_pagamentos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY formas_pagamentos
    ADD CONSTRAINT formas_pagamentos_pkey PRIMARY KEY (id);


--
-- Name: locais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY locais
    ADD CONSTRAINT locais_pkey PRIMARY KEY (id);


--
-- Name: locais_rotas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY locais_rotas
    ADD CONSTRAINT locais_rotas_pkey PRIMARY KEY (id);


--
-- Name: parcelas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parcelas
    ADD CONSTRAINT parcelas_pkey PRIMARY KEY (id);


--
-- Name: parcelas_rotas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parcelas_rotas
    ADD CONSTRAINT parcelas_rotas_pkey PRIMARY KEY (id);


--
-- Name: pessoas_fisicas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pessoas_fisicas
    ADD CONSTRAINT pessoas_fisicas_pkey PRIMARY KEY (id);


--
-- Name: rotas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rotas
    ADD CONSTRAINT rotas_pkey PRIMARY KEY (id);


--
-- Name: rotas_turistas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rotas_turistas
    ADD CONSTRAINT rotas_turistas_pkey PRIMARY KEY (id);


--
-- Name: tipos_locais_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipos_locais
    ADD CONSTRAINT tipos_locais_pkey PRIMARY KEY (id);


--
-- Name: uq_at; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY atividades
    ADD CONSTRAINT uq_at UNIQUE (descricao);


--
-- Name: uq_desc_form; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY formas_pagamentos
    ADD CONSTRAINT uq_desc_form UNIQUE (descricao);


--
-- Name: uq_desc_tp_loc; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipos_locais
    ADD CONSTRAINT uq_desc_tp_loc UNIQUE (descricao);


--
-- Name: uq_login_user; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT uq_login_user UNIQUE (login);


--
-- Name: usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- Name: fk_atv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY atividades_rotas_turistas
    ADD CONSTRAINT fk_atv FOREIGN KEY (ref_atividade) REFERENCES atividades(id);


--
-- Name: fk_hist_rota; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY atividades_rotas_turistas
    ADD CONSTRAINT fk_hist_rota FOREIGN KEY (ref_rota_turista) REFERENCES rotas_turistas(id);


--
-- Name: fk_hist_rota_parce; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parcelas_rotas
    ADD CONSTRAINT fk_hist_rota_parce FOREIGN KEY (ref_rota_turista) REFERENCES rotas_turistas(id);


--
-- Name: fk_locais_rotas_locais1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY locais_rotas
    ADD CONSTRAINT fk_locais_rotas_locais1 FOREIGN KEY (ref_local) REFERENCES locais(id);


--
-- Name: fk_locais_rotas_rotas1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY locais_rotas
    ADD CONSTRAINT fk_locais_rotas_rotas1 FOREIGN KEY (ref_rota) REFERENCES rotas(id);


--
-- Name: fk_locais_tipos_locais; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY locais
    ADD CONSTRAINT fk_locais_tipos_locais FOREIGN KEY (ref_tipo_local) REFERENCES tipos_locais(id);


--
-- Name: fk_parce; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY parcelas_rotas
    ADD CONSTRAINT fk_parce FOREIGN KEY (ref_parcela) REFERENCES parcelas(id);


--
-- Name: fk_rotas_turistas_forpag; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotas_turistas
    ADD CONSTRAINT fk_rotas_turistas_forpag FOREIGN KEY (ref_forma_pagamento) REFERENCES formas_pagamentos(id);


--
-- Name: fk_rotas_turistas_rotas1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotas_turistas
    ADD CONSTRAINT fk_rotas_turistas_rotas1 FOREIGN KEY (ref_rota) REFERENCES rotas(id);


--
-- Name: fk_rotas_turistas_turistas1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rotas_turistas
    ADD CONSTRAINT fk_rotas_turistas_turistas1 FOREIGN KEY (ref_turista) REFERENCES pessoas_fisicas(id);


--
-- Name: fk_table1_atividades1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY atividades_locais
    ADD CONSTRAINT fk_table1_atividades1 FOREIGN KEY (ref_atividade) REFERENCES atividades(id);


--
-- Name: fk_table1_locais1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY atividades_locais
    ADD CONSTRAINT fk_table1_locais1 FOREIGN KEY (ref_local) REFERENCES locais(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

--
-- INSERTS LOGIN PADRAO
--

INSERT INTO usuarios VALUES ( DEFAULT , 'admin','d033e22ae348aeb5660fc2140aec35850c4da997' , 'admin','admin@javatur.com');
