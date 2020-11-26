package services;

import dao.Coords;
import dao.repo.CoordsRepository;
import jdev.dto.PointDTO;
import jdev.tracker.GPSNavigator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

//Сервис GPS
@Component
public class GPSServise {

    private static final Logger log = LoggerFactory.getLogger(GPSServise.class);
    private PointDTO coordinates = new PointDTO();
    private GPSNavigator gpsNavigator = new GPSNavigator();
    private StorageService storageService = new StorageService();

    @Scheduled(cron = "${cronGPS.prop}")
    void putGPS() throws InterruptedException {
        List<Coords> all;
        // генерация gps-координат
        coordinates = gpsNavigator.setGPSCoordinates();
        // отправить в сервис хранения
        storageService.writeCoordinates(coordinates);

        Coords coords = new Coords();
        coords.setLat(coordinates.getLat());
        coords.setLon(coordinates.getLon());
        coords.setazimuth(coordinates.getAzimuth());
        coords.setSpeed(coordinates.getSpeed());
        coords.setDevice(coordinates.getDevice());
        coords.setTime(coordinates.getTime());
/*        Object obj = coordsRepository; // проверка на null debug
        coordsRepository.save(coords);
        all = (List<Coords>) coordsRepository.findAll();
        if (all.size() == 0) {
            log.info("NO RECORDS");
        } else {
            all.stream().forEach(coords1-> log.info(coords1.toString()));
        }*/

    }
}
