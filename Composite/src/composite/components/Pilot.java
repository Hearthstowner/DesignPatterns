package composite.components;

import composite.components.CanGetWight;

public class Pilot implements CanGetWight {

    @Override
    public int GetWeight() {
        return 0;
    }

    @Override
    public boolean SetWeight(int weight) {
        return true;
    }
}
