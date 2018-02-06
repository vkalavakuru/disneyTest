package asteroidAvoidanceAPI;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SafestLaunchDateController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/safestLaunchDate")
    public AsteroidAvoidance SafestLaunchDate(@RequestParam(value="name", defaultValue="Working on getting safest Launch date") String name) {
       
    	
    	//TODO: Need to call NASA service and get NasaApiResult
    	
    	String neowsUrl = "https://api.nasa.gov/neo/rest/v1/feed";
        String apiKey   ="H7V98iNStSoR1hRBQJgIMHWee0W6Pf5qvfyVLk4X";
    	String startDate ="2015-09-07";
    	String endDate ="2015-09-08";
    	String ampersand ="&";
        String urlConstruct = new StringBuffer(neowsUrl).
        						  append("?").
                                  append("start_date=").append(startDate).
                                  append(ampersand).
                                  append("end_date=").append(endDate).
                                  append(ampersand).
                                  append("detailed=true").
                                  append(ampersand).
                                  append("api_key=").
                                  append(apiKey).
                                  toString();
    	
    	NasaApiResult nasaApiResult = restTemplate.getForObject(urlConstruct, NasaApiResult.class);
    	
    	//TODO: Determine safe Launch Date depending on the conditions or requirements  
    	
    	
    	return new AsteroidAvoidance(counter.incrementAndGet(),
                            String.format(template, name));
    }
}