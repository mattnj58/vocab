import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Vocab {

    public static void main(String[] args) throws InterruptedException {
//        String vocab = "Dictionaries/vocab";
        String testNum = "12";
        String vocab = "Dictionaries/test"+testNum;
//        String vocab = "Dictionaries/vocab";
        HashMap<String, String> dict = createDict(vocab);
        Random rand = new Random();
        int wordNum = rand.nextInt(dict.size());

        System.out.println("Dictionary Size: "+dict.size());

        ArrayList<String> words = new ArrayList<>(dict.keySet());

        System.out.println(words.get(wordNum));
        Thread.sleep(6000);
        System.out.println(dict.get(words.get(wordNum)));
    }

    private static HashMap createDict(String vocab){
        BufferedReader reader;
        String line1;
        String line2;
        HashMap<String, String > dict = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(vocab));
            line1 = reader.readLine();
            line2 = reader.readLine();
            while (line1 != null && line2!=null) {

                dict.put(line1, line2);

                line1 = reader.readLine();
                line2 = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dict;
    }
}
