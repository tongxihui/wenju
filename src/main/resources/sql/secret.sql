DROP TABLE IF EXISTS `wenju_user_secret`

CREATE TABLE `wenju_user_secret`
(
    `user_id`   varchar(30) NOT NULL COMMENT '主键',
    `secret`    varchar(300) NOT NULL COMMENT '令牌',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY (`secret`)
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='文聚令牌表';