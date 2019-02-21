import exceptions.BadFormatException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, BadFormatException {
        IniParser iniParser = new IniParser();
        iniParser.read("src/file.ini");
    }


}
