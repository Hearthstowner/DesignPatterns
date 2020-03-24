package lab2;

class BusDriver extends Driver {
    private final String _licence;

    BusDriver(String licence) {
        _licence = licence;
    }

    String GetLicence(){
        return _licence;
    }
}
