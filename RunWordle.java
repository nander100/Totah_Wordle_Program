
public class RunWordle extends GameCommands   {
    public static void main(String[] args) {

        WordBank myWordBank = new WordBank();
        
        //start game initialization
        startGame();
        myWordBank.fillList();
        setFinalWord();

        //main sequence
        while (guessCounter!=6){
            displayTotal();//displays the changed lines after the guess
            
            setGuese();//once the user inputs a guesse, this checks if its a valid input and adds one to the counter
            
            checkGuess();//compares the guess to the correct word in the 
            
            if (!userInput.equalsIgnoreCase(finalWord)){
                printAid();
            }   
            else{
                guessCounter = 6;
            }
        }//end main sequence

        endGame();//either prints congrats or fail depending on how they did during their game
    }
}
