CREATE TABLE todos (
    id   long         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    done boolean default false
);

INSERT INTO todos (name, description, done)
VALUES ('jooksma', '10 km',false );
INSERT INTO todos(name, description, done)
VALUES ('sooma', 'koik', true );
INSERT INTO todos(name, description, done)
VALUES ('pidu', 'tana', true );
INSERT INTO todos(name, description, done)
VALUES ('pidu', 'homme', true );
