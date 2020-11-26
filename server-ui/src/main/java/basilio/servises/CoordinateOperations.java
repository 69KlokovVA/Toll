package basilio.servises;

import basilio.dao.Coords;
import basilio.repo.CoordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinateOperations {
    @Autowired
    private CoordsRepository coordsRepository;
    public Object getCoords() {
        List<Coords> listCoords  = (List<Coords>) coordsRepository.findAll();
        return listCoords;
    }
}
