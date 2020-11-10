package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// Сервис отправки сообщений
@Service
public class SendingService {
    private static final Logger log = LoggerFactory.getLogger(SendingService.class);
    private StorageService storageService = new StorageService();
    private PointDTO point;
    private SendCoordsServise sendCoordsServise;


    @Scheduled(cron = "${cronSend.prop}")
    void sendCoordinates() throws JsonProcessingException {
        sendCoordsServise = new SendCoordsServise();
        // чтение накопленных координат и отправка на сервер
        while ((point = storageService.readCoordinates()) != null) {
              sendCoordsServise.sendCoords(point);
        }
    }
}
