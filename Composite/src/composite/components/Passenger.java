package composite.components;

public class Passenger implements CanGetWight {

    private int weight;
    @Override

    public int GetWeight(){
        return weight;
    }

    @Override
    public boolean SetWeight(int weight) {
        this.weight = weight;
        return true;
    }
}
