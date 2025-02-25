package DictionaryController;

import Dictionary.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();
        dictionary.addWord("apple", "A fruit or something idk");
        dictionary.addWord("java", "A programming language");
        dictionary.addWord("book", "A paper with scribbles");
    }

    public String searchWord(String word) {
        return dictionary.searchWord(word);
    }
}

