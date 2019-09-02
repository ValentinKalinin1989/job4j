package menu;

public class NoSuchMenuAction extends RuntimeException {

    public NoSuchMenuAction() {
    }

    public NoSuchMenuAction(String message) {
        super(message);
    }
}
