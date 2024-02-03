import java.util.Random;
import java.util.Scanner;
public class RockPaperScisssor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random rand= new Random();
        while(true){
        System.out.println("Enter 1 for rock,2 for papers 3 for scissors and 0 to exit. ");
        int userChoice=scanner.nextInt();
        int computerchoice=rand.nextInt(3)+1;
        if(userChoice==0){
            System.out.println("Adios! ");
            break;
        }
        if(userChoice<0 ||userChoice>3 ){
            System.out.print("Enter a valid option: ");
            continue;
        }
        System.out.println("Computer has choosen: "+converttochoice(computerchoice));
        System.out.println("User has choosen: " + converttochoice(userChoice));
        System.out.println("Result: "+determineWinner(userChoice, computerchoice));
    } scanner.close();
}
        private static String converttochoice(int choice){
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
            return "Invalid choice.";
        }
        }
        private static String determineWinner(int userChoice, int computerchoice){
            if(userChoice==computerchoice){
                return "Its a tie!";
            } else if ((userChoice == 1 && computerchoice == 3) ||
                    (userChoice == 2 && computerchoice == 1) ||
                    (userChoice == 3 && computerchoice == 2)) {
                return "You win!";
            } else {
                return "Computer wins!";
            }
        }
    }