CREATE TABLE pets (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  eircode VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
  animal_type VARCHAR(255) NOT NULL,
  breed VARCHAR(255) NOT NULL,
  age INT NOT NULL
);
-- household
CREATE TABLE household (
                           eircode VARCHAR(8) PRIMARY KEY,
                           number_of_occupants INT NOT NULL,
                           max_number_of_occupants INT NOT NULL,
                           owner_occupied BIT NOT NULL
);

CREATE TABLE myusers(
    email VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    county VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    account_non_expired BOOLEAN DEFAULT TRUE,
    credentials_non_expired BOOLEAN DEFAULT TRUE,
    account_non_locked BOOLEAN DEFAULT TRUE
   );