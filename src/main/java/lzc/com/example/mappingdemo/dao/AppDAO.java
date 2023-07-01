package lzc.com.example.mappingdemo.dao;

import lzc.com.example.mappingdemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteById(int theId);
}
