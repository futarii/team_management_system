/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : basketball_team_db

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 02/05/2025 17:05:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `announce_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '内容',
  `publisher_id` bigint(0) NOT NULL COMMENT '发布人ID',
  `publish_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '发布时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`announce_id`) USING BTREE,
  INDEX `publisher_id`(`publisher_id`) USING BTREE,
  CONSTRAINT `announcement_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `sys_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (1, '新赛季训练计划', '每周一三五下午4点体育馆集训', 1, '2025-04-27 14:01:30', '2025-04-27 14:01:30');
INSERT INTO `announcement` VALUES (2, '队服尺寸统计通知', '请全体队员本周五前上报尺码', 1, '2025-04-27 14:01:30', '2025-04-27 14:01:30');

-- ----------------------------
-- Table structure for player_profile
-- ----------------------------
DROP TABLE IF EXISTS `player_profile`;
CREATE TABLE `player_profile`  (
  `profile_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '档案ID',
  `user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '真实姓名',
  `jersey_number` int(0) NULL DEFAULT NULL COMMENT '球衣号',
  `position` enum('guard','forward','center') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '场上位置',
  `height` decimal(5, 2) NULL DEFAULT NULL COMMENT '身高（米）',
  `weight` decimal(5, 2) NULL DEFAULT NULL COMMENT '体重（千克）',
  `join_date` date NOT NULL COMMENT '入队日期',
  PRIMARY KEY (`profile_id`) USING BTREE,
  UNIQUE INDEX `uniq_user`(`user_id`) USING BTREE,
  UNIQUE INDEX `jersey_number`(`jersey_number`) USING BTREE,
  UNIQUE INDEX `uniq_jersey`(`jersey_number`) USING BTREE,
  CONSTRAINT `player_profile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '球员档案表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of player_profile
-- ----------------------------
INSERT INTO `player_profile` VALUES (1, 1, '张伟', 23, 'forward', 1.98, 95.50, '2023-01-01');
INSERT INTO `player_profile` VALUES (2, 2, '李小明', 10, 'guard', 1.85, 80.00, '2023-03-15');
INSERT INTO `player_profile` VALUES (3, 3, '王芳', 33, 'center', 2.11, 110.00, '2023-05-20');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule`  (
  `schedule_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '赛程ID',
  `match_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '比赛名称',
  `match_time` datetime(0) NOT NULL COMMENT '比赛时间',
  `location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '比赛地点',
  `opponent` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '对手球队',
  `status` tinyint(0) NOT NULL DEFAULT 0 COMMENT '状态（0未开始 1进行中 2已结束）',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`schedule_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '赛程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES (1, '城市联赛揭幕战', '2024-08-20 19:00:00', '市体育馆', '雷霆队', 0, '2025-04-27 14:01:30', '2025-04-27 14:01:30');
INSERT INTO `schedule` VALUES (2, '友谊赛', '2024-09-05 15:30:00', '师大篮球馆', '师大明星队', 0, '2025-04-27 14:01:30', '2025-04-27 14:01:30');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `perm_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `perm_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名称',
  `perm_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限标识',
  PRIMARY KEY (`perm_id`) USING BTREE,
  UNIQUE INDEX `uniq_perm_key`(`perm_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '查看用户列表', 'user:view');
INSERT INTO `sys_permission` VALUES (2, '创建用户', 'user:create');
INSERT INTO `sys_permission` VALUES (3, '编辑用户', 'user:update');
INSERT INTO `sys_permission` VALUES (4, '删除用户', 'user:delete');
INSERT INTO `sys_permission` VALUES (5, '分配角色', 'role:assign');
INSERT INTO `sys_permission` VALUES (6, '查看公告', 'announce:view');
INSERT INTO `sys_permission` VALUES (7, '发布公告', 'announce:create');
INSERT INTO `sys_permission` VALUES (8, '编辑公告', 'announce:update');
INSERT INTO `sys_permission` VALUES (9, '删除公告', 'announce:delete');
INSERT INTO `sys_permission` VALUES (10, '查看赛程', 'schedule:view');
INSERT INTO `sys_permission` VALUES (11, '安排赛程', 'schedule:create');
INSERT INTO `sys_permission` VALUES (12, '调整赛程', 'schedule:update');
INSERT INTO `sys_permission` VALUES (13, '取消赛程', 'schedule:delete');
INSERT INTO `sys_permission` VALUES (14, '查看个人资料', 'profile:view');
INSERT INTO `sys_permission` VALUES (15, '编辑个人资料', 'profile:update');
INSERT INTO `sys_permission` VALUES (16, '查看球队信息', 'team:view');
INSERT INTO `sys_permission` VALUES (17, '修改球员信息', 'team:update');
INSERT INTO `sys_permission` VALUES (18, '查看球队角色', 'role:view');
INSERT INTO `sys_permission` VALUES (19, '新增球队角色', 'role:create');
INSERT INTO `sys_permission` VALUES (20, '修改球队角色', 'role:update');
INSERT INTO `sys_permission` VALUES (21, '删除球队角色', 'role:delete');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色标识',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `uniq_role_key`(`role_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理员', 'admin');
INSERT INTO `sys_role` VALUES (2, '普通用户', 'user');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` int(0) NOT NULL COMMENT '角色ID',
  `perm_id` int(0) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`, `perm_id`) USING BTREE,
  INDEX `perm_id`(`perm_id`) USING BTREE,
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`perm_id`) REFERENCES `sys_permission` (`perm_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1);
INSERT INTO `sys_role_permission` VALUES (1, 2);
INSERT INTO `sys_role_permission` VALUES (1, 3);
INSERT INTO `sys_role_permission` VALUES (1, 4);
INSERT INTO `sys_role_permission` VALUES (1, 5);
INSERT INTO `sys_role_permission` VALUES (1, 6);
INSERT INTO `sys_role_permission` VALUES (2, 6);
INSERT INTO `sys_role_permission` VALUES (1, 7);
INSERT INTO `sys_role_permission` VALUES (1, 8);
INSERT INTO `sys_role_permission` VALUES (1, 9);
INSERT INTO `sys_role_permission` VALUES (1, 10);
INSERT INTO `sys_role_permission` VALUES (2, 10);
INSERT INTO `sys_role_permission` VALUES (1, 11);
INSERT INTO `sys_role_permission` VALUES (1, 12);
INSERT INTO `sys_role_permission` VALUES (1, 13);
INSERT INTO `sys_role_permission` VALUES (1, 14);
INSERT INTO `sys_role_permission` VALUES (2, 14);
INSERT INTO `sys_role_permission` VALUES (1, 15);
INSERT INTO `sys_role_permission` VALUES (2, 15);
INSERT INTO `sys_role_permission` VALUES (1, 16);
INSERT INTO `sys_role_permission` VALUES (2, 16);
INSERT INTO `sys_role_permission` VALUES (1, 17);
INSERT INTO `sys_role_permission` VALUES (1, 18);
INSERT INTO `sys_role_permission` VALUES (1, 19);
INSERT INTO `sys_role_permission` VALUES (1, 20);
INSERT INTO `sys_role_permission` VALUES (1, 21);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `status` tinyint(0) NOT NULL DEFAULT 1 COMMENT '状态（0停用 1正常）',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uniq_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin_captain', 'e10adc3949ba59abbe56e057f20f883e', 1, '2025-04-27 14:01:30');
INSERT INTO `sys_user` VALUES (2, 'player1', 'e10adc3949ba59abbe56e057f20f883e', 1, '2025-04-27 14:01:30');
INSERT INTO `sys_user` VALUES (3, 'player2', 'e10adc3949ba59abbe56e057f20f883e', 1, '2025-04-27 14:01:30');

-- ----------------------------
-- Table structure for sys_user_position
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_position`;
CREATE TABLE `sys_user_position`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `position_id` int(0) NOT NULL COMMENT '职位ID',
  PRIMARY KEY (`user_id`, `position_id`) USING BTREE,
  INDEX `position_id`(`position_id`) USING BTREE,
  CONSTRAINT `sys_user_position_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_user_position_ibfk_2` FOREIGN KEY (`position_id`) REFERENCES `team_position` (`position_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户职位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_position
-- ----------------------------
INSERT INTO `sys_user_position` VALUES (1, 1);
INSERT INTO `sys_user_position` VALUES (2, 2);
INSERT INTO `sys_user_position` VALUES (3, 2);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(0) NOT NULL COMMENT '用户ID',
  `role_id` int(0) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 2);

-- ----------------------------
-- Table structure for team_position
-- ----------------------------
DROP TABLE IF EXISTS `team_position`;
CREATE TABLE `team_position`  (
  `position_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `position_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职位名称',
  `position_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职位代码',
  PRIMARY KEY (`position_id`) USING BTREE,
  UNIQUE INDEX `uniq_pos_code`(`position_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '球队职位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_position
-- ----------------------------
INSERT INTO `team_position` VALUES (1, '队长', 'captain');
INSERT INTO `team_position` VALUES (2, '队员', 'player');

SET FOREIGN_KEY_CHECKS = 1;
