import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MasterMindGame {
    public static void main (String[]args){
        //Part 1 system automate random numbers
        System.out.println("Welcome to the mastermind guessing game !");
        System.out.println("Guess the correct number in the correct order. You will get a Sun");
        System.out.println("Guess the correct number in the wrong order. You will get a Moon");
        System.out.println("Else. Nothing. Good luck :)");

        //create an arraylist to store the machine generate numbers
        ArrayList<Integer> sysNumbers = new ArrayList<>();
        Random random = new Random();
        //loop through the random numbers then add to variable sysNumbers
        for (int i = 0; i < 4; i++) {
            //while the next random number not the same then add to the list
            while (true) {
                int x = random.nextInt(10);
                if (!sysNumbers.contains(x)) {  //unique number by filter not the same number
                    sysNumbers.add(x);
                    break;
                }
            }
        }
        //Part 2 User pick their numbers within range 0 -9
        Scanner userInput = new Scanner(System.in);
        // create an arraylist to store the user input
        ArrayList<Integer> numb = new ArrayList<>();
        // loop through the user input then add to arraylist number1
        for (int i = 0; i < 4; i++) {
            System.out.println("Please enter a number between 0 - 9");
            numb.add(userInput.nextInt());
        }
        System.out.println("Your chosen numbers are " + numb);
        System.out.println("The secret numbers are " + sysNumbers);

        //Part 3 comparing the 2 Array List of numbers
        //for each loop to compare the elements in 2 arraylist then output to console
        int sun = 0;
        int moon = 0;
        for (int i = 0; i < numb.size(); i++) {
            //if the number is matching and in the correct position get a sun
            if (numb.get(i).equals(sysNumbers.get(i))) {
                sun++;
                //if the number is matching but in the wrong position get a moon
            } else if (numb.get(i).equals(sysNumbers.get((i + 1) % 4))) {
                moon++;
            } else if (numb.get(i).equals(sysNumbers.get((i + 2) % 4))) {
                moon++;
            } else if (numb.get(i).equals(sysNumbers.get((i + 3) % 4))) {
                moon++;
            }
        }
        System.out.println("Total Sun :" +sun);
        System.out.println("Total Moon : "+moon);

    }
}
