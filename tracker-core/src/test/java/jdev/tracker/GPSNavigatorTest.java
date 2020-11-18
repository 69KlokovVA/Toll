package jdev.tracker;

import jdev.dto.PointDTO;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

public class GPSNavigatorTest extends TestCase {
    @Test
    public void testSetGPSCoordinates() {
        GPSNavigator gpsNavigator = new GPSNavigator();
        PointDTO coordinates = gpsNavigator.setGPSCoordinates();
        assertTrue((coordinates.getLat() < 90) & (coordinates.getLat() > 0));
        assertTrue((coordinates.getLon() < 180) & (coordinates.getLon() > 0));
        assertTrue((coordinates.getAzimuth() < 360) & (coordinates.getAzimuth() > 0));
        assertTrue((coordinates.getSpeed() < 120) & (coordinates.getSpeed() > 0));

    }
}

