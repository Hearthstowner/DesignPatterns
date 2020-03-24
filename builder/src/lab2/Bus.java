package lab2;

import java.util.ArrayList;
import java.util.List;

class Bus {
    int _overallCost = 0;
    private final String _licence;
    private final int _capacity;

    private BusDriver _driver;

    private List<BusPassenger> _passengers;

    Bus() {
        _licence = "D";
        _capacity = 30;
        _passengers = new ArrayList<>(_capacity);
    }

    private String GetLicence() {
        return _licence;
    }

    void BoardDriver(BusDriver driver) {
        if (!driver.GetLicence().equals(GetLicence())) {
            throw new Error("Incompatible licence");
        }
        if (_driver != null) {
            throw new Error("Driver already boarded");
        }
        _driver = driver;
    }

    void BoardPassenger(BusPassenger passenger){
        if (_passengers.size() == _capacity) {
            throw new Error("No more seats");
        }
        _passengers.add(passenger);
    }

    int GetOverallCost(){
        return _overallCost;
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
