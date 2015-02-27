package marsrover;

public class Coordinates {

    private Point x;
    public void setX(Point value) { x = value; }
    public Point getX() { return x; }

    private Point y;
    public void setY(Point value) { y = value; }
    public Point getY() { return y; }

    public Coordinates(int xValue, int yValue, int maxXValue, int maxYValue) {
      setX(new Point(xValue, maxXValue));
      setY(new Point(yValue, maxYValue));
    }

    public void move(final Direction direction) {
        int xLocation = x.getLocation();
        int yLocation = y.getLocation();
        switch (direction) {
            case NORTH:
                yLocation = y.getForwardLocation();
                break;
            case EAST:
                xLocation = x.getForwardLocation();
                break;
            case SOUTH:
                yLocation = y.getBackwardLocation();
                break;
            case WEST:
                xLocation = x.getBackwardLocation();
                break;
        }
        x.setLocation(xLocation);
        y.setLocation(yLocation);
    }

    @Override
    public String toString() {
        return getX().getLocation() + " X " + getY().getLocation();
    }

}
