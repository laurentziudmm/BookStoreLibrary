CREATE TABLE IF NOT EXISTS room
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,
    floor       INT                               NOT NULL,
    type        VARCHAR(45)                       NOT NULL,
    status      VARCHAR(45)                       NOT NULL,
    description VARCHAR(200)                      NOT NULL,
    price       DECIMAL(10,2)                    NOT NULL,
    hotel_id     BIGINT,
    booking_id   BIGINT,
     FOREIGN KEY (hotel_id) REFERENCES hotel(id) ON DELETE CASCADE
);