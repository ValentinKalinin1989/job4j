package control;

import java.util.*;

public class FindDepend {
    public List load(Map<Integer, List<Integer>> map, Integer scriptId) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> list4loop = new HashSet<>();

        list4loop.addAll(map.get(scriptId));
        result.addAll(map.get(scriptId));

        while (!list4loop.isEmpty()) {
            HashSet<Integer> listIn = new HashSet<>();
            for (Integer id: list4loop) {
                if (map.containsKey(id)) {
                    result.addAll(map.get(id));
                    listIn.addAll(map.get(id));
                    map.remove(id);
                }

            }
            list4loop = listIn;
        }

        return new ArrayList<Integer>(result);
    }
}
