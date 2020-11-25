package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.repo.CoordsRepository;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// Сервис отправки сообщений
@Service
public class SendingService {
    private static final Logger log = LoggerFactory.getLogger(SendingService.class);
    private PointDTO point;
    private UpdateCoords updateCoords = new UpdateCoords();
    private StorageService storageService = new StorageService();
    private SendCoordsService sendCoordsService = new SendCoordsService();
    private RouteRequest routeRequest = new RouteRequest();

    @Scheduled(cron = "${cronSend.prop}")
    void sendCoordinates() throws JsonProcessingException {
        // чтение накопленных координат и отправка на сервер
        while ((point = storageService.readCoordinates()) != null) {
 //           updateCoords.UpdateDB(point); // допилить
//            sendCoordsService.sendCoords(point);
            routeRequest.sendRouteRequest("Navigator-3", 10);

        }
    }
}
