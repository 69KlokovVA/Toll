package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jdev on 06.03.2017.
 */
public class PointDTOTest {

    private String json = "{\"lat\":23.0,\"lon\":45.0,\"autoId\":\"o567gfd234\",\"time\":12345678}";
    private String autoId = "o567gfd234";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(23);
        point.setLon(45);
        point.setAutoId(autoId);
        point.setTime(12345678);
        assertTrue(point.toJson().contains("\"lat\":23"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDto() {
        PointDTO dto = new PointDTO();
        dto = dto.toPoint(json);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(12345678L, dto.getTime());
        assertEquals(45, dto.getLon(),0);
        assertEquals(23, dto.getLat(),0);
        System.out.println("прошел тест server-ui");
    }
}