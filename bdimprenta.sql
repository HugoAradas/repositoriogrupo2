-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-05-2022 a las 15:54:31
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

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
USE `bdfederacion`;

DELIMITER $$

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50),
  `apellidos` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`)	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Estructura de tabla para la tabla `lotes`
--

DROP TABLE IF EXISTS `lotes`;
CREATE TABLE IF NOT EXISTS `lotes` (
  `idLote` int(11) NOT NULL AUTO_INCREMENT,
  `nombreLote` varchar(50),
  `idDep` int(11) NOT NULL,
  PRIMARY KEY (`idLote`),
  KEY `FKDEP` (`idDep`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

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
  `idep` int(11) NOT NULL,
  PRIMARY KEY (`idOperario`),
  KEY `FKDEP` (`idDep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquinas`
--

DROP TABLE IF EXISTS `maquinas`;
CREATE TABLE IF NOT EXISTS `maquinas` (
  `idMaquina` int(11) NOT NULL,
  `fechaCompra` date NOT NULL,
  `ubicacion` varchar(50),
  `tipoImpresion` varchar(50),
  `modoImpresion` varchar(50),
  `volumenTinta` float NOT NULL,
  `idLote` int(11) NOT NULL,
  PRIMARY KEY (`idMaquina`),
  KEY `FKLOTE` (`idLote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `labores`
--

DROP TABLE IF EXISTS `labores`;
CREATE TABLE IF NOT EXISTS `labores` (
  `idLab` int(11) NOT NULL,
  `fechaReal` date NOT NULL,
  `descripcion` varchar(200),
  `idMaquina` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idLab`),
  KEY `FKMAQ` (`idMaquina`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pruebas`
--

DROP TABLE IF EXISTS `pruebas`;
CREATE TABLE IF NOT EXISTS `pruebas` (
  `idPrueba` int(11) NOT NULL,
  `explicacion` varchar(200),
  `resultado` varchar(200) NOT NULL,
  `fecha` date NOT NULL,
  `idMaquina` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idPrueba`),
  KEY `FKMAQ` (`idMaquina`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reglas`
--

DROP TABLE IF EXISTS `reglas`;
CREATE TABLE IF NOT EXISTS `reglas` (
  `idRegla` int(11) NOT NULL,
  `nombreRegla` varchar(50),
  `idPrueba` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idRegla`),
  KEY `FKPRU` (`idPrueba`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `politicas`
--

DROP TABLE IF EXISTS `politicas`;
CREATE TABLE IF NOT EXISTS `politicas` (
  `idPolitica` int(11) NOT NULL,
  `nombrePolitica` varchar(50),
  `fechaVig` date NOT NULL,
  `descripcion` varchar(200),
  `idRegla` int(11) NOT NULL,
  `idOperario` int(11) NOT NULL,
  PRIMARY KEY (`idPolitica`),
  KEY `FKREG` (`idRegla`),
  KEY `FKOP` (`idOperario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------



COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
