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
        rover.receiveSingleCommand('M');
        assertThat(rover.getCoordinates().getY().getLocation()).isEqualTo(y + 1);
    }

    @Test
    public void receiveSingleCommandShouldTurnLeftWhenCommandIsL() throws Exception {
        rover.receiveSingleCommand('L');
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void receiveSingleCommandShouldTurnRightWhenCommandIsR() throws Exception {
        rover.receiveSingleCommand('R');
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test(expected = Exception.class)
    public void receiveSingleCommandShouldThrowExceptionWhenCommandIsUnknown() throws Exception {
        rover.receiveSingleCommand('P');
    }

    @Test
    public void receiveCommandsShouldBeAbleToReceiveMultipleCommands() throws Exception {
        rover.receiveCommands("RMR");
        assertThat(rover.getCoordinates().getX().getLocation()).isEqualTo(x + 1);
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

}

