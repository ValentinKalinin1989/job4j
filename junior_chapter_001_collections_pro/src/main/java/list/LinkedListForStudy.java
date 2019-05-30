package list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListForStudy<E> implements Iterable<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> tail;
    private int modCount = 0;

    /**
     * Метод вставляет в конец списка данные.
     */
    public void add(E data) {
        if (this.size == 0) {
            Node<E> newLink = new Node<>(data);
           // newLink.next = this.first;
            //newLink.previos = this.first;
            this.first = newLink;
            this.tail = newLink;
            this.size++;
            this.modCount++;
        } else {
            Node<E> newLink = new Node<>(data);
            newLink.previos = this.tail; //ссылка на предыдущий элемент
            tail.next = newLink; //ссылка на следующий элемент
            this.tail = newLink;
            this.size++;
            this.modCount++;
        }
    }

    /**
     * Получает данные по индексу
     * @param index индекс
     * @return данные
     */
    public E get(int index) {
        if (index <= this.size / 2) {
            Node<E> resultif = this.first;
            for (int i = 1; i <= index; i++) {
                resultif = resultif.next;
            }
            return resultif.data;
        } else {
            Node<E> result = this.tail;
            for (int i = 0; i < size - index - 1; i++) {
                result = result.previos;
            }
            return result.data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> nodeIter = first;
            private int countIter = modCount;
            private int indexIt = 0;
            @Override
            public boolean hasNext() {
                if (this.countIter != modCount) {
                    throw new ConcurrentModificationException("Размер листа был увеличен");
                }
                return nodeIter != null;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Отсутвуют элементы");
                }
                E result = nodeIter.data;
                nodeIter = nodeIter.next;
                return result;
            }
        };
    }

    /*
    класс для хранения данных
     */

    private static class Node<E> {

        E data;
        Node<E> next;
        Node<E> previos;

        Node(E data) {
            this.data = data;
        }
    }
}


