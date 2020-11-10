package services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class SendCoordsServise {

    @Autowired
    RestTemplate restTemplate;

    public void sendCoords(PointDTO point) {
        String url = "http://localhost:8080/coords";
        restTemplate = new RestTemplate();
        // отправка координат для POST-запросом
        restTemplate.postForObject(url, point, PointDTO.class);
    }
}
