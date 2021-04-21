CREATE TABLE IF NOT EXISTS address(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    country        VARCHAR(45)                       NOT NULL,
    county         VARCHAR(45),
    city           VARCHAR(45)                       NOT NULL,
    street_address VARCHAR(45)                       NOT NULL,
    postal_code    VARCHAR(45)                       NOT NULL,
    phone_number   VARCHAR(45)                       NOT NULL,
    email_address  VARCHAR(45)                       NOT NULL
);