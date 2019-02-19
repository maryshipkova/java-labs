import exceptions.BadFormatException;
import exceptions.DataMissingException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, BadFormatException, DataMissingException {
        IniParser iniParser = new IniParser();
        iniParser.read("src/file.ini");
    }
}
