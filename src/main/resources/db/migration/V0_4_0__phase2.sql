-- PAYMENTS
CREATE TABLE "public"."payments" (
    "id" UUID NOT NULL,
    "order_id" UUID NOT NULL,
    "external_reference" UUID NULL,
    "created" TIMESTAMP(6) NOT NULL,
    "approved" BOOLEAN NOT NULL,
    "status" SMALLINT NOT NULL CHECK (status BETWEEN 0 AND 8),
    "status_detail" VARCHAR(50) NULL,
    "value" NUMERIC(38,2) NOT NULL,
    CONSTRAINT "payments_pk" PRIMARY KEY ("id"),
    CONSTRAINT "payments_uk_external_reference" UNIQUE ("external_reference")
);
ALTER TABLE payments
  ADD CONSTRAINT payments_fk_order_id FOREIGN KEY ("order_id") REFERENCES orders;

-- FLYWAY
-- INSERT INTO "public"."flyway_schema_history" ("installed_rank", "version", "description", "type", "script", "checksum", "installed_by", "installed_on", "execution_time", "success") VALUES (2, '0.4.0', 'phase2', 'SQL', 'V0_4_0__phase2.sql', -1277675930, 'postgres', '2023-09-03 08:49:51.408666', 17, true);