import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class WordsCounter {
        public static void main(String[] args) throws IOException {
            Map<String,Integer> wordsMap = new TreeMap<String, Integer>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileReader = reader.readLine();
            reader.close();
            try {
                reader = new BufferedReader(new FileReader(fileReader));
                while (reader.ready()) {
                    String s = reader.readLine();
                    String[] words = s.split("[^a-zA-Zа-яА-Я]");
                    for (String poisk : words) {
                        poisk = poisk.toLowerCase();
                        Integer counter = 1;
                        if (poisk.length()>0) {
                            if (wordsMap.containsKey(poisk)) {
                                counter = wordsMap.get(poisk) + 1;
                                wordsMap.put(poisk, counter);
                            } else {
                                wordsMap.put(poisk, counter);
                            }
                        }
                    }
                }
                reader.close();
                int max = 0;
                for (Map.Entry entry : wordsMap.entrySet()) {
                    System.out.println(entry.toString());
                    if ((int)entry.getValue()>max){
                        max = (int)entry.getValue();
                    }
                }
                System.out.println("Maximum " + max);
                for (Map.Entry entry : wordsMap.entrySet()) {
                    if ((int)entry.getValue() == max){
                        System.out.println(entry.toString());
                    }
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

