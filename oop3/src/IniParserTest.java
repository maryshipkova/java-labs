import exceptions.BadFormatException;
import exceptions.DataMissingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class IniParserTest {
    IniParser iniParser;

    @BeforeEach
    public void init() throws IOException, BadFormatException {
        iniParser = new IniParser();
        iniParser.read("src/file.ini");
    }

    @Test
    void fileNotFound() throws Exception {
        assertThrows(IOException.class, () -> iniParser.read("src/fil.ini"));
    }

    @Test
    void badFileFormat() throws Exception {
        assertThrows(BadFormatException.class, () -> iniParser.read("src/file.in"));
    }

    @Test
    void sectionIsExist() throws Exception {
        assertTrue(iniParser.getIniData().containsKey("COMMON"));
    }

    @Test
    void sectionIsNotExist() throws Exception {
        assertFalse(iniParser.getIniData().containsKey("COM"));
    }

    @Test
    void paramIsExist() throws Exception {
        assertTrue(iniParser.getIniData().get("COMMON").containsKey("StatisterTimeMs"));
    }

    @Test
    void paramIsNotExist() throws Exception {
        assertFalse(iniParser.getIniData().get("COMMON").containsKey("StatisterTimeM"));
    }

    @Test
    void testGetStringValue() throws Exception {
        assertEquals(iniParser.getStringValue("ADC_DEV", "BufferLenSeconds"), "0.65");
    }

    @Test
    void testGetIntValue() throws Exception {
        assertEquals(iniParser.getIntegerValue("COMMON", "StatisterTimeMs"), 5000);
    }

    @Test
    void testGetIntValueNumberFormatException() throws NumberFormatException {
        assertThrows(NumberFormatException.class,()->iniParser.getIntegerValue("ADC_DEV", "BufferLenSeconds"));
    }
    @Test
    void testGetDoubleValue() throws Exception {
        assertEquals(iniParser.getDoubleValue("ADC_DEV", "BufferLenSeconds"), 0.65);
    }

    @Test
    void testDataMissingInGetStringValue() throws Exception {
        assertThrows(DataMissingException.class, () -> iniParser.getStringValue("ADC_DEV", "BufferLenSecond"));
        assertThrows(DataMissingException.class, () -> iniParser.getStringValue("ADC_DE", "BufferLenSeconds"));
    }
}
