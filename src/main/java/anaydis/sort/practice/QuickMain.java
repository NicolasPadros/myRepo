package anaydis.sort.practice;

import anaydis.sort.HSorter;
import anaydis.sort.QuickSorter;
import anaydis.sort.ShellSorter;
import jdk.nashorn.tools.Shell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by isabel on 8/27/16.
 */
public class QuickMain {
    public static void main(String[] args) {
        QuickSorter sorter = new QuickSorter();
        List<Integer> list = new ArrayList<>(10);
        for(int i = 0; i < 10; i++){
            list.add((int)(Math.random()*100));
        }

        sorter.sort(Comparator.naturalOrder(), list);
        for(Integer i : list) System.out.println(i);
    }
}
