package asteroidAvoidanceAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import asteroidAvoidanceAPI.NasaApiResult.Diameter;
import asteroidAvoidanceAPI.NasaApiResult.NearEarthObject;

@RestController
public class SafestLaunchDateController {

    
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/safestLaunchDate")
    public SafestLaunchData SafestLaunchDate(@RequestParam(value="startDate") String startDate, @RequestParam(value="endDate") String endDate) {
       
    	
    	//TODO: Need to call NASA service and get NasaApiResult
    	
    	String neowsUrl = "https://api.nasa.gov/neo/rest/v1/feed";
        String apiKey   ="H7V98iNStSoR1hRBQJgIMHWee0W6Pf5qvfyVLk4X";
    	//String startDate ="2015-09-07";
    	//String endDate ="2015-09-09";
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
    	Map<String, List<NearEarthObject>> nearEarthObjects = nasaApiResult.getNearEarthObjects();
    	List<NearEarthObject> dangerousNeos = new ArrayList<NearEarthObject>();
    	String safestDate ="";
    	int safestCount=-1;
    	for (Entry<String, List<NearEarthObject>> entry : nearEarthObjects.entrySet()) {
    		int count =0;
    		List<NearEarthObject> list = new ArrayList<NearEarthObject>();
    		String date ="";
            for (NearEarthObject nearEarthObject :entry.getValue()) {
            	
            	Map<String, Diameter> estimatedDiameter = nearEarthObject.getEstimated_diameter();
            	Diameter diameter = estimatedDiameter.get("kilometers");
            	double estimated_diameter_max = diameter.getEstimated_diameter_max();
            	if(estimated_diameter_max>0.5) {
            		System.out.println("danger");
            		list.add(nearEarthObject);
            		count++;
            	}
            	date =entry.getKey();
        		
            	
            }
            if(safestCount==-1)
            {	
            	safestCount=count;
            	safestDate=date;
            	dangerousNeos=list;
            }
            else if(count<safestCount) {
            	safestCount =count;
            	safestDate=date;
            	dangerousNeos=list;
            	}
    	}
    	

    	SafestLaunchData safestLaunchData = new SafestLaunchData();
    	safestLaunchData.setNearEarthObjects(dangerousNeos);
    	safestLaunchData.setSafestedLaunchDate(safestDate);
    	if(safestCount==0)
        safestLaunchData.setMessage("No dangerous objects to be listed here");
    	
    	
    	return safestLaunchData;
    }
}