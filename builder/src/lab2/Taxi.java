package lab2;

import java.util.ArrayList;
import java.util.List;

class Taxi {
    private boolean _childSeat = false;
    private final String _licence;
    private final int _capacity;

    private TaxiDriver _driver;

    private List<Passenger> _passengers;


    Taxi() {
        _licence = "B";
        _capacity = 4;
        _passengers = new ArrayList<Passenger>(_capacity);
    }

    private String GetLicence() {
        return _licence;
    }

    void BoardPassenger(Passenger passenger) {
        if (_passengers.size() == _capacity) {
            throw new Error("No more seats");
        }
        _passengers.add(passenger);
    }
    void BoardChildPassenger(Passenger passenger) {
        if (!HasChildSeat()) {
            throw new Error("No Child Sit");
        }
        if (_passengers.size() == _capacity) {
            throw new Error("No more seats");
        }
        _passengers.add(passenger);
    }

    void AddChildSit() {
        _childSeat = true;
    }

    void BoardDriver(TaxiDriver driver) {
        if (!driver.GetLicence().equals(GetLicence())) {
            throw new Error("Incompatible licence");
        }
        if (_driver != null) {
            throw new Error("Driver already boarded");
        }
        _driver = driver;
    }

    private boolean HasChildSeat() {
        return _childSeat;
    }

    void Run() {
        if (_driver == null) {
            throw new Error("Can't run without driver");
        }
        if (_passengers.size() == 0) {
            throw new Error("Can't run without passengers");
        }
        System.out.println("Transport on the way!");
    }

}
