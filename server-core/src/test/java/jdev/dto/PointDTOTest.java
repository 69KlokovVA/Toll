package jdev.dto;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jdev on 06.03.2017.
 */
public class PointDTOTest {

    private final int anInt = 23;
    private final int anInt1 = 45;
    private String json = "{\"lat\":23.0,\"lon\":45.0,\"autoId\":\"o567gfd234\",\"time\":1601448016633}";
    private String autoId = "o567gfd234";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(anInt);
        point.setLon(anInt1);
        point.setAutoId(autoId);
        point.setTime(System.currentTimeMillis());
        String pointjson = point.toJson();
        assertTrue(pointjson.contains("\"lon\":45"));
        System.out.println(pointjson);
    }

    @Test
    public void decodeDto() {
        PointDTO dto = new PointDTO();
        dto = dto.toPoint(json);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1601448016633L, dto.getTime());
        assertEquals(anInt1, dto.getLon(),0);
        assertEquals(anInt, dto.getLat(),0);
        System.out.println("прошел тест server-core");
    }
}
