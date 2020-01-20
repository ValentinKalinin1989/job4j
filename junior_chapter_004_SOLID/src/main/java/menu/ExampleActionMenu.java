package menu;

import menu.action.MenuAction;

import java.util.List;
import java.util.StringJoiner;

public class ExampleActionMenu implements Action {

    private final SimpleMenu menu;
    private final MenuAction action;

    public ExampleActionMenu(SimpleMenu menu, MenuAction action) {
        this.menu = menu;
        this.action = action;
    }

    public void addMenuItem(ExampleActionMenu bullet1) {
        this.menu.addMenuItem(bullet1.menu);
    }


    public String getFullMenu() {
        StringBuilder actual = new StringBuilder();
        List<SimpleMenu> fullMenu = this.menu.getSubMenuTree();
        for (SimpleMenu menu : fullMenu
        ) {
            actual.append(getPrintName(menu));
        }
        return actual.toString();
    }

    /**
     * Get name in format (--- name 4.1.1)
     *
     * @return formatted name
     */
    public String getPrintName(SimpleMenu menu) {
        String fullNum = menu.getFullNumber(".");
        int level = fullNum.split("\\.").length;
        StringBuilder bullets = new StringBuilder();
        for (int i = 0; i < level - 1; i++) {
            bullets.append("--");
        }

        StringJoiner result = new StringJoiner(" ");
        result.add(bullets).add(menu.getName()).add(fullNum);

        return result.toString().trim();
    }

    /**
     * do action
     */
    public void doAction() {
        if (this.action == null) {
            throw new NoSuchMenuAction("no action");
        }
        this.action.doAction();
    }
}
