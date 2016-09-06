package anaydis.sort.statistics;

import anaydis.sort.SorterType;
import anaydis.sort.gui.SorterListener;

import static anaydis.sort.statistics.writer.StatisticsWriter.writeRecord;

/**
 * Created by isabel on 8/23/16.
 */
public class CountSorterListener implements SorterListener {
    private int swaps;
    private int greaters;
    private long initialTime;
    private long sortTime;
    private int length;
    private int equals;
    private SorterType type;
    private Class dataType;
    private int copies;


    public CountSorterListener() {
        swaps = 0;
        greaters = 0;
        equals = 0;
        copies = 0;
    }

    public void init(){
        initialTime = System.nanoTime();
    }

    public void finish(){
        sortTime = System.nanoTime() - initialTime;
        writeRecord(this, "Statistics");
    }


    @Override
    public void box(int from, int to) {

    }

    @Override
    public void copy(int from, int to, boolean copyToAux) {
        copies++;
    }

    @Override
    public void equals(int i, int j) {
        equals++;
    }

    @Override
    public void greater(int i, int j) {
        greaters++;
    }

    @Override
    public void swap(int i, int j) {
            swaps++;
    }

    public void setDataType(Class dataType) {
        this.dataType = dataType;
    }

    public void length(int length){
        this.length = length;
    }

    public void setSorterType(SorterType type){
        this.type = type;
    }

    public int getLength(){
        return length;
    }

    public SorterType getSorterType() {
        return type;
    }

    public long getNanoTime() {
        return sortTime;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getComparations() {
        return greaters;
    }

    public Class getDataType() {
        return dataType;
    }



}
