package ke.co.tracom.model;

public class Film {

    private String title;

    private PlanetConnection planetConnection;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PlanetConnection getPlanetConnection() {
        return planetConnection;
    }

    public void setPlanetConnection(PlanetConnection planetConnection) {
        this.planetConnection = planetConnection;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", planetConnection=" + planetConnection +
                '}';
    }
}
