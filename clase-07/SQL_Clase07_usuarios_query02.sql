CREATE DATABASE IF NOT EXISTS coderhouse;
USE coderhouse;

CREATE TABLE IF NOT EXISTS usuarios (
   id INT PRIMARY KEY AUTO_INCREMENT,
   usuario VARCHAR(20),
   nombre VARCHAR(20),
   sexo VARCHAR(1),
   nivel TINYINT,
   email VARCHAR(50),
   telefono VARCHAR(20),
   marca VARCHAR(20),
   compania VARCHAR(20),
   saldo FLOAT,
   activo BOOLEAN
);

INSERT INTO usuarios VALUES 
	('1','BRE2271','BRENDA','M','2','brenda@live.com','655-330-5736','SAMSUNG','IUSACELL','100','1'),
	('2','OSC4677','OSCAR','H','3','oscar@gmail.com','655-143-4181','LG','TELCEL','0','1'),
	('3','JOS7086','JOSE','H','3','francisco@gmail.com','655-143-3922','NOKIA','MOVISTAR','150','1'),
	('4','LUI6115','LUIS','H','0','enrique@outlook.com','655-137-1279','SAMSUNG','TELCEL','50','1'),
	('5','LUI7072','LUIS','H','1','luis@hotmail.com','655-100-8260','NOKIA','IUSACELL','50','0'),
	('6','DAN2832','DANIEL','H','0','daniel@outlook.com','655-145-2586','SONY','UNEFON','100','1'),
	('7','JAQ5351','JAQUELINE','M','0','jaqueline@outlook.com','655-330-5514','BLACKBERRY','AXEL','0','1'),
	('8','ROM6520','ROMAN','H','2','roman@gmail.com','655-330-3263','LG','IUSACELL','50','1'),
	('9','BLA9739','BLAS','H','0','blas@hotmail.com','655-330-3871','LG','UNEFON','100','1'),
	('10','JES4752','JESSICA','M','1','jessica@hotmail.com','655-143-6861','SAMSUNG','TELCEL','500','1'),
	('11','DIA6570','DIANA','M','1','diana@live.com','655-143-3952','SONY','UNEFON','100','0'),
	('12','RIC8283','RICARDO','H','2','ricardo@hotmail.com','655-145-6049','MOTOROLA','IUSACELL','150','1'),
	('13','VAL6882','VALENTINA','M','0','valentina@live.com','655-137-4253','BLACKBERRY','AT&T','50','0'),
	('14','BRE8106','BRENDA','M','3','brenda2@gmail.com','655-100-1351','MOTOROLA','NEXTEL','150','1'),
	('15','LUC4982','LUCIA','M','3','lucia@gmail.com','655-145-4992','BLACKBERRY','IUSACELL','0','1'),
	('16','JUA2337','JUAN','H','0','juan@outlook.com','655-100-6517','SAMSUNG','AXEL','0','0'),
	('17','ELP2984','ELPIDIO','H','1','elpidio@outlook.com','655-145-9938','MOTOROLA','MOVISTAR','500','1'),
	('18','JES9640','JESSICA','M','3','jessica2@live.com','655-330-5143','SONY','IUSACELL','200','1'),
	('19','LET4015','LETICIA','M','2','leticia@yahoo.com','655-143-4019','BLACKBERRY','UNEFON','100','1'),
	('20','LUI1076','LUIS','H','3','luis2@live.com','655-100-5085','SONY','UNEFON','150','1'),
	('21','HUG5441','HUGO','H','2','hugo@live.com','655-137-3935','MOTOROLA','AT&T','500','1');
    
    # Seleccionamos únicamente las columnas nombre y usuario de esta tabla
    SELECT nombre FROM usuarios;
    
    # 2.- Calcular el saldo máximo de los usuarios de sexo “Mujer”
	SELECT MAX(saldo) FROM usuarios WHERE sexo = "M";
    # 3.- Listar nombre y teléfono de los usuarios con teléfono NOKIA, BLACKBERRY o SONY
	SELECT nombre, telefono, marca FROM usuarios WHERE marca like "NOKIA" OR marca like "BLACKBERRY" OR marca like "SONY";
    # Otra forma, utilizando IN
    SELECT nombre, telefono, marca FROM usuarios WHERE marca IN("NOKIA", "BLACKBERRY", "SONY");
    
    # 4.- Contar los usuarios sin saldo o inactivos
	SELECT COUNT(*) FROM usuarios WHERE saldo = 0 OR activo = false;
    # Otra forma, pero utilizando NOT
    SELECT COUNT(*) FROM usuarios WHERE saldo = 0 OR NOT activo;
    
    # 5.- Listar el login de los usuarios con nivel 1, 2 o 3
	SELECT usuario, nivel FROM usuarios WHERE nivel in (1, 2, 3) ORDER BY nivel ASC;
    
    # 6. Listar los números de teléfono con saldo menor o igual a 300
	SELECT telefono, saldo FROM usuarios WHERE saldo <= 300 ORDER BY saldo DESC;
    
    # 7.- Calcular la suma de los saldos de los usuarios de la compañía telefónica NEXTEL
	SELECT SUM(saldo) AS Suma_Saldos FROM usuarios WHERE compañia = "NEXTEL";
    # Ahora de la compañía TELCEL
    	SELECT SUM(saldo) AS Suma_Saldos FROM usuarios WHERE compania = "TELCEL";

    # 8.- Contar el número de usuarios por compañía telefónica
	SELECT COUNT(*) AS Usuarios_x_Comp, compania FROM usuarios GROUP BY compania ORDER BY compania;
    
    # 9.- Contar el número de usuarios por nivel
	SELECT COUNT(*) AS Usuarios_x_nivel, nivel FROM usuarios GROUP BY nivel ORDER BY nivel;
    
    # 10.- Listar el login de los usuarios con nivel 2
	SELECT usuario, nivel FROM usuarios WHERE nivel = 2;

	# 11.- Mostrar el email de los usuarios que usan gmail
	SELECT email FROM usuarios WHERE email LIKE "%@gmail.com";
 
	# 12.- Listar nombre y teléfono de los usuarios con teléfono LG, SAMSUNG o MOTOROLA
	SELECT nombre, telefono, marca FROM usuarios WHERE marca in ("LG", "SAMSUNG", "MOTOROLA") ORDER BY marca;

	# PARTE 2 DE LA CLASE - UTILIZAREMOS CLAVES FORÁNEAS PARA UNIR DOS TABLAS (USUARIOS) Y (MARCA)
    SELECT marca FROM usuarios GROUP BY marca ORDER BY 1;
    # Unimos el CREATE TABLE con la selección anterior
    CREATE TABLE IF NOT EXISTS marcas (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY) SELECT marca FROM usuarios GROUP BY marca ORDER BY 1;
    
    # Comprobamos que funcionó al listar los valores de MARCA
    SELECT * FROM marcas;
    
    # Modificamos la tabla de usuarios original para agregar una columna con el ID de la tabla marcas
    ALTER TABLE usuarios ADD COLUMN id_marca INT NOT NULL; 
    SET SQL_SAFE_UPDATES = 0;
    UPDATE usuarios SET id_marca = 1 WHERE marca = "BLACKBERRY";
    UPDATE usuarios SET id_marca = 2 WHERE marca = "LG";
    UPDATE usuarios SET id_marca = 3 WHERE marca = "MOTOROLA";
    UPDATE usuarios SET id_marca = 4 WHERE marca = "NOKIA";
    UPDATE usuarios SET id_marca = 5 WHERE marca = "SAMSUNG";
    UPDATE usuarios SET id_marca = 6 WHERE marca = "SONY";
    
    # Alteramos la bd de usuarios para hacer referencia foránea a la marca(id)
    ALTER TABLE usuarios ADD FOREIGN KEY (id_marca) REFERENCES marcas(id);
        
    # Eliminamos la columna marca original
    ALTER TABLE usuarios DROP COLUMN marca;
    
    # Ahora unimos ambas tablas (sin utilizar un JOIN)
    SELECT U.nombre, U.telefono, M.marca FROM usuarios U, marcas M WHERE M.marca NOT IN("LG", "SAMSUNG");
    # Misma tarea, utilizando un JOIN
    SELECT U.nombre, U.telefono, M.marca 
	FROM usuarios U
	JOIN marcas M ON U.marca_id = M.id 
	WHERE M.marca NOT IN ('LG', 'SAMSUNG');
    
    # Creamos una nueva tabla: Compania
    SELECT compania FROM usuarios GROUP BY compania ORDER BY 1;
    CREATE TABLE companias (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY) SELECT compania FROM usuarios GROUP BY compania ORDER BY 1;
	ALTER TABLE usuarios ADD COLUMN id_compania INT NOT NULL;
    
    # Actualizamos los valores Varchar a numéricos (un id)
    SET SQL_SAFE_UPDATES = 0;
	ALTER TABLE usuarios ADD FOREIGN KEY (id_compania) REFERENCES companias(id);

    UPDATE usuarios SET id_compania = 1 WHERE compania = 'AT&T';
	UPDATE usuarios SET id_compania = 2 WHERE compania = 'AXEL';
	UPDATE usuarios SET id_compania = 3 WHERE compania = 'IUSACELL';
	UPDATE usuarios SET id_compania = 4 WHERE compania = 'MOVISTAR';
	UPDATE usuarios SET id_compania = 5 WHERE compania = 'NEXTEL';
	UPDATE usuarios SET id_compania = 6 WHERE compania = 'TELCEL';
	UPDATE usuarios SET id_compania = 7 WHERE compania = 'UNEFON';
    
	ALTER TABLE usuarios DROP COLUMN compania;
    
	# Comprobemos el efecto de los cambios: 
	SELECT * FROM usuarios;

    