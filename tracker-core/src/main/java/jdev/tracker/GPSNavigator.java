package jdev.tracker;

import jdev.dto.PointDTO;

import java.util.Random;

public class GPSNavigator {
    public GPSNavigator() {
    }
// эмуляция значений кооординат
    public PointDTO setGPSCoordinates() {
        PointDTO point = new PointDTO();
        final Random random = new Random();
        point.setLat(random.nextDouble()*90);
        point.setLon(random.nextDouble()*180);
        point.setAzimuth(random.nextDouble()*360);
        point.setSpeed(random.nextDouble()*120);
        return point;
    }

}
