import java.util.List;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.Arrays;

class Reader {
    public static List<WordsInDictionary> readFile(String pathToDictionary){
        ArrayList<WordsInDictionary> words = new ArrayList<WordsInDictionary>();

        try (final Stream<String> lines =
                     Files.lines(Paths.get(pathToDictionary)).flatMap(line-> Arrays.stream(line.split("[,;\\s+]")))){

            List<String> storageList = lines.filter(x -> x.length() != 0).collect(Collectors.toList());

            WordsInDictionary entryOfDictionary = new WordsInDictionary("start");

            for (String word : storageList){
                word = word.replace(",", " ").trim();
                try {
                    if (!word.matches("[0-9]{1,30}"))
                        entryOfDictionary.addAssociation(word);
                    else
                        entryOfDictionary.addWeight(Integer.parseInt(word));
                } catch (NumberFormatException nfe) {
                }

                if (word.matches("[А-Я]{1,50}:")) {
                    entryOfDictionary = new WordsInDictionary(word.substring(0,word.length()-1));
                    words.add(entryOfDictionary);
                }
            }

        } catch (Exception e){
            System.out.println(e);
        }

        return words;
    }
}
