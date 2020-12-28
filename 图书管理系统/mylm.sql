/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3306
 Source Schema         : mylm

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 29/10/2020 21:48:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookNumber` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
  `ISBN` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ISBN',
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `translator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '译者',
  `publishHouseNumber` int(3) NULL DEFAULT NULL COMMENT '出版社编号',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `callNumber` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '索书号',
  `imgLocation` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片位置',
  `classificationNumber` int(11) NOT NULL COMMENT '图书分类编号',
  `seClassification` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二级分类',
  `typeCirculationNumber` int(11) NOT NULL COMMENT '图书流通类型编号',
  `borrowTimes` int(7) NOT NULL COMMENT '借出次数',
  `bookStatusNumber` int(8) NOT NULL COMMENT '图书状态编号',
  `entryDate` date NOT NULL COMMENT '入库日期',
  `publishYear` year NULL DEFAULT NULL COMMENT '出版年份',
  `typeBook_CFNumber` int(2) NOT NULL COMMENT '图书类型编号',
  PRIMARY KEY (`bookNumber`) USING BTREE,
  INDEX `book_ibfk_1`(`classificationNumber`) USING BTREE,
  INDEX `book_ibfk_3`(`bookStatusNumber`) USING BTREE,
  INDEX `typeBook_CFNumber`(`typeBook_CFNumber`) USING BTREE,
  INDEX `typeCirculationNumber`(`typeCirculationNumber`) USING BTREE,
  INDEX `publishHouseNumber`(`publishHouseNumber`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`classificationNumber`) REFERENCES `classification_book` (`classificationNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `book_ibfk_3` FOREIGN KEY (`bookStatusNumber`) REFERENCES `status_book` (`bookStatusNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `book_ibfk_4` FOREIGN KEY (`typeBook_CFNumber`) REFERENCES `typebook_cf` (`typeBook_CFNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `book_ibfk_5` FOREIGN KEY (`typeCirculationNumber`) REFERENCES `typecirculation_book` (`typeCirculationNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `book_ibfk_6` FOREIGN KEY (`publishHouseNumber`) REFERENCES `publishhouse` (`publishHouseNumber`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1602767529490', '9787515904562', '希腊罗马神话', '(美)詹姆斯·鲍德温', '何雨舟', 445, '', 'I126', NULL, 9, NULL, 1, 8, 2, '2020-10-15', 1939, 1);
INSERT INTO `book` VALUES ('1603272799388', '9787515908861', '木偶奇遇记', '卡洛', '阿巴', 26, '', 'I124', NULL, 9, NULL, 4, 0, 1, '2020-10-21', 2013, 1);
INSERT INTO `book` VALUES ('1603272928178', '9787515907895', '马克思主义基本原理概论', '马克思', '', 23, '', 'A129', NULL, 1, NULL, 3, 0, 2, '2020-10-21', 2018, 1);
INSERT INTO `book` VALUES ('1603272984786', '9787515907896', '数据结构', '阿猫', '', 1, '', 'G128', NULL, 7, NULL, 2, 3, 4, '2020-10-21', 1989, 1);
INSERT INTO `book` VALUES ('1603273101075', '9787515908923', '唐骏日记', '唐骏', '', 8, '这是一本唐骏日记', 'I125', NULL, 9, NULL, 2, 2, 3, '2020-10-21', 1995, 1);
INSERT INTO `book` VALUES ('1603956706053', '9787515908862', '木偶奇遇记', '阿猫', '', 1, '', '', NULL, 1, NULL, 2, 0, 2, '2020-10-29', 2020, 1);
INSERT INTO `book` VALUES ('160395675618001', '9787302446699', '我是1', '1', '1', 1, '', '', NULL, 1, NULL, 2, 1, 2, '2020-10-29', 2017, 1);
INSERT INTO `book` VALUES ('160395675618002', '9787302446699', '我是1', '1', '1', 1, '', '', NULL, 1, NULL, 2, 0, 2, '2020-10-29', 2017, 1);
INSERT INTO `book` VALUES ('160395675618111', '9787806018590', '我是2', '2', '2', 1, '我是一本书2', 'A2', NULL, 1, NULL, 2, 0, 3, '2020-10-29', 2006, 1);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `borrowNumber` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借阅编号',
  `bookNumber` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
  `readerNumber` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者编号',
  `borrowDate` date NOT NULL COMMENT '借阅日期',
  `returnDate` date NOT NULL COMMENT '到期日期',
  `borrowStatusNumber` int(3) NOT NULL COMMENT '借阅状态编号',
  `borrowingsTimes` int(3) NOT NULL COMMENT '剩余借阅次数',
  `endDate` date NULL DEFAULT NULL COMMENT '归还日期',
  PRIMARY KEY (`borrowNumber`) USING BTREE,
  INDEX `borrow_ibfk_1`(`bookNumber`) USING BTREE,
  INDEX `borrow_ibfk_2`(`readerNumber`) USING BTREE,
  INDEX `borrowStatusNumber`(`borrowStatusNumber`) USING BTREE,
  CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`bookNumber`) REFERENCES `book` (`bookNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`readerNumber`) REFERENCES `reader` (`readerNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `borrow_ibfk_3` FOREIGN KEY (`borrowStatusNumber`) REFERENCES `statusborrow` (`statusBorrowNumber`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('1603273450398', '1603272984786', '20001', '2020-10-21', '2020-11-20', 3, 1, '2020-10-21');
INSERT INTO `borrow` VALUES ('1603273471794', '1603273101075', '20001', '2020-10-21', '2020-11-20', 3, 1, '2020-10-21');
INSERT INTO `borrow` VALUES ('1603273502713', '1603273101075', '20006', '2020-10-21', '2020-12-20', 1, 2, '0002-11-30');
INSERT INTO `borrow` VALUES ('1603350084358', '1603272984786', '20001', '2020-10-22', '2020-11-21', 1, 2, '0002-11-30');
INSERT INTO `borrow` VALUES ('1603957017200', '160395675618001', '20001', '2020-10-29', '2020-11-28', 3, 1, '2020-10-29');

-- ----------------------------
-- Table structure for classification_book
-- ----------------------------
DROP TABLE IF EXISTS `classification_book`;
CREATE TABLE `classification_book`  (
  `classificationNumber` int(2) NOT NULL COMMENT '图书分类编号',
  `classificationLetter` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字母',
  `classificationType` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书分类',
  PRIMARY KEY (`classificationNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classification_book
-- ----------------------------
INSERT INTO `classification_book` VALUES (1, 'a', '马克思主义、列宁主义、毛泽东思想、邓小平理论');
INSERT INTO `classification_book` VALUES (2, 'b', '哲学、宗教');
INSERT INTO `classification_book` VALUES (3, 'c', '社会科学总论');
INSERT INTO `classification_book` VALUES (4, 'd', '政治、法律');
INSERT INTO `classification_book` VALUES (5, 'e', '军事');
INSERT INTO `classification_book` VALUES (6, 'f', '经济');
INSERT INTO `classification_book` VALUES (7, 'g', '文化、科学、教育、体育');
INSERT INTO `classification_book` VALUES (8, 'h', '语言、文字');
INSERT INTO `classification_book` VALUES (9, 'i', '文学');
INSERT INTO `classification_book` VALUES (10, 'j', '艺术');
INSERT INTO `classification_book` VALUES (11, 'k', '历史、地理');
INSERT INTO `classification_book` VALUES (12, 'n', '自然科学总论');
INSERT INTO `classification_book` VALUES (13, 'o', '数理科学和化学');
INSERT INTO `classification_book` VALUES (14, 'p', '天文学、地球科学');
INSERT INTO `classification_book` VALUES (15, 'q', '生物科学');
INSERT INTO `classification_book` VALUES (16, 'r', '医药、卫生');
INSERT INTO `classification_book` VALUES (17, 's', '农业科学');
INSERT INTO `classification_book` VALUES (18, 't', '工业技术');
INSERT INTO `classification_book` VALUES (19, 'u', '交通运输');
INSERT INTO `classification_book` VALUES (20, 'v', '航空、航天');
INSERT INTO `classification_book` VALUES (21, 'x', '环境科学、劳动保护科学（安全科学）');
INSERT INTO `classification_book` VALUES (22, 'z', '综合性图书');

-- ----------------------------
-- Table structure for location_book
-- ----------------------------
DROP TABLE IF EXISTS `location_book`;
CREATE TABLE `location_book`  (
  `bookNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
  `location` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存放位置',
  PRIMARY KEY (`bookNumber`) USING BTREE,
  CONSTRAINT `location_book_ibfk_1` FOREIGN KEY (`bookNumber`) REFERENCES `book` (`bookNumber`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of location_book
-- ----------------------------
INSERT INTO `location_book` VALUES ('00000001', '二楼A架');
INSERT INTO `location_book` VALUES ('00000002', '三楼B架');
INSERT INTO `location_book` VALUES ('00000003', '二楼A架');
INSERT INTO `location_book` VALUES ('00000004', '五楼E架');
INSERT INTO `location_book` VALUES ('00000005', '一楼C架');

-- ----------------------------
-- Table structure for publishhouse
-- ----------------------------
DROP TABLE IF EXISTS `publishhouse`;
CREATE TABLE `publishhouse`  (
  `publishHouseNumber` int(3) NOT NULL COMMENT '出版社编号',
  `publishHouseName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社名称',
  `letter` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字母',
  PRIMARY KEY (`publishHouseNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of publishhouse
-- ----------------------------
INSERT INTO `publishhouse` VALUES (1, '安徽大学出版社', 'a');
INSERT INTO `publishhouse` VALUES (2, '安徽教育出版社', 'a');
INSERT INTO `publishhouse` VALUES (3, '安徽科学技术出版社', 'a');
INSERT INTO `publishhouse` VALUES (4, '安徽美术出版社', 'a');
INSERT INTO `publishhouse` VALUES (5, '安徽人民出版社', 'a');
INSERT INTO `publishhouse` VALUES (6, '安徽少年儿童出版社', 'a');
INSERT INTO `publishhouse` VALUES (7, '安徽文艺出版社', 'a');
INSERT INTO `publishhouse` VALUES (8, '巴蜀书社', 'b');
INSERT INTO `publishhouse` VALUES (9, '白山出版社', 'b');
INSERT INTO `publishhouse` VALUES (10, '百花文艺出版社', 'b');
INSERT INTO `publishhouse` VALUES (11, '百花洲文艺出版社', 'b');
INSERT INTO `publishhouse` VALUES (12, '北方妇女儿童出版社', 'b');
INSERT INTO `publishhouse` VALUES (13, '北方文艺出版社', 'b');
INSERT INTO `publishhouse` VALUES (14, '北京出版社', 'b');
INSERT INTO `publishhouse` VALUES (15, '北京大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (16, '北京大学医学出版社', 'b');
INSERT INTO `publishhouse` VALUES (17, '北京工业大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (18, '北京工艺美术出版社', 'b');
INSERT INTO `publishhouse` VALUES (19, '北京古籍出版社', 'b');
INSERT INTO `publishhouse` VALUES (20, '北京广播学院出版社', 'b');
INSERT INTO `publishhouse` VALUES (21, '北京航空航天大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (22, '北京交通大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (23, '北京教育出版社', 'b');
INSERT INTO `publishhouse` VALUES (24, '北京科学技术出版社', 'b');
INSERT INTO `publishhouse` VALUES (25, '北京理工大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (26, '北京联合出版公司', 'b');
INSERT INTO `publishhouse` VALUES (27, '北京美术摄影出版社', 'b');
INSERT INTO `publishhouse` VALUES (28, '北京少年儿童出版社', 'b');
INSERT INTO `publishhouse` VALUES (29, '北京师范大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (30, '北京十月文艺出版社', 'b');
INSERT INTO `publishhouse` VALUES (31, '北京体育大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (32, '北京图书馆出版社', 'b');
INSERT INTO `publishhouse` VALUES (33, '北京燕山出版社', 'b');
INSERT INTO `publishhouse` VALUES (34, '北京邮电大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (35, '北京语言大学出版社', 'b');
INSERT INTO `publishhouse` VALUES (36, '北岳文艺出版社', 'b');
INSERT INTO `publishhouse` VALUES (37, '兵器工业出版社', 'b');
INSERT INTO `publishhouse` VALUES (38, '测绘出版社', 'c');
INSERT INTO `publishhouse` VALUES (39, '朝华出版社', 'c');
INSERT INTO `publishhouse` VALUES (40, '晨光出版社', 'c');
INSERT INTO `publishhouse` VALUES (41, '成都地图出版社', 'c');
INSERT INTO `publishhouse` VALUES (42, '成都科技大学出版社', 'c');
INSERT INTO `publishhouse` VALUES (43, '成都时代出版社', 'c');
INSERT INTO `publishhouse` VALUES (44, '崇文书局', 'c');
INSERT INTO `publishhouse` VALUES (45, '春风文艺出版社', 'c');
INSERT INTO `publishhouse` VALUES (46, '长城出版社', 'c');
INSERT INTO `publishhouse` VALUES (47, '长春出版社', 'c');
INSERT INTO `publishhouse` VALUES (48, '长虹出版公司', 'c');
INSERT INTO `publishhouse` VALUES (49, '长江出版社', 'c');
INSERT INTO `publishhouse` VALUES (50, '长江文艺出版社', 'c');
INSERT INTO `publishhouse` VALUES (51, '长征出版社', 'c');
INSERT INTO `publishhouse` VALUES (52, '大连出版社', 'd');
INSERT INTO `publishhouse` VALUES (53, '大连海事大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (54, '大连理工大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (55, '大象出版社', 'd');
INSERT INTO `publishhouse` VALUES (56, '大众文艺出版社', 'd');
INSERT INTO `publishhouse` VALUES (57, '当代世界出版社', 'd');
INSERT INTO `publishhouse` VALUES (58, '当代中国出版社', 'd');
INSERT INTO `publishhouse` VALUES (59, '党建读物出版社', 'd');
INSERT INTO `publishhouse` VALUES (60, '德宏民族出版社', 'd');
INSERT INTO `publishhouse` VALUES (61, '地震出版社', 'd');
INSERT INTO `publishhouse` VALUES (62, '地质出版社', 'd');
INSERT INTO `publishhouse` VALUES (63, '第二军医大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (64, '第四军医大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (65, '电子工业出版社', 'd');
INSERT INTO `publishhouse` VALUES (66, '电子科技大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (67, '东北财经大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (68, '东北大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (69, '东北林业大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (70, '东北师范大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (71, '东方出版社', 'd');
INSERT INTO `publishhouse` VALUES (72, '东方出版中心', 'd');
INSERT INTO `publishhouse` VALUES (73, '东华大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (74, '东南大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (75, '对外经济贸易大学出版社', 'd');
INSERT INTO `publishhouse` VALUES (76, '敦煌文艺出版社', 'd');
INSERT INTO `publishhouse` VALUES (77, '二十一世纪出版社', 'e');
INSERT INTO `publishhouse` VALUES (78, '法律出版社', 'f');
INSERT INTO `publishhouse` VALUES (79, '方志出版社', 'f');
INSERT INTO `publishhouse` VALUES (80, '福建教育出版社', 'f');
INSERT INTO `publishhouse` VALUES (81, '福建科学技术出版社', 'f');
INSERT INTO `publishhouse` VALUES (82, '福建美术出版社', 'f');
INSERT INTO `publishhouse` VALUES (83, '福建人民出版社', 'f');
INSERT INTO `publishhouse` VALUES (84, '福建少年儿童出版社', 'f');
INSERT INTO `publishhouse` VALUES (85, '福建省地图出版社', 'f');
INSERT INTO `publishhouse` VALUES (86, '复旦大学出版社', 'f');
INSERT INTO `publishhouse` VALUES (87, '甘肃教育出版社', 'g');
INSERT INTO `publishhouse` VALUES (88, '甘肃科学技术出版社', 'g');
INSERT INTO `publishhouse` VALUES (89, '甘肃民族出版社', 'g');
INSERT INTO `publishhouse` VALUES (90, '甘肃人民出版社', 'g');
INSERT INTO `publishhouse` VALUES (91, '甘肃人民美术出版社', 'g');
INSERT INTO `publishhouse` VALUES (92, '甘肃少年儿童出版社', 'g');
INSERT INTO `publishhouse` VALUES (93, '甘肃文化出版社', 'g');
INSERT INTO `publishhouse` VALUES (94, '高等教育出版社', 'g');
INSERT INTO `publishhouse` VALUES (95, '古吴轩出版社', 'g');
INSERT INTO `publishhouse` VALUES (96, '光明日报出版社', 'g');
INSERT INTO `publishhouse` VALUES (97, '广东高等教育出版社', 'g');
INSERT INTO `publishhouse` VALUES (98, '广东教育出版社', 'g');
INSERT INTO `publishhouse` VALUES (99, '广东经济出版社', 'g');
INSERT INTO `publishhouse` VALUES (100, '广东科技出版社', 'g');
INSERT INTO `publishhouse` VALUES (101, '广东旅游出版社', 'g');
INSERT INTO `publishhouse` VALUES (102, '广东人民出版社', 'g');
INSERT INTO `publishhouse` VALUES (103, '广东省地图出版社', 'g');
INSERT INTO `publishhouse` VALUES (104, '广陵书社', 'g');
INSERT INTO `publishhouse` VALUES (105, '广西教育出版社', 'g');
INSERT INTO `publishhouse` VALUES (106, '广西科学技术出版社', 'g');
INSERT INTO `publishhouse` VALUES (107, '广西美术出版社', 'g');
INSERT INTO `publishhouse` VALUES (108, '广西民族出版社', 'g');
INSERT INTO `publishhouse` VALUES (109, '广西人民出版社', 'g');
INSERT INTO `publishhouse` VALUES (110, '广西师范大学出版社', 'g');
INSERT INTO `publishhouse` VALUES (111, '广州出版社', 'g');
INSERT INTO `publishhouse` VALUES (112, '贵州教育出版社', 'g');
INSERT INTO `publishhouse` VALUES (113, '贵州科技出版社', 'g');
INSERT INTO `publishhouse` VALUES (114, '贵州民族出版社', 'g');
INSERT INTO `publishhouse` VALUES (115, '贵州人民出版社', 'g');
INSERT INTO `publishhouse` VALUES (116, '国防大学出版社', 'g');
INSERT INTO `publishhouse` VALUES (117, '国防工业出版社', 'g');
INSERT INTO `publishhouse` VALUES (118, '国防科技大学出版社', 'g');
INSERT INTO `publishhouse` VALUES (119, '国际文化出版公司', 'g');
INSERT INTO `publishhouse` VALUES (120, '国家行政学院出版社', 'g');
INSERT INTO `publishhouse` VALUES (121, '哈尔滨出版社', 'h');
INSERT INTO `publishhouse` VALUES (122, '哈尔滨地图出版社', 'h');
INSERT INTO `publishhouse` VALUES (123, '哈尔滨工程大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (124, '哈尔滨工业大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (125, '海潮出版社', 'h');
INSERT INTO `publishhouse` VALUES (126, '海潮摄影艺术出版社', 'h');
INSERT INTO `publishhouse` VALUES (127, '海风出版社', 'h');
INSERT INTO `publishhouse` VALUES (128, '海南出版社', 'h');
INSERT INTO `publishhouse` VALUES (129, '海天出版社', 'h');
INSERT INTO `publishhouse` VALUES (130, '海豚出版社', 'h');
INSERT INTO `publishhouse` VALUES (131, '海峡文艺出版社', 'h');
INSERT INTO `publishhouse` VALUES (132, '海燕出版社', 'h');
INSERT INTO `publishhouse` VALUES (133, '海洋出版社', 'h');
INSERT INTO `publishhouse` VALUES (134, '汉语大词典出版社', 'h');
INSERT INTO `publishhouse` VALUES (135, '杭州出版社', 'h');
INSERT INTO `publishhouse` VALUES (136, '航空工业出版社', 'h');
INSERT INTO `publishhouse` VALUES (137, '合肥工业大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (138, '河北大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (139, '河北教育出版社', 'h');
INSERT INTO `publishhouse` VALUES (140, '河北科学技术出版社', 'h');
INSERT INTO `publishhouse` VALUES (141, '河北美术出版社', 'h');
INSERT INTO `publishhouse` VALUES (142, '河北人民出版社', 'h');
INSERT INTO `publishhouse` VALUES (143, '河北少年儿童出版社', 'h');
INSERT INTO `publishhouse` VALUES (144, '河海大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (145, '河南大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (146, '河南科学技术出版社', 'h');
INSERT INTO `publishhouse` VALUES (147, '河南美术出版社', 'h');
INSERT INTO `publishhouse` VALUES (148, '河南人民出版社', 'h');
INSERT INTO `publishhouse` VALUES (149, '河南文艺出版社', 'h');
INSERT INTO `publishhouse` VALUES (150, '黑龙江朝鲜民族出版社', 'h');
INSERT INTO `publishhouse` VALUES (151, '黑龙江教育出版社', 'h');
INSERT INTO `publishhouse` VALUES (152, '黑龙江科学技术出版社', 'h');
INSERT INTO `publishhouse` VALUES (153, '黑龙江美术出版社', 'h');
INSERT INTO `publishhouse` VALUES (154, '黑龙江人民出版社', 'h');
INSERT INTO `publishhouse` VALUES (155, '黑龙江少年儿童出版社', 'h');
INSERT INTO `publishhouse` VALUES (156, '红旗出版社', 'h');
INSERT INTO `publishhouse` VALUES (157, '湖北教育出版社', 'h');
INSERT INTO `publishhouse` VALUES (158, '湖北科学技术出版社', 'h');
INSERT INTO `publishhouse` VALUES (159, '湖北美术出版社', 'h');
INSERT INTO `publishhouse` VALUES (160, '湖北人民出版社', 'h');
INSERT INTO `publishhouse` VALUES (161, '湖北少年儿童出版社', 'h');
INSERT INTO `publishhouse` VALUES (162, '湖南大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (163, '湖南地图出版社', 'h');
INSERT INTO `publishhouse` VALUES (164, '湖南教育出版社', 'h');
INSERT INTO `publishhouse` VALUES (165, '湖南科学技术出版社', 'h');
INSERT INTO `publishhouse` VALUES (166, '湖南美术出版社', 'h');
INSERT INTO `publishhouse` VALUES (167, '湖南人民出版社', 'h');
INSERT INTO `publishhouse` VALUES (168, '湖南少年儿童出版社', 'h');
INSERT INTO `publishhouse` VALUES (169, '湖南师范大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (170, '湖南文艺出版社', 'h');
INSERT INTO `publishhouse` VALUES (171, '花城出版社', 'h');
INSERT INTO `publishhouse` VALUES (172, '花山文艺出版社', 'h');
INSERT INTO `publishhouse` VALUES (173, '华东理工大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (174, '华东师范大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (175, '华乐出版社', 'h');
INSERT INTO `publishhouse` VALUES (176, '华龄出版社', 'h');
INSERT INTO `publishhouse` VALUES (177, '华南理工大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (178, '华文出版社', 'h');
INSERT INTO `publishhouse` VALUES (179, '华夏出版社', 'h');
INSERT INTO `publishhouse` VALUES (180, '华艺出版社', 'h');
INSERT INTO `publishhouse` VALUES (181, '华语教学出版社', 'h');
INSERT INTO `publishhouse` VALUES (182, '华中理工大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (183, '华中师范大学出版社', 'h');
INSERT INTO `publishhouse` VALUES (184, '化学工业出版社', 'h');
INSERT INTO `publishhouse` VALUES (185, '黄河出版社', 'h');
INSERT INTO `publishhouse` VALUES (186, '黄河水利出版社', 'h');
INSERT INTO `publishhouse` VALUES (187, '黄山书社', 'h');
INSERT INTO `publishhouse` VALUES (188, '机械工业出版社', 'j');
INSERT INTO `publishhouse` VALUES (189, '吉林出版集团', 'j');
INSERT INTO `publishhouse` VALUES (190, '吉林大学出版社', 'j');
INSERT INTO `publishhouse` VALUES (191, '吉林教育出版社', 'j');
INSERT INTO `publishhouse` VALUES (192, '吉林科学技术出版社', 'j');
INSERT INTO `publishhouse` VALUES (193, '吉林美术出版社', 'j');
INSERT INTO `publishhouse` VALUES (194, '吉林人民出版社', 'j');
INSERT INTO `publishhouse` VALUES (195, '吉林摄影出版社', 'j');
INSERT INTO `publishhouse` VALUES (196, '吉林文史出版社', 'j');
INSERT INTO `publishhouse` VALUES (197, '济南出版社', 'j');
INSERT INTO `publishhouse` VALUES (198, '暨南大学出版社', 'j');
INSERT INTO `publishhouse` VALUES (199, '江苏古籍出版社', 'j');
INSERT INTO `publishhouse` VALUES (200, '江苏教育出版社', 'j');
INSERT INTO `publishhouse` VALUES (201, '江苏科学技术出版社', 'j');
INSERT INTO `publishhouse` VALUES (202, '江苏美术出版社', 'j');
INSERT INTO `publishhouse` VALUES (203, '江苏人民出版社', 'j');
INSERT INTO `publishhouse` VALUES (204, '江苏少年儿童出版社', 'j');
INSERT INTO `publishhouse` VALUES (205, '江苏文艺出版社', 'j');
INSERT INTO `publishhouse` VALUES (206, '江西高校出版社', 'j');
INSERT INTO `publishhouse` VALUES (207, '江西教育出版社', 'j');
INSERT INTO `publishhouse` VALUES (208, '江西科学技术出版社', 'j');
INSERT INTO `publishhouse` VALUES (209, '江西美术出版社', 'j');
INSERT INTO `publishhouse` VALUES (210, '江西人民出版社', 'j');
INSERT INTO `publishhouse` VALUES (211, '教育科学出版社', 'j');
INSERT INTO `publishhouse` VALUES (212, '接力出版社', 'j');
INSERT INTO `publishhouse` VALUES (213, '解放军出版社', 'j');
INSERT INTO `publishhouse` VALUES (214, '解放军文艺出版社', 'j');
INSERT INTO `publishhouse` VALUES (215, '金城出版社', 'j');
INSERT INTO `publishhouse` VALUES (216, '金盾出版社', 'j');
INSERT INTO `publishhouse` VALUES (217, '京华出版社', 'j');
INSERT INTO `publishhouse` VALUES (218, '经济管理出版社', 'j');
INSERT INTO `publishhouse` VALUES (219, '经济科学出版社', 'j');
INSERT INTO `publishhouse` VALUES (220, '经济日报出版社', 'j');
INSERT INTO `publishhouse` VALUES (221, '九州出版社', 'j');
INSERT INTO `publishhouse` VALUES (222, '军事科学出版社', 'j');
INSERT INTO `publishhouse` VALUES (223, '军事医学科学出版社', 'j');
INSERT INTO `publishhouse` VALUES (224, '军事谊文出版社', 'j');
INSERT INTO `publishhouse` VALUES (225, '喀什维吾尔文出版社', 'k');
INSERT INTO `publishhouse` VALUES (226, '开明出版社', 'k');
INSERT INTO `publishhouse` VALUES (227, '科学出版社', 'k');
INSERT INTO `publishhouse` VALUES (228, '科学技术文献出版社', 'k');
INSERT INTO `publishhouse` VALUES (229, '科学普及出版社', 'k');
INSERT INTO `publishhouse` VALUES (230, '克孜勒苏柯尔克孜文出版社', 'k');
INSERT INTO `publishhouse` VALUES (231, '昆仑出版社', 'k');
INSERT INTO `publishhouse` VALUES (232, '兰州大学出版社', 'l');
INSERT INTO `publishhouse` VALUES (233, '兰州大学出版社', 'l');
INSERT INTO `publishhouse` VALUES (234, '蓝天出版社', 'l');
INSERT INTO `publishhouse` VALUES (235, '漓江出版社', 'l');
INSERT INTO `publishhouse` VALUES (236, '立信会计出版社', 'l');
INSERT INTO `publishhouse` VALUES (237, '辽海出版社', 'l');
INSERT INTO `publishhouse` VALUES (238, '辽宁大学出版社', 'l');
INSERT INTO `publishhouse` VALUES (239, '辽宁教育出版社', 'l');
INSERT INTO `publishhouse` VALUES (240, '辽宁科学技术出版社', 'l');
INSERT INTO `publishhouse` VALUES (241, '辽宁美术出版社', 'l');
INSERT INTO `publishhouse` VALUES (242, '辽宁民族出版社', 'l');
INSERT INTO `publishhouse` VALUES (243, '辽宁人民出版社', 'l');
INSERT INTO `publishhouse` VALUES (244, '辽宁少年儿童出版社', 'l');
INSERT INTO `publishhouse` VALUES (245, '辽宁师范大学出版社', 'l');
INSERT INTO `publishhouse` VALUES (246, '岭南美术出版社', 'l');
INSERT INTO `publishhouse` VALUES (247, '龙门书局', 'l');
INSERT INTO `publishhouse` VALUES (248, '鹭江出版社', 'l');
INSERT INTO `publishhouse` VALUES (249, '旅游教育出版社', 'l');
INSERT INTO `publishhouse` VALUES (250, '煤炭工业出版社', 'm');
INSERT INTO `publishhouse` VALUES (251, '民主与建设出版社', 'm');
INSERT INTO `publishhouse` VALUES (252, '民族出版社', 'm');
INSERT INTO `publishhouse` VALUES (253, '明天出版社', 'm');
INSERT INTO `publishhouse` VALUES (254, '南方出版社', 'n');
INSERT INTO `publishhouse` VALUES (255, '南方日报出版社', 'n');
INSERT INTO `publishhouse` VALUES (256, '南海出版公司', 'n');
INSERT INTO `publishhouse` VALUES (257, '南京出版社', 'n');
INSERT INTO `publishhouse` VALUES (258, '南京大学出版社', 'n');
INSERT INTO `publishhouse` VALUES (259, '南京师范大学出版社', 'n');
INSERT INTO `publishhouse` VALUES (260, '南开大学出版社', 'n');
INSERT INTO `publishhouse` VALUES (261, '内蒙古大学出版社', 'n');
INSERT INTO `publishhouse` VALUES (262, '内蒙古教育出版社', 'n');
INSERT INTO `publishhouse` VALUES (263, '内蒙古科学技术出版社', 'n');
INSERT INTO `publishhouse` VALUES (264, '内蒙古人民出版社', 'n');
INSERT INTO `publishhouse` VALUES (265, '内蒙古少年儿童出版社', 'n');
INSERT INTO `publishhouse` VALUES (266, '内蒙古文化出版社', 'n');
INSERT INTO `publishhouse` VALUES (267, '宁波出版社', 'n');
INSERT INTO `publishhouse` VALUES (268, '宁夏人民出版社', 'n');
INSERT INTO `publishhouse` VALUES (269, '宁夏人民教育出版社', 'n');
INSERT INTO `publishhouse` VALUES (270, '宁夏少年儿童出版社', 'n');
INSERT INTO `publishhouse` VALUES (271, '农村读物出版社', 'n');
INSERT INTO `publishhouse` VALUES (272, '齐鲁书社', 'q');
INSERT INTO `publishhouse` VALUES (273, '企业管理出版社', 'q');
INSERT INTO `publishhouse` VALUES (274, '气象出版社', 'q');
INSERT INTO `publishhouse` VALUES (275, '青岛出版社', 'q');
INSERT INTO `publishhouse` VALUES (276, '青海民族出版社', 'q');
INSERT INTO `publishhouse` VALUES (277, '青海人民出版社', 'q');
INSERT INTO `publishhouse` VALUES (278, '清华大学出版社', 'q');
INSERT INTO `publishhouse` VALUES (279, '群言出版社', 'q');
INSERT INTO `publishhouse` VALUES (280, '群众出版社', 'q');
INSERT INTO `publishhouse` VALUES (281, '人民出版社', 'r');
INSERT INTO `publishhouse` VALUES (282, '人民法院出版社', 'r');
INSERT INTO `publishhouse` VALUES (283, '人民交通出版社', 'r');
INSERT INTO `publishhouse` VALUES (284, '人民教育出版社', 'r');
INSERT INTO `publishhouse` VALUES (285, '人民军医出版社', 'r');
INSERT INTO `publishhouse` VALUES (286, '人民美术出版社', 'r');
INSERT INTO `publishhouse` VALUES (287, '人民日报出版社', 'r');
INSERT INTO `publishhouse` VALUES (288, '人民体育出版社', 'r');
INSERT INTO `publishhouse` VALUES (289, '人民卫生出版社', 'r');
INSERT INTO `publishhouse` VALUES (290, '人民文学出版社', 'r');
INSERT INTO `publishhouse` VALUES (291, '人民武警出版社', 'r');
INSERT INTO `publishhouse` VALUES (292, '人民音乐出版社', 'r');
INSERT INTO `publishhouse` VALUES (293, '人民邮电出版社', 'r');
INSERT INTO `publishhouse` VALUES (294, '人民中国出版社', 'r');
INSERT INTO `publishhouse` VALUES (295, '荣宝斋出版社', 'r');
INSERT INTO `publishhouse` VALUES (296, '三环出版社', 's');
INSERT INTO `publishhouse` VALUES (297, '三秦出版社', 's');
INSERT INTO `publishhouse` VALUES (298, '山东大学出版社', 's');
INSERT INTO `publishhouse` VALUES (299, '山东画报出版社', 's');
INSERT INTO `publishhouse` VALUES (300, '山东教育出版社', 's');
INSERT INTO `publishhouse` VALUES (301, '山东科学技术出版社', 's');
INSERT INTO `publishhouse` VALUES (302, '山东美术出版社', 's');
INSERT INTO `publishhouse` VALUES (303, '山东人民出版社', 's');
INSERT INTO `publishhouse` VALUES (304, '山东省地图出版社', 's');
INSERT INTO `publishhouse` VALUES (305, '山东文艺出版社', 's');
INSERT INTO `publishhouse` VALUES (306, '山东友谊出版社', 's');
INSERT INTO `publishhouse` VALUES (307, '山西古籍出版社', 's');
INSERT INTO `publishhouse` VALUES (308, '山西教育出版社', 's');
INSERT INTO `publishhouse` VALUES (309, '山西经济出版社', 's');
INSERT INTO `publishhouse` VALUES (310, '山西科学技术出版社', 's');
INSERT INTO `publishhouse` VALUES (311, '山西人民出版社', 's');
INSERT INTO `publishhouse` VALUES (312, '陕西科学技术出版社', 's');
INSERT INTO `publishhouse` VALUES (313, '陕西旅游出版社', 's');
INSERT INTO `publishhouse` VALUES (314, '陕西人民出版社', 's');
INSERT INTO `publishhouse` VALUES (315, '陕西人民教育出版社', 's');
INSERT INTO `publishhouse` VALUES (316, '陕西人民美术出版社', 's');
INSERT INTO `publishhouse` VALUES (317, '陕西师范大学出版社', 's');
INSERT INTO `publishhouse` VALUES (318, '汕头大学出版社', 's');
INSERT INTO `publishhouse` VALUES (319, '商务印书馆', 's');
INSERT INTO `publishhouse` VALUES (320, '商务印书馆国际有限公司', 's');
INSERT INTO `publishhouse` VALUES (321, '上海财经大学出版社', 's');
INSERT INTO `publishhouse` VALUES (322, '上海辞书出版社', 's');
INSERT INTO `publishhouse` VALUES (323, '上海大学出版社', 's');
INSERT INTO `publishhouse` VALUES (324, '上海古籍出版社', 's');
INSERT INTO `publishhouse` VALUES (325, '上海画报出版社', 's');
INSERT INTO `publishhouse` VALUES (326, '上海交通大学出版社', 's');
INSERT INTO `publishhouse` VALUES (327, '上海教育出版社', 's');
INSERT INTO `publishhouse` VALUES (328, '上海科技教育出版社', 's');
INSERT INTO `publishhouse` VALUES (329, '上海科学技术出版社', 's');
INSERT INTO `publishhouse` VALUES (330, '上海科学技术文献出版社', 's');
INSERT INTO `publishhouse` VALUES (331, '上海科学普及出版社', 's');
INSERT INTO `publishhouse` VALUES (332, '上海人民出版社', 's');
INSERT INTO `publishhouse` VALUES (333, '上海人民美术出版社', 's');
INSERT INTO `publishhouse` VALUES (334, '上海三联书店', 's');
INSERT INTO `publishhouse` VALUES (335, '上海社会科学院出版社', 's');
INSERT INTO `publishhouse` VALUES (336, '上海书店', 's');
INSERT INTO `publishhouse` VALUES (337, '上海书画出版社', 's');
INSERT INTO `publishhouse` VALUES (338, '上海外语教育出版社', 's');
INSERT INTO `publishhouse` VALUES (339, '上海文化出版社', 's');
INSERT INTO `publishhouse` VALUES (340, '上海文艺出版社', 's');
INSERT INTO `publishhouse` VALUES (341, '上海医科大学出版社', 's');
INSERT INTO `publishhouse` VALUES (342, '上海译文出版社', 's');
INSERT INTO `publishhouse` VALUES (343, '上海音乐出版社', 's');
INSERT INTO `publishhouse` VALUES (344, '上海音乐学院出版社', 's');
INSERT INTO `publishhouse` VALUES (345, '上海远东出版社', 's');
INSERT INTO `publishhouse` VALUES (346, '上海中医药大学出版社', 's');
INSERT INTO `publishhouse` VALUES (347, '少年儿童出版社', 's');
INSERT INTO `publishhouse` VALUES (348, '社会科学文献出版社', 's');
INSERT INTO `publishhouse` VALUES (349, '深圳报业集团出版社', 's');
INSERT INTO `publishhouse` VALUES (350, '沈阳出版社', 's');
INSERT INTO `publishhouse` VALUES (351, '生活·读书·新知三联书店', 's');
INSERT INTO `publishhouse` VALUES (352, '石化出版社', 's');
INSERT INTO `publishhouse` VALUES (353, '石油大学出版社', 's');
INSERT INTO `publishhouse` VALUES (354, '石油工业出版社', 's');
INSERT INTO `publishhouse` VALUES (355, '时代文艺出版社', 's');
INSERT INTO `publishhouse` VALUES (356, '时事出版社', 's');
INSERT INTO `publishhouse` VALUES (357, '世界图书出版公司', 's');
INSERT INTO `publishhouse` VALUES (358, '世界知识出版社', 's');
INSERT INTO `publishhouse` VALUES (359, '首都经济贸易大学出版社', 's');
INSERT INTO `publishhouse` VALUES (360, '首都师范大学出版社', 's');
INSERT INTO `publishhouse` VALUES (361, '书海出版社', 's');
INSERT INTO `publishhouse` VALUES (362, '四川辞书出版社', 's');
INSERT INTO `publishhouse` VALUES (363, '四川大学出版社', 's');
INSERT INTO `publishhouse` VALUES (364, '四川教育出版社', 's');
INSERT INTO `publishhouse` VALUES (365, '四川科学技术出版社', 's');
INSERT INTO `publishhouse` VALUES (366, '四川美术出版社', 's');
INSERT INTO `publishhouse` VALUES (367, '四川民族出版社', 's');
INSERT INTO `publishhouse` VALUES (368, '四川人民出版社', 's');
INSERT INTO `publishhouse` VALUES (369, '四川少年儿童出版社', 's');
INSERT INTO `publishhouse` VALUES (370, '四川文艺出版社', 's');
INSERT INTO `publishhouse` VALUES (371, '苏州大学出版社', 's');
INSERT INTO `publishhouse` VALUES (372, '台海出版社', 't');
INSERT INTO `publishhouse` VALUES (373, '太白文艺出版社', 't');
INSERT INTO `publishhouse` VALUES (374, '泰山出版社', 't');
INSERT INTO `publishhouse` VALUES (375, '天地出版社', 't');
INSERT INTO `publishhouse` VALUES (376, '天津大学出版社', 't');
INSERT INTO `publishhouse` VALUES (377, '天津古籍出版社', 't');
INSERT INTO `publishhouse` VALUES (378, '天津教育出版社', 't');
INSERT INTO `publishhouse` VALUES (379, '天津科技翻译出版公司', 't');
INSERT INTO `publishhouse` VALUES (380, '天津科学技术出版社', 't');
INSERT INTO `publishhouse` VALUES (381, '天津人民出版社', 't');
INSERT INTO `publishhouse` VALUES (382, '天津人民美术出版社', 't');
INSERT INTO `publishhouse` VALUES (383, '天津社会科学院出版社', 't');
INSERT INTO `publishhouse` VALUES (384, '天津杨柳青画社', 't');
INSERT INTO `publishhouse` VALUES (385, '同济大学出版社', 't');
INSERT INTO `publishhouse` VALUES (386, '同心出版社', 't');
INSERT INTO `publishhouse` VALUES (387, '团结出版社', 't');
INSERT INTO `publishhouse` VALUES (388, '外国文学出版社', 'w');
INSERT INTO `publishhouse` VALUES (389, '外文出版社', 'w');
INSERT INTO `publishhouse` VALUES (390, '外语教学与研究出版社', 'w');
INSERT INTO `publishhouse` VALUES (391, '万国学术出版社', 'w');
INSERT INTO `publishhouse` VALUES (392, '万卷出版公司', 'w');
INSERT INTO `publishhouse` VALUES (393, '未来出版社', 'w');
INSERT INTO `publishhouse` VALUES (394, '文化艺术出版社', 'w');
INSERT INTO `publishhouse` VALUES (395, '文汇出版社', 'w');
INSERT INTO `publishhouse` VALUES (396, '文津出版社', 'w');
INSERT INTO `publishhouse` VALUES (397, '文物出版社', 'w');
INSERT INTO `publishhouse` VALUES (398, '文心出版社', 'w');
INSERT INTO `publishhouse` VALUES (399, '五洲传播出版社', 'w');
INSERT INTO `publishhouse` VALUES (400, '武汉测绘科技大学出版社', 'w');
INSERT INTO `publishhouse` VALUES (401, '武汉出版社', 'w');
INSERT INTO `publishhouse` VALUES (402, '武汉大学出版社', 'w');
INSERT INTO `publishhouse` VALUES (403, '武汉工业大学出版社', 'w');
INSERT INTO `publishhouse` VALUES (404, '武汉水利电力大学出版社', 'w');
INSERT INTO `publishhouse` VALUES (405, '厦门大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (406, '西安出版社', 'x');
INSERT INTO `publishhouse` VALUES (407, '西安地图出版社', 'x');
INSERT INTO `publishhouse` VALUES (408, '西安电子科技大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (409, '西安交通大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (410, '西北大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (411, '西北工业大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (412, '西北农林科技大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (413, '西藏藏文古籍出版社', 'x');
INSERT INTO `publishhouse` VALUES (414, '西藏人民出版社', 'x');
INSERT INTO `publishhouse` VALUES (415, '西泠出版社', 'x');
INSERT INTO `publishhouse` VALUES (416, '西南财经大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (417, '西南交通大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (418, '西南师范大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (419, '西苑出版社', 'x');
INSERT INTO `publishhouse` VALUES (420, '希望出版社', 'x');
INSERT INTO `publishhouse` VALUES (421, '现代出版社', 'x');
INSERT INTO `publishhouse` VALUES (422, '现代教育出版社', 'x');
INSERT INTO `publishhouse` VALUES (423, '线装书局', 'x');
INSERT INTO `publishhouse` VALUES (424, '新华出版社', 'x');
INSERT INTO `publishhouse` VALUES (425, '新疆大学出版社', 'x');
INSERT INTO `publishhouse` VALUES (426, '新疆教育出版社', 'x');
INSERT INTO `publishhouse` VALUES (427, '新疆科学技术出版社', 'x');
INSERT INTO `publishhouse` VALUES (428, '新疆美术摄影出版社', 'x');
INSERT INTO `publishhouse` VALUES (429, '新疆青少年出版社', 'x');
INSERT INTO `publishhouse` VALUES (430, '新疆人民出版社', 'x');
INSERT INTO `publishhouse` VALUES (431, '新疆人民卫生出版社', 'x');
INSERT INTO `publishhouse` VALUES (432, '新蕾出版社', 'x');
INSERT INTO `publishhouse` VALUES (433, '新时代出版社', 'x');
INSERT INTO `publishhouse` VALUES (434, '新世纪出版社', 'x');
INSERT INTO `publishhouse` VALUES (435, '新世界出版社', 'x');
INSERT INTO `publishhouse` VALUES (436, '新星出版社', 'x');
INSERT INTO `publishhouse` VALUES (437, '星球地图出版社', 'x');
INSERT INTO `publishhouse` VALUES (438, '学林出版社', 'x');
INSERT INTO `publishhouse` VALUES (439, '学习出版社', 'x');
INSERT INTO `publishhouse` VALUES (440, '学苑出版社', 'x');
INSERT INTO `publishhouse` VALUES (441, '延边大学出版社', 'y');
INSERT INTO `publishhouse` VALUES (442, '延边教育出版社', 'y');
INSERT INTO `publishhouse` VALUES (443, '延边人民出版社', 'y');
INSERT INTO `publishhouse` VALUES (444, '研究出版社', 'y');
INSERT INTO `publishhouse` VALUES (445, '羊城晚报出版社', 'y');
INSERT INTO `publishhouse` VALUES (446, '冶金工业出版社', 'y');
INSERT INTO `publishhouse` VALUES (447, '伊犁人民出版社', 'y');
INSERT INTO `publishhouse` VALUES (448, '译林出版社', 'y');
INSERT INTO `publishhouse` VALUES (449, '印刷工业出版社', 'y');
INSERT INTO `publishhouse` VALUES (450, '语文出版社', 'y');
INSERT INTO `publishhouse` VALUES (451, '原子能出版社', 'y');
INSERT INTO `publishhouse` VALUES (452, '远方出版社', 'y');
INSERT INTO `publishhouse` VALUES (453, '岳麓书社', 'y');
INSERT INTO `publishhouse` VALUES (454, '云南大学出版社', 'y');
INSERT INTO `publishhouse` VALUES (455, '云南教育出版社', 'y');
INSERT INTO `publishhouse` VALUES (456, '云南科学技术出版社', 'y');
INSERT INTO `publishhouse` VALUES (457, '云南美术出版社', 'y');
INSERT INTO `publishhouse` VALUES (458, '云南民族出版社', 'y');
INSERT INTO `publishhouse` VALUES (459, '云南人民出版社', 'y');
INSERT INTO `publishhouse` VALUES (460, '浙江大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (461, '浙江古籍出版社', 'z');
INSERT INTO `publishhouse` VALUES (462, '浙江教育出版社', 'z');
INSERT INTO `publishhouse` VALUES (463, '浙江科学技术出版社', 'z');
INSERT INTO `publishhouse` VALUES (464, '浙江人民出版社', 'z');
INSERT INTO `publishhouse` VALUES (465, '浙江人民美术出版社', 'z');
INSERT INTO `publishhouse` VALUES (466, '浙江少年儿童出版社', 'z');
INSERT INTO `publishhouse` VALUES (467, '浙江摄影出版社', 'z');
INSERT INTO `publishhouse` VALUES (468, '浙江文艺出版社', 'z');
INSERT INTO `publishhouse` VALUES (469, '郑州大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (470, '知识产权出版社', 'z');
INSERT INTO `publishhouse` VALUES (471, '知识出版社', 'z');
INSERT INTO `publishhouse` VALUES (472, '中共党史出版社', 'z');
INSERT INTO `publishhouse` VALUES (473, '中共中央党校出版社', 'z');
INSERT INTO `publishhouse` VALUES (474, '中国ISBN中心', 'z');
INSERT INTO `publishhouse` VALUES (475, '中国标准出版社', 'z');
INSERT INTO `publishhouse` VALUES (476, '中国财政经济出版社', 'z');
INSERT INTO `publishhouse` VALUES (477, '中国藏学出版社', 'z');
INSERT INTO `publishhouse` VALUES (478, '中国城市出版社', 'z');
INSERT INTO `publishhouse` VALUES (479, '中国大百科全书出版社', 'z');
INSERT INTO `publishhouse` VALUES (480, '中国大地出版社', 'z');
INSERT INTO `publishhouse` VALUES (481, '中国档案出版社', 'z');
INSERT INTO `publishhouse` VALUES (482, '中国地图出版社', 'z');
INSERT INTO `publishhouse` VALUES (483, '中国地质大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (484, '中国电力出版社', 'z');
INSERT INTO `publishhouse` VALUES (485, '中国电影出版社', 'z');
INSERT INTO `publishhouse` VALUES (486, '中国对外翻译出版公司', 'z');
INSERT INTO `publishhouse` VALUES (487, '中国对外经济贸易大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (488, '中国发展出版社', 'z');
INSERT INTO `publishhouse` VALUES (489, '中国法制出版社', 'z');
INSERT INTO `publishhouse` VALUES (490, '中国方正出版社', 'z');
INSERT INTO `publishhouse` VALUES (491, '中国纺织出版社', 'z');
INSERT INTO `publishhouse` VALUES (492, '中国福利会出版社', 'z');
INSERT INTO `publishhouse` VALUES (493, '中国妇女出版社', 'z');
INSERT INTO `publishhouse` VALUES (494, '中国工人出版社', 'z');
INSERT INTO `publishhouse` VALUES (495, '中国工商出版社', 'z');
INSERT INTO `publishhouse` VALUES (496, '中国广播电视出版社', 'z');
INSERT INTO `publishhouse` VALUES (497, '中国国际广播出版社', 'z');
INSERT INTO `publishhouse` VALUES (498, '中国海关出版社', 'z');
INSERT INTO `publishhouse` VALUES (499, '中国海洋大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (500, '中国和平出版社', 'z');
INSERT INTO `publishhouse` VALUES (501, '中国华侨出版社', 'z');
INSERT INTO `publishhouse` VALUES (502, '中国画报出版社', 'z');
INSERT INTO `publishhouse` VALUES (503, '中国环境科学出版社', 'z');
INSERT INTO `publishhouse` VALUES (504, '中国计划出版社', 'z');
INSERT INTO `publishhouse` VALUES (505, '中国计量出版社', 'z');
INSERT INTO `publishhouse` VALUES (506, '中国检察出版社', 'z');
INSERT INTO `publishhouse` VALUES (507, '中国建材工业出版社', 'z');
INSERT INTO `publishhouse` VALUES (508, '中国建筑工业出版社', 'z');
INSERT INTO `publishhouse` VALUES (509, '中国金融出版社', 'z');
INSERT INTO `publishhouse` VALUES (510, '中国经济出版社', 'z');
INSERT INTO `publishhouse` VALUES (511, '中国科学技术出版社', 'z');
INSERT INTO `publishhouse` VALUES (512, '中国科学技术大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (513, '中国矿业大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (514, '中国劳动社会保障出版社', 'z');
INSERT INTO `publishhouse` VALUES (515, '中国林业出版社', 'z');
INSERT INTO `publishhouse` VALUES (516, '中国旅游出版社', 'z');
INSERT INTO `publishhouse` VALUES (517, '中国盲文出版社', 'z');
INSERT INTO `publishhouse` VALUES (518, '中国美术出版总社（连环画出版社）', 'z');
INSERT INTO `publishhouse` VALUES (519, '中国美术学院出版社', 'z');
INSERT INTO `publishhouse` VALUES (520, '中国民航出版社', 'z');
INSERT INTO `publishhouse` VALUES (521, '中国民主法制出版社', 'z');
INSERT INTO `publishhouse` VALUES (522, '中国民族摄影艺术出版社', 'z');
INSERT INTO `publishhouse` VALUES (523, '中国农业出版社', 'z');
INSERT INTO `publishhouse` VALUES (524, '中国农业大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (525, '中国农业科学技术出版社', 'z');
INSERT INTO `publishhouse` VALUES (526, '中国青年出版社', 'z');
INSERT INTO `publishhouse` VALUES (527, '中国轻工业出版社', 'z');
INSERT INTO `publishhouse` VALUES (528, '中国人口出版社', 'z');
INSERT INTO `publishhouse` VALUES (529, '中国人民大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (530, '中国人民公安大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (531, '中国人事出版社', 'z');
INSERT INTO `publishhouse` VALUES (532, '中国三峡出版社', 'z');
INSERT INTO `publishhouse` VALUES (533, '中国商业出版社', 'z');
INSERT INTO `publishhouse` VALUES (534, '中国少年儿童出版社', 'z');
INSERT INTO `publishhouse` VALUES (535, '中国社会出版社', 'z');
INSERT INTO `publishhouse` VALUES (536, '中国社会科学出版社', 'z');
INSERT INTO `publishhouse` VALUES (537, '中国摄影出版社', 'z');
INSERT INTO `publishhouse` VALUES (538, '中国石化出版社', 'z');
INSERT INTO `publishhouse` VALUES (539, '中国时代经济出版社', 'z');
INSERT INTO `publishhouse` VALUES (540, '中国世界语出版社', 'z');
INSERT INTO `publishhouse` VALUES (541, '中国市场出版社', 'z');
INSERT INTO `publishhouse` VALUES (542, '中国书店', 'z');
INSERT INTO `publishhouse` VALUES (543, '中国书籍出版社', 'z');
INSERT INTO `publishhouse` VALUES (544, '中国水利水电出版社', 'z');
INSERT INTO `publishhouse` VALUES (545, '中国税务出版社', 'z');
INSERT INTO `publishhouse` VALUES (546, '中国铁道出版社', 'z');
INSERT INTO `publishhouse` VALUES (547, '中国统计出版社', 'z');
INSERT INTO `publishhouse` VALUES (548, '中国文联出版社', 'z');
INSERT INTO `publishhouse` VALUES (549, '中国文史出版社', 'z');
INSERT INTO `publishhouse` VALUES (550, '中国文学出版社', 'z');
INSERT INTO `publishhouse` VALUES (551, '中国物资出版社', 'z');
INSERT INTO `publishhouse` VALUES (552, '中国戏剧出版社', 'z');
INSERT INTO `publishhouse` VALUES (553, '中国协和医科大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (554, '中国言实出版社', 'z');
INSERT INTO `publishhouse` VALUES (555, '中国医药科技出版社', 'z');
INSERT INTO `publishhouse` VALUES (556, '中国友谊出版公司', 'z');
INSERT INTO `publishhouse` VALUES (557, '中国宇航出版社', 'z');
INSERT INTO `publishhouse` VALUES (558, '中国长安出版社', 'z');
INSERT INTO `publishhouse` VALUES (559, '中国政法大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (560, '中国致公出版社', 'z');
INSERT INTO `publishhouse` VALUES (561, '中国中医药出版社', 'z');
INSERT INTO `publishhouse` VALUES (562, '中华地图学社', 'z');
INSERT INTO `publishhouse` VALUES (563, '中华工商联合出版社', 'z');
INSERT INTO `publishhouse` VALUES (564, '中华书局', 'z');
INSERT INTO `publishhouse` VALUES (565, '中南大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (566, '中山大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (567, '中西书局(原百家出版社)', 'z');
INSERT INTO `publishhouse` VALUES (568, '中信出版社', 'z');
INSERT INTO `publishhouse` VALUES (569, '中央编译出版社', 'z');
INSERT INTO `publishhouse` VALUES (570, '中央广播电视大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (571, '中央民族大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (572, '中央文献出版社', 'z');
INSERT INTO `publishhouse` VALUES (573, '中央音乐学院出版社', 'z');
INSERT INTO `publishhouse` VALUES (574, '中医古籍出版社', 'z');
INSERT INTO `publishhouse` VALUES (575, '中原农民出版社', 'z');
INSERT INTO `publishhouse` VALUES (576, '中州古籍出版社', 'z');
INSERT INTO `publishhouse` VALUES (577, '重庆出版社', 'z');
INSERT INTO `publishhouse` VALUES (578, '重庆大学出版社', 'z');
INSERT INTO `publishhouse` VALUES (579, '珠海出版社', 'z');
INSERT INTO `publishhouse` VALUES (580, '紫禁城出版社', 'z');
INSERT INTO `publishhouse` VALUES (581, '宗教文化出版社', 'z');
INSERT INTO `publishhouse` VALUES (582, '作家出版社', 'z');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `readerNumber` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者编号',
  `readerName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者名',
  `registrationDate` date NOT NULL COMMENT '注册日期',
  `expirationDays` int(4) NOT NULL COMMENT '有效期',
  `readerStatusNumber` int(3) NULL DEFAULT 1 COMMENT '读者状态',
  `password` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `readerTypeNumber` int(11) NOT NULL COMMENT '读者类型编号',
  `endDate` date NOT NULL COMMENT '到期日期',
  PRIMARY KEY (`readerNumber`) USING BTREE,
  INDEX `reader_ibfk_2`(`readerTypeNumber`) USING BTREE,
  INDEX `reader_ibfk_1`(`readerStatusNumber`) USING BTREE,
  CONSTRAINT `reader_ibfk_1` FOREIGN KEY (`readerStatusNumber`) REFERENCES `status_reader` (`readerStatusNumber`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `reader_ibfk_2` FOREIGN KEY (`readerTypeNumber`) REFERENCES `type_reader` (`readerTypeNumber`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('20001', '钟蓓', '2020-03-05', 999, 1, '123456', 1, '2022-11-29');
INSERT INTO `reader` VALUES ('20002', '刘晗日', '2020-03-02', 999, 1, '123456', 2, '2022-11-26');
INSERT INTO `reader` VALUES ('20003', '王光熙', '2020-06-09', 80, 1, '123456', 1, '2020-08-28');
INSERT INTO `reader` VALUES ('20004', '林发发', '2020-10-20', 999, 1, '123456', 1, '2023-07-16');
INSERT INTO `reader` VALUES ('20005', '蓝牧绮', '2020-01-08', 5, 2, '123456', 1, '2020-01-13');
INSERT INTO `reader` VALUES ('20006', '萨顶顶', '2020-10-21', 333, 1, '123456', 3, '2021-09-19');
INSERT INTO `reader` VALUES ('20007', '尹安吉', '2020-10-21', 999, 1, '123456', 2, '2023-07-17');
INSERT INTO `reader` VALUES ('20008', '白琪琪', '2020-10-21', 10, 1, '123456', 1, '2020-10-31');

-- ----------------------------
-- Table structure for rold
-- ----------------------------
DROP TABLE IF EXISTS `rold`;
CREATE TABLE `rold`  (
  `roldNumber` int(2) NOT NULL COMMENT '角色编号',
  `roldName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  PRIMARY KEY (`roldNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rold
-- ----------------------------
INSERT INTO `rold` VALUES (1, '普通管理员');
INSERT INTO `rold` VALUES (2, '超级管理员');

-- ----------------------------
-- Table structure for status_book
-- ----------------------------
DROP TABLE IF EXISTS `status_book`;
CREATE TABLE `status_book`  (
  `bookStatusNumber` int(3) NOT NULL COMMENT '图书状态编号',
  `bookStatus` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书状态',
  PRIMARY KEY (`bookStatusNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status_book
-- ----------------------------
INSERT INTO `status_book` VALUES (1, '编目中');
INSERT INTO `status_book` VALUES (2, '在架上');
INSERT INTO `status_book` VALUES (3, '已外借');
INSERT INTO `status_book` VALUES (4, '赔原书中');

-- ----------------------------
-- Table structure for status_reader
-- ----------------------------
DROP TABLE IF EXISTS `status_reader`;
CREATE TABLE `status_reader`  (
  `readerStatusNumber` int(2) NOT NULL COMMENT '读者状态编号',
  `statusName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者状态',
  PRIMARY KEY (`readerStatusNumber`) USING BTREE,
  INDEX `statusName`(`statusName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status_reader
-- ----------------------------
INSERT INTO `status_reader` VALUES (1, '有效');
INSERT INTO `status_reader` VALUES (2, '禁用');

-- ----------------------------
-- Table structure for status_user
-- ----------------------------
DROP TABLE IF EXISTS `status_user`;
CREATE TABLE `status_user`  (
  `userStatusNumber` int(3) NOT NULL COMMENT '用户状态编号',
  `statusName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`userStatusNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status_user
-- ----------------------------
INSERT INTO `status_user` VALUES (1, '有效');
INSERT INTO `status_user` VALUES (2, '禁用');

-- ----------------------------
-- Table structure for statusborrow
-- ----------------------------
DROP TABLE IF EXISTS `statusborrow`;
CREATE TABLE `statusborrow`  (
  `statusBorrowNumber` int(11) NOT NULL COMMENT '借阅状态编号',
  `statusBorrowName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '借阅状态',
  PRIMARY KEY (`statusBorrowNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of statusborrow
-- ----------------------------
INSERT INTO `statusborrow` VALUES (1, '已借出');
INSERT INTO `statusborrow` VALUES (2, '续借中');
INSERT INTO `statusborrow` VALUES (3, '已归还');
INSERT INTO `statusborrow` VALUES (4, '逾期中');
INSERT INTO `statusborrow` VALUES (5, '丢失');

-- ----------------------------
-- Table structure for type_reader
-- ----------------------------
DROP TABLE IF EXISTS `type_reader`;
CREATE TABLE `type_reader`  (
  `readerTypeNumber` int(2) NOT NULL COMMENT '读者类型编号',
  `readerType` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '读者类型',
  `borrowAmount` int(4) NOT NULL COMMENT '借阅本数',
  `borrowDays` int(4) NOT NULL COMMENT '借阅天数',
  `renewTimesTimes` int(2) NOT NULL COMMENT '续借次数',
  `renewDays` int(4) NOT NULL COMMENT '续借天数',
  `renewAmount` int(4) NOT NULL COMMENT '续借本数',
  PRIMARY KEY (`readerTypeNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type_reader
-- ----------------------------
INSERT INTO `type_reader` VALUES (1, '学生', 5, 30, 1, 30, 5);
INSERT INTO `type_reader` VALUES (2, '教师', 10, 45, 2, 45, 10);
INSERT INTO `type_reader` VALUES (3, '职工', 15, 60, 2, 60, 15);

-- ----------------------------
-- Table structure for typebook_cf
-- ----------------------------
DROP TABLE IF EXISTS `typebook_cf`;
CREATE TABLE `typebook_cf`  (
  `typeBook_CFNumber` int(2) NOT NULL COMMENT '图书类型编号',
  `typeBook_CFName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书类型',
  `overdueDailyMoney` float(4, 1) NOT NULL COMMENT '每日逾期金额',
  PRIMARY KEY (`typeBook_CFNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of typebook_cf
-- ----------------------------
INSERT INTO `typebook_cf` VALUES (1, '中文图书', 0.1);
INSERT INTO `typebook_cf` VALUES (2, '外文图书', 0.2);

-- ----------------------------
-- Table structure for typecirculation_book
-- ----------------------------
DROP TABLE IF EXISTS `typecirculation_book`;
CREATE TABLE `typecirculation_book`  (
  `typeCirculationNumber` int(3) NOT NULL COMMENT '图书流通编号',
  `typeCirculationName` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书流通分类',
  PRIMARY KEY (`typeCirculationNumber`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of typecirculation_book
-- ----------------------------
INSERT INTO `typecirculation_book` VALUES (1, '入藏');
INSERT INTO `typecirculation_book` VALUES (2, '外借');
INSERT INTO `typecirculation_book` VALUES (3, '基藏');
INSERT INTO `typecirculation_book` VALUES (4, '内阅');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userNumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `registrationDate` date NOT NULL COMMENT '注册日期',
  `expirationDays` int(4) NOT NULL COMMENT '有效期',
  `userStatusNumber` int(3) NULL DEFAULT 1 COMMENT '状态',
  `password` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `roldNumber` int(3) NOT NULL COMMENT '角色',
  `endDate` date NOT NULL COMMENT '到期日期',
  PRIMARY KEY (`userNumber`) USING BTREE,
  INDEX `userStatusNumber`(`userStatusNumber`) USING BTREE,
  INDEX `roldNumber`(`roldNumber`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`userStatusNumber`) REFERENCES `status_user` (`userStatusNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`roldNumber`) REFERENCES `rold` (`roldNumber`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1000001', '吴怀蕊', '2020-03-04', 999, 1, '123456', 1, '2022-11-28');
INSERT INTO `user` VALUES ('1000002', '白凡儿', '2020-03-05', 999, 1, '123456', 2, '2022-11-29');
INSERT INTO `user` VALUES ('1000003', '夏真', '2020-03-21', 999, 1, '123456', 1, '2022-12-15');
INSERT INTO `user` VALUES ('1000004', '钱吉星', '2020-04-05', 999, 1, '123456', 2, '2022-12-30');
INSERT INTO `user` VALUES ('1000005', '珮瑶', '2020-10-15', 999, 2, '123456', 1, '2022-07-11');
INSERT INTO `user` VALUES ('1000006', '林发发', '2020-10-21', 999, 1, '123456', 1, '2023-07-17');

-- ----------------------------
-- Triggers structure for table borrow
-- ----------------------------
DROP TRIGGER IF EXISTS `borrowTimes`;
delimiter ;;
CREATE TRIGGER `borrowTimes` AFTER INSERT ON `borrow` FOR EACH ROW UPDATE book set borrowTimes=borrowTimes+1 where new.bookNumber=book.bookNumber
;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
