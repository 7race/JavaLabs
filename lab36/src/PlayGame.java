import java.util.Scanner;
import java.util.ArrayList;

public class PlayGame {
    private WordsInDictionary enterD;
    private ArrayList<String> entriesAssociations;
    private ArrayList<String> givenAssociations;
    private String levelStr;
    private boolean isConntinue = true;
    private int leftC;
    ArrayList<WordsInDictionary> listOfEntriesD;
    private final int level;

    private boolean playRound(){
        System.out.println("Уровень: "+levelStr+"\n"+
                "Попыток осталось: "+leftC+"\n"
        );
        int numberInList = (int)(Math.random()*entriesAssociations.size());
        String newAssociation = entriesAssociations.get(numberInList);
        entriesAssociations.remove(numberInList);
        givenAssociations.add(newAssociation);

        for (String association : givenAssociations)
            System.out.println(association);


        String guess = new Scanner(System.in).nextLine();
        leftC--;

        if (guess.equalsIgnoreCase(enterD.getMainWord())) {
            System.out.println("Да \n");
            return true;
        }else {
            System.out.println("Хорошая попытка, но нет  \n");
            return false;
        }
    }

    public PlayGame(ArrayList<WordsInDictionary> listOfEntriesD) {
        givenAssociations = new ArrayList<>();
        this.listOfEntriesD = listOfEntriesD;
        System.out.println("1 - легко"+"\n" + "2 - средне"+"\n" + "3 - сложно");
        this.level = new Scanner(System.in).nextInt();

        switch (level){
            case (1):
                leftC = 12;
                levelStr = "easy";
                do {
                    enterD = listOfEntriesD.get((int)Math.floor(Math.random()*listOfEntriesD.size()));
                } while ((enterD.getAssociations_strong().size()+enterD.getAssociations_medium().size())<=leftC);
                entriesAssociations = new ArrayList<String>(enterD.getAssociations_strong().keySet());
                entriesAssociations.addAll(enterD.getAssociations_medium().keySet());
                break;
            case (2):
                leftC = 10;
                levelStr = "medium";
                do {
                    enterD = listOfEntriesD.get((int)Math.floor(Math.random()*listOfEntriesD.size()));
                } while ((enterD.getAssociations_strong().size()+enterD.getAssociations_medium().size())<=leftC);
                entriesAssociations =  new ArrayList<String>(enterD.getAssociations_strong().keySet());
                entriesAssociations.addAll(enterD.getAssociations_medium().keySet());
                break;
            case (3):
                leftC = 10;
                levelStr = "hard";
                do {
                    enterD = listOfEntriesD.get((int)Math.floor(Math.random()*listOfEntriesD.size()));
                } while (enterD.getAssociations_weak().size()<=leftC);
                entriesAssociations =  new ArrayList<String>(enterD.getAssociations_weak().keySet());
                break;
        }
    }

    public void play(){
        boolean isSuccess = false;
        while ((leftC>0)&&!isSuccess&&isConntinue)
            isSuccess = playRound();


        System.out.println("Загаднное слово: \""+enterD.getMainWord()+"\"");
        if (isSuccess) {
            System.out.println("Ура! Победа! \n");
        }

    }
}
