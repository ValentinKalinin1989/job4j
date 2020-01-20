package map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private int size = 16;
    private int index = 0;
    private int modCount = 0;
    private Node[] container;

    public SimpleHashMap() {
        this.container = new Node[size];
    }

    /**
     * получение индекса элемента на основе хэш-кода
     *
     * @param key ключ для получениея индеса элемента в массиве
     * @return индекс для размещения элемента в массиве
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    /**
     * увелечение массива на 16 элементов и перенос элементов в новый массив
     */
    private void increaseSize() {
        this.size += 16;
        Node[] newCont = new Node[size];
        for (Node node : this.container) {
            newCont[hash((K) node.getKey())] = node;
        }
        this.container = newCont;
    }

    /**
     * добавление элемента в массив
     *
     * @param key   ключ
     * @param value значение
     * @return результат добавления true, либо false
     */
    public boolean insert(K key, V value) {
        int position = hash(key);
        if (this.container[position] != null) {
            if (this.container[position].getKey().equals(key)) {
                this.container[position] = new Node(key, value);
                return true;
            }
            return false;
        }
        this.container[position] = new Node(key, value);
        index++;
        modCount++;
        if (this.index == this.size) {
            increaseSize();
        }
        return true;
    }

    public V get(K key) {
        return (V) this.container[hash(key)].getValue();
    }

    public boolean delete(K key) {
        boolean result = false;
        if (this.container[hash(key)].getKey().equals(key)) {
            this.container[hash(key)] = null;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int modCountIer = modCount;
            int indexIter = 0;

            @Override
            public boolean hasNext() {
                if (this.modCountIer != modCount) {
                    throw new ConcurrentModificationException("Массив был увеличен");
                }
                for (int i = this.indexIter; i < size; i++) {
                    if (container[i] != null) {
                        this.indexIter = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Отсутвует элементы");
                }
                return (V) container[indexIter++].getValue();
            }

            public Node<K, V> nextFBin() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Отсутвует элементы");
                }
                return (Node<K, V>) container[indexIter++];
            }
        };
    }


    private static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
