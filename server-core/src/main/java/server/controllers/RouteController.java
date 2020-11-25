package server.controllers;

import com.google.gson.Gson;
import jdev.dto.PointRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.dao.Coords;
import server.repo.CoordsRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class RouteController {


    @Autowired
    private CoordsRepository coordsRepository;

    // прием запроса маршрута от устройства
    @PostMapping("/points")
    public String getCoords(@RequestBody PointRequestDTO points) throws IOException {
        // читаем информацию из БД
        List<Coords> coords  = (List<Coords>) coordsRepository.findAll();

        // отбор информации по конкретному устройству, например "Navigator-3" )
        coords = coords.stream().filter(d -> Objects.equals(d.getDevice(), points.getDevice())).collect(Collectors.toList());
        // сортировка полученной информации по последнему времени точек маршрута
        Comparator<Coords> comparator = Comparator.comparing(Coords::getTime);
        Collections.sort(coords, comparator.reversed());
        // отобрать первые (самые поздние по времени) MaxNumberOfPoints точек
        coords = coords.stream().limit(points.getMaxNumberOfPoints()).collect(Collectors.toList());
        // результат в Json
        String sCoords = new Gson().toJson(coords );

        return sCoords;
    }

}