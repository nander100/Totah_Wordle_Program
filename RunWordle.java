
public class RunWordle extends GameCommands   {
    public static void main(String[] args) {

        WordBank myWordBank = new WordBank();
            
        startGame();
        myWordBank.fillList();
        setFinalWord();
        addRemainingLetters();
        while (guessCounter!=6){
            displayTotal();
            setGuese();
            checkGuess();
            setRemainingLetters();
            if (!userInput.equalsIgnoreCase(finalWord)){
                printAid();
                printRemainingLetters();
            }   
            else{
                //guessCounter = 6;
                break;
            }
        }
        endGame();
    }
}
