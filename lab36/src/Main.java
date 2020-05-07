import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ArrayList<WordsInDictionary> listOfEntriesD = (ArrayList<WordsInDictionary>)Reader.readFile("dr.txt");
        do {
            PlayGame game = new PlayGame(listOfEntriesD);
            game.play();
            System.out.println("Хотите играть еще?"+"\n"+
                    "Y or N");
        } while (new Scanner(System.in).nextLine().toUpperCase().equals("Y"));
    }
}








