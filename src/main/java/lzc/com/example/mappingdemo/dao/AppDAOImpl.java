package lzc.com.example.mappingdemo.dao;

import jakarta.persistence.EntityManager;
import lzc.com.example.mappingdemo.entity.Instructor;
import lzc.com.example.mappingdemo.entity.InstructorDetail;
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

    @Override
    @Transactional
    public void deleteById(int theId) {
        // retrieve instructor by id
        Instructor tempinstructor = entityManager.find(Instructor.class ,theId);
        // delete the instructor
        if(tempinstructor != null) {
            entityManager.remove(tempinstructor);
        }
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class ,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // retrieve instructor by id
        InstructorDetail tempinstructorDetail = entityManager.find(InstructorDetail.class ,theId);

        // remove the associated object reference
        // break bidirectional link
        if(tempinstructorDetail != null) {
            tempinstructorDetail.getInstructor().setInstructorDetail(null);
        }

        // delete the instructor
        if(tempinstructorDetail != null) {
            entityManager.remove(tempinstructorDetail);
        }

    }


}
