CREATE TABLE `ocean_gen_test` (
  `id` bigint(20) NOT NULL,
  `api_path` varchar(120) DEFAULT NULL COMMENT '前端api文件路径',
  `author` varchar(36) DEFAULT NULL COMMENT '作者',
  `cover` bit(1) DEFAULT NULL COMMENT '是否覆盖',
  `module_name` varchar(120) DEFAULT NULL COMMENT '模块名',
  `pack` varchar(120) DEFAULT NULL COMMENT '包路径',
  `path` varchar(120) DEFAULT NULL COMMENT '前端文件路径',
  `prefix` varchar(24) DEFAULT NULL COMMENT '表前缀',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;