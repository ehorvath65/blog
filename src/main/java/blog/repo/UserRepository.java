package blog.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blog.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email); // email alapján ezzel megkereshető egy felhasználó, ami visszaad egy User
									// objektumot
	// a visszaadott User objektum alapján aztán a jelszó, role visszakereshető

	User findByFullName(String fullName);

}