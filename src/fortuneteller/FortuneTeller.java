
package fortuneteller;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;

/**
 *
 * @author Christopher
 */
public class FortuneTeller {

    public static void main(String[] args) {
        
        /*
            This program will use the File class to create an instance of the
            a file object containing the text file name. An ArrayList is created
            to store the different lines of answers contained in the text file.
            The Random class is used to create a instance of random object to
            be used with the size of the Arraylist as the range of numeric
            values to be random returned. That returned random number will
            then be used as the index number to get that particular element
            from the ArrayList.
        */
        
        //Creating a File object with the text file name.
        File inputFile = new File ("answers.txt");
        //Creating a ArrayList object
        ArrayList<String> answers = new ArrayList<String>();
        //Defining and declaring String variables.
        String answer, response = "y";
        //Creating a random object
        Random rand = new Random();
        
        //Try and see if file exist if not catch an Exception
        try{
            Scanner input = new Scanner(inputFile);
            //read the text file until EOF and add it to the ArrayList
            while(input.hasNextLine()){
                answer = input.nextLine();
                answers.add(answer);
                
            }
        }
        catch(Exception e){
            System.out.println("The input file \"answer.txt\" was not found. ");
            System.out.println(e.toString());
            
        }
        //Create a Scanner object to read from console user's response
        Scanner in = new Scanner(System.in);
        
        //Continue looping in While loop until the user respond with n
        while(response.equalsIgnoreCase("y")){
           
        System.out.println("The fortune teller is ready for you\n" +
                    "Please think about your question in your mind \n" +
                    "and hit enter for you reply. ");
            //get user's input from console
            in.nextLine();
            //print out message and get the ArrayList value at index location
            //that was generated from random object reference method nextInt
            System.out.println("The fortune teller says: " +
                    answers.get(rand.nextInt(answers.size())) + "\n");
            //print out message to see if user would like to continue
            System.out.println("Do you have another question? (y/n) ");
            response = in.nextLine();            
        
        }
        
             
    }
    
}
