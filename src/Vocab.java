import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Vocab {

    public static void main(String[] args) throws InterruptedException {
        String testMain = "Dictionaries/testMain";
        String testNum = "Main";
        String vocab = "Dictionaries/test"+testNum;
        HashMap<String, String> dict = createDict(vocab);
        Random rand = new Random();
        int wordNum = rand.nextInt(dict.size());

        System.out.println("Test: " + testNum);
        System.out.println("Test Size: " + dict.size());

        ArrayList<String> words = new ArrayList<>(dict.keySet());

        System.out.println(words.get(wordNum));
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println((dict.get(words.get(wordNum))));
            System.exit(0);
        }
        System.out.println(dict.get(words.get(wordNum)));
    }

    private static HashMap createDict(String vocab){
        BufferedReader reader;
        HashMap<String, String > dict = new HashMap<>();
        String line1;
        String line2;

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
