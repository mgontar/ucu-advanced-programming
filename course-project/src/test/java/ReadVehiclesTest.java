import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transport.bl.DrivePoint;
import com.transport.bl.Vehicle;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadVehiclesTest {

    @Test
    public void parseVehiclesFile() {
        int numberOfLines = 0;
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            vehicles = mapper.readValue(new File("data/vehicles.json"), new TypeReference<List<Vehicle>>(){});
        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
        }

        Assert.assertNotEquals(0,vehicles.size());
    }
}
