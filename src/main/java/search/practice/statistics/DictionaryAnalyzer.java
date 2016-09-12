package search.practice.statistics;

import anaydis.search.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by isabel on 9/12/16.
 */
public class DictionaryAnalyzer {

    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private ArrayList<String> dictionary;


    public DictionaryAnalyzer() {
        dictionary = new ArrayList<String>();
    }

    public void analyze(String file, int length) {
        try {
            File file2 = new File(file);
            fr = new FileReader (file2);
            br = new BufferedReader(fr);

            String s;
            for(int i = 0; i < length; i++) {
                if((s = br.readLine()) != null) aux(s);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{

            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }

        }

    }


    private void aux(String linea) {
        if(linea.equals("")) return;
        String[] words = remove(linea).replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        //System.out.println(linea);
        addLine(words);
    }

    private void addLine(String[] words) {
        for (String m : words) {
            if (dictionary.contains(m)) dictionary.add(m);
        }
    }


    private static String remove(String input) {
        String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String output = input;
        for (int i=0; i<original.length(); i++) {
            output = output.replace(original.charAt(i), ascii.charAt(i));
        }
        return output;
    }


    public ArrayList<String> getDictionary() {
        return dictionary;
    }

}

