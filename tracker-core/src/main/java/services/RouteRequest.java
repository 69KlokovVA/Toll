package services;

import jdev.dto.PointRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RouteRequest {
    private static final Logger log = LoggerFactory.getLogger(SendingService.class);
    PointRequestDTO pointRequestDTO = new PointRequestDTO();
    private RestTemplate restTemplate;
    public void sendRouteRequest(String device, int maxNumberOfPoints) {
        // запрос маршрута по точкам от данного устройства, maxNumberOfPoints самых поздних по времени точек
        pointRequestDTO.setDevice(device);
        pointRequestDTO.setMaxNumberOfPoints(maxNumberOfPoints);

        String url = "http://localhost:8080/points";
        restTemplate = new RestTemplate();
        // запроса маршута  POST-запросом

        String route = restTemplate.postForObject(url, pointRequestDTO, String.class);
        // выводим полученный результат в виде json
        log.info(route);
//получен результат
//[{"id":308,"lat":39.01882991866116,"lon":112.41393360754266,"asimuth":91.79325429927107,"speed":42.79872364631116,"time":1606296780006,"device":"Navigator-3"}
// ,{"id":296,"lat":28.97751589544359,"lon":86.96599607732303,"asimuth":262.6081120929871,"speed":89.40749526098662,"time":1606296773014,"device":"Navigator-3"}
// ,{"id":288,"lat":20.66909270800383,"lon":23.916235872686126,"asimuth":344.0264239381163,"speed":107.15628981831952,"time":1606296769010,"device":"Navigator-3"}
// ,{"id":283,"lat":68.10758517320676,"lon":70.33878702935012,"asimuth":118.20109366000788,"speed":104.9115605263932,"time":1606296767003,"device":"Navigator-3"}
// ,{"id":282,"lat":85.54918387855656,"lon":156.79933955635533,"asimuth":101.53117972151452,"speed":9.588789860050202,"time":1606296766014,"device":"Navigator-3"}
// ,{"id":277,"lat":32.4477909473438,"lon":74.5051592946995,"asimuth":261.5736784350244,"speed":78.1712990241223,"time":1606296764003,"device":"Navigator-3"}
// ,{"id":273,"lat":57.0752881980503,"lon":166.97607231199666,"asimuth":114.3513763260627,"speed":99.61850334122633,"time":1606296762014,"device":"Navigator-3"}
// ,{"id":269,"lat":77.1121605910082,"lon":141.34262856623045,"asimuth":236.28281774115675,"speed":78.88682395186355,"time":1606296760011,"device":"Navigator-3"}
// ,{"id":263,"lat":0.44682776646238875,"lon":124.20523799625389,"asimuth":310.8299950470958,"speed":0.4947200870496804,"time":1606296757007,"device":"Navigator-3"}
// ,{"id":260,"lat":89.41480302632088,"lon":129.95526141069166,"asimuth":63.206034059019615,"speed":54.203160378524544,"time":1606296756002,"device":"Navigator-3"}]

    }
}
