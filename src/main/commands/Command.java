package main.commands;

import main.Graph;

public interface Command<V> {
    Iterable<V> execute(Graph<V> G, V start, V end);
}
