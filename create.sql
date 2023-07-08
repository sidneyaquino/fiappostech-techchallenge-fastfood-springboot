-- CUSTOMERS
CREATE TABLE "public"."customers" ( 
  "id" UUID NOT NULL,
  "personal_id" VARCHAR(11) NOT NULL,
  "email" VARCHAR(255) NOT NULL,
  "name" VARCHAR(150) NOT NULL,
  CONSTRAINT "customers_pkey" PRIMARY KEY ("id"),
  CONSTRAINT "uk_rfbvkrffamfql7cjmen8v976v" UNIQUE ("email"),
  CONSTRAINT "uk_tm7tv6x6kgafot3226v38nnw2" UNIQUE ("personal_id")
);
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('5e5e53f6-97ba-4edb-b4a1-cb6b409a9ba7', '12345678902', 'otto@bismark.de', 'Otto Bismark');
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('5e095b86-eba1-4fd3-b630-e97c58c2da8e', '12345678901', 'nikolas@grosskopf.com', 'Nikolas Grosskopf');
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('4fee3c91-db14-434a-8dec-a140215573cd', '12345678903', 'michael@Huttemberg.com', 'Michael Huttemberg');
INSERT INTO "public"."customers" ("id", "personal_id", "email", "name") VALUES ('1d9b9381-d7bc-4d97-adf8-a6f626eba5e1', '12345678904', 'mikki@einstein.com', 'Mikki Einstein');


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


-- ORDERS
CREATE TABLE "public"."orders" ( 
  "id" UUID NOT NULL,
  "created" TIMESTAMP NOT NULL,
  "tracked" TIMESTAMP NULL,
  "tracking" SMALLINT NULL,
  "value" NUMERIC NOT NULL,
  "customer_id" UUID NULL,
  CONSTRAINT "orders_pkey" PRIMARY KEY ("id")
);
ALTER TABLE orders 
    ADD CONSTRAINT FKpxtb8awmi0dk6smoh2vp1litg FOREIGN KEY ("customer_id") REFERENCES customers;

-- INSERT INTO
