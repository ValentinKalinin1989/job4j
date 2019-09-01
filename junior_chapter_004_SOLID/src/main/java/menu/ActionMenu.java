package menu;

import menu.action.MenuAction;

public class ActionMenu extends Menu {

    private final MenuAction action;

    public ActionMenu(String name, MenuAction action) {
        super(name);
        this.action = action;
    }

    /**
     * do action
     */
    public void doAction() {
        if (action != null) {
            action.doAction();
        } else {
            System.out.println("no action");
        }
    }
}
