package search.practice.statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by isabel on 9/10/16.
 */
public class FileAnalyzer {

        private static File archivo = null;
        private static FileReader fr = null;
        private static BufferedReader br = null;
        private List<String> dictionary;

    public FileAnalyzer() {
        dictionary = new ArrayList<String>();
    }

    public void analyze(String file, int length) {
            try {
                File file2 = new File(file);
                fr = new FileReader (file2);
                br = new BufferedReader(fr);

                String s;
                for(int i = 0; i < length; i++) {
                    s = br.readLine();
                    aux(s);
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
            System.out.println(linea);
            addDictionary(words);
        }

    private void addDictionary(String[] words) {
        for(String m : words) dictionary.add(m);
    }

    public void printDictionary(){
        for(String m : dictionary) System.out.println(m);
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


}
