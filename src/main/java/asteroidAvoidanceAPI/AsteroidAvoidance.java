package asteroidAvoidanceAPI;

public class AsteroidAvoidance {

    private final long id;
    private final String content;

    public AsteroidAvoidance(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}