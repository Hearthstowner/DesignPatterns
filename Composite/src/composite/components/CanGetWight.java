package composite.components;

public interface CanGetWight {

    int WEIGHT_LIMIT = 60;
    int WEIGHT_REQ = 0;

    int GetWeight();
    boolean SetWeight(int weight);
}
