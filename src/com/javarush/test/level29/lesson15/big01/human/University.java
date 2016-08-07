package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    String name;
    int age;
    private List<Student> students = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }


    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade)return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = null;
        if (students.size()>0){
            student = students.get(0);
            for (Student student1 : students) {
                if (student1.getAverageGrade() > student.getAverageGrade()){
                    student = student1;
                }
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = null;
        if (students.size()>0){
            student = students.get(0);
            for (Student student1 : students) {
                if (student1.getAverageGrade() < student.getAverageGrade()){
                    student = student1;
                }
            }
        }
        return student;
    }

    public void expel(Student student){
        students.remove(student);
    }
}
