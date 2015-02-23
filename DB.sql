CREATE TABLE User(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
    email VARCHAR(50),
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    position VARCHAR(30),
    phoneNumber VARCHAR(20),
    hashedPassword CHAR(64),
)

CREATE TABLE Group(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    ownerId INT NOT NULL,
    FOREIGN KEY (ownerId) REFERENCES User.id
)

CREATE TABLE GroupUser(
    userId INT NOT NULL,
    groupId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES User.id,
    FOREIGN KEY (groupId) REFERENCES Group.id
)