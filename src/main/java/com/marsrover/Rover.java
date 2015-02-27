package marsrover;

public class Rover {

  private Coordinates coordinates;
  public void setCoordinates(Coordinates value) {
    coordinates = value;
  }
  public Coordinates getCoordinates() {
    return coordinates;
  }

  private Direction direction;
  public void setDirection(Direction value) {
    direction = value;
  }
  public Direction getDirection() {
    return direction;
  }

  public Rover(Coordinates coordinatesValue, Direction directionValue) {
    setCoordinates(coordinatesValue);
    setDirection(directionValue);
  }
  
}
  // public void receiveCommands(String commands) throws Exception {
  //   for (char command: