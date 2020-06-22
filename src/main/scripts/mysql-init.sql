-- DROP DATABASE IF EXISTS fileservice;
DROP USER IF EXISTS `file_info_service`@`%`;
-- CREATE DATABASE IF NOT EXISTS fileservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `file_info_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, EXECUTE ON `fileservice`.* TO `file_info_service`@`%`;
FLUSH PRIVILEGES;
