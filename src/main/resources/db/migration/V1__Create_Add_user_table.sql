-- 逻辑线 登陆用户 查找到 对应角色，拿到对应的角色后，再找到所有对应角色的权限
-- 用户表
CREATE TABLE user
(
	id VARCHAR(32) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	password VARCHAR(30) NULL DEFAULT NULL COMMENT '密码',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);
INSERT INTO user (id, name, password, age, email) VALUES
(1, 'Jone', '123456', 18, 'test1@baomidou.com'),
(2, 'Jack', '123456',  20, 'test2@baomidou.com'),
(3, 'Tom', '123456', 28, 'test3@baomidou.com'),
(4, 'Sandy', '123456',  21, 'test4@baomidou.com'),
(5, 'Billie', '123456', 24, 'test5@baomidou.com');

-- 角色表
CREATE TABLE role
(
	id VARCHAR(32) NOT NULL COMMENT '主键ID',
	role_name VARCHAR(30) NULL DEFAULT NULL COMMENT '角色名称',
	role_desc VARCHAR(50) NULL DEFAULT NULL COMMENT '角色描述',
	PRIMARY KEY (id)
);
INSERT INTO role (id, role_name, role_desc) VALUES
(1, 'admin', '管理员角色'),
(2, 'normal', '普通用户');

-- 用户所拥有的角色 关系表
CREATE TABLE user_role
(
	id VARCHAR(32) NOT NULL COMMENT '主键ID',
	role_id VARCHAR(30) NULL DEFAULT NULL COMMENT '角色id',
	user_id VARCHAR(50) NULL DEFAULT NULL COMMENT '用户id',
	PRIMARY KEY (id)
);
INSERT INTO user_role (id, role_id, user_id) VALUES
(1, '1', '1'),
(2, '2', '2');

-- 菜单
CREATE TABLE  menu
(
	id VARCHAR(32) NOT NULL COMMENT '主键ID',
	menu_name VARCHAR(30) NOT NULL COMMENT '菜单名称',
	perms VARCHAR(50) NOT NULL COMMENT '授权标识',
	url VARCHAR(80) NULL DEFAULT NULL COMMENT '链接地址',
	PRIMARY KEY (id)
);
INSERT INTO  menu (id,menu_name, perms, url) VALUES
(1,'用户添加','user:add','/add' ),
(2, '用户更新','user:update','/update' );

-- 角色所对应的菜单权限 关系表
CREATE TABLE role_menu
(
	id VARCHAR(32) NOT NULL COMMENT '主键ID',
	role_id VARCHAR(30) NULL DEFAULT NULL COMMENT '角色id',
	menu_id VARCHAR(50) NULL DEFAULT NULL COMMENT '权限id',
	PRIMARY KEY (id)
);

INSERT INTO role_menu (id, role_id, menu_id) VALUES
(1, '1', '1'),
(2, '1', '2'),
(3, '2', '2');

