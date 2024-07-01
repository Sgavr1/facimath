CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    login VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL
);
CREATE TABLE tests (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    test TEXT NOT NULL
);