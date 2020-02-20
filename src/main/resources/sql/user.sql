CREATE TABLE `user` (
    `user_id`   varchar (30)    NOT NULL COMMENT '主键',
    `phone`     varchar (11)    NOT NULL COMMENT '手机号',
    `real_name` varchar (20)    NOT NULL COMMENT '真实姓名',
    `nick_name` varchar (30)    DEFAULT NULL COMMENT '昵称',
    `password`  varchar (40)    NOT NULL COMMENT '密码',
    `user_salt` varchar (10)    NOT NULL COMMENT '用户密码等hash计算相关salt',
    `email`     varchar (100)   DEFAULT NULL COMMENT '邮箱',
    `qq`        varchar (12)    DEFAULT NULL COMMENT 'QQ',
    `wx`        varchar (32)    DEFAULT NULL COMMENT '微信',
    `status`    varchar (10)    DEFAULT 'NORMAL' COMMENT '状态: NORMAL - 正常, BANNED - 封禁',
    `extra`     varchar (30)    DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文聚用户表';