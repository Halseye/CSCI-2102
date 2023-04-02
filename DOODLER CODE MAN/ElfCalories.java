import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class ElfCalories {
    public static void main(String[] args) throws FileNotFoundException {
        String line;
        ArrayList<Integer> list = new ArrayList<>();
        int whatever = 0;

       // PrintWriter out = new PrintWriter("elf.txt");
        File inputFile = new File("elf.txt");
        Scanner in = new Scanner(inputFile);
        
        
        while(in.hasNextLine()){
            line = in.nextLine();
            int sum = 0;


            while(!line.equals("") && in.hasNextLine()){
                whatever = Integer.parseInt(line);
                sum += whatever;
                line = in.nextLine();
            }

            list.add(sum);
        }
        list.sort(Collections.reverseOrder());
        System.out.println("big boi singular");
        System.out.println(Collections.max(list));
        System.out.println("big boi podium");
        System.out.println(list.get(0) + list.get(1) + list.get(2));
    }
}


