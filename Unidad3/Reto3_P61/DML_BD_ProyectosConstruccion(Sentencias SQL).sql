-- Conceptos SQL -> DML (Consultas)
-- ------------------------------
-- Manipulación de cadenas.*
-- Expresiones aritméticas en las consultas.*
-- Funciones de agregación.*
-- Relacionamiento de tablas (JOIN).*
-- Renombramiento de las tablas.*
-- Agrupamientos y agregación tablas.*
-- Desempates de ordenamiento.*
-- Diferencia entre HAVING y WHERE (IN).*
-- Comparaciones de cadenas con LIKE (Expresiones Regulares).*


-- Requerimiento -> Generar los corresos electronicos (2 variantes)
-- LENGTH 

--> Generar los correos electrónicos de los funcionarios de la 
-- empresa administradora de proyectos. Estos correos deben quedar
-- ordenados de mayor a menor según la longitud de estos y deben
-- tener la siguiente estructura:
-- 1) Primera letra en minúscula del nombre
-- 2) Punto
-- 3) Segundo apellido en minúscula (variación 2)
-- 4) Concatenar el ID del líder
-- 5) El dominio de la empresa: @constr.com.co
-- La tabla debe tener como encabezado: Email_Funcionarios 


-- ---------------------------------------------------------
-- -------------------------------------- MANIPULACION DE CADENAS --------------------------------------------------
-- CONSULTA UTILIZANDO CONECTORES PARA UN SOLO CAMPO

-- Funcion SUBSTRING(string, punto de partida, posiciones)
SELECT LOWER(SUBSTRING(l.Nombre, 1, 1)) || "." || LOWER(l.Segundo_Apellido) || l.ID_Lider || "@consr.com.co" AS Email_Funcionarios,
	   l.Nombre AS Nombre,
	   l.Segundo_Apellido AS SegundoApellido,
	   l.ID_Lider AS ID 
FROM Lider AS l
ORDER BY LENGTH(Email_Funcionarios) DESC;
-- ---------------
SELECT LOWER(SUBSTRING(l.Nombre, 1, 1)) || "." || LOWER(l.Segundo_Apellido) || l.ID_Lider || "@consr.com.co" AS Email_Funcionarios,
FROM Lider AS l
ORDER BY LENGTH(Email_Funcionarios) DESC;

-- Variacion 2 Con laas ultimas 4 letras del apellido
SELECT LOWER(SUBSTRING(l.Nombre, 1, 1)) || "." || LOWER(SUBSTRING(l.Segundo_Apellido, LENGTH(l.Segundo_Apellido)-3, 4))  || l.ID_Lider || "@consr.com.co" AS Email_Funcionarios,
	   l.Nombre AS Nombre,
	   l.Segundo_Apellido AS SegundoApellido,
	   l.ID_Lider AS ID 
FROM Lider AS l
ORDER BY LENGTH(Email_Funcionarios) DESC;

-- --------------------------------------- EXPRESIONES ARTIMÉTICAS (Agregación)-------------------------------------------------------
-- SUM() Suma
-- AVG() Promedio
-- MAX() Maximo
-- MIN() Minimo
-- COUNT() Contar 
-- Obetener la edad promedio de los lideres y redondear (Tenga en cuenta que el campo edad no existe acá, pero si se tiene la fecha de nacimiento)
SELECT 
	l.ID_Lider AS ID,
	l.Nombre AS Nombre,
	DATETIME('now') - l.Fecha_Nacimiento as Edad,
	l.Salario * 0.19 AS Impuestos
FROM Lider AS l;

-- Combinar edadesy obtener el promedio
-- Agregacion -> 1 solo valor 
SELECT 
	ROUND(AVG(DATETIME('now') - l.Fecha_Nacimiento)) AS Edad_Promedio
FROM Lider AS l;

-- Propuespa para sacar la diferencia de edad completa del usuario:
SELECT  strftime('%Y', 'now') - strftime('%Y', l.Fecha_Nacimiento ) as Year,
		strftime('%m', 'now') - strftime('%m', l.Fecha_Nacimiento ) as Month,
		strftime('%d', 'now') - strftime('%d', l.Fecha_Nacimiento ) as Day,
		l.Fecha_Nacimiento		
FROM Lider l;

-- -------------------------------------- RELACION DE TABLAS (JOIN) -------------------------------------------------------

SELECT 
	* 
FROM Proyecto AS p 
INNER JOIN Tipo AS t 
ON p.ID_Tipo = t.ID_Tipo;

-- --------------------------
SELECT 
	p.ID_Proyecto,
	p.Clasificacion,
	p.Banco_Vinculado,
	t.Area_Max,
	t.Estrato,
	t.Financiable 
FROM Proyecto AS p 
INNER JOIN Tipo AS t 
ON p.ID_Tipo = t.ID_Tipo;

-- Ampliación con con Tipo y Lider
SELECT 
	l.ID_Lider, 
	l.Nombre, 
	l.Documento_Identidad,
	l.Cargo,
	p.ID_Proyecto,
	p.Clasificacion,
	p.Banco_Vinculado,
	t.Area_Max,
	t.Estrato,
	t.Financiable 
FROM Proyecto AS p 
INNER JOIN Tipo AS t 
	ON p.ID_Tipo = t.ID_Tipo
INNER JOIN Lider AS l
	ON p.ID_Lider = l.ID_Lider
ORDER BY l.ID_Lider;


-- Saber cuantos proyectos tiene cada lider
SELECT 
	l.ID_Lider, 
	l.Nombre, 
	l.Cargo,
	COUNT(*) AS Numero_Proyectos
FROM Proyecto AS p 
INNER JOIN Lider AS l
	ON p.ID_Lider = l.ID_Lider
GROUP BY l.ID_Lider 
ORDER BY Numero_Proyectos DESC;

-- --------------------------------------- DESEMPATES POR ORDENAMIENTO ------------------------------

SELECT 
	l.ID_Lider, 
	l.Nombre, 
	l.Cargo,
	COUNT(*) AS Numero_Proyectos
FROM Proyecto AS p 
INNER JOIN Lider AS l
	ON p.ID_Lider = l.ID_Lider
GROUP BY l.ID_Lider 
ORDER BY Numero_Proyectos DESC, 
	     l.Cargo ASC,
		 l.Nombre ASC,
		 l.ID_Lider ASC
LIMIT 15;


-- -------------------------------------- DIFERENCIA ENTRE HAVING Y WHERE -------------------------------------------

-- El requerimiento anterior pero solamente para los lideres que son coordinadores y gerentes 
-- y que manejen entre 7 y 11 proyectos. 

--Requerimiento a) 
SELECT 
	l.ID_Lider, 
	l.Nombre, 
	l.Cargo,
	COUNT(*) AS Numero_Proyectos
FROM Proyecto AS p 
INNER JOIN Lider AS l
	ON p.ID_Lider = l.ID_Lider
WHERE l.Cargo IN ('Coordinador', 'Gerente') -- Acá se están usando conjuntos
GROUP BY l.ID_Lider 
ORDER BY l.Cargo ASC;

-- Requerimiento b)
-- El Having es como un where pero para filtrar los campos que fueron calculados (Es decir, en tiempo de ejecución o en RAM)
SELECT 
	l.ID_Lider, 
	l.Nombre, 
	l.Cargo,
	COUNT(*) AS Numero_Proyectos
FROM Proyecto AS p 
INNER JOIN Lider AS l
	ON p.ID_Lider = l.ID_Lider
WHERE l.Cargo IN ('Coordinador', 'Gerente') -- Acá se están usando conjuntos
GROUP BY l.ID_Lider 
HAVING Numero_Proyectos BETWEEN 7 AND 11
ORDER BY 
	l.Cargo DESC,
	Numero_Proyectos DESC;
	
	
-- ---------- COMPARACION CON LA INSTRUCCION LIKE -----------------

-- RQ: Proyectos con el serial terminando en BP (Banco Principal)

SELECT 
	p.ID_Proyecto,
	p.Clasificacion,
	p.Serial 
FROM Proyecto AS p 
WHERE p.Serial LIKE '%BP';
		
-- -------------------------
SELECT 
	p.ID_Proyecto,
	p.Clasificacion,
	p.Serial 
FROM Proyecto AS p 
WHERE p.Serial LIKE 'c%';

-- -------------------
SELECT 
	p.ID_Proyecto,
	p.Clasificacion,
	p.Serial 
FROM Proyecto AS p 
WHERE p.Serial LIKE '%l%';

-- RQ: Proyectos realizados en el año 2020 de estrato 3 

-- y que tengan menos de 50mt2
SELECT 
	p.ID_Proyecto,
	p.Clasificacion,
	p.Fecha_Inicio,
	t.Estrato,
	t.Area_Max
FROM Proyecto AS p 
INNER JOIN Tipo AS t
	ON p.ID_Tipo = t.ID_Tipo 
WHERE strftime('%Y', p.Fecha_Inicio) = '2020' 
	AND t.Estrato <= 3 
	AND t.Area_Max <= 350;
	
-- y que estén en ciudadades diferentes a Bogota y Pereira.

SELECT 
	p.ID_Proyecto,
	p.Clasificacion,
	p.Fecha_Inicio,
	p.Ciudad, 
	t.Estrato,
	t.Area_Max
FROM Proyecto AS p 
INNER JOIN Tipo AS t
	ON p.ID_Tipo = t.ID_Tipo 
WHERE strftime('%Y', p.Fecha_Inicio) = '2020' 
	AND t.Estrato <= 3
	AND p.Ciudad NOT IN ('Bogota', 'Pereira')
ORDER BY p.Ciudad DESC;






















