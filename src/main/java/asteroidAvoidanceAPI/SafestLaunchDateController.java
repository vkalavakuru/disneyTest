package asteroidAvoidanceAPI;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SafestLaunchDateController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/safestLaunchDate")
    public AsteroidAvoidance SafestLaunchDate(@RequestParam(value="name", defaultValue="Working on getting safest Launch date") String name) {
       
    	//TODO: Need to call NASA service and get NasaApiResult
    	//TODO: Determine SafeLaunchDate and required data to populate as API result
    	
    	return new AsteroidAvoidance(counter.incrementAndGet(),
                            String.format(template, name));
    }
}