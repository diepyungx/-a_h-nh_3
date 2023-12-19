import java.awt.*;
import java.util.Objects;

public class Circle extends Shape {
    protected Point center;
    protected double radius;

    public Circle(double radius, Color color, boolean b, Point position) {
    }

    /**
     * Constructor1.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor2.
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**.*/
    public Circle(double radius, double velocity) {
        super();
        this.radius = radius;
        this.velocity = velocity;
    }

    /**
     * Constructor3.
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    /**
     * getCenter.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * setCenter.
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * getRadius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * setRadius.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * getArea.
     */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * getPerimeter.
     */
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        String d = super.toString();
        return "Circle[" + "center=" + center + ",radius=" + radius + d + "]";
    }

    /**
     * equals.
     */
    @Override
    public boolean equals(Object o) {
        boolean check;
        if (o instanceof Circle) {
            Circle circle = (Circle) o;
            if (circle == this) {
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
        return Objects.hash(center, radius);
    }

    @Override
    public void move() {
        double angle = velocity / radius;
        double newX = position.getPointX() + radius * Math.cos(angle);
        double newY = position.getPointY() + radius * Math.sin(angle);


        position.setPointX(newX);
        position.setPointY(newY);
    }

    @Override
    public boolean collidesWith(Shape other) {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int) (position.getPointX() - radius), (int) (position.getPointY() - radius), (int) (2 * radius), (int) (2 * radius));
    }

}