CREATE TABLE IF NOT EXISTS hotel(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    name        VARCHAR(45)                       NOT NULL,
    rating      VARCHAR(45)                       NOT NULL,
    description VARCHAR(120)                      NOT NULL,
    address_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE
);