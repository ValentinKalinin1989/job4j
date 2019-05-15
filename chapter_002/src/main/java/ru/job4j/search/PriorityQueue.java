package ru.job4j.search;

import java.util.LinkedList;
import java.util.stream.*;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var index = (int) tasks.stream().filter(taskFilter -> taskFilter.getPriority() <= task.getPriority()).count();
        tasks.add(index, task);
    }
    public Task take() {
        return this.tasks.poll();
    }
}
