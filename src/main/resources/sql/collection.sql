CREATE TABLE `wenju_collection` (
    `id`        int(11)     NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`      varchar(30) NOT NULL COMMENT '名称',
    `collector` varchar(30) NOT NULL COMMENT '收集者',
    `create_time` bigint(20) NOT NULL COMMENT '创建时间',
    `deadline`  bigint(20)  NOT NULL COMMENT '截止时间',
    `status`    varchar(20) DEFAULT 'NOT_PUBLISHED' COMMENT '状态: CLOSED - 已关闭, NOT_PUBLISHED - 未发布, PUBLISHED - 已发布, DELETED - 已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`collector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文聚收集表';