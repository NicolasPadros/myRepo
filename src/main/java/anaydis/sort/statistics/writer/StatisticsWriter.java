package anaydis.sort.statistics.writer;



import anaydis.sort.statistics.CountSorterListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by isabel on 25/8/2016.
 */
public class StatisticsWriter {

    public static void writeRecord(CountSorterListener recordToWrite, String fileName){
        final CSVWriter writer = new CSVWriter(fileName);
        try {
            final BufferedReader br = new BufferedReader(new FileReader(fileName + ".csv"));
            if (br.readLine() == null) {
                writer.writeString("DATE");
                writer.addComma();
                writer.writeString("SORTER TYPE");
                writer.addComma();
                writer.writeString("DATA TYPE");
                writer.addComma();
                writer.writeString("LENGTH");
                writer.addComma();
                writer.writeString("SWAPS");
                writer.addComma();
                writer.writeString("COMPARITIONS");
                writer.addComma();
                writer.writeString("NANO TIME");
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        writer.writeString(getDateAndTime());
        writer.addComma();
        writer.writeString(recordToWrite.getSorterType().toString());
        writer.addComma();
        writer.writeString(recordToWrite.getDataType().toString());
        writer.addComma();
        writer.writeString(Integer.toString(recordToWrite.getLength()));
        writer.addComma();
        writer.writeString(Integer.toString(recordToWrite.getSwaps()));
        writer.addComma();
        writer.writeString(Integer.toString(recordToWrite.getComparations()));
        writer.addComma();
        writer.writeLong(recordToWrite.getNanoTime());
        writer.newLine();
        writer.close();
    }

    private static String getDateAndTime(){
        return (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
    }
}
