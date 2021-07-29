package scrabble.utility;

public class WorkerWithStrings {

    public String subtract(String main, String sub){
        if(sub == ""){
            return main;
        }
        int pos;
        for (int i = 0; i < sub.length(); i++) {
            pos = main.indexOf(sub.charAt(i));
            if(pos != -1){
                main = main.substring(0, pos) + main.substring(pos+1);
            }
        }
        return main;
    }

    public String removeSymbolsAndMakeStringToLower(String s){
        s = s.replaceAll("[^a-zA-Z]+","");
        s = s.toLowerCase();
        return s;
    }

}
