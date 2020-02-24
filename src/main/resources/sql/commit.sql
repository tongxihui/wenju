DROP TABLE IF EXISTS `wenju_commit`;

CREATE TABLE `wenju_commit`
(
    `id`            int(11)     NOT NULL AUTO_INCREMENT COMMENT '主键',
    `collection_id` int(11)     NOT NULL COMMENT '收集id',
    `updater_id`    varchar(30) NOT NULL COMMENT '上传者id',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`collection_id`),
    UNIQUE KEY (`updater_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='文聚上传表';