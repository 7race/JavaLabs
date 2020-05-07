import java.util.HashMap;

class WordsInDictionary {
    private String word;
    private final HashMap<String, Integer> easy;
    private final HashMap<String, Integer> medium;
    private final HashMap<String, Integer> hight;
    private static final int medium_boundary = 2;
    private static final int hightBoundary = 10;
    private String lastKey;

    public WordsInDictionary(String word) {
        this.word = word;
        easy = new HashMap<String, Integer>();
        medium = new HashMap<String, Integer>();
        hight = new HashMap<String, Integer>();
    }

    public void addAssociation(String association){
        easy.put(association, 1);
        lastKey = association;
    }

    public String getMainWord(){
        return word;
    }

    public HashMap<String, Integer> getAssociations_weak() {
        return easy;
    }

    public HashMap<String, Integer> getAssociations_medium() {
        return medium;
    }

    public HashMap<String, Integer> getAssociations_strong() {
        return hight;
    }


    public void addWeight(int weight){
            if (weight < medium_boundary)
                easy.replace(lastKey, weight);
            else if ((medium_boundary <= weight) && (weight < hightBoundary)) {
                easy.remove(lastKey);
                hight.remove(lastKey);
                medium.put(lastKey, weight);
            } else {
                easy.remove(lastKey);
                medium.remove(lastKey);
                hight.put(lastKey, weight);
            }
    }

}