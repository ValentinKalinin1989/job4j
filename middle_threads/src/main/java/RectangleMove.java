import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int x = 1;
        int y = 1;
        while (true) {
            this.rect.setX(this.rect.getX() + x);
            this.rect.setY(this.rect.getY() + y);
            if ((rect.getX() >= 300)) {
                x *= -1;
            }
            if ((rect.getX() <= 0)) {
                x *= -1;
            }
            if ((rect.getY() >= 300)) {
                y *= -1;
            }
            if ((rect.getY() <= 0)) {
                y *= -1;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}