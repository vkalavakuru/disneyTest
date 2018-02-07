package asteroidAvoidanceAPI;

import java.util.List;

import asteroidAvoidanceAPI.NasaApiResult.NearEarthObject;

public class SafestLaunchData {

    private List<NearEarthObject> nearEarthObjects;
    private String safestedLaunchDate;
    private String message;
    
    /**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the safestedLaunchDate
	 */
	public String getSafestedLaunchDate() {
		return safestedLaunchDate;
	}

	/**
	 * @param safestedLaunchDate the safestedLaunchDate to set
	 */
	public void setSafestedLaunchDate(String safestedLaunchDate) {
		this.safestedLaunchDate = safestedLaunchDate;
	}

	/**
	 * @return the nearEarthObjects
	 */
	public List<NearEarthObject> getNearEarthObjects() {
		return nearEarthObjects;
	}

	/**
	 * @param nearEarthObjects the nearEarthObjects to set
	 */
	public void setNearEarthObjects(List<NearEarthObject> nearEarthObjects) {
		this.nearEarthObjects = nearEarthObjects;
	}
    
}