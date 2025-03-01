import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter; 

public class StatsManager {
    private static StatsManager INSTANCE; // Singleton instance
    private String filePath;
    
    private StatsManager() {
		filePath = "stats.csv";
		
		File file = new File(filePath);
		
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + filePath);
                
                //file.delete();
                FileWriter writer = new FileWriter(filePath);                
                writer.write("0,0,0,0,0,0,0,0,0,0,50");
                
                
                /*
                 * When this reads the file, we'll just simply tokenize the line into seperate values. So far we have
                 * [0] = Total Wins
                 * [1] = Total Losses
                 * 
                 * [2] = Normal Wins
                 * [3] = Normal Losses
                 * 
                 * [4] = Timed Wins
                 * [5] = Timed Losses
                 * [6] = Best time?
                 * 
                 * [7] = Highest Endless Streak
                 * [8] = Words Guessed in Endless
                 * [9] = Number of endless games played
                 * 
                 * [10] = Points
                 * 
                 */
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static synchronized StatsManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StatsManager();
        }
        return INSTANCE;
    }

    public void incrementWins(int num) {
    	int[] arrayToIncrease = {0, num};
    	incramentCSV(arrayToIncrease);
    }
    public void incrementWins() {
    	int[] arrayToIncrease = {0};
    	incramentCSV(arrayToIncrease);
    }

    public void incrementLosses(int num) {
    	int[] arrayToIncrease = {1, num};
    	incramentCSV(arrayToIncrease);
    }
    public void incrementLosses() {
    	int[] arrayToIncrease = {1};
    	incramentCSV(arrayToIncrease);
    }

    public int getCSVal(int num) {
        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuffer buffer = new StringBuffer();
            
            while (sc.hasNextLine()) {
               buffer.append(sc.nextLine());
            }
            
            String[] fileContents = buffer.toString().split(",");
            sc.close();
            
            return Integer.parseInt(fileContents[num]);
                        
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Something went wrong, returning -1");
        return -1;
    }
    
    
    /**
     * We use an array of integers for the idea of total wins and losses here
     * @param nums
     */
    private void incramentCSV(int[] nums) {

        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuffer buffer = new StringBuffer();
            
            while (sc.hasNextLine()) {
               buffer.append(sc.nextLine());
            }
            
            String fileContents = buffer.toString();
            sc.close();

            String[] fileArray = fileContents.split(",");
            
            for(int num : nums) {
            	fileArray[num] = "" + (Integer.parseInt(fileArray[num]) + 1);
            }
            fileContents = String.join(",", fileArray);
            
            //System.out.println(fileContents);
            
            FileWriter writer = new FileWriter(filePath);
            
            File file = new File(filePath);
            file.delete();
            file.createNewFile();
            
            writer.append(fileContents);
            writer.flush();
            writer.close();
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void update(int value, int pos) {
        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuffer buffer = new StringBuffer();
            
            while (sc.hasNextLine()) {
               buffer.append(sc.nextLine());
            }
            
            String fileContents = buffer.toString();
            sc.close();

            String[] fileArray = fileContents.split(",");
            
            fileArray[pos] = "" + value;
            
            fileContents = String.join(",", fileArray);
            
            //System.out.println(fileContents);
            
            FileWriter writer = new FileWriter(filePath);
            
            File file = new File(filePath);
            file.delete();
            file.createNewFile();
            
            writer.append(fileContents);
            writer.flush();
            writer.close();
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteSave() {
        try {
    		File file = new File(filePath);
    		file.delete();
                file.createNewFile();
                System.out.println("File created: " + filePath);
                
                //file.delete();
                FileWriter writer = new FileWriter(filePath);                
                writer.write("0,0,0,0,0,0,0,0,0,0,50");
                writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void modifyPoints(boolean add){
        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuffer buffer = new StringBuffer();
            
            while (sc.hasNextLine()) {
               buffer.append(sc.nextLine());
            }
            
            String fileContents = buffer.toString();
            sc.close();

            String[] fileArray = fileContents.split(",");
            
            if(add)
            	fileArray[10] = "" + (Integer.parseInt(fileArray[10]) + 50);
            else {
            	fileArray[10] = "" + (Integer.parseInt(fileArray[10]) - 50);
            }
            
            fileContents = String.join(",", fileArray);
            
            //System.out.println(fileContents);
            
            FileWriter writer = new FileWriter(filePath);
            
            File file = new File(filePath);
            file.delete();
            file.createNewFile();
            
            writer.append(fileContents);
            writer.flush();
            writer.close();
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
