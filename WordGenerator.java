

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
	
	private List<String> words;
    
    public WordGenerator(String csvFilePath) throws IOException {
        this.words = readFile(csvFilePath);
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

    public String getRandomWord() 
    {
        Random random = new Random();
        int index = random.nextInt(words.size());
        
        return words.get(index);
    }
}