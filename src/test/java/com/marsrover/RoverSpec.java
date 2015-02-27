package marsrover;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class RoverSpec {

    private Rover rover;
    private Coordinates roverCoordinates;
    private final Direction direction = Direction.NORTH;
    private final int x = 1;
    private final int y = 2;
    private final int maxX = 9;

    @Before
    public void beforeRoverTest() {
        roverCoordinates = new Coordinates(x, y, maxX, 9);
        rover = new Rover(roverCoordinates, direction);
    }

    @Test
    public void newInstanceShouldSetRoverCoordinatesAndDirection() {
        assertThat(rover.getCoordinates()).isEqualToComparingFieldByField(roverCoordinates);
        assertThat(rover.getDirection()).isEqualTo(direction);
    }

    @Test
    public void receiveSingleCommandShouldMoveForwardWhenCommandIsM() throws Exception {
        rover.receiveSingleCommand('L');
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

}

