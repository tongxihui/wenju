DROP TABLE IF EXISTS `wenju_file`;

CREATE TABLE `wenju_file`
(
    `id`           bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`         varchar(50) NOT NULL COMMENT '文件名',
    `collector_id` int(11)     NOT NULL COMMENT '收集id',
    `updater_id`   varchar(30) NOT NULL COMMENT '上传者id',
    `create_time`  bigint(20)  NOT NULL COMMENT '上传时间',
    `size`         double COMMENT '文件大小',
    `url`          varchar(2083) COMMENT 'url',
    `index`        int(2)      NOT NULL COMMENT '模板编号',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`collector_id`),
    UNIQUE KEY (`updater_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='文聚文件表';