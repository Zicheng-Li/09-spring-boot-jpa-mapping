package lzc.com.example.mappingdemo.dao;

import jakarta.persistence.EntityManager;
import lzc.com.example.mappingdemo.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    // define fields for entity-manager
    private EntityManager entityManager;

    // inject entity-manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    // create constructor

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int theId) {
        return entityManager.find(Instructor.class ,theId);
    }
}
