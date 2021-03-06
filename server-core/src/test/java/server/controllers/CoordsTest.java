package server.controllers;

import jdev.dto.PointDTO;
import junit.framework.TestCase;
import server.dao.Coords;

import java.io.IOException;

public class CoordsTest extends TestCase {

    public void testGetCoords() throws IOException {
        PointDTO point = new PointDTO();
        point.setSpeed(119);
        point.setLat(89);
        point.setLon(179);
        point.setAzimuth(359);
        Coords coords = new Coords();
        CoordsController coordsController = new CoordsController();
        String pointJson = coordsController.getCoords(point);
        String sCoords = point.toJson();
        assertEquals("{\"lat\":89.0,\"lon\":179.0,\"azimuth\":359.0,\"speed\":119.0,\"autoId\":null,\"time\":0}", sCoords);
    }
}