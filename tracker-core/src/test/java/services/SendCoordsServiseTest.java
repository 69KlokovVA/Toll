package services;

import jdev.dto.PointDTO;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class SendCoordsServiseTest extends TestCase {
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testSendCoords() {
        String url = "http://localhost:8080/coords";
        restTemplate = new RestTemplate();
        PointDTO point = new PointDTO();
        point.setSpeed(101);
        point.setAzimuth(123);
        point.setLat(21);
        point.setLon(34);
        String coords = restTemplate.postForObject(url, point, String.class);
        String expectedResult = "{\"lat\":21.0,\"lon\":34.0,\"azimuth\":123.0,\"speed\":101.0,\"autoId\":null,\"time\":0}";
        assertEquals(expectedResult, coords);

    }
}
