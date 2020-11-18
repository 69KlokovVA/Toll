package services;

import jdev.dto.PointDTO;
import jdev.tracker.GPSNavigator;
import junit.framework.TestCase;
import org.junit.Test;

public class GPSServiseTest extends TestCase {
    private PointDTO coordinates = new PointDTO();
    private GPSNavigator gpsNavigator = new GPSNavigator();
    private StorageService storageService = new StorageService();
    @Test
    public void testPutGPS() throws InterruptedException {
        coordinates = gpsNavigator.setGPSCoordinates();
        double lon = coordinates.getLon();
        double speed = coordinates.getSpeed();
        storageService.writeCoordinates(coordinates);
        PointDTO coord = storageService.readCoordinates();
        assertEquals(coord.getLon(), lon);
        assertEquals(coord.getSpeed(), speed);

    }
}