package scrabble.tree;

    public class Node {
        public char data;
        public int endWord; // 1 - is the end of the word
        public int indexOfNode;
        public String prefix;
        public Node parent;
        public Node[] children = new Node[26];

        public Node(char data){
            this.data = data;
            this.endWord = 0;
            this.prefix = "";
            this.parent = null;
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }

    }
