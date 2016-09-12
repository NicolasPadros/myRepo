package search.practice.statistics;


import anaydis.search.Map;
import org.junit.Test;
import search.ArrayMap;
import search.BinarySearchMap;
import search.RandomizedTreeMap;
import search.TreeMap;

import java.util.Comparator;

/**
 * Created by isabel on 9/10/16.
 */
public class QuijoteMain {
    public static void main(String[] args) {

        Map<String, Integer> randomMap = new BinarySearchMap<String, Integer>(10, Comparator.naturalOrder());
        String[] words = {"el", "nuevo", "el"};
        for (String m : words) {
            if (randomMap.containsKey(m)) {
                randomMap.put(m, randomMap.get(m) + 1);
            } else {
                randomMap.put(m, 1);
            }
        }



        int[] nSizes = {10, 50000, 100000, 150000, 200000};
        for(int i = 0; i < nSizes.length; i++){
            FileAnalyzer arrayMapAnalyzer = new FileAnalyzer(new BinarySearchMap<String, Integer>(nSizes[i], Comparator.naturalOrder()));
            FileAnalyzer randomizedTreeMapAnalyzer = new FileAnalyzer(new RandomizedTreeMap<String, Integer>(Comparator.naturalOrder()));
            arrayMapAnalyzer.analyze("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijote.txt", nSizes[i]);
            randomizedTreeMapAnalyzer.analyze("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijote.txt", nSizes[i]);
            arrayMapAnalyzer.search("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijoteReversed.txt", nSizes[i]);
            randomizedTreeMapAnalyzer.search("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijoteReversed.txt", nSizes[i]);
            //System.out.println("ArrayMapTime: " + arrayMapAnalyzer.getSearchingTime());
            System.out.println("RandomizedTreeMap: " + randomizedTreeMapAnalyzer.getSearchingTime());
            //System.out.println("ArrayMap: " + randomizedTreeMapAnalyzer.getSuccess());
            System.out.println("RandomizedTreeMap: " + randomizedTreeMapAnalyzer.getSuccess());

        }
    }

    //Writes a document with 200.000 reversed words to be read and sought by the analyzer
    //Notated as Test to be ran separately from the main() method
     @Test
    public  void Writermain() {
         FileAnalyzer analyzer = new FileAnalyzer(new TreeMap<String, Integer>(Comparator.naturalOrder()));
         analyzer.analyze("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijote.txt", 200000);
         FileWriter writer = new FileWriter(analyzer.getDictionary());
         writer.write("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijoteReversed2.txt", 200000);
    }

}
