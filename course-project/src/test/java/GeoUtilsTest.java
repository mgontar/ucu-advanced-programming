import com.transport.utils.GeoUtils;
import org.junit.Assert;
import org.junit.Test;

public class GeoUtilsTest {

    @Test
    public void GeoUtilsDistanceTest() {
        double distance = GeoUtils.distance(50.433, 30.517, 49.833, 24);
        Assert.assertEquals(469, distance, 2);
    }
}
