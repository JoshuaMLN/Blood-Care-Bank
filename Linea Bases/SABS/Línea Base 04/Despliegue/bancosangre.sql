-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2022 a las 22:46:46
-- Versión del servidor: 8.0.29
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bancosangre`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donante`
--

CREATE TABLE `donante` (
  `id_donante` int NOT NULL,
  `nombre_d` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_naci` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `dni_d` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `edad_d` int NOT NULL,
  `telf_d` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `correo_d` varchar(45) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `donante`
--

INSERT INTO `donante` (`id_donante`, `nombre_d`, `fecha_naci`, `dni_d`, `edad_d`, `telf_d`, `correo_d`) VALUES
(5, 'Hans', '12-12-12', '345234', 30, '4232342', 'asd@gmail.com'),
(6, 'Jhon', '12-12-12', '77766554', 20, '999888777', 'jhon@gmail.com'),
(7, 'Kasd', '01-01-01', '12341', 23, '1231243', 'kasd@gmail'),
(8, 'Antony', '11-11-11', '77766655', 30, '2345345', 'erqwqe@gmail.com'),
(9, 'asdasd', '14-14-14', '444444', 45, '2134234', 'gdfg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id_empleado` int NOT NULL,
  `cargo_emp` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `correo_emp` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresasangre`
--

CREATE TABLE `empresasangre` (
  `id_emp` int NOT NULL,
  `nombre_emp` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `estado_emp` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `telf_emp` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `direc_emp` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `correo_emp` varchar(100) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extracsangre`
--

CREATE TABLE `extracsangre` (
  `id_extrac` int NOT NULL,
  `fecha_extrac` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `vol_extrac` float NOT NULL,
  `grupo_extrac` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `rh_extrac` varchar(45) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `extracsangre`
--

INSERT INTO `extracsangre` (`id_extrac`, `fecha_extrac`, `vol_extrac`, `grupo_extrac`, `rh_extrac`) VALUES
(3, '11-11-23', 340, 'AB', '+'),
(4, '16-05-22', 67, 'B', '-'),
(5, '05-05-15', 23, 'O', '-'),
(6, '12-12-12', 89, 'O', '+'),
(7, '11-11-11', 34, 'A', '+'),
(8, '11-11-11', 34, 'A', '+'),
(9, '11-11-11', 22, 'A', '+'),
(10, '12-12-12', 45, 'A', '+'),
(11, '12-12-12', 45, 'AB', '-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sangre`
--

CREATE TABLE `sangre` (
  `id_sangre` int NOT NULL,
  `vol_sangre` float NOT NULL,
  `grupo_sangre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `rh_sangre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sangre`
--

INSERT INTO `sangre` (`id_sangre`, `vol_sangre`, `grupo_sangre`, `rh_sangre`) VALUES
(1, 900, 'A', '+'),
(2, 1000, 'B', '+'),
(3, 1089, 'O', '+'),
(4, 1000, 'A', '-'),
(5, 1067, 'B', '-'),
(6, 1023, 'O', '-'),
(7, 1340, 'AB', '+'),
(8, 1045, 'AB', '-');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitante`
--

CREATE TABLE `solicitante` (
  `id_soli` int NOT NULL,
  `nombre_soli` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `telf_soli` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `correo_soli` varchar(45) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes`
--

CREATE TABLE `solicitudes` (
  `id_solicitud` int NOT NULL,
  `nombre_soli` varchar(45) NOT NULL,
  `motivo_soli` varchar(45) NOT NULL,
  `grupo_soli` varchar(45) NOT NULL,
  `rh_soli` varchar(45) NOT NULL,
  `volumen_soli` float NOT NULL,
  `fecha_soli` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `solicitudes`
--

INSERT INTO `solicitudes` (`id_solicitud`, `nombre_soli`, `motivo_soli`, `grupo_soli`, `rh_soli`, `volumen_soli`, `fecha_soli`) VALUES
(2, 'EsSalud', 'Trasfución', 'A', '+', 12.3, '22/11/2022 13:29'),
(5, 'LaLuz', 'sdfsa', 'A', '+', 85, '01/12/2022 16:07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL,
  `nombre_u` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `contraseña_u` varchar(45) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_u`, `contraseña_u`) VALUES
(1, 'user', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `donante`
--
ALTER TABLE `donante`
  ADD PRIMARY KEY (`id_donante`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `empresasangre`
--
ALTER TABLE `empresasangre`
  ADD PRIMARY KEY (`id_emp`);

--
-- Indices de la tabla `extracsangre`
--
ALTER TABLE `extracsangre`
  ADD PRIMARY KEY (`id_extrac`);

--
-- Indices de la tabla `sangre`
--
ALTER TABLE `sangre`
  ADD PRIMARY KEY (`id_sangre`);

--
-- Indices de la tabla `solicitante`
--
ALTER TABLE `solicitante`
  ADD PRIMARY KEY (`id_soli`);

--
-- Indices de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  ADD PRIMARY KEY (`id_solicitud`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `donante`
--
ALTER TABLE `donante`
  MODIFY `id_donante` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id_empleado` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresasangre`
--
ALTER TABLE `empresasangre`
  MODIFY `id_emp` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `extracsangre`
--
ALTER TABLE `extracsangre`
  MODIFY `id_extrac` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `sangre`
--
ALTER TABLE `sangre`
  MODIFY `id_sangre` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `solicitante`
--
ALTER TABLE `solicitante`
  MODIFY `id_soli` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  MODIFY `id_solicitud` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
