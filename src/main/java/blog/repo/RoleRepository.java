package blog.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blog.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}