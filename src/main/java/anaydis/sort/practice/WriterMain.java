package anaydis.sort.practice;

import anaydis.sort.statistics.writer.CSVWriter;

/**
 * Created by isabel on 8/26/16.
 */
public class WriterMain {
    public static void main(String[] args) {
        CSVWriter writer = new CSVWriter("Estad");
        writer.writeString("hola");
    }
}
