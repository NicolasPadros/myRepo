package anaydis.sort.gui;

/**
 * Created by isabel on 8/23/16.
 */
public class CountSorterListener implements SorterListener {
    private int swaps;
    private int greaters;
    private long initialTime;
    private long sortingTime;



    public CountSorterListener() {
        swaps = 0;
        greaters = 0;
    }

    public void init(){
        initialTime = System.nanoTime();
    }

    public void finish(){
        sortingTime = System.nanoTime() - initialTime;
    }

    @Override
    public void box(int from, int to) {

    }

    @Override
    public void copy(int from, int to, boolean copyToAux) {

    }

    @Override
    public void equals(int i, int j) {

    }

    @Override
    public void greater(int i, int j) {
        greaters++;
    }

    @Override
    public void swap(int i, int j) {
            swaps++;
    }


}
