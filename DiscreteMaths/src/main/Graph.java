package main;

import java.util.List;

/**
 * Created by FliaPadros on 13/9/2016.
 */
public interface Graph {
    void addVertex(Object x);
    void addEdge(int v, int w);
    void removeEdge(int v, int w);
    void removeVertex(int v);
    boolean hasEdge(int v, int w);
    int order();
    int edges();
    Object seeVertex(int v);
    List<Integer> getadyList(int v);
}

