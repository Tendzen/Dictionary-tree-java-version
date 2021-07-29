import org.junit.jupiter.api.Test;
import scrabble.tree.ScrabbleTree;
import scrabble.utility.Main;
import scrabble.utility.WorkerWithStrings;

import java.io.IOException;

public class Tests {

    @Test
    public void testNodeGeneration() {
        String[] arrayStrings = new String[] {"hello", "world", "name"};
        ScrabbleTree dictionary = new ScrabbleTree();
        int index = 0;
        for (int i = 0; i < arrayStrings.length; i++) {
            dictionary.addWordInTree(arrayStrings[i], index);
        }
        String p = "eehlowrdl";
        dictionary.searchAllCombinationsOfWords(dictionary.getRoot(), p);
    }

    @Test
    public void testSubtractString(){
        String s = "hello";
        String p = "el";
        String ss = "fasefnkjaey";
        String pp = "afky";
        WorkerWithStrings Sub = new WorkerWithStrings();
        Sub.subtract(ss,pp);
    }


    @Test
    public void testRemoveSymbols(){
        String s = "He9l/le1o";
        WorkerWithStrings Rem = new WorkerWithStrings();
        System.out.println(s);
        s = Rem.removeSymbolsAndMakeStringToLower(s);
        System.out.println(s);
    }


    @Test
    public void testMain() {
        Main start = new Main();
        String input = "abcdeultad";
        start.readFileAndStartSearch(input);
    }


}
