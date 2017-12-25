import com.transport.bl.DrivePoint;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDrivePointsTest {

    @Test
    public void parseDrivePointsFile() {
        int numberOfLines = 0;
        List<DrivePoint> drivePoints = new ArrayList<DrivePoint>();
        Path path = Paths.get("data/raw_data.txt");
        try{
            List<String> lines = Files.lines(path).collect(Collectors.toList());
            numberOfLines = lines.size();
            for (String line :lines) {
                drivePoints.add(new DrivePoint(line));
            }
        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
        }
        catch (ParseException ex) {
            Assert.fail(ex.getMessage());
        }
        Assert.assertEquals(numberOfLines,drivePoints.size());
    }

}
