
import java.util.Scanner;//imports all the things that are needed in the class

public class GameCommands{

    public static String[] currentGameState = new String[5];//the array of strings that is printed when a guess is made
    public static Scanner wordScanner = new Scanner(System.in);//sets up a scanner to read user unput from the command prompt.
    public static String userInput;//create a string to store user input

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

    public GameCommands(){}//empty constructor

    public static void startGame(){

        /*
        * This function is run once at the start of the game. It assigns the values to the game state array as blanks
        * becuase no words have been guessed at the time of the function call. 
        */

        //Fills the currentGameState with underscores when the game starts
        currentGameState[0] = "_ ";
        currentGameState[1] = "_ ";
        currentGameState[2] = "_ ";
        currentGameState[3] = "_ ";
        currentGameState[4] = "_ ";

        System.out.println("Welcome to Wordle!");
        System.out.println("You have 6 tries to guess today's Wordle!");

        //prints blank lines to provide space
        System.out.println();
        System.out.println();
    }//end startGame()

    public static void setFinalWord(){

        /**This function assigns a value to the final word based on a random number between 0 and 33. */

        randomWord = (int)(Math.random()*(WordBank.wordList.length - 1));//picks a random number between 0 and one less than the length of the array for the index
        finalWord =  WordBank.wordList[randomWord];//sets the finalWord equal to the word at the random index in the list
        //finalWord = "aaaab";
        //^^the above line is for troubleshooting purpouses.
    }//end setFinalWord()

    public static void setGuese(){

        /**
         * Waits for a use input to the command prompt and sets that input to the userInput string variable.
         */

        userInput = wordScanner.nextLine();//sets userInput equal to what is typed into the terminal

        if(userInput.length() ==5){
            guessCounter++;//only increments the counter if the guess is 5 letters long
            //users can make as many guesses that are not 5 letters
        }
    }//end setGuese()


    public static void checkGuess(){
        /**
         * This code compares the correct answer to the guesse that the user put in. 
         * It changes the elements in the currentGameState array from "_ " to whatever
         * letter that correctly cooresponds with that index. It also checks to see if 
         * any given letter in the user's guess is anywhere else in the word. In the 
         * actual wordle game, these actions coorespond to the green and yellow letters
         * respectively.
         */

        //nothing inside this loop will run if the length of the input is not equal to 5 which eliminates out of bounds exceptions.
        if(userInput.length() == 5){

            for (int i = 0; i<=4; i++){
                //if the userInput letters are in the correct spot, change the value of the the game state at that index. (The green letters in Wordle)
                if (finalWord.charAt(i) == userInput.charAt(i)){
                    currentGameState[i] = String.valueOf(userInput.charAt(i));
                }

                //iterates through the correct word to see if there is any other letters matching anywhere else in the word. (Yellow letters)
                for (int j = 0; j<=4; j++){

                    //for any letter in the guess, does that letter exist anywhere in the final word that is not in the same location.
                    if (userInput.charAt(i) == finalWord.charAt(j)){

                        //assigns variable names acording to what spot the letter in the guess is.
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
    }//end checkGuess()


    public static void printAid(){

        /**
         *  This method contains the code to print the "yellow letters" depending on 
         *  whether or not that letter is in the final word. The "isLetter_" variable
         *  is set to false after each term in otder to reset the letters that are 
         *  printed on the next term.
         **/  

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
    }//end printAid()

    public static void displayTotal(){

        /**
         * Traverses through the gameState array and prints each character on one line 
         * and prints it to the terminal. Any changes due to correct letter guesses 
         * will be reflected once these are printed.
         */

        for (int i = 0; i<=4; i++){
            System.out.print(currentGameState[i]);
        }
        
        System.out.println();
        System.out.println();

    }//end displayTotal()

    public static void endGame() {

        /**
         * This method is run once at the end of the game and prints the "congrats" statement.
         * If you don't guess the word correctly, you're a disapointment to your family and 
         * the program prints the "failure" line.
         */
        if (userInput.equalsIgnoreCase(finalWord)){
            System.out.println("Congrats! You've won");
            guessCounter = 6;
        }
        else{
            System.out.println("YOU ARE A FAILURE! THE WORD WAS '" + finalWord + "'.");
        }
    }//end endGame()
}//end class
