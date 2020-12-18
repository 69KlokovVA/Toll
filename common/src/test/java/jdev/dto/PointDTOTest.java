package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jdev on 06.03.2017.
 */
public class PointDTOTest {

    private final int anInt = 56;
    private final int anInt1 = 74;
    private String json = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1601448777831}";
    private String autoId = "o567gfd";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(anInt);
        point.setLon(anInt1);
//        point.setAutoId(autoId);
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDto() {
        PointDTO dto = new PointDTO();
        dto = dto.toPoint(json);
//        assertEquals(autoId, dto.getAutoId());
        assertEquals(anInt1, dto.getLon(),0);
        assertEquals(anInt, dto.getLat(),0);
        assertEquals(1601448777831L, dto.getTime());
        System.out.println("прошел тест common");
    }
}