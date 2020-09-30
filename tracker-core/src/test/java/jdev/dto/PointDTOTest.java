package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jdev on 06.03.2017.
 */
public class PointDTOTest {
    private String json = "{\"lat\":47.0,\"lon\":45.0,\"autoId\":\"qwerty123\",\"time\":1601448822585}";
    private String autoId = "qwerty123";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(47);
        point.setLon(74);
        point.setAutoId(autoId);
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":47"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDto() {
        PointDTO dto = new PointDTO();
        dto = dto.toPoint(json);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1601448822585L, dto.getTime());
        System.out.println("прошел тест tracker-core");
    }
}