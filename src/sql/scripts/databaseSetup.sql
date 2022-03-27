-- DDL to create all tables:

CREATE TABLE Employee (
    empID			        INT,
    name			        VARCHAR(30) NOT NULL,
    specialization	        VARCHAR(30),
    salary 			        INT NOT NULL,
    dateOfBirth 	        DATE NOT NULL,
    email			        VARCHAR(50) NOT NULL UNIQUE,
    freightCar		        INT,
    licenseExpiryDate       DATE,
    licenseNumber 	        INT,
    certificationIssueDate  DATE,
    PRIMARY KEY(empID)
);

CREATE TABLE Train_Main (
    trainID         INT,
    model           VARCHAR(20),
    manufactureYear INT,
    PRIMARY KEY (trainID),
    FOREIGN KEY (model, manufactureYear) REFERENCES Train_Extra -- cascade??
);

CREATE TABLE Train_Extra (
    model           VARCHAR(20),
    manufactureYear INT,
    numSeats        INT,
    numCars         INT,
    PRIMARY KEY (model, manufactureYear)
);

CREATE TABLE Manages (
    empID	INT,
    trainID	INT NOT NULL,
    PRIMARY KEY (empID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (empID) REFERENCES Employee ON DELETE CASCADE
);

CREATE TABLE Drives (
    empID	INT,
    trainID	INT NOT NULL,
    PRIMARY KEY (empID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (empID) REFERENCES Employee ON DELETE CASCADE
);

CREATE TABLE Maintains (
    empID	INT,
    trainID	INT,
    PRIMARY KEY (empID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (empID) REFERENCES Employee ON DELETE CASCADE
);

CREATE TABLE Passenger (
    passengerID INT,
    name		VARCHAR(30),
    PRIMARY KEY(passengerID)
);

CREATE TABLE Cargo_BelongsTo (
    passengerID	INT,
    cargoID		INT,
    weight		INT NOT NULL,
    PRIMARY KEY (passengerID, cargoID),
    FOREIGN KEY (passengerID) REFERENCES Passenger ON DELETE CASCADE
);

CREATE TABLE Seat_Main (
    seatNum INT,
    trainID INT,
    class   VARCHAR(20),
    PRIMARY KEY (seatNum, trainID),
    FOREIGN KEY (seatNum) REFERENCES Seat_CarMapping -- cascade??
);

CREATE TABLE Seat_CarMapping (
    seatNum INT,
    carNum  INT NOT NULL,
    PRIMARY KEY (seatNum)
);

CREATE TABLE Route (
    routeID	            INT,
    departureStation    VARCHAR(30) NOT NULL,
    destinationStation  VARCHAR(30) NOT NULL,
    departureTime       TIMESTAMP,
    estimatedDuration   INT NOT NULL,
    tripDistance        INT,
    PRIMARY KEY (routeID)
);

CREATE TABLE Station (
    name    VARCHAR(30),
    address	VARCHAR(50) NOT NULL,
    PRIMARY KEY(name)
);

CREATE TABLE Trip (
    seatNum	    INT,
    passengerID	INT,
    routeID	    INT,
    trainID	    INT,
    PRIMARY KEY (seatNum, passengerID, routeID, trainID),
    FOREIGN KEY (seatNum, trainID) REFERENCES Seat_Main ON DELETE CASCADE,
    FOREIGN KEY (passengerID) REFERENCES Passenger ON DELETE CASCADE,
    FOREIGN KEY (routeID) REFERENCES Route ON DELETE CASCADE,
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE
);

CREATE TABLE GoesThrough (
    stationName	VARCHAR(30),
    routeID	    INT,
    timeOfStop  TIMESTAMP,
    PRIMARY KEY (stationName, routeID),
    FOREIGN KEY (stationName) REFERENCES Station (name) ON DELETE CASCADE,
    FOREIGN KEY (routeID) REFERENCES Route ON DELETE CASCADE
);

CREATE TABLE StoredAt (
    trainId	    INT,
    stationName	VARCHAR(30),
    PRIMARY KEY (trainID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (stationName) REFERENCES Station (name) ON DELETE CASCADE
);

-- insert tuples into tables:

