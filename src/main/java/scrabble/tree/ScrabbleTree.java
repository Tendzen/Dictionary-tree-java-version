package scrabble.tree;


import scrabble.utility.WorkerWithStrings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ScrabbleTree {
    private Node root;

    public ScrabbleTree(){
        root = new Node('/');
        root.indexOfNode = 0;
    }
    public Node getRoot() {
        return root;
    }

    public void addWordInTree(String word, int indexOfNode){
        Node temp = root;
        int alphabetIndex;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            alphabetIndex = c - 'a';
            if(temp.children[alphabetIndex] == null){
                temp.children[alphabetIndex] = new Node(c);
                temp.children[alphabetIndex].parent = temp;
                temp.children[alphabetIndex].prefix = temp.prefix + temp.children[alphabetIndex].data;
                indexOfNode++;
                temp.children[alphabetIndex].indexOfNode = indexOfNode;
            }
            temp = temp.children[alphabetIndex];
        }
        if(temp != root){
            temp.endWord = 1;
        }
    }

    public void searchAllCombinationsOfWords(Node root, String userInput){
        HashMap<Node, Boolean>visited = new HashMap<>();
        WorkerWithStrings Sub = new WorkerWithStrings();
        Stack<Node> SNodes = new Stack<>();
        ArrayList<String> listOfWords = new ArrayList<String>();
        String workingCopy;
        visited.put(root, true);
        SNodes.push(root);
        int index;
        while(!SNodes.isEmpty()){
            Node temp = SNodes.pop();
            workingCopy = userInput;
            workingCopy = Sub.subtract(workingCopy, temp.prefix);
            if(temp.endWord == 1){
                listOfWords.add(temp.prefix);
            }
            for (int i = 0; i < workingCopy.length(); i++) {
                index = workingCopy.charAt(i) - 'a';
                if(temp.children[index] != null && !visited.containsKey(temp.children[index])){
                    visited.put(temp.children[index], true);
                    SNodes.push(temp.children[index]);
                }
            }

        }
        if(!listOfWords.isEmpty()){
            for (int i = 0; i < listOfWords.size(); i++) {
                System.out.println(listOfWords.get(i));
            }
        }

    }

}
