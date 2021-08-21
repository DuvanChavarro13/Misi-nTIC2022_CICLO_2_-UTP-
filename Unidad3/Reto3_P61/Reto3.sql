-- Este es el reto de la Unidad 3 (Consultas SQL)

-- REQUERIMIENTOS:

-- 1). Cuales son los 10 proyectos ordenados de mayor a menor donde
-- más dinero se ha invertido en compra de materiales

SELECT  
    p.ID_Proyecto,
    p.Clasificacion,
    SUM(c.Cantidad * mc.Precio_Unidad) AS Gasto_Compras,
    p.Serial
FROM Proyecto AS p
INNER JOIN Compra AS c
    ON p.ID_Proyecto = c.ID_Proyecto
INNER JOIN MaterialConstruccion AS mc
    ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion
GROUP BY p.ID_Proyecto
ORDER BY Gasto_Compras DESC
LIMIT 10;


--2). Listado de los lideres que no son ni clasificación 2 ni
-- clasificacion 5. Ordenados de menor a mayor según el identificador
-- del lider del proyecto.  

-- FORMA PREFERIDA ----------------------------------------
SELECT 
    l.ID_Lider,
    l.Nombre,
    l.Primer_Apellido,
    l.Clasificacion
FROM Lider AS l
WHERE NOT l.clasificacion = 2 AND NOT l.clasificacion = 5
ORDER BY 
    l.clasificacion DESC,
    l.ID_Lider ASC;

---- (De otra forma) ---
SELECT 
    l.ID_Lider,
    l.Nombre,
    l.Primer_Apellido,
    l.Clasificacion
FROM Lider AS l
WHERE l.Clasificacion != 2 AND l.Clasificacion != 5
ORDER BY 
    l.clasificacion DESC,
    l.ID_Lider ASC;

-- (De otra forma mas)
SELECT 
    l.ID_Lider,
    l.Nombre,
    l.Primer_Apellido,
    l.Clasificacion
FROM Lider AS l
WHERE l.Clasificacion NOT IN (2,5)
ORDER BY 
    l.clasificacion DESC,
    l.ID_Lider ASC;


--3). Bancos ordenados de mayor a menor según el área de 
-- construcción promedio de los proyectos que respaldan. 

-- Banco_Vinculado ; Area_Promedio
SELECT 
    p.Banco_Vinculado,
    AVG(t.Area_Max) AS Area_Promedio
FROM Proyecto AS p 
INNER JOIN Tipo AS t 
    ON p.ID_Tipo = t.ID_Tipo
GROUP BY p.Banco_Vinculado
ORDER BY Area_Promedio DESC;

--4). Ranking de las constructoras que tienen el mayor numero 
-- de proyectos a cargo. 

-- Constructora ; Numero_Proyectos
SELECT
    p.Constructora,
    COUNT(p.ID_Proyecto) AS Numero_Proyectos
FROM Proyecto AS p 
GROUP BY p.Constructora 
ORDER BY Numero_Proyectos DESC;


--5). Los materiales importados mas comprados en los proyectos, 
-- mostrando cuantas compras se han hecho de cada uno. 
-- Desempatar alfabéticamente.

-- Nombre_Material ; Importado ; No_Compras

SELECT 
    mc.Nombre_Material,
    mc.Importado,
    COUNT(mc.ID_MaterialConstruccion * c.Cantidad) AS No_Compras
FROM MaterialConstruccion AS mc
INNER JOIN Compra AS c
    ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion
WHERE mc.Importado IN ('si', 'Si')
GROUP BY mc.Nombre_Material
ORDER BY 
    No_Compras DESC,
    mc.Nombre_Material ASC;


-- De otra forma

SELECT 
    mc.Nombre_Material,
    mc.Importado,
    COUNT(c.ID_Compra) AS No_Compras
FROM MaterialConstruccion AS mc
INNER JOIN Compra AS c
    ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion
WHERE mc.Importado LIKE 'si'
GROUP BY mc.Nombre_Material
ORDER BY 
    No_Compras DESC,
    mc.Nombre_Material ASC;