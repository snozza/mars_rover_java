package marsrover;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CoordinatesSpec {

    private Coordinates coordinates;
    private Point x;
    private Point y;
    private final Direction direction = Direction.NORTH;

    @Before
    public void beforeCoordinatesTest() {
        x = new Point(1, 99);
        y = new Point(2, 99);
        coordinates = new Coordinates(x, y, direction);
    }

    @Test
    public void newInstanceShouldSetXAndYParams() {
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(x);
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(y);
    }

    @Test
    public void newInstanceShouldSetDirection() {
        assertThat(coordinates.getDirection()).isEqualTo(direction);
    }

    @Test
    public void moveShouldIncreaseYWhenDirectionIsNorth() {
        Point expected = new Point(y.getLocation() + 1, y.getMaxLocation());
        coordinates.setDirection(Direction.NORTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldIncreaseXWhenDirectionIsEast() {
        Point expected = new Point(x.getLocation() + 1, x.getMaxLocation());
        coordinates.setDirection(Direction.EAST);
        coordinates.moveForward();
        assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    }

    @Test
    public void moveShouldDecreaseYWhenDirectionIsSouth() {
        Point expected = new Point(y.getLocation() - 1, y.getMaxLocation());
        coordinates.setDirection(Direction.SOUTH);
        coordinates.moveForward();
        assertThat(coordinates.getY()).isEqualToComparingFieldByField(expected);
    }

    // @Test
    // public void moveShouldDecreaseXWhenDirectionIsWest() {
    //     Point expected = new Point(coordinates.getX().getLocation() - 1, maxLocation);
    //     coordinates.move(Direction.WEST);
    //     assertThat(coordinates.getX()).isEqualToComparingFieldByField(expected);
    // }

    // @Test
    // public void toStringShouldReturnXandY() {
    //     assertThat(coordinates.toString()).isEqualTo(x + " X " + y);
    // }

}

