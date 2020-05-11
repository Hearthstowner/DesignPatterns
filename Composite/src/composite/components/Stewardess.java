package composite.components;

public class Stewardess implements CanGetWight {

    @Override
    public int GetWeight() {
        return 0;
    }

    @Override
    public boolean SetWeight(int weight) {
        return true;
    }
}
