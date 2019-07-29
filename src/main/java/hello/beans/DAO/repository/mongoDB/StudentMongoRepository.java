package hello.beans.DAO.repository.mongoDB;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.beans.DAO.noSql.Student;

public interface StudentMongoRepository extends MongoRepository<Student,String> {

	public Student findByName(String name);
    public List<Student> findByCourse(String course);
}
