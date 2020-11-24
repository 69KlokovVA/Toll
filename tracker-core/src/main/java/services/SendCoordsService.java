package services;

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
        Object obj = coordsRepository;
        String url = "http://localhost:8080/coords";
        restTemplate = new RestTemplate();
        // отправка координат для POST-запросом
        String coords = restTemplate.postForObject(url, point, String.class);


    }

}
