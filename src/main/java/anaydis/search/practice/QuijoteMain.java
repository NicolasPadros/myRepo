package anaydis.search.practice;


import anaydis.search.BinarySearchMap;
import anaydis.search.RandomizedTreeMap;

import java.util.Comparator;

/**
 * Created by isabel on 9/10/16.
 */
public class QuijoteMain {
    public static void main(String[] args) {



        //Set as a comment to stop it from running
        //WriterMain();

        int[] nSizes = {5000, 50000, 100000, 150000, 200000};
        for(int i = 0; i < nSizes.length; i++){
            System.out.println("N: " + nSizes[i]);
            FileAnalyzer arrayMapAnalyzer = new FileAnalyzer(new BinarySearchMap<String, Integer>(200000, Comparator.naturalOrder()));
            FileAnalyzer randomizedTreeMapAnalyzer = new FileAnalyzer(new RandomizedTreeMap<String, Integer>(Comparator.naturalOrder()));
            arrayMapAnalyzer.analyze("src/main/resources/books/quijote.txt", nSizes[i]);
            randomizedTreeMapAnalyzer.analyze("src/main/resources/books/quijote.txt", nSizes[i]);
            arrayMapAnalyzer.search("src/main/resources/books/quijoteReversed.txt", nSizes[i]);
            randomizedTreeMapAnalyzer.search("src/main/resources/books/quijoteReversed.txt", nSizes[i]);
            System.out.println("ArrayMapTime: " + arrayMapAnalyzer.getSearchingTime());
            System.out.println("RandomizedTreeMap: " + randomizedTreeMapAnalyzer.getSearchingTime());
            System.out.println("ArrayMap: " + randomizedTreeMapAnalyzer.getSuccess());
            System.out.println("RandomizedTreeMap: " + randomizedTreeMapAnalyzer.getSuccess());
        }
    }

    //Writes a document with 200.000 reversed words to be read and sought by the analyzer
    public static void WriterMain() {
         DictionaryAnalyzer analyzer = new DictionaryAnalyzer();
         analyzer.analyze("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijote.txt", 200000);
         FileWriter writer = new FileWriter(analyzer.getDictionary());
         writer.write("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijoteReversed2.txt", 200000);
    }

}
