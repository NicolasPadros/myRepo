package search.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by isabel on 9/11/16.
 */
public class FileWriter {

    private File archivo = null;
    private java.io.FileWriter fr = null;
    private BufferedWriter br = null;
    private List<String> dictionary;

    public FileWriter(ArrayList<String> dictionary) {
        this.dictionary = dictionary;
    }

    public void write(String file, int length) {
        try {
            File file2 = new File(file);
            fr = new java.io.FileWriter(file2);
            br = new BufferedWriter(fr);

            String s;
            if(length < dictionary.size()) {
                for (int i = 0; i < length; i += 15) {
                    for (int j = i; j < i + 15; j++) {

                        br.write(new StringBuilder(dictionary.get(j)).reverse().toString() + " ");
                    }
                    br.write(System.lineSeparator());
                }
            }
            else {
                for (int i = 0; i < dictionary.size(); i += 15) {
                    for (int j = i; j < i + 15 && j < dictionary.size(); j++) {
                        br.write(new StringBuilder(dictionary.get(j)).reverse().toString() + " ");
                    }
                    br.write(System.lineSeparator());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{

            try{
                if( null != fr ){
                    br.close();
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }

        }
    }
}
