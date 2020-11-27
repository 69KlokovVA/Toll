package basilio.controllers;

import basilio.dao.Coords;
import basilio.servises.CoordinateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReadCoords {
    @Autowired
    CoordinateOperations coordinateOperations;

    @GetMapping("/table")
    public String getCoordinates(Model model) {

        List<Coords> coordsList = (List<Coords>) coordinateOperations.getCoords();
        model.addAttribute("coords", coordsList);

        return "table";
    }

}
