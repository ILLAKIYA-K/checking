

CREATE TABLE if not exists Country(
countryId   INT Primary Key AUTO_INCREMENT, 
 countryName    VARCHAR(255),                
  currency      VARCHAR(255),                 
 population     INT ,               
  latitude      VARCHAR(255),                 
  longitude     VARCHAR(255) );


  CREATE TABLE if not exists City(
    cityId    INT Primary Key AUTO_INCREMENT, 
  cityName    VARCHAR(255),           
 population   INT,               
  latitude    VARCHAR(255),           
 longitude    VARCHAR(255) ,
 countryId  INT,
 FOREIGN KEY (countryId) REFERENCES Country(countryId)       
 
);