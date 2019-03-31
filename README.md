#  项目信息
1. 该项目使用了springboot + mybatis + jwt
2. 主要功能包含对文章类别，类别中的目录，目录下的文章进行操作。
3. 使用前请在数据库中执行以下语句根据实际情况配置用户名和密码
````
CREATE DATABASE `mybatis_test` ;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL,
  `title` varchar(45) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='存放文章的信息';

CREATE TABLE `article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章的类别';

CREATE TABLE `my_user` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `type_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) DEFAULT NULL COMMENT '类别的编号。',
  `name` varchar(45) NOT NULL COMMENT '目录名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='当前类别下的文件夹';


```
4. 还有一个前端的项目