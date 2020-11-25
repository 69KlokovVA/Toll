package services;

import dao.Coords;
import dao.repo.CoordsRepository;
import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCoords {
    private Coords coords = new Coords();


    @Autowired
    private CoordsRepository coordsRepository; // NULL ????

    @Transactional
    public void UpdateDB(PointDTO pointDTO) {
        coords.setSpeed(pointDTO.getSpeed());
        //...
//        coordsRepository.save(coords);
    }

}
