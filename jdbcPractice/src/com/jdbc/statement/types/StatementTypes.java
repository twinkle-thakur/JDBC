package com.jdbc.statement.types;

import com.jdbc.entity.Student;

//1.Statement
//2.PreparedStatement
//3.CallableStatement(Will discuss after sotre procedure in mysql)
public class StatementTypes {
public static void main(String[] args) {
Student stu=new Student();
stu.setRollNumber(111);
stu.setName("Ashok");
stu.setCollege("IIT BHU");
//JdbcOperation.insert(stu);
//JdbcOperation.update(stu);
//JdbcOperation.deleteByRollNumber(11);
JdbcOperation.fetchAll();
//JdbcOperation.fetchByRollNumber(12);
}
}
