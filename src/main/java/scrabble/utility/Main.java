package scrabble.utility;
import scrabble.tree.ScrabbleTree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public void readFileAndStartSearch(String input) {
        try {
            File file = new File("/Users/Imcheldon/Documents/c++/trida/Zapocet_Scrabble/Build/Products/Debug/TheHobbit.txt");
            Scanner in = new Scanner(file);
            int index = 0;
            WorkerWithStrings worker = new WorkerWithStrings();
            ScrabbleTree dictionary = new ScrabbleTree();
            while (in.hasNextLine()){
                String currentLine = in.nextLine();
                String[] words = currentLine.split(" ");
                for(String s: words){
                    s = worker.removeSymbolsAndMakeStringToLower(s);
                    dictionary.addWordInTree(s, index);
                }
            }
            input = worker.removeSymbolsAndMakeStringToLower(input);
            dictionary.searchAllCombinationsOfWords(dictionary.getRoot(), input);
        }catch (IOException e){
            System.out.println("Error, file could not be opened");
            e.printStackTrace();
        }

    }

}
