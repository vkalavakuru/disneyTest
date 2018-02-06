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
  }

  public static class Diameter {
    public double estimated_diameter_max;
  }

}
