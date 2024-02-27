/* Evan Dennis 2/27/2024 
Gets one random word from the specified csv file
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordGenerator 
{
    public static void main(String[] args) 
    {
        String csvFilePath = "src/Hangman_wordbank.csv";

        try 
        {
            List<String> words = readFile(csvFilePath);
            if (!words.isEmpty()) 
            {
                String randomWord = getRandomWord(words);
                System.out.println("Random Word: " + randomWord);
            }
            else 
            {
                System.out.println("The CSV file is empty.");
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    private static List<String> readFile(String filePath) throws IOException 
    {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                // Split the line by commas and add all words to the list
                words.addAll(Arrays.asList(line.split(", ")));
            }
        }
        return words;
    }

    private static String getRandomWord(List<String> words) 
    {
        Random random = new Random();
        int index = random.nextInt(words.size());
        
        return words.get(index);
    }
}