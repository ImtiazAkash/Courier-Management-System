package administration;

public class Modeltable {
    String pickup, destination, weight, token, cost;

    public Modeltable(String pickup, String destination, String weight, String token, String cost) {
        this.pickup = pickup;
        this.destination = destination;
        this.weight = weight;
        this.token = token;
        this.cost = cost;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    
}
