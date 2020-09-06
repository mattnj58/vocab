import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Vocab {

    public static void main(String[] args) throws InterruptedException {
        String vocab = "Dictionaries/vocab.txt";
        HashMap<String, String> dict = createDict(vocab);
        Random rand = new Random();
        int wordNum = rand.nextInt(dict.size());

        System.out.println("Dictionary Size: "+dict.size());

        List<String> words = new ArrayList<>(dict.keySet());

        System.out.println(words.get(wordNum));
        TimeUnit.SECONDS.sleep(5);
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
