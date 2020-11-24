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
    UpdateCoords updateCoords = new UpdateCoords();
    @Autowired
    private StorageService storageService;
    @Autowired
    private SendCoordsService sendCoordsService;

    @Scheduled(cron = "${cronSend.prop}")
    void sendCoordinates() throws JsonProcessingException {
        // чтение накопленных координат и отправка на сервер
        while ((point = storageService.readCoordinates()) != null) {
            sendCoordsService.sendCoords(point);
updateCoords.UpdateDB(point);

        }
    }
}
