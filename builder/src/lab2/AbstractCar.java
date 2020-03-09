package lab2;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractCar {
    private final String _licence;
    private final int _capacity;

    private Driver _driver;

    private List<Passenger> _passengers;

    AbstractCar(String licence, int capacity) {
        _licence = licence;
        _capacity = capacity;
        _passengers = new ArrayList<>(_capacity);
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

    void BoardDriver(Driver driver) {
        if (!driver.GetLicence().equals(GetLicence())) {
            throw new Error("Incompatible licence");
        }
        if (_driver != null) {
            throw new Error("Driver already boarded");
        }
        _driver = driver;
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
