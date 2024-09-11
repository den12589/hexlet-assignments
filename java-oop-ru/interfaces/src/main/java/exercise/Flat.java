package exercise;

// BEGIN

public class Flat implements Home {
    double area;
    double balconyArea;
    int flat;

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + flat + " этаже" ;
    }

    public Flat(double area, double balconyArea, int flat) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.flat = flat;
    }
}
// END
