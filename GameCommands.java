
import java.util.ArrayList;
import java.util.Scanner;

public class GameCommands{

    public static String[] currentGameState = new String[5];//the array of strings that is printed when a guess is made
    public static Scanner wordScanner = new Scanner(System.in);//sets up a scanner to read user unput
    public static String userInput;//create a string to store user input
    public static ArrayList<String> remainingLetters = new ArrayList<String>(); 

    public static int randomWord;//an integer for the index of the random word
    public static String finalWord;//a string to store the correct word. This is what the userInput string is compared to

    //creates a string for each letter in the word (makes it easier for comparison and identification)
    public String letterOne;
    public String letterTwo;
    public String letterThree;
    public String letterFour;
    public String letterFive;


    //creates t/f variables for wheter or not the user guessed letter is in the word
    public static boolean isLetterOne;
    public static boolean isLetterTwo;
    public static boolean isLetterThree;
    public static boolean isLetterFour;
    public static boolean isLetterFive;

    public static int guessCounter = 0;//counts how many guesses the user takes

    public GameCommands(){}

    /*
     * This function is run once at the start of the game. It assigns the values to the game state array as blanks
     * becuase no words have been guessed at the time of the function call. 
     */
    public static void startGame(){

        //Fills the currentGameState with underscores when the game starts
        currentGameState[0] = "_ ";
        currentGameState[1] = "_ ";
        currentGameState[2] = "_ ";
        currentGameState[3] = "_ ";
        currentGameState[4] = "_ ";

        System.out.println("Welcome to Wordle!");
        System.out.println("You have 6 tries to guess today's Wordle!");
        System.out.println();
        System.out.println();
    }


    /* This function assigns a value to the final word. */

    public static void setFinalWord(){
        randomWord = (int)(Math.random()*19);//picks a random number between 0 and 20 for the index of the array
        //finalWord =  WordBank.wordList[randomWord];//sets the finalWord equal to the word at the random index in the list
        finalWord = "aaaab";
    }

    public static void setGuese(){
        userInput = wordScanner.nextLine();//sets userInput equal to what is typed into the terminal

        if(userInput.length() ==5){
            guessCounter++;//only increments the counter if the guess is 5 letters long
        }
    }
    public static void checkGuess(){

        //nothing inside this loop will run if the length of the input is not equal to 5 which eliminates out of bounds exceptions.
        if(userInput.length() == 5){

            for (int i = 0; i<=4; i++){
                //if the userInput letters are in the correct spot, change the value of the the game state at that index. (The green letters in Wordle)
                if (finalWord.charAt(i) == userInput.charAt(i)){
                    currentGameState[i] = String.valueOf(userInput.charAt(i));
                }

                //iterates through the correct word to see if there is any other letters matching anywhere else in the word. (Yellow letters)
                for (int j = 0; j<=4; j++){
                    if (userInput.charAt(i) == finalWord.charAt(j)){
                        if (i==0){
                            isLetterOne = true;
                        }
    
                        if (i==1){
                            isLetterTwo = true;
                        }
    
                        if (i==2){
                            isLetterThree = true;
                        }
    
                        if (i==3){
                            isLetterFour = true;
                        }
    
                        if (i==4){
                            isLetterFive = true;
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Type a word with 5 letters!");//if the word is not equal to 5 letters in length, it will print this and end.
        }
    }

    public static void addRemainingLetters(){
        remainingLetters.add("a");
        remainingLetters.add("b");
        remainingLetters.add("c");
        remainingLetters.add("d");
        remainingLetters.add("e");
        remainingLetters.add("f");
        remainingLetters.add("g");
        remainingLetters.add("h");
        remainingLetters.add("i");
        remainingLetters.add("j");
        remainingLetters.add("k");
        remainingLetters.add("l");
        remainingLetters.add("m");
        remainingLetters.add("n");
        remainingLetters.add("o");
        remainingLetters.add("p");
        remainingLetters.add("q");
        remainingLetters.add("r");
        remainingLetters.add("s");
        remainingLetters.add("t");
        remainingLetters.add("u");
        remainingLetters.add("v");
        remainingLetters.add("w");
        remainingLetters.add("x");
        remainingLetters.add("y");
        remainingLetters.add("z");
    }

    public static void setRemainingLetters(){
        if (!isLetterOne){
            for (int i = 0; i<remainingLetters.size(); i++){
                if (String.valueOf(userInput.charAt(0)) == remainingLetters.get(i)){
                    remainingLetters.remove(i);
                }
            }
        }

        if (!isLetterTwo){
            for (int i = 0; i<remainingLetters.size(); i++){
                if (String.valueOf(userInput.charAt(1)) == remainingLetters.get(i)){
                remainingLetters.remove(i);
                }
            }   
        }
        
        

        if (!isLetterThree){
            for (int i = 0; i<remainingLetters.size(); i++){
                if (String.valueOf(userInput.charAt(2)) == remainingLetters.get(i)){
                    remainingLetters.remove(i);
                }
            }
        }

        if (!isLetterFour){
            for (int i = 0; i<remainingLetters.size(); i++){
                if (String.valueOf(userInput.charAt(3)) == remainingLetters.get(i)){
                    remainingLetters.remove(i);
                }
            }
        }

        if (isLetterFive){
            for (int i = 0; i<remainingLetters.size(); i++){
                if (String.valueOf(userInput.charAt(4)) == remainingLetters.get(i)){
                    remainingLetters.remove(i);
                }
            }
        }
    }

    public static void printRemainingLetters(){
        System.out.print("Availabel letters: ");

        for (int i = 0; i<remainingLetters.size(); i++){
            System.out.print(remainingLetters.get(i) + " ");
        }
        System.out.println();

    }

    public static void printAid(){

        if (isLetterOne){
            System.out.println("The letter " + userInput.charAt(0) + " is in the word.");
            isLetterOne = false;
        }

        if (isLetterTwo){
            System.out.println("The letter " + userInput.charAt(1) + " is in the word.");
            isLetterTwo = false;
        }

        if (isLetterThree){
            System.out.println("The letter " + userInput.charAt(2) + " is in the word.");
            isLetterThree = false;
        }

        if (isLetterFour){
            System.out.println("The letter " + userInput.charAt(3) + " is in the word.");
            isLetterFour = false;
        }

        if (isLetterFive){
            System.out.println("The letter " + userInput.charAt(4) + " is in the word.");
            isLetterFive = false;
        }
    }

    public static void displayTotal(){
        for (int i = 0; i<=4; i++){
            System.out.print(currentGameState[i]);
        }
        
        System.out.println();
        System.out.println();
    }

    public static void endGame() {
        if (userInput.equalsIgnoreCase(finalWord)){
            System.out.println("Congrats! You've won");
            guessCounter = 6;
        }
        else{
            System.out.println("YOU ARE A FAILURE! THE WORD WAS '" + finalWord + "'.");
        }
    }
}
