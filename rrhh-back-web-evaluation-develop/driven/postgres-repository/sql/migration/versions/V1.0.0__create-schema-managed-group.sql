/*==============================================================*/
/* Table: topic_managed_group                                        */
/*==============================================================*/
CREATE TABLE topic_managed_group (
	managed_group_id varchar(2) NOT NULL,
	financial_company_public_id varchar(2) NULL,
	"name" varchar(250) NULL,
	short_name varchar(45) NULL,
	is_visible bool DEFAULT false NULL,
	CONSTRAINT topic_managed_group_pkey PRIMARY KEY (managed_group_id)
);

INSERT INTO topic_managed_group (managed_group_id,financial_company_public_id,"name",short_name,is_visible) VALUES
	 ('72',NULL,'EDEM','EDEM',false),
	 ('57',NULL,'MANDIJE','MANDIJE',false),
	 ('71',NULL,'CALADERO','CALADERO',false),
	 ('70',NULL,'RADAR','RADAR',false),
	 ('60',NULL,'ISTMADONA S. DE RL.','ISTMADONA',false),
	 ('80',NULL,'GRUPO SOTHIS','SOTHIS',false),
	 ('59',NULL,'AGENCIA DE CHILE','AGENCIA DE CHILE',false),
	 ('11',NULL,'FORNS VALENCIANS FORVA S.A.U.','FORVASA',false),
	 ('73',NULL,'LANZADERA','LANZADERA',false),
	 ('76',NULL,'EXPATRIADOS','EXPATRIADO',false);
INSERT INTO topic_managed_group (managed_group_id,financial_company_public_id,"name",short_name,is_visible) VALUES
	 ('81',NULL,'LICAMPA, S.L.','LICAMPA',false),
	 ('51',NULL,'BELGISA','BELGISA',false),
	 ('85',NULL,'VALENCIA 5 ESTRELLAS','VLC 5 ESTRELLAS',false),
	 ('50',NULL,'MI EINKAUF','MI EINKAUF',false),
	 ('53',NULL,'OR VIETNAM','OR VIETNAM',false),
	 ('18',NULL,'FINOP (SOCIEDAD UNIPERSONAL)','FINOP',false),
	 ('82',NULL,'CONSEJO ADMIN. Y ACCIONISTAS','CONSEJO AD. Y ACC.',false),
	 ('01',NULL,'PRESIDENCIA','PRESIDENCIA',false),
	 ('54',NULL,'OR SUCURSAL TAILANDIA','SUCURSAL TAILANDIA',false),
	 ('12',NULL,'LLANOREL S.A.','LLANOREL',false);
INSERT INTO topic_managed_group (managed_group_id,financial_company_public_id,"name",short_name,is_visible) VALUES
	 ('55',NULL,'MERTICADONA','MERTICADONA',false),
	 ('52',NULL,'MEICHIADA','MEICHIADA',false),
	 ('77',NULL,'LA MARINA','LA MARINA',false),
	 ('79',NULL,'FUNDACION TRINIDAD ALFONSO','F.TRINIDAD ALFONSO',false),
	 ('84',NULL,'VALENCIA BASKET CLUB','VLC BASKET CLUB',false),
	 ('56',NULL,'ANDINADONA','ANDINADONA',false),
	 ('19',NULL,'INMOALAMEDA, S.L.','INMOALAMEDA',false),
	 ('83',NULL,'FUNDACION HORTENSIA HERRERO','F. HORTEN. HERRERO',false),
	 ('74',NULL,'ANGELS','ANGELS',false),
	 ('75',NULL,'MENA','MENA',false);
INSERT INTO topic_managed_group (managed_group_id,financial_company_public_id,"name",short_name,is_visible) VALUES
	 ('58',NULL,'MERCAIRMA','MERCAIRMA',false),
	 ('61',NULL,'INMOALAMEDA','INMOALAMEDA',false),
	 ('08','08','MERCADONA, S.A.','MERCADONA',true),
	 ('09','09','IRMÃDONA','IRMÃDONA',true),
	 ('78',NULL,'INMOALAMEDA','INMOALAMEDA',false),
	 ('62',NULL,'ARENA FOOD AND BEVERAGE, S.L.','AFB',false);
