package blog.repo;

import org.springframework.data.repository.CrudRepository;

import blog.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	

}