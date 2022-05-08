-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2022 a las 19:48:24
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdimprenta`
--
CREATE DATABASE IF NOT EXISTS `bdimprenta` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdimprenta`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nombre`, `apellidos`) VALUES
(1, 'Sergio', 'Tuero González'),
(2, 'Borja', 'Chacon Alvarez'),
(3, 'Roman', 'Garcia Santos'),
(4, 'Hugo', 'Aradas Martínez'),
(5, 'Alvaro', 'Benito Saez'),
(6, 'Maria', 'Gonzalez Gonzalez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
CREATE TABLE IF NOT EXISTS `departamentos` (
  `idDep` char(1) NOT NULL,
  PRIMARY KEY (`idDep`),
  UNIQUE KEY `idDep` (`idDep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`idDep`) VALUES
('A'),
('B'),
('C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `labores`
--

DROP TABLE IF EXISTS `labores`;
CREATE TABLE IF NOT EXISTS `labores` (
  `idLab` int(11) NOT NULL,
  `fechaReal` date NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `idMaquina` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idLab`),
  KEY `FKMAQ` (`idMaquina`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `labores`
--

INSERT INTO `labores` (`idLab`, `fechaReal`, `descripcion`, `idMaquina`, `idOperario`) VALUES
(1, '2017-03-14', NULL, 1, 5),
(2, '2016-02-04', NULL, 2, 6),
(3, '2012-03-11', NULL, 3, 5),
(4, '2019-06-24', NULL, 4, 6),
(5, '2016-01-13', NULL, 5, 5),
(6, '2015-03-25', NULL, 6, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

DROP TABLE IF EXISTS `libros`;
CREATE TABLE IF NOT EXISTS `libros` (
  `idLibro` int(11) NOT NULL,
  `colorTapa` varchar(50) NOT NULL,
  `numCopiasLibro` int(11) NOT NULL,
  `idTrabajo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idTrabajo`),
  KEY `FKTRAB` (`idTrabajo`),
  KEY `FKCLI` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`idLibro`, `colorTapa`, `numCopiasLibro`, `idTrabajo`, `idCliente`) VALUES
(1, 'Rojo', 35, 5, 5),
(2, 'Azul', 10, 6, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lotes`
--

DROP TABLE IF EXISTS `lotes`;
CREATE TABLE IF NOT EXISTS `lotes` (
  `idLote` int(11) NOT NULL AUTO_INCREMENT,
  `nombreLote` varchar(50) DEFAULT NULL,
  `idDep` char(11) NOT NULL,
  PRIMARY KEY (`idLote`),
  KEY `FKDEP` (`idDep`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lotes`
--

INSERT INTO `lotes` (`idLote`, `nombreLote`, `idDep`) VALUES
(1, 'lote maquinas 1', 'A'),
(2, 'lote maquinas 2', 'B'),
(3, 'lote maquinas 3', 'C'),
(4, 'lote maquinas 4', 'A'),
(5, 'lote maquinas 5', 'B'),
(6, 'lote maquinas 6', 'C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquinas`
--

DROP TABLE IF EXISTS `maquinas`;
CREATE TABLE IF NOT EXISTS `maquinas` (
  `idMaquina` int(11) NOT NULL,
  `fechaCompra` date NOT NULL,
  `ubicacion` varchar(50) DEFAULT NULL,
  `tipoImpresion` varchar(50) DEFAULT NULL,
  `modoImpresion` varchar(50) DEFAULT NULL,
  `volumenTinta` float NOT NULL,
  `idLote` int(11) NOT NULL,
  PRIMARY KEY (`idMaquina`),
  KEY `FKLOTE` (`idLote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `maquinas`
--

INSERT INTO `maquinas` (`idMaquina`, `fechaCompra`, `ubicacion`, `tipoImpresion`, `modoImpresion`, `volumenTinta`, `idLote`) VALUES
(1, '2017-09-10', 'sotano', 'serigrafia', 'digital', 10, 1),
(2, '2011-12-12', 'sotano', 'relieve', 'digital', 10, 2),
(3, '2017-10-17', 'planta 1', 'serigrafia', 'digital', 10, 3),
(4, '2012-01-17', 'planta 1', 'serigrafia', 'digital', 15, 4),
(5, '2018-08-24', 'planta 2', 'relieve', 'laser', 15, 5),
(6, '2022-02-24', 'planta 2', 'relieve', 'laser', 15, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operarios`
--

DROP TABLE IF EXISTS `operarios`;
CREATE TABLE IF NOT EXISTS `operarios` (
  `idOperario` int(11) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `num_telefono` varchar(15) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `senior` tinyint(1) NOT NULL,
  `idDep` char(11) NOT NULL,
  PRIMARY KEY (`idOperario`),
  KEY `FKDEP` (`idDep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `operarios`
--

INSERT INTO `operarios` (`idOperario`, `nif`, `nombre`, `apellidos`, `num_telefono`, `direccion`, `senior`, `idDep`) VALUES
(1, '99960093T', 'DIEGO', 'PEÑA APARICIO', '737666864', 'ib3p83ingi@post.com', 1, 'A'),
(2, '08464260F', 'CANDIDO', 'MENA PARDO', '741496057', 'pxcvkc2v@yahoo.es', 0, 'A'),
(3, '65303457V', 'Moises', 'Valdes Luque', '664743807', 'fk7ta32u@lycos.co.uk', 0, 'B'),
(4, '17433419V', 'SILVIA', 'VELASCO PELAEZ', '678933812', 'i50x49tj69@yahoo.es', 0, 'B'),
(5, '58851994P', 'BARBARA', 'SOLA ROIG', '708014221', 'xz336ian@writeme.com', 1, 'C'),
(6, '45917129K', 'ANDER', 'ESTEVE CARMONA', '710685178', 'zrnwbnb5@journalism.com', 1, 'C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opscalidad`
--

DROP TABLE IF EXISTS `opscalidad`;
CREATE TABLE IF NOT EXISTS `opscalidad` (
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idOperario`),
  KEY `FKLOTE` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opscalidad`
--

INSERT INTO `opscalidad` (`idOperario`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opsimpresion`
--

DROP TABLE IF EXISTS `opsimpresion`;
CREATE TABLE IF NOT EXISTS `opsimpresion` (
  `idOperario` int(11) NOT NULL,
  `idmod` int(11) NOT NULL,
  PRIMARY KEY (`idOperario`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opsimpresion`
--

INSERT INTO `opsimpresion` (`idOperario`, `idmod`) VALUES
(3, 1),
(4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opsmaquina`
--

DROP TABLE IF EXISTS `opsmaquina`;
CREATE TABLE IF NOT EXISTS `opsmaquina` (
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idOperario`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opsmaquina`
--

INSERT INTO `opsmaquina` (`idOperario`) VALUES
(5),
(6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `politicas`
--

DROP TABLE IF EXISTS `politicas`;
CREATE TABLE IF NOT EXISTS `politicas` (
  `idPolitica` int(11) NOT NULL,
  `nombrePolitica` varchar(50) DEFAULT NULL,
  `fechaVig` date NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `idRegla` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idPolitica`),
  KEY `FKREG` (`idRegla`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `politicas`
--

INSERT INTO `politicas` (`idPolitica`, `nombrePolitica`, `fechaVig`, `descripcion`, `idRegla`, `idOperario`) VALUES
(1, 'Politica 1', '2018-12-12', 'Política de calidad de los engranajes de las máquinas', 1, 1),
(2, 'Politica 2', '2020-12-17', 'Política de calidad en el tanque de tinta', 2, 2),
(3, 'Politica 3', '2021-11-14', 'Politica de calidad en las conexiones entre máquina y ordenador', 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `posters`
--

DROP TABLE IF EXISTS `posters`;
CREATE TABLE IF NOT EXISTS `posters` (
  `idPoster` int(11) NOT NULL,
  `ancho` float NOT NULL,
  `alto` float NOT NULL,
  `numCopiasPoster` int(11) NOT NULL,
  `idTrabajo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idTrabajo`),
  KEY `FKTRAB` (`idTrabajo`),
  KEY `FKCLI` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `posters`
--

INSERT INTO `posters` (`idPoster`, `ancho`, `alto`, `numCopiasPoster`, `idTrabajo`, `idCliente`) VALUES
(1, 20, 20, 250, 3, 3),
(2, 15.5, 15.5, 200, 4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pruebas`
--

DROP TABLE IF EXISTS `pruebas`;
CREATE TABLE IF NOT EXISTS `pruebas` (
  `idPrueba` int(11) NOT NULL,
  `explicacion` varchar(200) DEFAULT NULL,
  `resultado` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `idMaquina` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idPrueba`),
  KEY `FKMAQ` (`idMaquina`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pruebas`
--

INSERT INTO `pruebas` (`idPrueba`, `explicacion`, `resultado`, `fecha`, `idMaquina`, `idOperario`) VALUES
(1, 'Comprobación de los engranajes', 'Prueba sin ningún problema', '2015-05-06', 1, 2),
(2, 'Comprobación de los engranajes', 'Prueba sin ningún problema', '2017-05-24', 2, 1),
(3, 'Prueba en el tanque de tinta', 'Prueba sin ningún problema', '2019-05-14', 3, 2),
(4, 'Prueba en la conexión con el ordenador', 'Prueba sin ningún problema', '2021-05-03', 4, 1),
(5, 'Prueba en la conexión con el ordenador', 'Conexión fallida', '2020-08-05', 5, 2),
(6, 'Prueba en el tanque de tinta', 'Pérdidas de tinta', '2021-10-19', 6, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reglas`
--

DROP TABLE IF EXISTS `reglas`;
CREATE TABLE IF NOT EXISTS `reglas` (
  `idRegla` int(11) NOT NULL,
  `nombreRegla` varchar(50) DEFAULT NULL,
  `idPrueba` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idRegla`),
  KEY `FKPRU` (`idPrueba`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reglas`
--

INSERT INTO `reglas` (`idRegla`, `nombreRegla`, `idPrueba`, `idOperario`) VALUES
(1, 'Volumen de tinta', 3, 2),
(2, 'Conexion', 2, 1),
(3, 'Engranajes', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rotulos`
--

DROP TABLE IF EXISTS `rotulos`;
CREATE TABLE IF NOT EXISTS `rotulos` (
  `idRotulo` int(11) NOT NULL,
  `centroComercial` varchar(50) NOT NULL,
  `idTrabajo` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idTrabajo`),
  KEY `FKTRAB` (`idTrabajo`),
  KEY `FKCLI` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rotulos`
--

INSERT INTO `rotulos` (`idRotulo`, `centroComercial`, `idTrabajo`, `idCliente`) VALUES
(1, 'Parque Principado', 1, 1),
(1, 'Los Fresnos', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajos`
--

DROP TABLE IF EXISTS `trabajos`;
CREATE TABLE IF NOT EXISTS `trabajos` (
  `idTrabajo` int(11) NOT NULL,
  `fechaSolicitud` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `tipoRelieve` varchar(200) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idMaquina` int(11) NOT NULL,
  PRIMARY KEY (`idTrabajo`),
  KEY `FKCLI` (`idCliente`),
  KEY `FKMAQ` (`idMaquina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `trabajos`
--

INSERT INTO `trabajos` (`idTrabajo`, `fechaSolicitud`, `fechaEntrega`, `tipoRelieve`, `idCliente`, `idMaquina`) VALUES
(1, '2015-12-08', '2015-12-10', 'Sin relieve', 6, 1),
(2, '2016-01-13', '2016-01-17', 'Sin relieve', 5, 2),
(3, '2016-02-13', '2016-02-16', 'Sin relieve', 4, 3),
(4, '2017-02-13', '2017-02-15', 'Sin relieve', 3, 4),
(5, '2017-05-18', '2017-05-21', 'Sin relieve', 2, 5),
(6, '2017-08-13', '2017-08-15', 'Sin relieve', 1, 6);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
