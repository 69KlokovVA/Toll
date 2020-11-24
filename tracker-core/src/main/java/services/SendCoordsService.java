package services;

import dao.Coords;
import dao.repo.CoordsRepository;
import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendCoordsService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CoordsRepository coordsRepository;

    public void sendCoords(PointDTO point) {
        // запись в базу данных
        Object obj = coordsRepository; // вот здесь видно в debug, что  NULL
        Coords coords = new Coords();
        coords.setLat(point.getLat());
        coords.setLon(point.getLon());
        coords.setAsimuth(point.getAzimuth());
        coords.setSpeed(point.getSpeed());
        coordsRepository.save(coords); // не работает

        // отправка координат для POST-запросом
        String url = "http://localhost:8080/coords";
        restTemplate = new RestTemplate();
        // отправка координат для POST-запросом
        String coordsR = restTemplate.postForObject(url, point, String.class);
    }

}
