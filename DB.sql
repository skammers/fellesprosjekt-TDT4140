CREATE TABLE User(
    id INT NOT NULL PRIMARY KEY
    email VARCHAR(50),
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    position VARCHAR(30),
    phoneNumber VARCHAR(20),
    hashedPassword CHAR(64),
)