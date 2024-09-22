package exercise;

// BEGIN
public class Circle {
    private Point center;
    private int radius;

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if(getRadius() < 0 ){
            throw new NegativeRadiusException("");
        }
        return Math.PI * Math.pow(radius, 2);
    }

    public Circle(Point point, int radius) {
        center = point;
        this.radius = radius;
    }
}
// END
