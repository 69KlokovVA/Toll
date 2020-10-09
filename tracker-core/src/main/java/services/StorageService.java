package services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

// ������ �������� ���������
public class StorageService {
    private static final Logger log = LoggerFactory.getLogger(GPSServise.class);
    private PointDTO coordinates = new PointDTO();
    private static BlockingDeque<PointDTO> gpsQueue = new LinkedBlockingDeque<>();

    // ��������� ��� ������ ������� ���������� ���������� (GPS)
    void writeCoordinates(PointDTO coordinates) throws InterruptedException {
        gpsQueue.put(coordinates);
    }

    // ��������� ��� ���������� ���������� ���������� (GPS)
    PointDTO readCoordinates() {
        coordinates = null;
        if (gpsQueue.size() != 0) {
            coordinates = gpsQueue.remove();
        }
        return coordinates;
    }
}
