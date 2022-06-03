
public class RunWordle extends GameCommands   {
    public static void main(String[] args) {

        WordBank myWordBank = new WordBank();
            
        startGame();
        myWordBank.fillList();
        setFinalWord();
        while (guessCounter!=6){
            displayTotal();
            setGuese();
            checkGuess();
            if (!userInput.equalsIgnoreCase(finalWord)){
                printAid();
            }   
            else{
                guessCounter = 6;
            }
        }
        endGame();
    }
}
