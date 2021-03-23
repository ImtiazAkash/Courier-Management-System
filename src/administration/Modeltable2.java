package administration;

public class Modeltable2 {
    String token, pickup;

    public Modeltable2(String token, String pickup) {
        this.token = token;
        this.pickup = pickup;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }
}
