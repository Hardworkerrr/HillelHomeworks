create database if not exists university;

create table if not exists university.students(
	student_id int primary key auto_increment,
	fullname varchar(255) null,
	`group` varchar(255) null,
	admission_year year null
);

create table if not exists university.groups(
	group_id int primary key auto_increment,
	group_name varchar(255) null
);

create table if not exists university.lessons(
	lesson_id int primary key auto_increment,
	lesson_name varchar(255) null,
	teacher_name varchar(255) null,
	semester int null,
	year_of_lesson year null
);

create table if not exists university.points(
	point_id int primary key auto_increment,
	lesson_name varchar(255) null,
	student_name varchar(255) null,
	student_point int null
);

create table if not exists university.teachers(
	teacher_id int primary key auto_increment,
	fullname varchar(255) null,
	lectern_name varchar(255) null
);

create table if not exists university.lectern(
	lectern_id int primary key auto_increment,
	lectern_name varchar(255) null,
	lectern_holder varchar(255) null
);


