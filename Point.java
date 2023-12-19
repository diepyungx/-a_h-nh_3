import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    /**
     * Constructor1.
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    /**
     * getPointX.
     */
    public double getPointX() {
        return pointX;
    }

    /**
     * setPointX.
     */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    /**
     * getPointY.
     */
    public double getPointY() {
        return pointY;
    }

    /**
     * setPointY.
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * distance.
     */
    public double distance(Point newPoint) {
        double delX = newPoint.getPointX() - this.getPointX();
        double delY = newPoint.getPointY() - this.getPointY();
        return Math.sqrt(delX * delX - delY * delY);
    }

    /**
     * equlas.
     */
    @Override
    public boolean equals(Object o) {
        boolean check;
        if (o instanceof Point) {
            Point tmp = (Point) o;
            if ((this.pointX == tmp.getPointX()) && (this.pointY == tmp.getPointY())) {
                check = true;
            } else {
                check = false;
            }

        } else {
            check = false;
        }

        return check;
    }

    /**.*/
    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        return "(" + pointX + "," + pointY + ")";
    }
}


