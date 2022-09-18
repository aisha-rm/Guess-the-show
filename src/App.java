import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class App {
    //store text file location as a string
    public static String resource="src/shows.txt";
    
    //generate random integer object
    public static Random r = new Random();
    
    //create scanner object to collect user input
    public static Scanner keybooard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //read text file and store content in a list
        Path path = Paths.get(resource);
        List<String> shows = Files.readAllLines(path);

        //generate random integer 
        int random_num = r.nextInt(shows.size());
        //use the above integer to select movie randomly from the list
        String show = shows.get(random_num);
        System.out.println(show);
        //show number of characters in the movie name using a dash
        System.out.println("_".repeat(show.length()));
        
        //ask user to guess letters
        System.out.print("Enter a letter in the movie title: ");
        String letter = keybooard.next();   //consider using char
        System.out.println(letter);

        if (show.contains(letter)) {
            //get index of the letter in the show title
            int index = show.indexOf(letter);
            System.out.println("_".repeat(index) + letter + "_".repeat(show.length()-1-index));
        }
    }
}
