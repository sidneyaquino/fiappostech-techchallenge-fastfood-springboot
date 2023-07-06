-- CUSTOMERS
CREATE TABLE "public"."customers" ( 
  "personal_id" VARCHAR(11) NOT NULL,
  "email" VARCHAR(255) NOT NULL,
  "name" VARCHAR(150) NOT NULL,
  CONSTRAINT "customers_pkey" PRIMARY KEY ("personal_id"),
  CONSTRAINT "uk_rfbvkrffamfql7cjmen8v976v" UNIQUE ("email")
);
INSERT INTO "public"."customers" ("personal_id", "email", "name") VALUES ('12345678902', 'otto@bismark.de', 'Otto Bismark');
INSERT INTO "public"."customers" ("personal_id", "email", "name") VALUES ('12345678901', 'nikolas@grosskopf.com', 'Nikolas Grosskopf');
INSERT INTO "public"."customers" ("personal_id", "email", "name") VALUES ('12345678903', 'michael@Huttemberg.com', 'Michael Huttemberg');

-- PRODUCTS
CREATE TABLE "public"."products" ( 
  "id" UUID NOT NULL,
  "category" SMALLINT NOT NULL,
  "deleted" BOOLEAN NOT NULL,
  "description" TEXT NOT NULL,
  "name" VARCHAR(150) NOT NULL,
  "value" NUMERIC NOT NULL,
  CONSTRAINT "products_pkey" PRIMARY KEY ("id")
);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('5ccf3357-150d-4661-8201-eceb744edbe9', 0, 'Double Burger with Many Mayo', 'Prima Burger Stuttgart', '13.99', false);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('4c987ae3-bdb8-4355-86de-2eb3ad2e0fe2', 0, 'Double Big Burger with a lot of Cheese', 'Super Burger Munich', '15.99', false);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('36c82b28-a66c-4cad-b77c-b39916bd0a1f', 2, 'Normal Coke 1L', 'Big Coke', '5.99', false);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('61c100ee-0e8b-41a9-915c-70892d5fac50', 2, 'Fanta 500 ml', 'Orange Fanta', '3.49', false);