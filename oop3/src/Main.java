import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        IniParser iniParser = new IniParser();
        iniParser.read("src/file.ini");
    }
}
