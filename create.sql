CREATE TABLE "public"."customers" ( 
  "personal_id" VARCHAR(255) NOT NULL,
  "email" VARCHAR(255) NULL,
  "name" VARCHAR(255) NOT NULL,
  CONSTRAINT "customers_pkey" PRIMARY KEY ("personal_id"),
  CONSTRAINT "uk_rfbvkrffamfql7cjmen8v976v" UNIQUE ("email")
);