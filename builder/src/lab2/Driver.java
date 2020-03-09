package lab2;

abstract class Driver {
    private final String _licence;

    Driver(String licence) {
        _licence = licence;
    }

    String GetLicence(){
        return _licence;
    }
}
