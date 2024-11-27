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