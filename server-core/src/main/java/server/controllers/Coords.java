package server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class Coords {
    private static final Logger log = LoggerFactory.getLogger(Coords.class);

    // прием координат в виде POST запроса
    @PostMapping("/coords")
    public PointDTO getCoords(@RequestBody PointDTO coords) throws IOException {
        FileWriter fileCoords =  new FileWriter("d:\\UDO\\coords.txt", true);
        String sCoords = coords.toJson();
        // вывод принятых координат в лог
        log.info("Coordinates received: "+ sCoords);
        // вывод принятых координат в файл
        fileCoords.write(sCoords+"\n");
        fileCoords.close();
        return coords;
    }

}