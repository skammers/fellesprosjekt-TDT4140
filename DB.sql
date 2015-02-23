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
    parentId INT,
    FOREIGN KEY (ownerId) REFERENCES User (id),
    FOREIGN KEY (parentId) REFERENCES Group (id)
)

CREATE TABLE GroupUser(
    userId INT NOT NULL,
    groupId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES User (id),
    FOREIGN KEY (groupId) REFERENCES Group (id),
    PRIMARY KEY (userId, groupId)
)

CREATE TABLE Building(
    name VARCHAR(30) NOT NULL PRIMARY KEY,
    location VARCHAR(50),
)

CREATE TABLE Room(
    roomName VARCHAR(30) NOT NULL,
    buildingName VARCHAR(30) NOT NULL,
    location VARCHAR(50),
    capacity INT,
    FOREIGN KEY (buildingName) REFERENCES Building (name),
    PRIMARY KEY (roomName, buildingName)
)

CREATE TABLE Calendar(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    ownerId INT NOT NULL,
    groupId INT,
    FOREIGN KEY (ownerId) REFERENCES User (id),
    FOREIGN KEY (groupId) REFERENCES Group (id)
)

CREATE TABLE Appointment(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    calendarId INT NOT NULL,
    roomName VARCHAR(30),
    buildingName VARCHAR(30),
    description VARCHAR(200),
    startTime DATETIME NOT NULL,
    endTime DATETIME NOT NULL,
    FOREIGN KEY (roomName, buildingName) REFERENCES Room (roomName, buildingName),
    FOREIGN KEY (calendarId) REFERENCES Calendar (id)
)

CREATE TABLE Invitation(
    userId INT NOT NULL,
    appointmentId INT NOT NULL,
    rsvp INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES User (id),
    FOREIGN KEY (appointmentId) REFERENCES Appointment (id),
    PRIMARY KEY (userId, appointmentId)
)