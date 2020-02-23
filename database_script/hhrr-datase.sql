--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-02-23 11:39:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 37978)
-- Name: candidates; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.candidates (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    age integer NOT NULL,
    first_name character varying(64) NOT NULL,
    last_name character varying(128) NOT NULL,
    identity_card character varying(11) NOT NULL,
    user_id bigint,
    email character varying(255) NOT NULL
);


ALTER TABLE public.candidates OWNER TO hhrr_user;

--
-- TOC entry 202 (class 1259 OID 37976)
-- Name: candidates_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.candidates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.candidates_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 202
-- Name: candidates_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.candidates_id_seq OWNED BY public.candidates.id;


--
-- TOC entry 227 (class 1259 OID 38250)
-- Name: candidates_languages; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.candidates_languages (
    candidate_id bigint NOT NULL,
    language_id bigint NOT NULL
);


ALTER TABLE public.candidates_languages OWNER TO hhrr_user;

--
-- TOC entry 204 (class 1259 OID 37984)
-- Name: candidates_skills; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.candidates_skills (
    candidate_id bigint NOT NULL,
    skill_id bigint NOT NULL
);


ALTER TABLE public.candidates_skills OWNER TO hhrr_user;

--
-- TOC entry 206 (class 1259 OID 37996)
-- Name: departments; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.departments (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL
);


ALTER TABLE public.departments OWNER TO hhrr_user;

--
-- TOC entry 205 (class 1259 OID 37994)
-- Name: departments_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.departments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departments_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 205
-- Name: departments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.departments_id_seq OWNED BY public.departments.id;


--
-- TOC entry 208 (class 1259 OID 38007)
-- Name: employees; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.employees (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    department_id bigint NOT NULL,
    first_name character varying(64) NOT NULL,
    hire_date date,
    identity_card integer NOT NULL,
    last_name character varying(128) NOT NULL,
    montly_salary numeric(10,2) NOT NULL,
    age integer NOT NULL
);


ALTER TABLE public.employees OWNER TO hhrr_user;

--
-- TOC entry 207 (class 1259 OID 38005)
-- Name: employees_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.employees_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 207
-- Name: employees_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;


--
-- TOC entry 210 (class 1259 OID 38015)
-- Name: institution; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.institution (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL
);


ALTER TABLE public.institution OWNER TO hhrr_user;

--
-- TOC entry 209 (class 1259 OID 38013)
-- Name: institution_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.institution_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.institution_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 209
-- Name: institution_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.institution_id_seq OWNED BY public.institution.id;


--
-- TOC entry 212 (class 1259 OID 38026)
-- Name: jobs; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.jobs (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL,
    maximun_salary numeric(10,2) NOT NULL,
    minimun_salary numeric(10,2) NOT NULL,
    risk_level_id bigint
);


ALTER TABLE public.jobs OWNER TO hhrr_user;

--
-- TOC entry 226 (class 1259 OID 38205)
-- Name: jobs_candidates; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.jobs_candidates (
    candidate_id bigint NOT NULL,
    job_id bigint NOT NULL
);


ALTER TABLE public.jobs_candidates OWNER TO hhrr_user;

--
-- TOC entry 211 (class 1259 OID 38024)
-- Name: jobs_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.jobs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jobs_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 211
-- Name: jobs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.jobs_id_seq OWNED BY public.jobs.id;


--
-- TOC entry 214 (class 1259 OID 38037)
-- Name: languages; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.languages (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL
);


ALTER TABLE public.languages OWNER TO hhrr_user;

--
-- TOC entry 213 (class 1259 OID 38035)
-- Name: languages_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.languages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.languages_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 213
-- Name: languages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.languages_id_seq OWNED BY public.languages.id;


--
-- TOC entry 216 (class 1259 OID 38048)
-- Name: risk_level; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.risk_level (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL
);


ALTER TABLE public.risk_level OWNER TO hhrr_user;

--
-- TOC entry 215 (class 1259 OID 38046)
-- Name: risk_level_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.risk_level_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.risk_level_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 215
-- Name: risk_level_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.risk_level_id_seq OWNED BY public.risk_level.id;


--
-- TOC entry 222 (class 1259 OID 38162)
-- Name: roles; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(20)
);


ALTER TABLE public.roles OWNER TO hhrr_user;

--
-- TOC entry 221 (class 1259 OID 38160)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 221
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 218 (class 1259 OID 38059)
-- Name: skills; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.skills (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL
);


ALTER TABLE public.skills OWNER TO hhrr_user;

--
-- TOC entry 217 (class 1259 OID 38057)
-- Name: skills_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.skills_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.skills_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 217
-- Name: skills_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.skills_id_seq OWNED BY public.skills.id;


--
-- TOC entry 229 (class 1259 OID 38268)
-- Name: trainings; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.trainings (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL,
    candidate_id bigint NOT NULL,
    date_from date NOT NULL,
    date_to date NOT NULL,
    institution_id bigint NOT NULL
);


ALTER TABLE public.trainings OWNER TO hhrr_user;

--
-- TOC entry 228 (class 1259 OID 38266)
-- Name: trainings_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.trainings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trainings_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 228
-- Name: trainings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.trainings_id_seq OWNED BY public.trainings.id;


--
-- TOC entry 223 (class 1259 OID 38168)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.user_roles (
    user_id bigint NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE public.user_roles OWNER TO hhrr_user;

--
-- TOC entry 225 (class 1259 OID 38175)
-- Name: users; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(50),
    password character varying(120),
    username character varying(20),
    candidate_id bigint
);


ALTER TABLE public.users OWNER TO hhrr_user;

--
-- TOC entry 224 (class 1259 OID 38173)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 224
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 220 (class 1259 OID 38081)
-- Name: work_experience; Type: TABLE; Schema: public; Owner: hhrr_user
--

CREATE TABLE public.work_experience (
    id bigint NOT NULL,
    is_active boolean NOT NULL,
    version bigint NOT NULL,
    created_date timestamp without time zone NOT NULL,
    modified_date timestamp without time zone NOT NULL,
    description character varying(1024),
    name character varying(128) NOT NULL,
    candidate_id bigint NOT NULL,
    date_from date NOT NULL,
    date_to date NOT NULL,
    salary double precision NOT NULL
);


ALTER TABLE public.work_experience OWNER TO hhrr_user;

--
-- TOC entry 219 (class 1259 OID 38079)
-- Name: work_experience_id_seq; Type: SEQUENCE; Schema: public; Owner: hhrr_user
--

CREATE SEQUENCE public.work_experience_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.work_experience_id_seq OWNER TO hhrr_user;

--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 219
-- Name: work_experience_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: hhrr_user
--

ALTER SEQUENCE public.work_experience_id_seq OWNED BY public.work_experience.id;


--
-- TOC entry 2777 (class 2604 OID 37981)
-- Name: candidates id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates ALTER COLUMN id SET DEFAULT nextval('public.candidates_id_seq'::regclass);


--
-- TOC entry 2778 (class 2604 OID 37999)
-- Name: departments id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.departments ALTER COLUMN id SET DEFAULT nextval('public.departments_id_seq'::regclass);


--
-- TOC entry 2779 (class 2604 OID 38010)
-- Name: employees id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);


--
-- TOC entry 2780 (class 2604 OID 38018)
-- Name: institution id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.institution ALTER COLUMN id SET DEFAULT nextval('public.institution_id_seq'::regclass);


--
-- TOC entry 2781 (class 2604 OID 38029)
-- Name: jobs id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.jobs ALTER COLUMN id SET DEFAULT nextval('public.jobs_id_seq'::regclass);


--
-- TOC entry 2782 (class 2604 OID 38040)
-- Name: languages id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.languages ALTER COLUMN id SET DEFAULT nextval('public.languages_id_seq'::regclass);


--
-- TOC entry 2783 (class 2604 OID 38051)
-- Name: risk_level id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.risk_level ALTER COLUMN id SET DEFAULT nextval('public.risk_level_id_seq'::regclass);


--
-- TOC entry 2786 (class 2604 OID 38165)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 2784 (class 2604 OID 38062)
-- Name: skills id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.skills ALTER COLUMN id SET DEFAULT nextval('public.skills_id_seq'::regclass);


--
-- TOC entry 2788 (class 2604 OID 38271)
-- Name: trainings id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.trainings ALTER COLUMN id SET DEFAULT nextval('public.trainings_id_seq'::regclass);


--
-- TOC entry 2787 (class 2604 OID 38178)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2785 (class 2604 OID 38084)
-- Name: work_experience id; Type: DEFAULT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.work_experience ALTER COLUMN id SET DEFAULT nextval('public.work_experience_id_seq'::regclass);


--
-- TOC entry 2998 (class 0 OID 37978)
-- Dependencies: 203
-- Data for Name: candidates; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.candidates (id, is_active, version, created_date, modified_date, age, first_name, last_name, identity_card, user_id, email) FROM stdin;
3	t	0	2020-02-22 02:28:45.872929	2020-02-22 02:28:45.872929	63	Brayan Kelly	pedro	12345678910	7	a@a.com
4	t	0	2020-02-22 02:42:15.794611	2020-02-22 02:42:15.794611	46	Martina	Perez	40226747243	8	b@b.com
5	t	4	2020-02-22 11:06:30.45574	2020-02-22 11:06:30.45574	18	Pedro	Salvado	40226747240	9	pedro@pedro.com
2	t	31	2020-02-22 01:20:16.431	2020-02-22 01:20:16.431	32	Maria	Robles	12345678913	6	maria@a.com
\.


--
-- TOC entry 3022 (class 0 OID 38250)
-- Dependencies: 227
-- Data for Name: candidates_languages; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.candidates_languages (candidate_id, language_id) FROM stdin;
2	37
2	39
2	40
2	6
2	8
2	9
\.


--
-- TOC entry 2999 (class 0 OID 37984)
-- Dependencies: 204
-- Data for Name: candidates_skills; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.candidates_skills (candidate_id, skill_id) FROM stdin;
2	3
2	2
5	3
5	2
2	4
\.


--
-- TOC entry 3001 (class 0 OID 37996)
-- Dependencies: 206
-- Data for Name: departments; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.departments (id, is_active, version, created_date, modified_date, description, name) FROM stdin;
\.


--
-- TOC entry 3003 (class 0 OID 38007)
-- Dependencies: 208
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.employees (id, is_active, version, created_date, modified_date, department_id, first_name, hire_date, identity_card, last_name, montly_salary, age) FROM stdin;
\.


--
-- TOC entry 3005 (class 0 OID 38015)
-- Dependencies: 210
-- Data for Name: institution; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.institution (id, is_active, version, created_date, modified_date, description, name) FROM stdin;
2	t	3	2020-02-18 18:15:14.004532	2020-02-18 18:15:14.004532	El Instituto Tecnológico de Santo Domingo es una institución dominicana de educación superior privada	INTEC
3	t	0	2020-02-18 22:23:15.829362	2020-02-18 22:23:15.829362	La Universidad APEC es la Institución primogénita de Acción Pro Educación y Cultura (APEC), constituida en 1964.	UNAPEC
1	t	1	2020-02-16 23:42:11.964259	2020-02-16 23:42:11.964259	Instituto tecnologico de las americas	UNIBE
\.


--
-- TOC entry 3007 (class 0 OID 38026)
-- Dependencies: 212
-- Data for Name: jobs; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.jobs (id, is_active, version, created_date, modified_date, description, name, maximun_salary, minimun_salary, risk_level_id) FROM stdin;
11	t	4	2020-02-18 09:54:11.441756	2020-02-18 09:54:11.441756	Design and develop data integrations from a variety of sources including database extracts and external APIs.	Software Engineer, Data	150000.00	200000.00	5
14	t	2	2020-02-18 12:30:12.205306	2020-02-18 12:30:12.205306	Designs, develops, troubleshoots and debugs software programs for software enhancements and new products. 	Systems Software Engineer Experienced	50000.00	5231002.00	1
16	t	0	2020-02-22 11:03:07.845027	2020-02-22 11:03:07.845027	Implementa	Gerente IT	5236.00	500.00	2
\.


--
-- TOC entry 3021 (class 0 OID 38205)
-- Dependencies: 226
-- Data for Name: jobs_candidates; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.jobs_candidates (candidate_id, job_id) FROM stdin;
2	11
\.


--
-- TOC entry 3009 (class 0 OID 38037)
-- Dependencies: 214
-- Data for Name: languages; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.languages (id, is_active, version, created_date, modified_date, description, name) FROM stdin;
4	t	0	2020-02-16 15:15:20.479694	2020-02-16 15:15:20.479694	Felix	Juan
6	t	0	2020-02-16 15:47:58.524311	2020-02-16 15:47:58.524311	Islamic	Arabe
8	t	0	2020-02-16 15:48:55.211561	2020-02-16 15:48:55.211561	indu	Indu
9	t	0	2020-02-16 15:51:41.265316	2020-02-16 15:51:41.265316	ddf	asas
11	t	0	2020-02-16 15:53:45.205625	2020-02-16 15:53:45.205625	asasa	asasa
36	t	0	2020-02-16 16:15:30.220799	2020-02-16 16:15:30.220799	Lopez	Pepe
1	f	1	2020-02-15 22:40:33.312316	2020-02-15 22:40:33.312316	string	string
2	f	1	2020-02-15 22:40:45.87115	2020-02-15 22:40:45.87115	Se habla en estados unidos	Englis
5	t	1	2020-02-16 15:42:39.068572	2020-02-16 15:42:39.068572	Speking and usa	English
3	t	5	2020-02-16 15:11:07.243226	2020-02-16 15:11:07.243226	Speak in iran	Iran
37	t	0	2020-02-16 17:54:31.390887	2020-02-16 17:54:31.390887	Speak in Portugal	Portuguese
39	t	1	2020-02-16 18:01:28.10707	2020-02-16 18:01:28.10707	sasasaas	Greek
40	t	0	2020-02-17 15:11:08.411999	2020-02-17 15:11:08.411999	German	German
41	t	0	2020-02-17 15:20:19.64399	2020-02-17 15:20:19.64399		British
42	t	1	2020-02-18 13:48:39.398396	2020-02-18 13:48:39.398396		Russian
43	t	0	2020-02-22 11:01:38.799136	2020-02-22 11:01:38.799136	Se ha bla en china	Chino
\.


--
-- TOC entry 3011 (class 0 OID 38048)
-- Dependencies: 216
-- Data for Name: risk_level; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.risk_level (id, is_active, version, created_date, modified_date, description, name) FROM stdin;
1	t	1	2020-02-16 21:11:37.358577	2020-02-16 21:11:37.358577	Significa nivel de peligro alto	Hight
2	t	2	2020-02-16 21:12:23.187564	2020-02-16 21:12:23.187564	Nivel medios	Medium
5	t	2	2020-02-18 11:59:16.730746	2020-02-18 11:59:16.730746	Low Level	Low
\.


--
-- TOC entry 3017 (class 0 OID 38162)
-- Dependencies: 222
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.roles (id, name) FROM stdin;
1	ROLE_USER
2	ROLE_MODERATOR
3	ROLE_ADMIN
\.


--
-- TOC entry 3013 (class 0 OID 38059)
-- Dependencies: 218
-- Data for Name: skills; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.skills (id, is_active, version, created_date, modified_date, description, name) FROM stdin;
2	t	1	2020-02-18 08:48:48.940889	2020-02-18 08:48:48.940889	\N	programing
3	t	0	2020-02-22 05:00:00.782605	2020-02-22 05:00:00.782605		Java
4	t	0	2020-02-22 11:02:11.823255	2020-02-22 11:02:11.823255		Gestion de presupuesto
\.


--
-- TOC entry 3024 (class 0 OID 38268)
-- Dependencies: 229
-- Data for Name: trainings; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.trainings (id, is_active, version, created_date, modified_date, description, name, candidate_id, date_from, date_to, institution_id) FROM stdin;
1	t	1	2020-02-23 10:31:13.931298	2020-02-23 10:31:13.931298	Diploma for certification OCP Java  11	Diploma Java OCP	2	2020-02-01	2020-05-23	2
\.


--
-- TOC entry 3018 (class 0 OID 38168)
-- Dependencies: 223
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.user_roles (user_id, role_id) FROM stdin;
5	3
5	2
6	1
7	1
8	1
9	1
\.


--
-- TOC entry 3020 (class 0 OID 38175)
-- Dependencies: 225
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.users (id, email, password, username, candidate_id) FROM stdin;
5	admin@admin.com	$2a$10$TI/6sldk8OaO8QfTUeYBhOi5tPThaoC321H.sEwyFOsg4JwrcjMOa	admin	\N
6	maria@a.com	$2a$10$YMrSEtONNxoKgES8Gxe96eSFJcf/XnTCYc7czhzj0XV/EkXDZAgaO	maria	\N
7	a@a.com	$2a$10$crNkWaQfcZ5lp4RBnfpoMOr7WRVCyJbGmjZwEQfEnXHsHeRH/7U4u	pedro	\N
8	b@b.com	$2a$10$0hDnckdIpbYaoNI.ruJRbOaYQbPPFiJrcgMZjxw/qYe1bagTwnXJW	martina	\N
9	pedro@pedro.com	$2a$10$/KIaMWe.SC94InMc1sXNG.jugQrE48yN2GATNunGBU2yAOYnTMd7m	pedro1	\N
\.


--
-- TOC entry 3015 (class 0 OID 38081)
-- Dependencies: 220
-- Data for Name: work_experience; Type: TABLE DATA; Schema: public; Owner: hhrr_user
--

COPY public.work_experience (id, is_active, version, created_date, modified_date, description, name, candidate_id, date_from, date_to, salary) FROM stdin;
\.


--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 202
-- Name: candidates_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.candidates_id_seq', 5, true);


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 205
-- Name: departments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.departments_id_seq', 1, false);


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 207
-- Name: employees_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.employees_id_seq', 1, false);


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 209
-- Name: institution_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.institution_id_seq', 3, true);


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 211
-- Name: jobs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.jobs_id_seq', 16, true);


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 213
-- Name: languages_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.languages_id_seq', 48, true);


--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 215
-- Name: risk_level_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.risk_level_id_seq', 5, true);


--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 221
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 217
-- Name: skills_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.skills_id_seq', 4, true);


--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 228
-- Name: trainings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.trainings_id_seq', 1, true);


--
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 224
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.users_id_seq', 9, true);


--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 219
-- Name: work_experience_id_seq; Type: SEQUENCE SET; Schema: public; Owner: hhrr_user
--

SELECT pg_catalog.setval('public.work_experience_id_seq', 1, false);


--
-- TOC entry 2848 (class 2606 OID 38254)
-- Name: candidates_languages candidates_languages_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates_languages
    ADD CONSTRAINT candidates_languages_pkey PRIMARY KEY (candidate_id, language_id);


--
-- TOC entry 2790 (class 2606 OID 37983)
-- Name: candidates candidates_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT candidates_pkey PRIMARY KEY (id);


--
-- TOC entry 2795 (class 2606 OID 37988)
-- Name: candidates_skills candidates_skills_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates_skills
    ADD CONSTRAINT candidates_skills_pkey PRIMARY KEY (candidate_id, skill_id);


--
-- TOC entry 2797 (class 2606 OID 38004)
-- Name: departments departments_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_pkey PRIMARY KEY (id);


--
-- TOC entry 2802 (class 2606 OID 38012)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- TOC entry 2808 (class 2606 OID 38023)
-- Name: institution institution_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.institution
    ADD CONSTRAINT institution_pkey PRIMARY KEY (id);


--
-- TOC entry 2846 (class 2606 OID 38209)
-- Name: jobs_candidates jobs_candidates_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.jobs_candidates
    ADD CONSTRAINT jobs_candidates_pkey PRIMARY KEY (candidate_id, job_id);


--
-- TOC entry 2814 (class 2606 OID 38034)
-- Name: jobs jobs_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT jobs_pkey PRIMARY KEY (id);


--
-- TOC entry 2818 (class 2606 OID 38045)
-- Name: languages languages_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);


--
-- TOC entry 2823 (class 2606 OID 38056)
-- Name: risk_level risk_level_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.risk_level
    ADD CONSTRAINT risk_level_pkey PRIMARY KEY (id);


--
-- TOC entry 2836 (class 2606 OID 38167)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2828 (class 2606 OID 38067)
-- Name: skills skills_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.skills
    ADD CONSTRAINT skills_pkey PRIMARY KEY (id);


--
-- TOC entry 2853 (class 2606 OID 38276)
-- Name: trainings trainings_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.trainings
    ADD CONSTRAINT trainings_pkey PRIMARY KEY (id);


--
-- TOC entry 2800 (class 2606 OID 38095)
-- Name: departments uidx_departments_name; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.departments
    ADD CONSTRAINT uidx_departments_name UNIQUE (name);


--
-- TOC entry 2810 (class 2606 OID 38101)
-- Name: institution uidx_institution_name; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.institution
    ADD CONSTRAINT uidx_institution_name UNIQUE (name);


--
-- TOC entry 2820 (class 2606 OID 38107)
-- Name: languages uidx_language_name; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.languages
    ADD CONSTRAINT uidx_language_name UNIQUE (name);


--
-- TOC entry 2825 (class 2606 OID 38110)
-- Name: risk_level uidx_risklevel_name; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.risk_level
    ADD CONSTRAINT uidx_risklevel_name UNIQUE (name);


--
-- TOC entry 2830 (class 2606 OID 38113)
-- Name: skills uidx_skills_name; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.skills
    ADD CONSTRAINT uidx_skills_name UNIQUE (name);


--
-- TOC entry 2855 (class 2606 OID 38281)
-- Name: trainings uidx_trainings_name; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.trainings
    ADD CONSTRAINT uidx_trainings_name UNIQUE (name);


--
-- TOC entry 2840 (class 2606 OID 38184)
-- Name: users uk6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- TOC entry 2842 (class 2606 OID 38182)
-- Name: users ukr43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- TOC entry 2838 (class 2606 OID 38172)
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);


--
-- TOC entry 2844 (class 2606 OID 38180)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2834 (class 2606 OID 38089)
-- Name: work_experience work_experience_pkey; Type: CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.work_experience
    ADD CONSTRAINT work_experience_pkey PRIMARY KEY (id);


--
-- TOC entry 2791 (class 1259 OID 38091)
-- Name: idx_candidates_first_name; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_candidates_first_name ON public.candidates USING btree (first_name);


--
-- TOC entry 2792 (class 1259 OID 38090)
-- Name: idx_candidates_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_candidates_isactive ON public.candidates USING btree (is_active);


--
-- TOC entry 2793 (class 1259 OID 38092)
-- Name: idx_candidates_last_name; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_candidates_last_name ON public.candidates USING btree (last_name);


--
-- TOC entry 2798 (class 1259 OID 38093)
-- Name: idx_departments_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_departments_isactive ON public.departments USING btree (is_active);


--
-- TOC entry 2803 (class 1259 OID 38097)
-- Name: idx_employees_first_name; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_employees_first_name ON public.employees USING btree (first_name);


--
-- TOC entry 2804 (class 1259 OID 38096)
-- Name: idx_employees_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_employees_isactive ON public.employees USING btree (is_active);


--
-- TOC entry 2805 (class 1259 OID 38098)
-- Name: idx_employees_last_name; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_employees_last_name ON public.employees USING btree (last_name);


--
-- TOC entry 2806 (class 1259 OID 38099)
-- Name: idx_institution_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_institution_isactive ON public.institution USING btree (is_active);


--
-- TOC entry 2811 (class 1259 OID 38102)
-- Name: idx_jobs_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_jobs_isactive ON public.jobs USING btree (is_active);


--
-- TOC entry 2812 (class 1259 OID 38104)
-- Name: idx_jobs_risklevel; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_jobs_risklevel ON public.jobs USING btree (risk_level_id);


--
-- TOC entry 2816 (class 1259 OID 38105)
-- Name: idx_language_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_language_isactive ON public.languages USING btree (is_active);


--
-- TOC entry 2821 (class 1259 OID 38108)
-- Name: idx_risklevel_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_risklevel_isactive ON public.risk_level USING btree (is_active);


--
-- TOC entry 2826 (class 1259 OID 38111)
-- Name: idx_skill_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_skill_isactive ON public.skills USING btree (is_active);


--
-- TOC entry 2849 (class 1259 OID 38279)
-- Name: idx_training_candidate_id; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_training_candidate_id ON public.trainings USING btree (candidate_id);


--
-- TOC entry 2850 (class 1259 OID 38278)
-- Name: idx_training_institution_id; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_training_institution_id ON public.trainings USING btree (institution_id);


--
-- TOC entry 2851 (class 1259 OID 38277)
-- Name: idx_training_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_training_isactive ON public.trainings USING btree (is_active);


--
-- TOC entry 2831 (class 1259 OID 38118)
-- Name: idx_work_experience_cantidades; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_work_experience_cantidades ON public.work_experience USING btree (candidate_id);


--
-- TOC entry 2832 (class 1259 OID 38117)
-- Name: idx_work_experience_isactive; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX idx_work_experience_isactive ON public.work_experience USING btree (is_active);


--
-- TOC entry 2815 (class 1259 OID 38103)
-- Name: uidx_jobs_name; Type: INDEX; Schema: public; Owner: hhrr_user
--

CREATE INDEX uidx_jobs_name ON public.jobs USING btree (name);


--
-- TOC entry 2864 (class 2606 OID 38200)
-- Name: users fk5eao4qguk9a2im2j1k4xq386k; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk5eao4qguk9a2im2j1k4xq386k FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2868 (class 2606 OID 38260)
-- Name: candidates_languages fk_candidates_languagues_candidate; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates_languages
    ADD CONSTRAINT fk_candidates_languagues_candidate FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2867 (class 2606 OID 38255)
-- Name: candidates_languages fk_cantidates_languagues_languages; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates_languages
    ADD CONSTRAINT fk_cantidates_languagues_languages FOREIGN KEY (language_id) REFERENCES public.languages(id);


--
-- TOC entry 2858 (class 2606 OID 38124)
-- Name: candidates_skills fk_cantidates_skills_candidates; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates_skills
    ADD CONSTRAINT fk_cantidates_skills_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2857 (class 2606 OID 38119)
-- Name: candidates_skills fk_cantidates_skills_skills; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates_skills
    ADD CONSTRAINT fk_cantidates_skills_skills FOREIGN KEY (skill_id) REFERENCES public.skills(id);


--
-- TOC entry 2859 (class 2606 OID 38139)
-- Name: employees fk_employee_department; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES public.departments(id);


--
-- TOC entry 2866 (class 2606 OID 38215)
-- Name: jobs_candidates fk_jobs_cantidates_candidates; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.jobs_candidates
    ADD CONSTRAINT fk_jobs_cantidates_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2865 (class 2606 OID 38210)
-- Name: jobs_candidates fk_jobs_cantidates_jobs; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.jobs_candidates
    ADD CONSTRAINT fk_jobs_cantidates_jobs FOREIGN KEY (job_id) REFERENCES public.jobs(id);


--
-- TOC entry 2860 (class 2606 OID 38144)
-- Name: jobs fk_jobs_risklevel; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT fk_jobs_risklevel FOREIGN KEY (risk_level_id) REFERENCES public.risk_level(id);


--
-- TOC entry 2869 (class 2606 OID 38282)
-- Name: trainings fk_trainings_candidates; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.trainings
    ADD CONSTRAINT fk_trainings_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2870 (class 2606 OID 38287)
-- Name: trainings fk_trainings_institution; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.trainings
    ADD CONSTRAINT fk_trainings_institution FOREIGN KEY (institution_id) REFERENCES public.institution(id);


--
-- TOC entry 2861 (class 2606 OID 38154)
-- Name: work_experience fk_work_experience_candidate; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.work_experience
    ADD CONSTRAINT fk_work_experience_candidate FOREIGN KEY (candidate_id) REFERENCES public.candidates(id);


--
-- TOC entry 2862 (class 2606 OID 38185)
-- Name: user_roles fkh8ciramu9cc9q3qcqiv4ue8a6; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 2863 (class 2606 OID 38190)
-- Name: user_roles fkhfh9dx7w3ubf1co1vdev94g3f; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2856 (class 2606 OID 38195)
-- Name: candidates fkme4fkelukmx2s63tlcrft6hio; Type: FK CONSTRAINT; Schema: public; Owner: hhrr_user
--

ALTER TABLE ONLY public.candidates
    ADD CONSTRAINT fkme4fkelukmx2s63tlcrft6hio FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2020-02-23 11:39:06

--
-- PostgreSQL database dump complete
--

