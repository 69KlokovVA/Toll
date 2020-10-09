package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// ������ �������� ���������
@Service
public class SendingService {
    private static final Logger log = LoggerFactory.getLogger(SendingService.class);
    private StorageService storageService = new StorageService();
    private PointDTO point;

    @Scheduled(cron = "${cronSend.prop}")
    void sendCoordinates() throws JsonProcessingException {
        // ������ ����������� ���������
        while ((point = storageService.readCoordinates()) != null) {
            // �������� � ���� ������
            log.info("to DateBase "+ point.toJson());
        }
    }
}
