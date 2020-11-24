package services;

import dao.repo.CoordsRepository;
import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendCoordsService {

    @Autowired
    RestTemplate restTemplate;


    private CoordsRepository coordsRepository;

    public SendCoordsService(CoordsRepository coordsRepository) {
        this.coordsRepository = coordsRepository;
    }

    public SendCoordsService() {
    }


    public void sendCoords(PointDTO point) {
        Object obj = coordsRepository;
        // запись в базу данных
  /*      Object obj = coordsRepository; // вот здесь видно в debug, что  NULL
        Coords coords = new Coords();
        coords.setLat(point.getLat());
        coords.setLon(point.getLon());
        coords.setAsimuth(point.getAzimuth());
        coords.setSpeed(point.getSpeed());
        coordsRepository.save(coords); // не работает*/

        // отправка координат в другое приложение  POST-запросом
        String url = "http://localhost:8080/coords";
  //      restTemplate = new RestTemplate();
        // отправка координат для POST-запросом
        String coordsR = restTemplate.postForObject(url, point, String.class);
    }

}
