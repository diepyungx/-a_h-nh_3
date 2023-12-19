import java.awt.*;

public abstract class Shape {
    protected String color;
    protected boolean filled;
    protected Point position;
    protected double velocity;

    public Shape() {
        this.color = "unknown";
        this.filled = false;
    }

    /**
     * Constructor.
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**.*/
    public Shape(double velocity, Point initialPosition) {
        this.velocity = velocity;
        this.position = initialPosition;
    }

    /**
     * getColor.
     */
    public String getColor() {
        return color;
    }

    /**
     * setColor.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * IsFilled.
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * setFilled.
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * getArea.
     */
    public double getArea() {
        return 0;
    }

    /**
     * getPerimeter.
     */
    public double getPerimeter() {
        return 0;
    }

    /**
     *hashCode.
     */
    public int hasCode() {
        return 0;
    }

    /**
     * toString.
     */
    public String toString() {
        return ",color=" + color + ",filled=" + filled;
    }



    /**.*/
    public double getVelocity() {
        return velocity;
    }

    /**.*/
    public void setVelocity(double velocity) {
        this.velocity = velocity;

    }

    /**.*/
    public abstract void draw(Graphics g);

    /**.*/
    public void move() {
        double deltaX = velocity;
        double deltaY = velocity;

        position.setPointX(position.getPointX() + deltaX);
        position.setPointY(position.getPointY() + deltaY);
    }

    public abstract boolean collidesWith(Shape other);

}

