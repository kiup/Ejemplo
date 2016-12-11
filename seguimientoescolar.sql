-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2016 a las 07:42:31
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `seguimientoescolar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `MATRIC` char(4) NOT NULL,
  `NALUM` varchar(50) DEFAULT NULL,
  `DIREC` varchar(50) DEFAULT NULL,
  `TELEF` char(12) DEFAULT NULL,
  `CCAR` char(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`MATRIC`, `NALUM`, `DIREC`, `TELEF`, `CCAR`) VALUES
('1111', 'PEREZ JUAN', 'C 17 No. 222', '1111111', 'LCC'),
('1212', 'CHAVEZ JOSE', 'C 27 No. 332', '1121212', 'LIS'),
('1313', 'QUIROZ PATRICIA', 'C 57 No. 168', '4511111', 'LCC'),
('1414', 'SANCHEZ LOURDES', 'C 11 No. 290', '1167811', 'LIS'),
('1512', 'Milka Cabrilla', 'Calle 8E', '9991581878', 'LIS'),
('1515', 'GARCIA RAUL', 'C 33 No. 284', '1111987', 'LCC'),
('1616', 'SANDOVAL IRMA', 'C 45 No. 130', '1156411', 'LIS'),
('1717', 'LORONO JUAN', 'C 89 No. 222', '1187211', 'LCC'),
('1801', 'ZARITA CABRILLA', 'CALLE 23', '166385847', 'LCC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `CCAR` char(3) NOT NULL,
  `NCAR` char(6) NOT NULL,
  `TCRED` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`CCAR`, `NCAR`, `TCRED`) VALUES
('LCC', 'LIC CC', 360),
('LIC', 'LIC IC', 360),
('LIS', 'LIC IS', 360),
('LM', 'LIC M', 360);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

CREATE TABLE `grupos` (
  `CPROF` char(3) NOT NULL,
  `CASIG` char(5) NOT NULL,
  `HORARIO` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `MATRIC` char(4) NOT NULL,
  `CPROF` char(3) NOT NULL,
  `CASIG` char(5) NOT NULL,
  `CALIF` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `CASIG` char(5) NOT NULL,
  `NASIG` char(50) DEFAULT NULL,
  `NCRED` int(2) DEFAULT NULL,
  `SEM` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`CASIG`, `NASIG`, `NCRED`, `SEM`) VALUES
('BD-01', 'BASES DE DATOS', 10, 5),
('CC-01', 'TEORIA COMPUTACIONAL', 10, 4),
('CC-02', 'COMPILADORES', 14, 6),
('CC-03', 'SISTEMAS OPERATIVOS', 10, 5),
('CC-04', 'LENGUAJES PROGRAMACION', 10, 4),
('CC-05', 'ESTRUCTURAS DATOS', 10, 3),
('CC-06', 'ANALISIS ALGORITMOS', 10, 5),
('HW-01', 'ARQUITECTURA COMP I', 10, 3),
('HW-02', 'LENGUAJE ENSAMBLADOR', 10, 3),
('IS-01', 'INGENIERIA SOFTWARE I', 10, 5),
('IS-02', 'INGENIERIA SOFTWARE II', 10, 6),
('IS-03', 'ADMINISTRACION PROYS', 10, 7),
('MA-01', 'MATEMATICAS I', 16, 1),
('MA-02', 'MATEMATICAS II', 16, 2),
('MA-03', 'MATEMATICAS III', 16, 3),
('MA-04', 'MATEMATICAS IV', 16, 4),
('MA-05', 'MATEMATICAS V', 16, 5),
('OP-01', 'PROGRAMACION LENG C', 12, 2),
('OP-02', 'PROGRAMACION LENG BASIC', 12, 1),
('OP-03', 'PROGRAMACION LENG JAVA', 12, 3),
('OP-04', 'INTELIGENCIA ARTIFICIAL', 12, 5),
('OP-05', 'PROGRAMACION MOVILES', 12, 7),
('OP-06', 'BD DISTRIBUIDAS', 12, 6),
('OP-07', 'VIDEOJUEGOS III', 12, 7),
('PG-01', 'PROGRAMACION OO', 12, 2),
('PG-02', 'PROGRAMACION VISUAL', 12, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profes`
--

CREATE TABLE `profes` (
  `CPROF` char(3) NOT NULL,
  `NPROF` char(50) DEFAULT NULL,
  `GRADO` char(5) DEFAULT NULL,
  `FINGR` char(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profes`
--

INSERT INTO `profes` (`CPROF`, `NPROF`, `GRADO`, `FINGR`) VALUES
('P01', 'JUAN CANTILLO', 'DR.', '01012001'),
('P02', 'JAVIER ARANDA', 'DR.', '01022008'),
('P03', 'ISAIS BACELIS', 'MC.', '01082001'),
('P04', 'BENJAMIN BUTON', 'MC.', '01082010'),
('P05', 'CRISTOBAL COLIN', 'DR.', '01032011'),
('P06', 'HERNAN MENDEZ', 'DR.', '01052003'),
('P07', 'MARGARITA PEREZ', 'ING.', '01021990'),
('P08', 'AMALIA DURAN', 'ING.', '01042006'),
('P09', 'JOSE RAMIREZ', 'MC.', '01012001'),
('P10', 'IRMA DORANTES', 'DR.', '01012006'),
('P11', 'LUCELY TINOCO', 'MC.', '01012005'),
('P12', 'ENNA DUARTE', 'MC.', '01112004');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `CUSER` char(4) NOT NULL,
  `CONTR` char(4) DEFAULT NULL,
  `TIPO` char(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`CUSER`, `CONTR`, `TIPO`) VALUES
('0000', '0000', 'ADMI'),
('1111', '1111', 'ALUM'),
('1212', '1212', 'ALUM'),
('1313', '1313', 'ALUM'),
('1414', '1414', 'ALUM'),
('1512', '1512', 'ALUM'),
('1515', '1515', 'ALUM'),
('1616', '1616', 'ALUM'),
('1717', '1717', 'ALUM'),
('P01', 'P01', 'PROF'),
('P02', 'P02', 'PROF'),
('P03', 'P03', 'PROF'),
('P04', 'P04', 'PROF'),
('P05', 'P05', 'PROF'),
('P06', 'P06', 'PROF'),
('P07', 'P07', 'PROF'),
('P08', 'P08', 'PROF'),
('P09', 'P09', 'PROF'),
('P10', 'P10', 'PROF'),
('P11', 'P11', 'PROF'),
('P12', 'P12', 'PROF');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`MATRIC`),
  ADD KEY `CCAR` (`CCAR`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`CCAR`);

--
-- Indices de la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD PRIMARY KEY (`CPROF`,`CASIG`),
  ADD KEY `CASIG` (`CASIG`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`MATRIC`,`CPROF`,`CASIG`),
  ADD KEY `CPROF` (`CPROF`),
  ADD KEY `CASIG` (`CASIG`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`CASIG`);

--
-- Indices de la tabla `profes`
--
ALTER TABLE `profes`
  ADD PRIMARY KEY (`CPROF`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CUSER`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`CCAR`) REFERENCES `carreras` (`CCAR`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD CONSTRAINT `grupos_ibfk_1` FOREIGN KEY (`CPROF`) REFERENCES `profes` (`CPROF`) ON UPDATE CASCADE,
  ADD CONSTRAINT `grupos_ibfk_2` FOREIGN KEY (`CASIG`) REFERENCES `materias` (`CASIG`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`MATRIC`) REFERENCES `alumno` (`MATRIC`) ON UPDATE CASCADE,
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`CPROF`) REFERENCES `profes` (`CPROF`) ON UPDATE CASCADE,
  ADD CONSTRAINT `inscripcion_ibfk_3` FOREIGN KEY (`CASIG`) REFERENCES `materias` (`CASIG`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
