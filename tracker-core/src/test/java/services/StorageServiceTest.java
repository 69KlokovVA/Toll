package services;

import jdev.dto.PointDTO;
import jdev.tracker.GPSNavigator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class StorageServiceTest extends TestCase {
    private PointDTO coordinates = new PointDTO();
    private static BlockingDeque<PointDTO> gpsQueue = new LinkedBlockingDeque<>();
    private GPSNavigator gpsNavigator = new GPSNavigator();

    void writeCoordinates(PointDTO coordinates) throws InterruptedException {
        gpsQueue.put(coordinates);
    }

    @Test
    public void testReadCoordinates() throws InterruptedException {
        for (int i=0; i<10; i++) {
            coordinates = gpsNavigator.setGPSCoordinates();
            gpsQueue.put(coordinates);
        }
        assertEquals(10, gpsQueue.size());
        coordinates = null;
        if (gpsQueue.size() != 0) {
            coordinates = gpsQueue.remove();
        }
        assertEquals(9,gpsQueue.size());
        assertNotNull(coordinates.getLat());
    }
}