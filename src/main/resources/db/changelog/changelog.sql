--liquibase formatted sql
--changeset Dhrutimaya:9090.v1 splitStatements:true;
CREATE TABLE IF NOT EXISTS credential_master (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(100) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  phone_no varchar(20) DEFAULT NULL,
  user_id bigint DEFAULT NULL,
  user_type_id int DEFAULT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS user_data (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(100) DEFAULT NULL,
  phone_no varchar(20) DEFAULT NULL,
  user_name varchar(255) DEFAULT NULL,
  is_active bit(1) DEFAULT NULL,
  PRIMARY KEY (id)
);

--changeset Manoranjan:22928
CREATE TABLE IF NOT EXISTS parent_product (
  id bigint NOT NULL AUTO_INCREMENT,
  product_name varchar(200),
  image_url text,
  PRIMARY KEY (id)
);
