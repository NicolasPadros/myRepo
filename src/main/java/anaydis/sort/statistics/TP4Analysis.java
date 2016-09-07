package anaydis.sort.statistics;

import anaydis.sort.CutOffQuickSorter;
import anaydis.sort.MedianOfThreeQuickSorter;
import anaydis.sort.Sorter;
import anaydis.sort.SorterType;
import anaydis.sort.data.IntegerDataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;

import java.util.*;

import static anaydis.sort.CutOffQuickSorter.setM;

/**
 * Created by FliaPadros on 6/9/2016.
 */
public class TP4Analysis {

    public static void main(String[] args) {
        //testBestMain();
        testBestQuickSorterMain();
    }


    public static void testBestMain() {
        CutOffQuickSorter quick = new CutOffQuickSorter();
        IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        int[] sizes = {1000, 10000, 100000, 1000000};
        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 10; j++) {
                long recordTime = 1000000000;
                int index = 0;
                for (int i = 5; i <= 25; i++) {
                    List<Integer> list = generator.createRandom(sizes[k]);
                    setM(i);
                    long time = System.nanoTime();
                    quick.sort(Comparator.naturalOrder(), list);
                    time = (System.nanoTime() - time);
                    //System.out.println("N=" + 1000 + " M= " + i + " " + time + " ms");
                    if (time < recordTime) {
                        recordTime = time;
                        index = i;
                    }
                }
                System.out.println("For N: " + 100000 + ", best M= " + index + " with " + recordTime + " ms");
            }
        }
    }


    public static void testBestQuickSorterMain(){
        final SorterProvider provider = new SorterProviderImpl();
        final IntegerDataSetGenerator generator = new IntegerDataSetGenerator();
        List<Integer> original;



        final Sorter recursive = provider.getSorterForType(SorterType.QUICK);
        final Sorter nonRecursive = provider.getSorterForType(SorterType.QUICK_NON_RECURSIVE);
        final Sorter cutOff = provider.getSorterForType(SorterType.QUICK_CUT);
        final Sorter median = provider.getSorterForType(SorterType.QUICK_MED_OF_THREE);
        final Sorter threeWay = provider.getSorterForType(SorterType.QUICK_THREE_PARTITION);
        int[] sizes = {12500, 25000, 50000, 100000};
        CutOffQuickSorter.setM(25);
        MedianOfThreeQuickSorter.setM(25);
        for(int i = 0; i < 4; i++){
            System.out.println("N = " + sizes[i]);
            original = generator.createRandom(sizes[i]);
            recursive.sort(Comparator.<Integer>naturalOrder(), original);
            System.out.println("Recursive finished");
            original = generator.createRandom(sizes[i]);
            nonRecursive.sort(Comparator.<Integer>naturalOrder(), original);
            System.out.println("NonRecursive finished");
            original = generator.createRandom(sizes[i]);
            cutOff.sort(Comparator.<Integer>naturalOrder(), original);
            System.out.println("CutOff finished");
            original = generator.createRandom(sizes[i]);
            //median.sort(Comparator.<Integer>naturalOrder(), original);
            System.out.println("Median finished");
            original = generator.createRandom(sizes[i]);
            //threeWay.sort(Comparator.<Integer>naturalOrder(), original);
            System.out.println("3Way finished");
        }

    }


}
