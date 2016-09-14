package main;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by FliaPadros on 13/9/2016.
 */
public class GraphAdy implements Graph {
        private Object[] V;
        private int[][] A;
        private int n;
        private int alpha;
        public GraphAdy() {
            V = new Object[10];
            A = new int[10][10];
            n = 0;
            alpha = 0;
        }
        public GraphAdy(int size) {
            V = new Object[size];
            A = new int[size][size];
            n = 0;
            alpha = 0;
        }

    @Override
    public void addVertex(Object x) {
        V[n] = x;
        n++;

    }

    @Override
    public void addEdge(int v, int w) {
        Integer oldV = A[v][w];
        if(oldV == null) A[v][w]=A[w][v] = oldV+1;
        else A[v][w]=A[w][v] = oldV+1;
        alpha++;
    }

    @Override
    public void removeEdge(int v, int w) {
        Integer oldV = A[v][w];
        if(oldV == 0) throw new NoSuchElementException("No edges to remove");
        else A[v][w]=A[w][v] = oldV-1;
        alpha--;

    }

    @Override
    public void removeVertex(int v) {
        for (int w = 0; w < n ; w++)
            if (A[v][w] != 0) removeEdge(v, w);
        V[v] = null;
        n--;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        return A[v][w] > 0;
    }

    @Override
    public int order() {
        return n;
    }

    @Override
    public int edges() {
        return alpha;
    }

    @Override
    public Object seeVertex(int v) {
        return V[v];
    }

    @Override
    public List<Integer> getadyList(int v) {
        List<Integer> list = new ArrayList<Integer>();
        for (int w = 0; w < n ; w++)
            if (A[v][w] > 0)
                list.add(w);
        return list;
    }

    public int laces() {
        int n = 0;
        for (int w = 0; w < n; w++)
            if (A[w][w] > 0)
                n += A[w][w];
        return n;
    }

    public Object[] lacesArray(){
        Object[] laces = new Object[laces()];
        int i = 0;
        for (int w = 0; w < n; w++)
            if (A[w][w] > 0)
                laces[i++] = w;
        return laces;
    }

    public boolean isIsolated(int v){
        for (int w = 0; w < n; w++)
            if (A[v][w] == 0 || A[w][v] == 0) return true;
        return false;
    }

    public int isolatedVertexesCount(){
        int i = 0;
        for (int w = 0; w < n; w++)
            if(isIsolated(w)) i++;
        return i;
    }

    public Object[] isolatedArray(){
        Object[] isolated = new Object[isolatedVertexesCount()];
        int i = 0;
        for (int w = 0; w < n; w++)
            if (isIsolated(w)) isolated[i++] = w;
        return isolated;
    }

    public Graph noLacesNoIsolatedGraph(){
        Graph result = new GraphAdy();
        Object[] laces = lacesArray();
        for (int v = 0; v < n; v++){
            if (!isIsolated(v)) result.addVertex(v);
                for (int w = v+1; w< n; w++){
                    if(hasEdge(v, w)) result.addEdge(v, w);
            }
        }
        return result;
    }
}
