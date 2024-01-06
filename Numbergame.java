import java.util.Random;
import java.util.Scanner;
public class Numbergame {
    public static void main(String[] args) {

        int lowerBound = 1;
        int upperBound = 100;
        int maxTrial = 10;
        int score = 0;
        int tries;
        int rounds = 0;

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("*** WELCOME TO THE NUMBER GAME ***");
        System.out.println("==================================");

        boolean rightGuess = false;

        do {
            tries=0;
            rounds++;
            int secretNum = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("Rounds played: " + rounds);
            System.out.println("let's think of a number between " + upperBound + " and " + lowerBound);

            while (!rightGuess && tries <= maxTrial) {
                System.out.println("Take a guess: ");
                int UserIn = in.nextInt();
                tries++;

                if(Math.abs(UserIn - secretNum)<= 10 && Math.abs(UserIn - secretNum)!=0){
                    System.out.println("Very Close. Try again!");
                }
                else if (UserIn < secretNum){
                    System.out.println("The guessed number is too low. Try again!");
                }
                else if (UserIn > secretNum){
                    System.out.println("The guessed number is too high. Try again!");
                }
                else{
                    System.out.println("Congratulations! you have guessed the correct number: " + secretNum);
                    rightGuess = true;
                }
            }
            if(rightGuess){
                score++;

                if(tries<=3){
                    System.out.println("Brilliant! you guessed the correct answer in "+ tries + " tries");
                }
                else if(tries>4 && tries<=7){
                    System.out.println("Good job! you guessed the correct answer in " + tries + " tries");
                }
                else{
                    System.out.println("Phew, you took "+ tries + " tries but you did it at last! good!");
                }
            }
            if(!rightGuess){
                System.out.println("Sorry, you have used all your attempts.\n The correct number was : " + secretNum + "\nGAME OVER");
            }

            System.out.println("Thanks for playing!");
            System.out.println("Your Total Score is: " + score);

            System.out.println("Do you want to play again? (Yes/No)");
            String playAgain = in.next();
            if(!playAgain.equalsIgnoreCase("yes")){
                break;
            }

        }
        while(true);
    }
}