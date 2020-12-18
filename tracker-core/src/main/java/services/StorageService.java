package services;

import dao.repo.CoordsRepository;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

// Сервис хранения сообщений
@Service
public class StorageService {
    private static final Logger log = LoggerFactory.getLogger(GPSServise.class);
    private PointDTO coordinates = new PointDTO();
    private static BlockingDeque<PointDTO> gpsQueue = new LinkedBlockingDeque<>();

    @Autowired
    CoordsRepository coordsRepository;

    // интерфейс для записи текущих параметров транспорта (GPS)
    void writeCoordinates(PointDTO coordinates) throws InterruptedException {
        gpsQueue.put(coordinates);

    }

    // интерфейс для извлечения параметров транспорта (GPS) с очисткой очереди
    PointDTO readCoordinates() {
        coordinates = null;
        if (gpsQueue.size() != 0) {
            coordinates = gpsQueue.remove();
        }
        return coordinates;
    }

    @PostConstruct
    public void check() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!! coordsRepository != null -> " + coordsRepository != null);

    }

}
