CREATE DATABASE IF NOT EXISTS coderhouse;

USE coderhouse;

CREATE TABLE persona(
	nombre varchar(20),
    apellido varchar(20)
);

SELECT * FROsM persona;

INSERT INTO persona values
	("Alejandro" , "Di Stefano"),
    ("Alejandro", "Perez"),
    ("Alejandro", "Di Stefano");
    
# Ahora alteramos la tabla para agregar un ID.
ALTER TABLE persona ADD COLUMN id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY;

# Utilizamos SELECT
SELECT * FROM persona WHERE id = 1;

# Ahora alteramos la tabla para agregar una columna "DNI", que permite nulos.
ALTER TABLE persona ADD COLUMN dni INTEGER NULL;

# Ahora modificamos una fila existente en la tabla
UPDATE persona SET dni = 20222222 WHERE id = 1;
UPDATE persona SET dni = 20222223 WHERE id = 2;
UPDATE persona SET dni = 20222224 WHERE id = 3;

SELECT * FROM persona WHERE dni = 20222223;

DROP TABLE persona;
