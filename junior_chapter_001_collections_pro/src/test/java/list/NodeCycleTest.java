package list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class NodeCycleTest {


    @Test
    public void testNodeCycleWithResultTrue() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        NodeCycle nodeCycle = new NodeCycle();
        assertThat(nodeCycle.hasCycle(first), is(true));
    }

    @Test
    public void testNodeCycleWithResultFalse() {
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        NodeCycle nodeCycle = new NodeCycle();
        assertThat(nodeCycle.hasCycle(first), is(false));
    }

}
