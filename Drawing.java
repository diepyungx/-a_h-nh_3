import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Color;

public class Drawing extends JFrame {
    private Layer layer;

    public Drawing() {
        layer = new Layer();
        setTitle("Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(layer);

        addKeyListener(new ShapeKeyListener());

        setFocusable(true);

        Thread moveThread = new Thread(new MoveShapesTask());
        moveThread.start();
    }

    private class ShapeKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            char keyChar = e.getKeyChar();
            switch (keyChar) {
                case 'c':
                    addRandomCircle();
                    break;
                case 'r':
                    addRandomRectangle();
                    break;
                case 's':
                    addRandomSquare();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private void addRandomSquare() {
        Random rand = new Random();
        double side = rand.nextDouble() * 50 + 20;
        Point position = new Point(rand.nextInt(600), rand.nextInt(400));
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        Square square = new Square(side, color, true, position);
        layer.addShape(square);

        layer.repaint();
    }

    private void addRandomCircle() {
        Random rand = new Random();
        double radius = rand.nextDouble() * 50 + 20;
        Point position = new Point(rand.nextInt(600), rand.nextInt(400)); // Vị trí ngẫu nhiên
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Màu sắc ngẫu nhiên
        double velocity = rand.nextDouble() * 5;

        Circle circle = new Circle(radius, color, true, position);
        circle.setVelocity(velocity);
        layer.addShape(circle);
        layer.repaint();
    }


    private void addRandomRectangle() {
        Random rand = new Random();
        double width = rand.nextDouble() * 50 + 20; // Random width between 20 and 70
        double height = rand.nextDouble() * 50 + 20; // Random height between 20 and 70
        Point position = new Point(rand.nextInt(600), rand.nextInt(400)); // Random position within the JFrame
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Random color
        Rectangle rectangle = new Rectangle(width, height, color, true, position);
        layer.addShape(rectangle);
        layer.repaint();
    }

    private class MoveShapesTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                moveAllShapes();
                checkCollisions();

                layer.repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Inside the MoveShapesTask class
    private void moveAllShapes() {
        for (Shape shape : layer.getShapes()) {
            shape.move();
        }
    }

    // Inside the MoveShapesTask class
    private void checkCollisions() {
        int size = layer.getShapes().size();

        for (int i = 0; i < size - 1; i++) {
            Shape shape1 = layer.getShapes().get(i);
            for (int j = i + 1; j < size; j++) {
                Shape shape2 = layer.getShapes().get(j);
                if (shape1.collidesWith(shape2)) {
                    handleCollision(shape1, shape2);
                }
            }
        }
    }

    public void handleCollision(Shape shape1, Shape shape2) {
        shape1.setColor(String.valueOf(Color.YELLOW));
        shape2.setColor(String.valueOf(Color.YELLOW));
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Drawing app = new Drawing();
            app.setVisible(true);
        });
    }
}
