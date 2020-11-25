package services;

import jdev.dto.PointRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RouteRequest {
    private static final Logger log = LoggerFactory.getLogger(SendingService.class);
    PointRequestDTO pointRequestDTO = new PointRequestDTO();
    private RestTemplate restTemplate;
    public void sendRouteRequest(String device, int maxNumberOfPoints) {
        // ������ �������� �� ������ �� ������� ����������, maxNumberOfPoints ����� ������� �� ������� �����
        pointRequestDTO.setDevice(device);
        pointRequestDTO.setMaxNumberOfPoints(maxNumberOfPoints);

        String url = "http://localhost:8080/points";
        restTemplate = new RestTemplate();
        // ������� �������  POST-��������
        // ������� �������� ������� � ������� Json
        String route = restTemplate.postForObject(url, pointRequestDTO, String.class);

    }
}
