-- Creación de la tabla "CategoriaDeProducto"
CREATE TABLE InventoX.CategoriaDeProducto (
    ID INT PRIMARY KEY,
    NombreCategoria VARCHAR(255) NOT NULL
);

-- Creación de la tabla "MarcaDeProducto"
CREATE TABLE InventoX.MarcaDeProducto (
    ID INT PRIMARY KEY,
    NombreMarca VARCHAR(255) NOT NULL
);

-- Creación de la tabla "Producto"
CREATE TABLE InventoX.Producto (
    ID INT PRIMARY KEY,
    NombreProducto VARCHAR(255) NOT NULL,
    DescripcionProducto TEXT,
    CodigoDeBarras VARCHAR(50) UNIQUE,
    CodigoNumerico VARCHAR(50) UNIQUE,
    PrecioCompra DECIMAL(10, 2) NOT NULL,
    PrecioVenta DECIMAL(10, 2) NOT NULL,
    FechaDeEntrada DATE NOT NULL,
    FechaDeSalida DATE,
    CategoriaID INT,
    MarcaID INT,
    FOREIGN KEY (CategoriaID) REFERENCES CategoriaDeProducto(ID),
    FOREIGN KEY (MarcaID) REFERENCES MarcaDeProducto(ID)
);

-- Creación de la tabla "Stock"
CREATE TABLE InventoX.Stock (
    ID INT PRIMARY KEY,
    ProductoID INT,
    CantidadEnStock INT NOT NULL,
    FechaDeRegistro DATE NOT NULL,
    FOREIGN KEY (ProductoID) REFERENCES Producto(ID)
);

-- Creación de la tabla "Usuario"
CREATE TABLE InventoX.Usuario (
    ID INT PRIMARY KEY,
    NombreDeUsuario VARCHAR(50) NOT NULL,
    Contrasena VARCHAR(255) NOT NULL, -- Debe ser almacenada de forma segura (como hash)
    Rol ENUM('administrador', 'vendedor', 'lector') NOT NULL
);
