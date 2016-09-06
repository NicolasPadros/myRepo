package anaydis.sort.statistics.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by isabel on 24/8/2016.
 */
public class CSVWriter {
    private BufferedWriter writer;

    public  CSVWriter(String fileName){
        try {
            FileWriter fileWriter = new FileWriter(fileName +".csv",true);
            writer = new BufferedWriter(fileWriter);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void writeLong(long toWrite){
        try {
            writer.write(Long.toString(toWrite));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeString(String toWrite){
        try {
            if(toWrite == null) writer.write("null");
            else {
                writer.write(toWrite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void newLine(){
        try {
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addComma(){
        try {
            writer.write(',');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }


}
