package lzc.com.example.mappingdemo.dao;

import lzc.com.example.mappingdemo.entity.Instructor;
import lzc.com.example.mappingdemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
