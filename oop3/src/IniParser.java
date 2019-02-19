import java.io.*;
import java.util.HashMap;

public class IniParser {
    HashMap<String, HashMap<String, String>> _iniData = new HashMap<String, HashMap<String, String>>();

    public void read(String filename) throws IOException {
        File file = new File(filename);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String fileString, currSection = "";
        while ((fileString = bufferedReader.readLine()) != null) {

            switch (fileString.charAt(0)) {
                case ';':
                    continue;
                case '[':
                    int endSection = fileString.indexOf(']');
                    currSection = fileString.substring(1, endSection);
                    _iniData.put(currSection, new HashMap<String, String>());
                    break;
                default:
                    fileString = fileString.replaceAll(" ", "");
                    int endParam = fileString.indexOf('=');
                    int endElement = fileString.indexOf(';');
                    String param = fileString.substring(0, endParam);
                    String element = (endElement != -1) ? fileString.substring(endParam + 1, endElement) :
                            fileString.substring(endParam + 1);
                    _iniData.get(currSection).put(param, element);
                    break;
            }
        }

    }
}

