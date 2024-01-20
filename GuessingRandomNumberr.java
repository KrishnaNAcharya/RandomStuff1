import java.util.*;

class GuessingRandomNumberr{
    public static void main(String[] args) {
        String play="yes";
        
        Scanner scanner=new Scanner(System.in);
      
        while (play.equals("yes")){
            Random rand=new Random();
            int rannum=rand.nextInt(100);
            int guess=0;
            int tries=0;
            while (guess!=rannum){
            System.out.println("Enter a number between 1 to 100.");
            tries++;
            guess=scanner.nextInt();
                if(guess==rannum){
                    System.out.println("Awsome! You've won the game. It only took you "+tries +" tries. Do you want to keep playing?");
                    play=scanner.next().toLowerCase();

                }
              
           
                if(guess>rannum){
                    System.out.println("Too high. Try a lower number.");
                }
                if(guess<rannum){
                    System.out.println("Too low. Try a higher number.");
                }
            }
        }
        scanner.close();
    }
}