
CREATE TABLE `alquiler` (
  `id` int(11) NOT NULL,
  `id_vivienda` int(11) NOT NULL,
  `documento_residente` varchar(20) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `areascomunes` (
  `id` int(11) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `tipo` enum('piscina','gimnasio','sala','parrilla','sauna') NOT NULL,
  `ubicacion` varchar(100) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `estado` enum('disponible','mantenimiento','reservada') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `cuotas` (
  `id` int(11) NOT NULL,
  `id_alquiler` int(11) DEFAULT NULL,
  `codigo_cuota` varchar(20) DEFAULT NULL,
  `periodo_year` int(11) DEFAULT NULL,
  `periodo_mes` int(11) DEFAULT NULL,
  `importe` decimal(10,2) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `pagada` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `id_area` int(11) DEFAULT NULL,
  `documento_residente` varchar(20) DEFAULT NULL,
  `fecha_reserva` date NOT NULL,
  `cantidad_personas` int(11) NOT NULL,
  `nombre_responsable` varchar(100) DEFAULT NULL,
  `comentario` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `residente` (
  `documento` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `claveAcceso` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `usr_ususarios` (
  `usr_id` int(11) NOT NULL COMMENT 'Id Usuario',
  `usr_email` varchar(100) NOT NULL COMMENT 'Email Usuario',
  `usr_contraseña` varchar(100) NOT NULL COMMENT 'Contraseña Usuario',
  `usr_es_admin` tinyint(1) DEFAULT NULL COMMENT 'Usuario Administrador',
  `usr_activo` tinyint(1) DEFAULT NULL COMMENT 'Usuario Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabla de Usuarios';


