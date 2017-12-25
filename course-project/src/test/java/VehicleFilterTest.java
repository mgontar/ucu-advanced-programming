import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transport.Conf;
import com.transport.bl.DrivePoint;
import com.transport.bl.Vehicle;
import com.transport.services.TripLengthCalc;
import com.transport.services.VehicleFilter;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.transport.constants.AppRunProfile.DEV;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Conf.class)
@ActiveProfiles(DEV)
public class VehicleFilterTest {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private VehicleFilter vehicleFilter;

    @Test
    public void calcTripLengthTest() {
        List<DrivePoint> drivePoints = new ArrayList<DrivePoint>();
        Path path = Paths.get("data/raw_data.txt");
        try{
            List<String> lines = Files.lines(path).collect(Collectors.toList());
            for (String line :lines) {
                drivePoints.add(new DrivePoint(line));
            }
        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
        }
        catch (ParseException ex) {
            Assert.fail(ex.getMessage());
        }
        JavaRDD<DrivePoint> rddDrivePoints = sc.parallelize(drivePoints);


        JavaRDD<DrivePoint> rddVehicleDrivePoints = vehicleFilter.filterVehicle(rddDrivePoints, "ВС 7284 СО");
        Assert.assertNotEquals(0, rddVehicleDrivePoints.count());
    }
}
