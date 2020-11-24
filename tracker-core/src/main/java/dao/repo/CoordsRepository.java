package dao.repo;

import dao.Coords;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordsRepository extends CrudRepository<Coords, Integer> {
}
