import java.awt.*;
import java.util.Objects;

public class Square extends Rectangle {
    public Square(double side, Color color, boolean b, Point position) {
        super(side,side, color, true, position);
    }

    /**
     * Constructor1.
     */
    public Square(double side) {
        super(side, side);
    }

    /**.*/
    public Square(double side, double velocity, Point initialPosition) {
        super(side,side, velocity, initialPosition);
    }


    /**
     * Constructor2.
     */
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    /**
     * Constructor3.
     */
    public Square(Point topLeft, double side, String color, boolean filled) {
        super(side, side, color, filled);
        this.topLeft = topLeft;
    }

    /**
     * getSide.
     */
    public double getSide() {
        return getLength();
    }

    /**
     * setSide.
     */
    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    /**
     * setWidth.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * setLength.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**.*/
    public boolean equals(Object o) {
        boolean check;
        if (o instanceof Square) {
            Square square = (Square) o;
            if (square == this) {
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
        return Objects.hash(getSide());
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        String f = super.toStringg();
        return "Square[topLeft=" + getTopLeft() + ",side=" + getSide() + f + "]";
    }

    @Override
    public void move() {
        double deltaX = velocity;
        double deltaY = 0;

        position.setPointX(position.getPointX() + deltaX);
        position.setPointY(position.getPointY() + deltaY);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) position.getPointX(), (int) position.getPointY(), (int) getSide(), (int) getSide());
    }

    @Override
    public boolean collidesWith(Shape other) {
        if (other instanceof Circle) {
            Circle circle = (Circle) other;

            // Tính khoảng cách giữa tâm hình tròn và góc trên bên trái của hình vuông
            double deltaX = Math.max(topLeft.getPointX() - circle.getCenter().getPointX(), 0);
            double deltaY = Math.max(topLeft.getPointY() - circle.getCenter().getPointY(), 0);

            // Tính bình phương khoảng cách
            double distanceSquared = deltaX * deltaX + deltaY * deltaY;

            // Tính bình phương của bán kính hình tròn
            double radiusSquared = circle.getRadius() * circle.getRadius();

            // Kiểm tra xem hình tròn và hình vuông có va chạm không
            return distanceSquared <= radiusSquared;
        }
        // Handle other shape types if needed
        return false;
    }
}

