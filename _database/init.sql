CREATE TABLE users (
    id int NOT NULL,
    username varchar(255) NOT NULL,
	firstname varchar(255) NOT NULL,
    lastname varchar(255),
    email varchar(255) NOT NULL,
    country varchar(255) NOT NULL,
	city varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO users VALUES (0, 'administrator', 'Administrator', '', 'administrator@noodlesystem.com', 'Poland', 'Warszawa')
