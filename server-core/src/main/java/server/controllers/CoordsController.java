package server.controllers;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.dao.Coords;
import server.dao.Users;
import server.repo.CoordsRepository;
import server.repo.UsersRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
public class CoordsController {
    private static final Logger log = LoggerFactory.getLogger(CoordsController.class);
    private Coords coordsDB;
    @Autowired
    private CoordsRepository coordsRepository;

    // Реализация п. 5.2.1 задания 8
    @Autowired
    private UsersRepository usersRepository;
    private Users users = new Users();

    public void addUsers() {
        if (users != null) { // в данном сеансе  заполняем таблицу пользователей всего один раз
            List<Users> records = (List<Users>) usersRepository.findAll();
            if (records.size() == 0) { // заполняем таблицу, если она пустая (это просто пример работы CRUD)

                users.setFirstName("Иван");
                users.setLastName("Бойченко");
                users.setService(123);
                usersRepository.save(users);
                Users users = new Users();
                users.setFirstName("Василий");
                users.setLastName("Клоков");
                users.setService(456);
                usersRepository.save(users);
                users = null; // в данном сеансе  заполняем таблицу всего один раз
            }
        }
    }

    // прием координат в виде POST запроса
    @PostMapping("/coords")
    public String getCoords(@RequestBody PointDTO coords) throws IOException {

        addUsers(); // заполняем таблицу всего один раз ( не знаю, где ещё это реализовать в рамках практического ззадания 8

        FileWriter fileCoords =  new FileWriter("d:\\UDO\\coords.txt", true);
        String sCoords = coords.toJson();
        // вывод принятых координат в лог
        log.info("Coordinates received: "+ sCoords);
        // вывод принятых координат в файл
        fileCoords.write(sCoords+"\n");
        fileCoords.close();

        // запись в базу данных
        coordsDB = new Coords();
        coordsDB.setSpeed(coords.getSpeed());
        coordsDB.setazimuth(coords.getAzimuth());
        coordsDB.setLat(coords.getLat());
        coordsDB.setLon(coords.getLon());
        coordsDB.setTime(coords.getTime());
        coordsDB.setDevice(coords.getDevice());
        coordsRepository.save(coordsDB);
        return sCoords;
    }

}