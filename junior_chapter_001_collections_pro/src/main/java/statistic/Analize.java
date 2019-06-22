package statistic;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Analize {



    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info(0, 0, 0);

        Map<Integer, User> mapCur = new HashMap<>();
        for (User user: current) {
            mapCur.put(user.id, user);
        }

        for (User userPr: previous) {
            if (!mapCur.containsKey(userPr.id)) {
                result.plusDeleted();
            }
            if (mapCur.containsKey(userPr.id)) {
                if (!mapCur.get(userPr.id).name.equals(userPr.name)) {
                    result.plusChanged();
                }
                mapCur.remove(userPr.id);
            }
        }

        result.setAdded(mapCur.values().size());
        return result;

    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {

        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
           this.added = added;
           this.changed = changed;
           this.deleted = deleted;
        }

        public void plusAdded() {
            this.added++;
        }

        public void plusChanged() {
            this.changed++;
        }

        public void plusDeleted() {
            this.deleted++;
        }

        public int getAdded() {
            return this.added;
        }

        public int getChanged() {
            return this.changed;
        }

        public int getDeleted() {
            return this.deleted;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }
    }

}
