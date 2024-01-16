CREATE TABLE `job` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `admin` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '接受岗位id',
  `job_name` varchar(20) NOT NULL DEFAULT '' COMMENT '岗位名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`),
    unique key  `admin` (`admin`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '手机',
  `ware_id` bigint NOT NULL DEFAULT '0' COMMENT '身份id（默认为：0为学生,1为企业2为管理员）',
  `email` varchar(30) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uname` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

create table  `student`(
    `id` bigint not null  auto_increment comment 'id',
    `admin_id` bigint not null comment '用户id',
    `user_id` varchar(20) not null  comment '学生号',
    `grade` varchar(20) not null comment '所在年级',
    `major` varchar(20) not null  comment '专业',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    primary key (`id`),
    foreign key (`admin_id`) references admin(`id`)
)Engine =InnoDB auto_increment=2 default charset =utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学生表';

create table  `enterprise`(
    `id` bigint not null  auto_increment comment 'id',
    `admin_id` bigint not null comment '用户id',
    `user_id` varchar(20) not null  comment '企业号',
    `name` varchar(20) not null comment '所属企业',
    `department` varchar(20) not null  comment '所属部门',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标记（0:不可用 1:可用）',
    primary key (`id`),
    foreign key (`admin_id`) references admin(`id`)
)Engine =InnoDB auto_increment=2 default charset =utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='企业表';

CREATE TABLE `job_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `ent_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '发布者姓名',
  `stu_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '工作者姓名',
  `job_title` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '工作标题',
  `department` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '部门',
  `email` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '联系电话',
  `job_describe` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '工作描述',
  `requirement` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '要求',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除(1为删除,默认为0)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC COMMENT='工作信息';
