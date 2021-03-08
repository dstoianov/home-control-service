CREATE
DATABASE expencies;

show databases;

GRANT ALL PRIVILEGES ON expencies.*  TO 'expencies_db_user'@'%' IDENTIFIED BY 'expencies_db_password';
FLUSH PRIVILEGES;

SELECT *
FROM mysql.user;
