import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int x;
    private int y;

    public RectangleMove(Rectangle rect, int x, int y) {
        this.rect = rect;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        int deltaX = 1;
        int deltaY = 1;
        while (!Thread.currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + deltaX);
            this.rect.setY(this.rect.getY() + deltaY);
            if ((rect.getX() >= this.x) || (rect.getX() <= 0)) {
                deltaX *= -1;
            }
            if ((rect.getY() >= this.y) || (rect.getY() <= 0)) {
                deltaY *= -1;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}