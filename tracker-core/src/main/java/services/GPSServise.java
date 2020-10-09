package services;

import jdev.dto.PointDTO;
import jdev.tracker.GPSNavigator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
//������ GPS
@Service
public class GPSServise {
    private static final Logger log = LoggerFactory.getLogger(GPSServise.class);
    private PointDTO coordinates = new PointDTO();
    private GPSNavigator gpsNavigator = new GPSNavigator();
    private StorageService storageService = new StorageService();

    @Scheduled(cron = "${cronGPS.prop}")
    void putGPS() throws InterruptedException {
        // ��������� gps-���������
        coordinates = gpsNavigator.setGPSCoordinates();

        // ��������� � ������ ��������
        storageService.writeCoordinates(coordinates);
    }
}
