SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE categoria (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `rol_id` int(11) NOT NULL,
  `icono` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO categoria (id, nombre, descripcion, rol_id, icono, estado) VALUES
(1, 'Aplicaciones', 'Aplicaciones que provee Q-antica', 1, 'apps.png', 1),
(2, 'Documentos', 'Documentos ofrecidos por Q-antica', 1, 'documentos.png', 1),
(5, 'Videos', 'Videos ofrecidos por Q-antica', 1, 'videos.png', 1),
(6, 'Alta Gracia', 'Alta Gracia', 4, 'logo.png', 1),
(7, 'Alta Gracia', 'Alta Gracia', 4, 'logo.png', 1);

CREATE TABLE comentario (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `contenido_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE contenido (
  `id` int(11) NOT NULL,
  `captura_1` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `captura_2` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descargas` int(11) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `icono` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `publicacion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `ruta` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `version` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `subcategoria_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO contenido (id, captura_1, captura_2, descargas, descripcion, estado, icono, nombre, publicacion, rating, ruta, `version`, categoria_id, subcategoria_id) VALUES
(1, '1.png', 'concentrate.jpg', 8, 'Juego concéntrate para Samsung', 1, 'ic_launcher_concentrate.png', 'Concéntrate con Samsung', '24/08/2016', 0, 'ConcentrateFinal.apk', '1.2', 1, 1),
(4, '', '', 0, 'Contenido cargado desde la web', 1, 'ic_launcher.png', 'Contenido Web', '13/11/2016', 0, 'putty.exe', '1.2', 6, NULL);

CREATE TABLE descarga (
  `id` int(11) NOT NULL,
  `fecha` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `contenido_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO descarga (id, fecha, contenido_id, usuario_id) VALUES
(1, '2016-11-09', 1, 1),
(2, '2016-11-09', 1, 1),
(3, '2016-11-09', 1, 1),
(4, '2016-11-09', 1, 1),
(5, '2016-11-09', 1, 1),
(6, '2016-11-09', 1, 1),
(7, '2016-11-09', 1, 1),
(8, '2016-11-09', 1, 1);

CREATE TABLE ingreso (
  `id` int(11) NOT NULL,
  `fecha` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE noticia (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fuente` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rol_id` int(11) NOT NULL,
  `titulo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO noticia (id, descripcion, fecha, fuente, imagen, rol_id, titulo) VALUES
(2, 'Esta es una noticia que se está enviando desde el SErvlet', '2016-08-18 09:23:00', 'Q-antica', '', 1, 'Noticia de prueba'),
(3, 'Esta es una noticia que se está enviando desde el Servlet 2', '2016-08-18 09:23:00', 'Q-antica', '', 1, 'Noticia de prueba 2'),
(4, 'Noticia para Camilo', '24/08/2016', 'Q-antica', '123.png', 3, 'Camilo Mendieta'),
(6, 'Noticia de prueba web', '10/11/2016', 'Web', NULL, 4, 'Noticia de prueba web');

CREATE TABLE rol (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO rol (id, nombre, estado) VALUES
(1, 'Administrador', 1),
(2, 'prueba', 1),
(3, 'Product Manager', 1),
(4, 'Prueba web', 1);

CREATE TABLE subcategoria (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `subcategoria_id` int(11) DEFAULT NULL,
  `estado` tinyint(4) NOT NULL,
  `categoria_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO subcategoria (id, nombre, subcategoria_id, estado, categoria_id) VALUES
(1, 'Samsung', NULL, 1, 1),
(2, 'Prueba desde la web', NULL, 1, 6);

CREATE TABLE usuario (
  `id` int(11) NOT NULL,
  `nombreUsuario` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `identificacion` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `rol_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

INSERT INTO usuario (id, nombreUsuario, contrasena, identificacion, nombre, apellido, rol_id) VALUES
(1, 'jnrubiano', '123', '1032438571', 'Nicolás', 'Rubiano', 1),
(2, 'cmendieta', '123456', '1234567890', 'Camilo', 'Mendieta', 3),
(3, 'jlopera', '123', '12345', 'Jacinto', 'Lopera', 3);


ALTER TABLE categoria
  ADD PRIMARY KEY (`id`);

ALTER TABLE comentario
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9E0DE7E1B31820B3` (`usuario_id`),
  ADD KEY `FK9E0DE7E11BC76E93` (`contenido_id`);

ALTER TABLE contenido
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKE7BBDD79D5ECEA1` (`subcategoria_id`),
  ADD KEY `FKE7BBDD798AD91C53` (`categoria_id`);

ALTER TABLE descarga
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3CA91EDCB31820B3` (`usuario_id`),
  ADD KEY `FK3CA91EDC1BC76E93` (`contenido_id`);

ALTER TABLE ingreso
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK740432B1B31820B3` (`usuario_id`);

ALTER TABLE noticia
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_ROL_NOTICIA` (`rol_id`);

ALTER TABLE rol
  ADD PRIMARY KEY (`id`);

ALTER TABLE subcategoria
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CATEGORIA_SUBCATEGORIA` (`categoria_id`);

ALTER TABLE usuario
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKF814F32E13055593` (`rol_id`);


ALTER TABLE categoria
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
ALTER TABLE comentario
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE contenido
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
ALTER TABLE descarga
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
ALTER TABLE ingreso
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE noticia
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
ALTER TABLE rol
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
ALTER TABLE subcategoria
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
ALTER TABLE usuario
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE subcategoria
  ADD CONSTRAINT `FK_CATEGORIA_SUBCATEGORIA` FOREIGN KEY (`categoria_id`) REFERENCES categoria (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
