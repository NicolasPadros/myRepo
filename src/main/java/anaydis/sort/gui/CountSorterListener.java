package anaydis.sort.gui;

/**
 * Created by isabel on 8/23/16.
 */
public class CountSorterListener implements SorterListener {
    private int swaps;
    private int greaters;
    private long initialTime;


    public CountSorterListener() {
        swaps = 0;
        greaters = 0;
    }

    public void init(){
        initialTime = System.currentTimeMillis();
    }

    public void finish(){
        long sortTime = System.currentTimeMillis() - initialTime;
        System.out.println("Total sorting time: " + sortTime);
        System.out.println("Total number of swaps: " + swaps);
        System.out.println("Total number of comparisons: " + greaters);
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
