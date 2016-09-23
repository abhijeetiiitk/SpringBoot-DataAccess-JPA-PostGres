CREATE TABLE IF NOT EXISTS OPTOUT_KEYWORDS
(
    SERIAL_NO INT NOT NULL,
    OPTOUT_QUERY VARCHAR(100) NOT NULL,
    FREQUENCY INT NOT NULL,
    TIME_UPDATED TIMESTAMP DEFAULT current_timestamp,
    PRIMARY KEY (SERIAL_NO)
);

CREATE TABLE IF NOT EXISTS BLACKLIST_KEYWORDS
(
    SERIAL_NO INT NOT NULL,
    BLACKLIST_QUERY VARCHAR(100) NOT NULL,
    PRIMARY KEY (SERIAL_NO)
);