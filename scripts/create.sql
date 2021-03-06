DROP DATABASE IF EXISTS `blog`;
CREATE DATABASE `blog`;

USE `blog`;

CREATE TABLE `blog_info` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` VARCHAR(50) DEFAULT NULL COMMENT '编码',
  `title` VARCHAR(64) NOT NULL COMMENT '博客标题',
  `type` INT DEFAULT 0 COMMENT '博客类型',
  `content` TEXT NOT NULL COMMENT '博客内容',
  `create_time` timestamp DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`id`)
)