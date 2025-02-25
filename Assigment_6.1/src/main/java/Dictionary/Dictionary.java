package Dictionary;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> wordMap;

    public Dictionary() {
        wordMap = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        wordMap.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word)  {
        String meaning = wordMap.get(word.toLowerCase());
        if (meaning == null) {
           System.out.println("No word found for " + word);
        }
        return meaning;
    }
}
