import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
/*
* This class is an implementation of the Eliza Application assignment from Java Bootcamp
* It simulates a chat box by allow the user to enter a description of their problem and
*   generating a response.

* Kim Levin
* 4/28/2020
*/
public class ElizaApplication {
   public static void main(String[] args) {

      Scanner keyboard = new Scanner(System.in);
      String response = "";
      String reply = "";
      boolean done = false;
      int replyType = 1;	//1 is for qualifier, 2 is for hedge

      String[] hedges = {"Please tell me more", 
                         "Many of my patients tell me the same thing", 
                         "It is getting late, maybe we had better quit"};

      String[] qualifiers = {"Why do you say that",
                             "You seem to think that",
                             "So, you are concerned that"};

      System.out.println("Good day. What is your problem");
      do{
         System.out.println("Enter your response here or Q to quit: ");
         response = keyboard.nextLine();
    
         if ( !response.toLowerCase().equals("q")) {
            reply = replyMethod(response, replyType, hedges, qualifiers );
            System.out.println(reply);
            if ( replyType == 1) {
               replyType = 2;
            } else {
               replyType = 1;
            }
         } else {
            done = true;
         }
      } while(!done);
   }

   //This method modifies formulates a response based on the info passed by parameters
   //Then it resturns the reply back to the main method
   static String replyMethod(String rsp, int rType, String[] hdgs, String[] quals ){
      String response = rsp;
      String[] respArray = response.split(" ",0);
      int replyType = rType;
      String[] hedges = hdgs;   
      String[] qualifiers = quals;
      String reply = "";
      Random rand = new Random();
      
      if (replyType == 1) {
          String strToEval = "";
          String strToRtn = "";
          reply = qualifiers[rand.nextInt(qualifiers.length)];  
          for ( int i = 0; i < respArray.length; i++) {
             strToEval = respArray[i]; 
             switch(strToEval) {
                case "I":
                case "i":
                   respArray[i] = "you";
                   break;
                case "ME":
                case "Me":
                case "me":
                   respArray[i] = "you";
                   break;
                case "MY":
                case "My":
                case "my":
                   respArray[i] = "your";
                   break;
                case "AM":
                case "Am":
                case "am":
                   respArray[i] = "are";
                   break;
                default:
             }
             strToRtn += respArray[i] + " ";
          }
          reply += " " + strToRtn;
      } else {
          reply = hedges[rand.nextInt(hedges.length)];  
      }
      return reply;
   }
   
}
