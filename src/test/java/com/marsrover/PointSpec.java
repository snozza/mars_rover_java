package marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class PointSpec {

    Point point;
    private final int location = 5;
    public final int maxLocation = 9;

    @Before
    public void beforePointTest() {
        point = new Point(location, maxLocation);
    }

    @Test
    public void newInstanceShouldSetLocationAndMaxLocationParams() {
        assertThat(point.getLocation()).isEqualTo(location);
        assertThat(point.getMaxLocation()).isEqualTo(maxLocation);
    }
}
