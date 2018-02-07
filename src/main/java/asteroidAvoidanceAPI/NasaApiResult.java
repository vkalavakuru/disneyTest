package asteroidAvoidanceAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class NasaApiResult {
  @JsonProperty("near_earth_objects")
  Map<String, List<NearEarthObject>> nearEarthObjects;


public static class NearEarthObject {
    public String neo_reference_id;
    public String name;
    public Map<String, Diameter> estimated_diameter;
  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNeo_reference_id() {
			return neo_reference_id;
		}
		public void setNeo_reference_id(String neo_reference_id) {
			this.neo_reference_id = neo_reference_id;
		}
		
	public Map<String, Diameter> getEstimated_diameter() {
		return estimated_diameter;
	}
	public void setEstimated_diameter(Map<String, Diameter> estimated_diameter) {
		this.estimated_diameter = estimated_diameter;
	}
	
  }

  public static class Diameter {
	  
    public double estimated_diameter_max;

	public double getEstimated_diameter_max() {
		return estimated_diameter_max;
	}

	public void setEstimated_diameter_max(double estimated_diameter_max) {
		this.estimated_diameter_max = estimated_diameter_max;
	}
  }
  
  
  public Map<String, List<NearEarthObject>> getNearEarthObjects() {
	return nearEarthObjects;
}

  public void setNearEarthObjects(Map<String, List<NearEarthObject>> nearEarthObjects) {
	this.nearEarthObjects = nearEarthObjects;
}


}
