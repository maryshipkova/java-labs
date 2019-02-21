import exceptions.BadFormatException;
import exceptions.DataMissingException;

import java.io.*;
import java.util.HashMap;

public class IniParser {
    private HashMap<String, HashMap<String, String>> _iniData = new HashMap<String, HashMap<String, String>>();

    public void read(String filename) throws IOException, BadFormatException {
        if (!filename.substring(filename.length() - 3).equals("ini")) throw new BadFormatException();

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
                    int endValue = fileString.indexOf(';');
                    String param = fileString.substring(0, endParam);
                    String value = (endValue != -1) ? fileString.substring(endParam + 1, endValue) :
                            fileString.substring(endParam + 1);
                    _iniData.get(currSection).put(param, value);
                    break;
            }
        }
    }

    public String getStringValue(String section, String param) throws DataMissingException {
        if (!_iniData.containsKey(section)) throw new DataMissingException("this section does not exist");
        if (!_iniData.get(section).containsKey(param)) throw new DataMissingException("this parameter does not exist");
        return _iniData.get(section).get(param);
    }


    public Integer getIntegerValue(String section, String param) throws DataMissingException {
        return Integer.parseInt(getStringValue(section, param));
    }

    public double getDoubleValue(String section, String param) throws DataMissingException {
        return Double.parseDouble(getStringValue(section, param));
    }

    public HashMap<String, HashMap<String, String>> getIniData(){
        return _iniData;
    }

}

