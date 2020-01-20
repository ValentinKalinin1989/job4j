package tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    public Node<E> root;
    private int modCount = 0;

    /**
     * конструктор инициализирует корень дерева
     *
     * @param value
     */
    public Tree(E value) {

        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        Node<E> childIn = findBy(child).orElse(null);

        if (childIn != null) {
            return false;
        }

        if (!findBy(parent).isPresent()) {
            return false;
        }

        Node<E> parentIn = findBy(parent).get();
        List<Node<E>> listChild = parentIn.children;
        Node<E> children = new Node<>(child);
        parentIn.children.add(children);
        modCount++;
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue((E) value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private ArrayList<Node<E>> arrayList = new ArrayList<>();

            {
                arrayList.add(root);
            }

            private int index = 0;
            private int modIter = modCount;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (modIter != modCount) {
                    throw new ConcurrentModificationException("Размер дерева был увеличен");
                }
                if (index == arrayList.size()) {
                    ArrayList<Node<E>> arrayChildre = new ArrayList<>();
                    for (Node<E> node : arrayList) {
                        arrayChildre.addAll(node.children);
                    }
                    arrayList = arrayChildre;
                    index = 0;
                }
                if (index < arrayList.size()) {
                    result = true;
                }

                if (arrayList.isEmpty()) {
                    return false;
                }

                return result;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Нет элементов");
                }
                return arrayList.get(index++).value;
            }

        };
    }

    public boolean isBinary() {
        boolean result = true;
        Iterator iterBin = this.iterator();
        while (iterBin.hasNext()) {
            if (findBy((E) iterBin.next()).get().children.stream().count() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }
}
