package search.practice.statistics;


/**
 * Created by isabel on 9/10/16.
 */
public class QuijoteMain {
    public static void main(String[] args) {
        FileAnalyzer analyzer = new FileAnalyzer();
        analyzer.analyze("/home/isabel/Documents/Repos/npadros/src/main/resources/books/quijote.txt", 50);
        analyzer.printDictionary();
    }

}
