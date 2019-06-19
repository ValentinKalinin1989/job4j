package control;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class FindDependTest {

    @Test
    public void whenTestDepend() {
        Map<Integer, List<Integer>> testMap = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        testMap.put(1, list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        testMap.put(2, list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(5);
        testMap.put(3, list3);
        testMap.put(4, new ArrayList<>());
        testMap.put(5, new ArrayList<>());
        FindDepend find = new FindDepend();
        List<Integer> result = find.load(testMap, 1);
        assertThat(result.get(0), is(2));
        assertThat(result.get(1), is(3));
        assertThat(result.get(2), is(4));
        assertThat(result.get(3), is(5));
    }
}
