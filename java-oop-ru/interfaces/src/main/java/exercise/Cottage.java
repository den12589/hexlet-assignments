package exercise;

// BEGIN
public class Cottage implements Home{
    double area;
    int floorCount;


    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
}
// END
