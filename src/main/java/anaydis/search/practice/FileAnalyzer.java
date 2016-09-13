package anaydis.search.practice;

import anaydis.search.Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by isabel on 9/10/16.
 */
public class FileAnalyzer {

    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private Map<String, Integer> map;
    private int fails;
    private int success;
    private long initialTime;
    private long searchingTime;
    private ArrayList<String> dictionary;
    private int wordsCount;


    public FileAnalyzer(Map<String, Integer> map) {
        this.map = map;
        fails = 0;
        success = 0;
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

    public void search(String file, int length) {
        try {
            File file2 = new File(file);
            fr = new FileReader (file2);
            br = new BufferedReader(fr);

            String s;
            long initialTime = System.nanoTime();
            while(wordsCount < length && wordsCount < map.size()) {
                if((s = br.readLine()) != null) search(s);
            }
            wordsCount = 0;

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

    private void search(String s) {
        if(s.equals("")) return;
        String[] words = s.split("\\s+");
        wordsCount += words.length;
        for(String m : words){
        }
        System.out.println(wordsCount);
        searchingTime = System.nanoTime() - initialTime;
    }

    private void aux(String linea) {
            if(linea.equals("")) return;
            String[] words = remove(linea).replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            //System.out.println(linea);
            addLine(words);
        }

    private void addLine(String[] words) {
        for (String m : words) {
            if (map.containsKey(m)) map.put(m, map.get(m) + 1);
            else {
                map.put(m, 1);
            }
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
        Iterator<String> iterator = map.keys();
        ArrayList<String> dictionary = new ArrayList<String>();

        while(iterator.hasNext()) dictionary.add(iterator.next());
        return dictionary;
    }

    public long getSearchingTime() {
        return searchingTime;
    }

    public int getFails() {
        return fails;
    }

    public int getSuccess() {
        return success;
    }
}
