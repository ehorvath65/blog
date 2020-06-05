package blog.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blog.entity.Cat;

@Repository
public interface CatRepository extends CrudRepository<Cat, Long> {

	List<Cat> findAll();

	Cat findByCat(String cat);

}
