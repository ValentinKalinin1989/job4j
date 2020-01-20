package tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenTestIterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 3);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(8, 6);
        tree.add(4, 5);
        tree.add(4, 3);
        tree.add(5, 6);
        Iterator iterTree = tree.iterator();
        assertThat(iterTree.next(), is(1));
        assertThat(iterTree.next(), is(2));
        assertThat(iterTree.next(), is(3));
        assertThat(iterTree.next(), is(4));
        assertThat(iterTree.next(), is(5));
        assertThat(iterTree.next(), is(6));
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenTreeIsBinary() {
        Tree<Integer> tree = new Tree<>(1);

        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        tree.add(7, 8);

        assertThat(tree.isBinary(), is(true));
    }
}
