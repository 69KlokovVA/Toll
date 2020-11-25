package server.repo;

import org.springframework.data.repository.CrudRepository;
import server.dao.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
}
