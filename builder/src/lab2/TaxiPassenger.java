package lab2;

public class TaxiPassenger extends Passenger {
    private final boolean _isAdult;

    TaxiPassenger(boolean isAdult) {
        _isAdult = isAdult;
    }
    public boolean IsAdult(){
        return _isAdult;
    }

    boolean IsChild(){
        return !_isAdult;
    }
}
