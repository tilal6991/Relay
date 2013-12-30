package com.fusionx.relay.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UpdateableTreeSet<E extends UpdateableTreeSet.Updateable> extends TreeSet<E> {

    private final Set<E> toBeAdded = new HashSet<E>();

    public UpdateableTreeSet(Comparator<? super E> comparator) {
        super(comparator);
    }

    public void markForAddition(E element) {
        toBeAdded.add(element);
    }

    public synchronized void addMarked() {
        addAll(toBeAdded);
        toBeAdded.clear();
    }

    public synchronized void update(E element, Object newValue) {
        if (remove(element)) {
            element.update(newValue);
            add(element);
        }
    }

    public interface Updateable {

        void update(Object newValue);
    }
}