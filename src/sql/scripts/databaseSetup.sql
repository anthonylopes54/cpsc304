-- DDL to create all tables:

CREATE TABLE Employee (
    empID INT,
    name VARCHAR(30) NOT NULL,
    specialization VARCHAR(30),
    salary INT NOT NULL,
    dateOfBirth DATE NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    freightCar INT,
    licenseExpiryDate DATE,
    licenseNumber INT,
    certificationIssueDate DATE,
    PRIMARY KEY(empID)
);

CREATE TABLE Train_Extra (
    model VARCHAR(20),
    manufactureYear INT,
    numSeats INT,
    numCars INT,
    PRIMARY KEY (model, manufactureYear)
);

CREATE TABLE Train_Main (
    trainID INT,
    model VARCHAR(20),
    manufactureYear INT,
    PRIMARY KEY (trainID),
    FOREIGN KEY (model, manufactureYear) REFERENCES Train_Extra On DELETE CASCADE
);

CREATE TABLE Manages (
    empID INT,
    trainID	INT NOT NULL,
    PRIMARY KEY (empID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (empID) REFERENCES Employee ON DELETE CASCADE
);

CREATE TABLE Drives (
    empID INT,
    trainID INT NOT NULL,
    PRIMARY KEY (empID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (empID) REFERENCES Employee ON DELETE CASCADE
);

CREATE TABLE Maintains (
    empID INT,
    trainID	INT,
    PRIMARY KEY (empID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (empID) REFERENCES Employee ON DELETE CASCADE
);

CREATE TABLE Passenger (
    passengerID INT,
    name VARCHAR(30),
    PRIMARY KEY(passengerID)
);

CREATE TABLE Cargo_BelongsTo (
    passengerID INT,
    cargoID	INT,
    weight INT NOT NULL,
    PRIMARY KEY (passengerID, cargoID),
    FOREIGN KEY (passengerID) REFERENCES Passenger ON DELETE CASCADE
);

CREATE TABLE Seat_CarMapping (
    seatNum INT,
    carNum INT NOT NULL,
    PRIMARY KEY (seatNum)
);

CREATE TABLE Seat_Main (
    seatNum INT,
    trainID INT,
    class VARCHAR(20),
    PRIMARY KEY (seatNum, trainID),
    FOREIGN KEY (seatNum) REFERENCES Seat_CarMapping ON DELETE CASCADE,
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE
);

CREATE TABLE Route (
    routeID INT,
    departureStation VARCHAR(30) NOT NULL,
    destinationStation VARCHAR(30) NOT NULL,
    departureTime TIMESTAMP,
    estimatedDuration INT NOT NULL,
    tripDistance INT,
    PRIMARY KEY (routeID)
);

CREATE TABLE Station (
    name VARCHAR(30),
    address	VARCHAR(50) NOT NULL,
    PRIMARY KEY(name)
);

CREATE TABLE Trip (
    seatNum	INT,
    passengerID	INT,
    routeID	INT,
    trainID	INT,
    PRIMARY KEY (seatNum, passengerID, routeID, trainID),
    FOREIGN KEY (seatNum, trainID) REFERENCES Seat_Main ON DELETE CASCADE,
    FOREIGN KEY (passengerID) REFERENCES Passenger ON DELETE CASCADE,
    FOREIGN KEY (routeID) REFERENCES Route ON DELETE CASCADE,
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE
);

CREATE TABLE GoesThrough (
    stationName	VARCHAR(30),
    routeID	INT,
    timeOfStop TIMESTAMP,
    PRIMARY KEY (stationName, routeID),
    FOREIGN KEY (stationName) REFERENCES Station (name) ON DELETE CASCADE,
    FOREIGN KEY (routeID) REFERENCES Route ON DELETE CASCADE
);

CREATE TABLE StoredAt (
    trainId	INT,
    stationName	VARCHAR(30),
    PRIMARY KEY (trainID),
    FOREIGN KEY (trainID) REFERENCES Train_Main ON DELETE CASCADE,
    FOREIGN KEY (stationName) REFERENCES Station (name) ON DELETE CASCADE
);

INSERT INTO Employee VALUES (1, 'Joe Boe', 'ATTENDANT', 35000, TO_DATE('09-06-1999', 'MM-DD-YYYY'), 'jboe@gmail.com', 2, NULL, NULL, NULL);
INSERT INTO Employee VALUES (2, 'John Smith', 'ATTENDANT', 14531, TO_DATE('03-02-1992', 'MM-DD-YYYY'), 'johnsmith@gmail.com', NULL, NULL, NULL, NULL);
INSERT INTO Employee VALUES (3, 'Jane Doe', 'ATTENDANT', 23521, TO_DATE('03-15-1988', 'MM-DD-YYYY'), 'jd88@gmail.com', NULL, NULL, NULL, NULL);
INSERT INTO Employee VALUES (4, 'Dave Cantlon', 'ATTENDANT', 35000, TO_DATE('03-01-1975', 'MM-DD-YYYY'), 'dcantlon@gmail.com', 1, NULL, NULL, NULL);
INSERT INTO Employee VALUES (5, 'Patricia Davis', 'ATTENDANT', 35000, TO_DATE('09-12-1986', 'MM-DD-YYYY'), 'patriciad@gmail.com', 3, NULL, NULL, NULL);
INSERT INTO Employee VALUES (6, 'Maria Mayer', 'CONDUCTOR', 55231, TO_DATE('10-16-1977', 'MM-DD-YYYY'), 'm77@terra.com', NULL, NULL, 4484763, TO_DATE('03-20-2000', 'MM-DD-YYYY'));
INSERT INTO Employee VALUES (7, 'Margaret Mason', 'CONDUCTOR', 68772, TO_DATE('04-19-1981', 'MM-DD-YYYY'), 'margmason@gmail.com', NULL, NULL, 4484764, TO_DATE('03-20-2000', 'MM-DD-YYYY'));
INSERT INTO Employee VALUES (8, 'Cindy Read', 'CONDUCTOR', 42000, TO_DATE('12-07-1988', 'MM-DD-YYYY'), 'cindyread223@gmail.com', NULL, NULL, 4484765, TO_DATE('03-20-2000', 'MM-DD-YYYY'));
INSERT INTO Employee VALUES (9, 'Devon Ross', 'CONDUCTOR', 48750, TO_DATE('08-14-1988', 'MM-DD-YYYY'), 'dross@canadarail.com', NULL, NULL, 4484766, TO_DATE('03-20-2000', 'MM-DD-YYYY'));
INSERT INTO Employee VALUES (10, 'Ed Biel', 'CONDUCTOR', 55231, TO_DATE('11-27-1992', 'MM-DD-YYYY'), 'ed.biel@terra.com', NULL, NULL, 4484767, TO_DATE('03-20-2000', 'MM-DD-YYYY'));
INSERT INTO Employee VALUES (11, 'Sebastien Gonzales', 'MECHANIC', 64124, TO_DATE('12-12-1978', 'MM-DD-YYYY'), 'sg@canadarail.com', NULL, TO_DATE('10-12-2023', 'MM-DD-YYYY'), 6589, NULL);
INSERT INTO Employee VALUES (12, 'Mark Charette', 'MECHANIC', 60229, TO_DATE('03-02-1989', 'MM-DD-YYYY'), 'mc7209@gmail.com', NULL, TO_DATE('10-12-2023', 'MM-DD-YYYY'), 6594, NULL);
INSERT INTO Employee VALUES (13, 'Hannah Crawford', 'MECHANIC', 30500, TO_DATE('03-15-1996', 'MM-DD-YYYY'), 'hcrawford4@gmail.com', NULL, TO_DATE('08-01-2026', 'MM-DD-YYYY'), 7992, NULL);
INSERT INTO Employee VALUES (14, 'Alonzo Bradbury', 'MECHANIC', 68000, TO_DATE('12-12-1978', 'MM-DD-YYYY'), 'alonzob@canadarail.com', NULL, TO_DATE('10-14-2022', 'MM-DD-YYYY'), 5204, NULL);
INSERT INTO Employee VALUES (15, 'Sergei Washington', 'MECHANIC', 49672, TO_DATE('10-16-1977', 'MM-DD-YYYY'), 'sergei995@terra.com', NULL, TO_DATE('08-01-2026', 'MM-DD-YYYY'), 7993, NULL);
INSERT INTO Employee VALUES (16, 'Rebecca Clifton', NULL, 85000, TO_DATE('06-28-1993', 'MM-DD-YYYY'), 'rebecca.c@canadarail.com', NULL, NULL, NULL, NULL);
INSERT INTO Employee VALUES (17, 'Ross Harold', NULL, 23800, TO_DATE('02-18-2000', 'MM-DD-YYYY'), 'ross.harold@gmail.com', NULL, NULL, NULL, NULL);

INSERT INTO Train_Extra VALUES ('BOMBARDIER-TI-31', 2007, 200, 4);
INSERT INTO Train_Extra VALUES ('CRRC-C8-19', 2019, 650, 10);
INSERT INTO Train_Extra VALUES ('CRRC-1784', 2012, 400, 8);
INSERT INTO Train_Extra VALUES ('BOMBARDIER-TI-38', 2014, 400, 4);
INSERT INTO Train_Extra VALUES ('CRRC-2E43', 2015, 200, 4);
INSERT INTO Train_Extra VALUES ('General GP40-3507', 1971, 100, 2);
INSERT INTO Train_Extra VALUES ('Bachmann 01205', 2022, 32, 1);

INSERT INTO Train_Main VALUES (11, 'BOMBARDIER-TI-31', 2007);
INSERT INTO Train_Main VALUES (12, 'CRRC-C8-19', 2019);
INSERT INTO Train_Main VALUES (13, 'CRRC-1784', 2012);
INSERT INTO Train_Main VALUES (14, 'BOMBARDIER-TI-38', 2014);
INSERT INTO Train_Main VALUES (15, 'CRRC-2E43', 2015);
INSERT INTO Train_Main VALUES (201, 'General GP40-3507', 1971);
INSERT INTO Train_Main VALUES (202, 'Bachmann 01205', 2022);

INSERT INTO Manages VALUES (1, 11);
INSERT INTO Manages VALUES (2, 12);
INSERT INTO Manages VALUES (3, 13);
INSERT INTO Manages VALUES (4, 14);
INSERT INTO Manages VALUES (5, 15);

INSERT INTO Drives VALUES (6, 15);
INSERT INTO Drives VALUES (7, 11);
INSERT INTO Drives VALUES (8, 13);
INSERT INTO Drives VALUES (9, 12);
INSERT INTO Drives VALUES (10, 14);

INSERT INTO Maintains VALUES (11, 11);
INSERT INTO Maintains VALUES (12, 12);
INSERT INTO Maintains VALUES (13, 13);
INSERT INTO Maintains VALUES (14, 14);
INSERT INTO Maintains VALUES (15, 15);

INSERT INTO Passenger VALUES (63, 'John Smith');
INSERT INTO Passenger VALUES (64, 'Mark Smith');
INSERT INTO Passenger VALUES (26, 'Susan Williams');
INSERT INTO Passenger VALUES (117, 'Ben Thompson');
INSERT INTO Passenger VALUES (93, 'Rachel Brown');

INSERT INTO Cargo_BelongsTo VALUES (117, 23, 12);
INSERT INTO Cargo_BelongsTo VALUES (117, 24, 37);
INSERT INTO Cargo_BelongsTo VALUES (117, 25, 16);
INSERT INTO Cargo_BelongsTo VALUES (26, 2, 22);
INSERT INTO Cargo_BelongsTo VALUES (93, 13, 22);

INSERT INTO Seat_CarMapping VALUES (418, 4);
INSERT INTO Seat_CarMapping VALUES (204, 2);
INSERT INTO Seat_CarMapping VALUES (112, 1);
INSERT INTO Seat_CarMapping VALUES (147, 1);
INSERT INTO Seat_CarMapping VALUES (332, 3);

INSERT INTO Seat_Main VALUES (418, 15, 'ECONOMY');
INSERT INTO Seat_Main VALUES (204, 15, 'BUSINESS');
INSERT INTO Seat_Main VALUES (112, 15, 'FIRST');
INSERT INTO Seat_Main VALUES (147, 11, 'BUSINESS');
INSERT INTO Seat_Main VALUES (332, 13, 'ECONOMY1');

INSERT INTO Route VALUES (16, 'Toronto Union Station', 'Gare Centrale Montreal', TO_TIMESTAMP('10-24-2021 09:00:00', 'MM-DD-YYYY HH24:MI:SS'), 6.12, 542);
INSERT INTO Route VALUES (572, 'Gare Centrale Montreal', 'Ottawa Station', TO_TIMESTAMP('01-24-2022 13:20:00', 'MM-DD-YYYY HH24:MI:SS'), 1.93, 172);
INSERT INTO Route VALUES (89, 'Pacific Central Vancouver', 'Edmonton Station', TO_TIMESTAMP('01-24-2022 09:00:00', 'MM-DD-YYYY HH24:MI:SS'), 7.8, 837);
INSERT INTO Route VALUES (90, 'Gare Centrale Montreal', 'Toronto Union Station', TO_TIMESTAMP('02-27-2020 17:30:00', 'MM-DD-YYYY HH24:MI:SS'), 4.56, 542);
INSERT INTO Route VALUES (91, 'Toronto Union Station', 'Gare Centrale Montreal', TO_TIMESTAMP('01-24-2022 11:00:00', 'MM-DD-YYYY HH24:MI:SS'), 4.56, 542);

INSERT INTO Station VALUES ('Pacific Central Vancouver', '1150 Station St, Vancouver, BC V6A 4C7');
INSERT INTO Station VALUES ('Toronto Union Station', '55 Front St W, Toronto, ON M5J 1E6');
INSERT INTO Station VALUES ('Ottawa Station', '200 Tremblay Rd, Ottawa, ON K1G 3H5');
INSERT INTO Station VALUES ('London Station', '205 York St, London, ON N6A 1B1');
INSERT INTO Station VALUES ('Gare Centrale Montreal', '895 Rue De La Gauchetiere O, Montreal, QC H3B 4G1');

INSERT INTO Trip VALUES (418, 63, 16, 15);
INSERT INTO Trip VALUES (204, 64, 572, 15);
INSERT INTO Trip VALUES (147, 26, 89, 11);
INSERT INTO Trip VALUES (332, 117, 90, 13);
INSERT INTO Trip VALUES (112, 93, 91, 15);

INSERT INTO GoesThrough VALUES ('Ottawa Station', 16, TO_TIMESTAMP('10-24-2021 13:01:17', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('London Station', 16, TO_TIMESTAMP('10-24-2021 14:01:17', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('Gare Centrale Montreal', 16, TO_TIMESTAMP('10-24-2021 15:01:17', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('Pacific Central Vancouver', 16, TO_TIMESTAMP('10-24-2021 16:01:17', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('Toronto Union Station', 16, TO_TIMESTAMP('10-24-2021 17:01:17', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('Gare Centrale Montreal', 572, TO_TIMESTAMP('02-03-2022 16:22:28', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('London Station', 89, TO_TIMESTAMP('02-03-2022 06:39:04', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('Toronto Union Station', 90, TO_TIMESTAMP('11-03-2021 10:47:53', 'MM-DD-YYYY HH24:MI:SS'));
INSERT INTO GoesThrough VALUES ('Ottawa Station', 91, TO_TIMESTAMP('01-03-2021 10:40:07', 'MM-DD-YYYY HH24:MI:SS'));

INSERT INTO StoredAt VALUES (11, 'Toronto Union Station');
INSERT INTO StoredAt VALUES (12, 'Pacific Central Vancouver');
INSERT INTO StoredAt VALUES (13, 'Toronto Union Station');
INSERT INTO StoredAt VALUES (14, 'Gare Centrale Montreal');
INSERT INTO StoredAt VALUES (15, 'Toronto Union Station');
