package ke.co.tracom.model;

import java.util.List;

public class PlanetConnection {

    private List<Planet> planets;

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "PlanetConnection{" +
                "planets=" + planets +
                '}';
    }
}
