import java.util.*;

public class ParenthesesChecker {

    public ParenthesesChecker() {
    }

    public boolean checkParentheses(String string) {

        Stack<String> parenthesesHolder = new Stack<>();
        List<String> possibleElements = new ArrayList<>();
        List<String> fronts = new ArrayList<>();
        List<String> backs = new ArrayList<>();

        Collections.addAll(possibleElements, "(",")","[","]","{","}","<",">");
        Collections.addAll(fronts, "(","<","{","[");
        Collections.addAll(backs, ")",">","}","]");
        int frontsInARow = 0;

        for (int i = 0; i < string.length(); i++) {
            if (possibleElements.contains(string.substring(i,i+1))) {
                parenthesesHolder.push(string.substring(i, i + 1));
                if (fronts.contains(string.substring(i,i+1))) {
                    frontsInARow++;
                } else {
                    int currentElement = possibleElements.indexOf(parenthesesHolder.pop());
                    if (parenthesesHolder.isEmpty()){
                        return false;
                    }
                    else if (parenthesesHolder.peek().equals(possibleElements.get(currentElement-1))) {
                        parenthesesHolder.pop();
                        frontsInARow--;
                    } else {
                        return false;
                    }
                }
            }
        }

        return frontsInARow == 0;



    }


}