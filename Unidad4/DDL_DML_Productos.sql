-- Descripción de Datos dela BD -> Productos.db
 
-- Crear la tabla Empresa (Entidad del contexto general - no hace parte del REQ)
CREATE TABLE IF NOT EXISTS Empresa(
    ID_Empresa INTEGER NOT NULL,
    Nombre VARCHAR(15) NOT NULL,
    NIT VARCHAR(11) NOT NULL,
    Fecha_Fundacion DATETIME NOT NULL,
    Antiguedad INTEGER GENERATED ALWAYS AS( datetime('2021-01-01') - Fecha_Fundacion ) --Este es un campo calculado
    PRIMARY KEY (ID_Empresa)
);

CREATE TABLE IF NOT EXISTS(
    ID_Producto INTEGER NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    ID_Empresa INTEGER NOT NULL,
    PRIMARY KEY (ID_Producto)
    FOREIGN KEY (ID_Empresa) REFERENCES Empresa(ID_Empresa)
);