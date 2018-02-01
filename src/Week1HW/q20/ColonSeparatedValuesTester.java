package Week1HW.q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Functionality: Reads in data from data.txt and creates Person objects from the read data.
 */
public class ColonSeparatedValuesTester {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Scanner in = null;
        try {
            in = new Scanner(new File("src/Week1HW/q20/Data.txt"));//connect to the Data.txt file in this package
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
            System.exit(1);
        }
        while(in.hasNext()){//check if more data can be read
            list.add(new Person(in.nextLine()));
        }
        for (Person p:list) {
            System.out.println(p);
            System.out.println();//readability
        }
    }
}
