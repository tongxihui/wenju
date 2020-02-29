DROP TABLE IF EXISTS `wenju_secret`;

CREATE TABLE `wenju_secret`
(
    `user_id`     varchar(30)  NOT NULL COMMENT '主键',
    `utoken`      varchar(300) NOT NULL COMMENT '登录令牌',
    `create_time` bigint(20)   NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY (`utoken`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='文聚令牌表';