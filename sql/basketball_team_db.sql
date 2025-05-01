-- ----------------------------
-- 创建数据库
-- ----------------------------
CREATE DATABASE IF NOT EXISTS `basketball_team_db`
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_0900_ai_ci;

USE `basketball_team_db`;

-- ----------------------------
-- 核心表：系统用户（账户信息）
-- ----------------------------
CREATE TABLE `sys_user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) NOT NULL COMMENT '密码',
  `status` TINYINT NOT NULL DEFAULT 1 COMMENT '状态（0停用 1正常）',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uniq_username` (`username`)
) ENGINE=InnoDB COMMENT='系统用户表';

-- ----------------------------
-- 系统角色表（权限控制）
-- ----------------------------
CREATE TABLE `sys_role` (
  `role_id` INT NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` VARCHAR(20) NOT NULL COMMENT '角色名称',
  `role_key` VARCHAR(20) NOT NULL COMMENT '角色标识',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `uniq_role_key` (`role_key`)
) ENGINE=InnoDB COMMENT='系统角色表';

-- ----------------------------
-- 球队职位表（身份标识）
-- ----------------------------
CREATE TABLE `team_position` (
  `position_id` INT NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `position_name` VARCHAR(20) NOT NULL COMMENT '职位名称',
  `position_code` VARCHAR(20) NOT NULL COMMENT '职位代码',
  PRIMARY KEY (`position_id`),
  UNIQUE KEY `uniq_pos_code` (`position_code`)
) ENGINE=InnoDB COMMENT='球队职位表';

-- ----------------------------
-- 权限表（细粒度控制）
-- ----------------------------
CREATE TABLE `sys_permission` (
  `perm_id` INT NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `perm_name` VARCHAR(50) NOT NULL COMMENT '权限名称',
  `perm_key` VARCHAR(50) NOT NULL COMMENT '权限标识',
  PRIMARY KEY (`perm_id`),
  UNIQUE KEY `uniq_perm_key` (`perm_key`)
) ENGINE=InnoDB COMMENT='系统权限表';

-- ----------------------------
-- 角色权限关联表
-- ----------------------------
CREATE TABLE `sys_role_permission` (
  `role_id` INT NOT NULL COMMENT '角色ID',
  `perm_id` INT NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`, `perm_id`),
  FOREIGN KEY (`role_id`) REFERENCES `sys_role`(`role_id`),
  FOREIGN KEY (`perm_id`) REFERENCES `sys_permission`(`perm_id`)
) ENGINE=InnoDB COMMENT='角色权限关联表';

-- ----------------------------
-- 用户角色关联表
-- ----------------------------
CREATE TABLE `sys_user_role` (
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `role_id` INT NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`),
  FOREIGN KEY (`user_id`) REFERENCES `sys_user`(`user_id`),
  FOREIGN KEY (`role_id`) REFERENCES `sys_role`(`role_id`)
) ENGINE=InnoDB COMMENT='用户角色关联表';

-- ----------------------------
-- 用户职位关联表
-- ----------------------------
CREATE TABLE `sys_user_position` (
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `position_id` INT NOT NULL COMMENT '职位ID',
  PRIMARY KEY (`user_id`, `position_id`),
  FOREIGN KEY (`user_id`) REFERENCES `sys_user`(`user_id`),
  FOREIGN KEY (`position_id`) REFERENCES `team_position`(`position_id`)
) ENGINE=InnoDB COMMENT='用户职位关联表';

-- ----------------------------
-- 球员档案表
-- ----------------------------
CREATE TABLE `player_profile` (
  `profile_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '档案ID',
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `real_name` VARCHAR(50) NOT NULL COMMENT '真实姓名',
  `jersey_number` INT UNIQUE COMMENT '球衣号',
  `position` ENUM('guard', 'forward', 'center') COMMENT '场上位置',
  `height` DECIMAL(5,2) COMMENT '身高（米）',
  `weight` DECIMAL(5,2) COMMENT '体重（千克）',
  `join_date` DATE NOT NULL COMMENT '入队日期',
  PRIMARY KEY (`profile_id`),
  UNIQUE KEY `uniq_user` (`user_id`),
  UNIQUE KEY `uniq_jersey` (`jersey_number`),
  FOREIGN KEY (`user_id`) REFERENCES `sys_user`(`user_id`)
) ENGINE=InnoDB COMMENT='球员档案表';

-- ----------------------------
-- 公告信息表
-- ----------------------------
CREATE TABLE `announcement` (
  `announce_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `title` VARCHAR(200) NOT NULL COMMENT '标题',
  `content` TEXT NOT NULL COMMENT '内容',
  `publisher_id` BIGINT NOT NULL COMMENT '发布人ID',
  `publish_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`announce_id`),
  FOREIGN KEY (`publisher_id`) REFERENCES `sys_user`(`user_id`)
) ENGINE=InnoDB COMMENT='公告表';

-- ----------------------------
-- 赛程信息表
-- ----------------------------
CREATE TABLE `schedule` (
  `schedule_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '赛程ID',
  `match_name` VARCHAR(200) NOT NULL COMMENT '比赛名称',
  `match_time` DATETIME NOT NULL COMMENT '比赛时间',
  `location` VARCHAR(200) NOT NULL COMMENT '比赛地点',
  `opponent` VARCHAR(100) NOT NULL COMMENT '对手球队',
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '状态（0未开始 1进行中 2已结束）',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`schedule_id`)
) ENGINE=InnoDB COMMENT='赛程表';

-- ----------------------------
-- 初始化数据
-- ----------------------------

-- 系统角色数据
INSERT INTO `sys_role` (`role_name`, `role_key`) VALUES
('系统管理员', 'admin'),
('普通用户', 'user');

-- 球队职位数据
INSERT INTO `team_position` (`position_name`, `position_code`) VALUES
('队长', 'captain'),
('队员', 'player');

-- 系统权限数据
INSERT INTO `sys_permission` (`perm_name`, `perm_key`) VALUES
/* 用户管理 */
('查看用户列表', 'user:view'),
('创建用户', 'user:create'),
('编辑用户', 'user:update'),
('删除用户', 'user:delete'),

/* 角色管理 */
('分配角色', 'role:assign'),

/* 公告管理 */
('查看公告', 'announce:view'),
('发布公告', 'announce:create'),
('编辑公告', 'announce:update'),
('删除公告', 'announce:delete'),

/* 赛程管理 */
('查看赛程', 'schedule:view'),
('安排赛程', 'schedule:create'),
('调整赛程', 'schedule:update'),
('取消赛程', 'schedule:delete'),

/* 个人信息 */
('查看个人资料', 'profile:view'),
('编辑个人资料', 'profile:update');

-- 角色权限分配
-- 管理员拥有所有权限
INSERT INTO `sys_role_permission` (`role_id`, `perm_id`)
SELECT r.role_id, p.perm_id
FROM sys_role r
JOIN sys_permission p
WHERE r.role_key = 'admin';

-- 普通用户权限
INSERT INTO `sys_role_permission` (`role_id`, `perm_id`)
SELECT r.role_id, p.perm_id
FROM sys_role r
JOIN sys_permission p
WHERE r.role_key = 'user'
AND p.perm_key IN (
  'announce:view',
  'schedule:view',
  'profile:view',
  'profile:update'
);

-- 初始用户数据（密码均为123456的MD5）
INSERT INTO `sys_user` (`username`, `password`) VALUES
('admin_captain', 'e10adc3949ba59abbe56e057f20f883e'), -- 既是管理员又是队长
('player1', 'e10adc3949ba59abbe56e057f20f883e'),      -- 普通用户+队员
('player2', 'e10adc3949ba59abbe56e057f20f883e');     -- 普通用户+队员

-- 用户角色分配
INSERT INTO `sys_user_role` VALUES
(1, 1),  -- admin_captain 是管理员
(2, 2),  -- player1 是普通用户
(3, 2);  -- player2 是普通用户

-- 用户职位分配
INSERT INTO `sys_user_position` VALUES
(1, 1),  -- admin_captain 是队长
(2, 2),  -- player1 是队员
(3, 2);  -- player2 是队员

-- 球员档案数据
INSERT INTO `player_profile` 
(`user_id`, `real_name`, `jersey_number`, `position`, `height`, `weight`, `join_date`) VALUES
(1, '张伟', 23, 'forward', 1.98, 95.5, '2023-01-01'),
(2, '李明', 10, 'guard', 1.85, 80.0, '2023-03-15'),
(3, '王芳', 33, 'center', 2.11, 110.0, '2023-05-20');

-- 初始公告
INSERT INTO `announcement` (`title`, `content`, `publisher_id`) VALUES
('新赛季训练计划', '每周一三五下午4点体育馆集训', 1),
('队服尺寸统计通知', '请全体队员本周五前上报尺码', 1);

-- 赛程数据
INSERT INTO `schedule` (`match_name`, `match_time`, `location`, `opponent`) VALUES
('城市联赛揭幕战', '2024-08-20 19:00:00', '市体育馆', '雷霆队'),
('友谊赛', '2024-09-05 15:30:00', '师大篮球馆', '师大明星队');