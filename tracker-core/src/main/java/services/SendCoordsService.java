package services;

import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendCoordsService {

    private RestTemplate restTemplate;
    public void sendCoords(PointDTO point) {

        // отправка координат в другое приложение  POST-запросом
        String url = "http://localhost:8080/coords";
        restTemplate = new RestTemplate();
        // отправка координат для POST-запросом
        String coordsR = restTemplate.postForObject(url, point, String.class);
    }

}
