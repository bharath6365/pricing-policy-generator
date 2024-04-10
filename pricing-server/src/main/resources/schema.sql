CREATE TABLE rules (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       namespace VARCHAR(255),
                       description TEXT,
                       condition TEXT,
                       action TEXT,
                       rule_type INTEGER,
                       is_terminal BOOLEAN
);
