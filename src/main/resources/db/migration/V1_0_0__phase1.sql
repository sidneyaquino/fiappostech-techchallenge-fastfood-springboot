-- psql -U postgres -d fastfood
-- psql -w -U "postgres" -h localhost -p 5432 -c "CREATE DATABASE fastfood"
-- psql -q -U "postgres" -d "fastfood" -h localhost -p 5432 -f file.sql
-- psql -w -U "postgres" -d "fastfood" -h localhost -p 5432 -c "SELECT * FROM CUSTOMERS"

-- CUSTOMERS
CREATE TABLE "public"."customers" ( 
  "id" UUID NOT NULL,
  "personal_id" VARCHAR(11) NOT NULL,
  "email" VARCHAR(255) NOT NULL,
  "name" VARCHAR(150) NOT NULL,
  CONSTRAINT "customers_pk" PRIMARY KEY ("id"),
  CONSTRAINT "customers_uk_personal_id" UNIQUE ("personal_id")
);
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('5e5e53f6-97ba-4edb-b4a1-cb6b409a9ba7', '12345678902', 'otto@bismark.de', 'Otto Bismark');
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('5e095b86-eba1-4fd3-b630-e97c58c2da8e', '12345678901', 'nikolas@grosskopf.com', 'Nikolas Grosskopf');
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('4fee3c91-db14-434a-8dec-a140215573cd', '12345678903', 'michael@Huttemberg.com', 'Michael Huttemberg');
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('1d9b9381-d7bc-4d97-adf8-a6f626eba5e1', '12345678904', 'mikki@einstein.com', 'Mikki Einstein');

-- PRODUCTS
CREATE TABLE "public"."products" ( 
  "id" UUID NOT NULL,
  "name" VARCHAR(150) NOT NULL,
  "description" TEXT NOT NULL,
  "category" SMALLINT NOT NULL CHECK (category BETWEEN 0 AND 3),
  "value" NUMERIC(38,2) NOT NULL,
  "deleted" BOOLEAN NOT NULL,
  CONSTRAINT "products_pk" PRIMARY KEY ("id")
);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('5ccf3357-150d-4661-8201-eceb744edbe9', 0, 'Double Burger with Many Mayo', 'Prima Burger Stuttgart', '13.99', false);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('4c987ae3-bdb8-4355-86de-2eb3ad2e0fe2', 0, 'Double Big Burger with a lot of Cheese', 'Super Burger Munich', '15.99', false);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('36c82b28-a66c-4cad-b77c-b39916bd0a1f', 2, 'Normal Coke 1L', 'Big Coke', '5.99', false);
INSERT INTO "public"."products" ("id", "category", "description", "name", "value", "deleted") VALUES ('61c100ee-0e8b-41a9-915c-70892d5fac50', 2, 'Fanta 500 ml', 'Orange Fanta', '3.49', false);

-- ORDERS
CREATE TABLE "public"."orders" ( 
  "id" UUID NOT NULL,
  "customer_id" UUID NULL,
  "created" TIMESTAMP(6) NOT NULL,
  "tracked" TIMESTAMP(6) NULL,
  "tracking" SMALLINT NULL CHECK (tracking BETWEEN 0 AND 3),
  "value" NUMERIC(38,2) NOT NULL,
  CONSTRAINT "orders_pk" PRIMARY KEY ("id")
);
ALTER TABLE orders 
  ADD CONSTRAINT orders_fk_customer_id FOREIGN KEY ("customer_id") REFERENCES customers;

-- ORDER_PRODUCTS
CREATE TABLE "public"."order_products" ( 
  "order_id" UUID NOT NULL,
  "product_id" UUID NOT NULL,
  "quantity" SMALLINT NOT NULL,
  "value" NUMERIC(38,2) NOT NULL,
  CONSTRAINT "order_products_pk" PRIMARY KEY ("order_id", "product_id")
);
ALTER TABLE order_products 
  ADD CONSTRAINT order_products_fk_product_id FOREIGN KEY (product_id) REFERENCES products;
ALTER TABLE order_products 
  ADD CONSTRAINT order_products_fk_order_id FOREIGN KEY (order_id) REFERENCES orders;

-- -- FLYWAY
-- CREATE TABLE "public"."flyway_schema_history" ( 
--   "installed_rank" INTEGER NOT NULL,
--   "version" VARCHAR(50) NULL,
--   "description" VARCHAR(200) NOT NULL,
--   "type" VARCHAR(20) NOT NULL,
--   "script" VARCHAR(1000) NOT NULL,
--   "checksum" INTEGER NULL,
--   "installed_by" VARCHAR(100) NOT NULL,
--   "installed_on" TIMESTAMP NOT NULL DEFAULT now() ,
--   "execution_time" INTEGER NOT NULL,
--   "success" BOOLEAN NOT NULL,
--   CONSTRAINT "flyway_schema_history_pk" PRIMARY KEY ("installed_rank")
-- );
-- CREATE INDEX "flyway_schema_history_s_idx" 
-- ON "public"."flyway_schema_history" (
--   "success" ASC
-- );
-- INSERT INTO "public"."flyway_schema_history" ("installed_rank", "version", "description", "type", "script", "checksum", "installed_by", "installed_on", "execution_time", "success") VALUES (1, '1.0.0', 'phase1', 'SQL', 'V1_0_0__phase1.sql', 554950033, 'postgres', '2023-08-25 10:55:29.702102', 104, true);