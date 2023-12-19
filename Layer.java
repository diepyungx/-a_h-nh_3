import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Layer extends JPanel {
    private List<Shape> shapes;

    public Layer() {
        shapes = new ArrayList<>();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * addShape.
     */
    public void addShape(Shape s) {
        shapes.add(s);
    }

    /**
     * removeCircles.
     */
    public void removeCircles() {
        shapes.removeIf(shape -> shape instanceof Circle);
    }

    public void removeRectangle() {
        shapes.removeIf(shape -> shape instanceof Rectangle);
    }

    public void removeSquare() {
        shapes.removeIf(shape -> shape instanceof Square);
    }

    /**
     * getInfo.
     */
    public String getInfo() {
        StringBuffer info = new StringBuffer("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            info.append(shape.toString()).append("\n");
        }
        return info.toString();
    }

    /**
     * removeDuplicates.
     */
    public  void  removeDuplicates() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).hashCode() == shapes.get(j).hashCode()) {
                    shapes.remove(j);
                    j--;
                }
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            drawShape(g, shape);
        }
    }

    /**.*/
    private void drawShape(Graphics g, Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            g.setColor(Color.RED);
            g.fillOval((int) circle.getCenter().getPointX(), (int) circle.getCenter().getPointY(),
                    (int) (2 * circle.getRadius()), (int) (2 * circle.getRadius()));
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            g.setColor(Color.ORANGE);
            g.fillRect((int) rectangle.getTopLeft().getPointX(), (int) rectangle.getTopLeft().getPointY(),
                    (int) rectangle.getWidth(), (int) rectangle.getLength());
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            g.setColor(Color.GREEN);
            g.fillRect((int) square.getTopLeft().getPointX(), (int) square.getTopLeft().getPointY(),
                    (int) square.getSide(), (int) square.getSide());
        }
    }

    /**
     * Kiểm tra va chạm giữa các hình trong Layer.
     */
    public void detectCollisions() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                Shape shape1 = shapes.get(i);
                Shape shape2 = shapes.get(j);

                if (shape1.collidesWith(shape2)) {
                    // Xử lý va chạm giữa shape1 và shape2
                    // Ví dụ: Hiển thị thông báo, thay đổi màu sắc, v.v.
                }
            }
        }
    }

    public void moveShapes() {
        for (Shape shape : shapes) {
            shape.move();
        }
    }

    private void handleCollision(Shape shape1, Shape shape2) {
        System.out.println("Collision detected!");
    }

}
