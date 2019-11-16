package com.MikeOfficiaI.Dao;

import com.MikeOfficiaI.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Zheka", "Computer Science"));
                put(2, new Student(2, "Vlad", "Math & Informatic"));
                put(3, new Student(3, "Ivan", "Buisness & Informatic"));
            }
        };
    }

    public Collection<Student> getAllStudent(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void removeStudentById(int id){
        this.students.remove(id);
    }

    public void updateStudent(Student student) {
        Student anotherStudent = students.get(student.getId());
        anotherStudent.setCourse(student.getCourse());
        anotherStudent.setName(student.getName());
        students.put(student.getId(), student);
    }
}
