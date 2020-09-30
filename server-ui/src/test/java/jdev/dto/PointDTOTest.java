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
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(12345678);
        assertTrue(point.toJson().contains("\"lat\":56"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDto() {
        PointDTO dto = new PointDTO();
        dto = dto.toPoint(json);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(12345678L, dto.getTime());
        System.out.println("прошел тест server-ui");
    }
}