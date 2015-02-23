CREATE TABLE User(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
    email VARCHAR(50) NOT NULL,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    position VARCHAR(30),
    phoneNumber VARCHAR(20),
    hashedPassword CHAR(64) NOT NULL,
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

CREATE TABLE Building(
    name VARCHAR(30) NOT NULL PRIMARY KEY
)

CREATE TABLE Room(
    roomName VARCHAR(30) NOT NULL,
    buildingName VARCHAR(30) NOT NULL,
    location VARCHAR(50),
    FOREIGN KEY (buildingName) REFERENCES Building.name,
    PRIMARY KEY (roomName, buildingName)
)