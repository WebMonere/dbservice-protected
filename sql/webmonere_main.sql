-- Adminer 4.7.6 PostgreSQL dump

\connect "webmonere_main";

DROP TABLE IF EXISTS "customer";
DROP SEQUENCE IF EXISTS customer_user_id_seq;
CREATE SEQUENCE customer_user_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."customer" (
    "user_id" integer DEFAULT nextval('customer_user_id_seq') NOT NULL,
    "email" character varying(255),
    "mobile_number" character varying(15),
    "name" character varying(255),
    CONSTRAINT "customer_pkey" PRIMARY KEY ("user_id"),
    CONSTRAINT "uk_5v8hijx47m783qo8i4sox2n5t" UNIQUE ("mobile_number"),
    CONSTRAINT "uk_dwk6cx0afu8bs9o4t536v1j5v" UNIQUE ("email")
) WITH (oids = false);


DROP TABLE IF EXISTS "hostmapping";
DROP SEQUENCE IF EXISTS hostmapping_id_seq;
CREATE SEQUENCE hostmapping_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."hostmapping" (
    "id" integer DEFAULT nextval('hostmapping_id_seq') NOT NULL,
    "hostname_id" bigint NOT NULL,
    "user_id" bigint NOT NULL,
    CONSTRAINT "hostmapping_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "hostmapping_hostname_id_fkey" FOREIGN KEY (hostname_id) REFERENCES hostname(hostname_id) NOT DEFERRABLE,
    CONSTRAINT "hostmapping_hostname_id_fkey1" FOREIGN KEY (hostname_id) REFERENCES hostname(hostname_id) NOT DEFERRABLE,
    CONSTRAINT "hostmapping_user_id_fkey" FOREIGN KEY (user_id) REFERENCES customer(user_id) NOT DEFERRABLE
) WITH (oids = false);


DROP TABLE IF EXISTS "hostname";
DROP SEQUENCE IF EXISTS hostname_hostname_id_seq;
CREATE SEQUENCE hostname_hostname_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."hostname" (
    "hostname_id" integer DEFAULT nextval('hostname_hostname_id_seq') NOT NULL,
    "hostname" character varying(255) NOT NULL,
    CONSTRAINT "hostname_pkey" PRIMARY KEY ("hostname_id")
) WITH (oids = false);


-- 2020-02-15 16:40:22.849168+00
