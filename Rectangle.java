import java.awt.*;
import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft;
    protected double width;
    protected double length;

    public Rectangle(double width, double height, Color color, boolean b, Point position) {
    }

    /**.*/
    public Rectangle(double width, double length, double velocity, Point initialPosition) {
        super(velocity, initialPosition);
        this.width = width;
        this.length = length;
    }


    /**
     * Constructor1.
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor2.
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor3.
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    /**
     * getTopLeft.
     */
    public Point getTopLeft() {
        return topLeft;
    }

    /**
     * setTopLeft.
     */
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    /**
     * getWidth.
     */
    public double getWidth() {
        return width;
    }

    /**
     * setWidth.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * getLength.
     */
    public double getLength() {
        return length;
    }

    /**
     * setLength.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * getArea.
     */
    public double getArea() {
        return width * length;
    }

    /**
     * getPerimeter.
     */
    public double getPerimeter() {
        return 2 * (width + length);
    }

    /**
     * equals.
     */
    public boolean equals(Object o) {
        boolean check;
        if (o instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) o;
            if (rectangle == this) {
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
        return Objects.hash(width, length, topLeft);
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        String d = super.toString();
        return "Rectangle[topLeft=" + topLeft + ",width=" + width + ",length=" + length + d + "]";
    }

    /**
     * toStringg.
     */
    public String toStringg() {
        String t = super.toString();
        return t;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int) position.getPointX(), (int) position.getPointY(), (int) width, (int) length);
    }

    @Override
    public void move() {
        double deltaX = velocity;
        double deltaY = 0;

        position.setPointX(position.getPointX() + deltaX);
        position.setPointY(position.getPointY() + deltaY);
    }

    @Override
    public boolean collidesWith(Shape other) {
        if (other instanceof Circle) {
            Circle circle = (Circle) other;
            double deltaX = Math.max(topLeft.getPointX() - circle.getCenter().getPointX(), 0);
            double deltaY = Math.max(topLeft.getPointY() - circle.getCenter().getPointY(), 0);

            double distanceSquared = deltaX * deltaX + deltaY * deltaY;

            double radiusSquared = circle.getRadius() * circle.getRadius();

            return distanceSquared <= radiusSquared;
        }
        return false;
    }
}
