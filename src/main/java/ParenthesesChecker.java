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

        /*The algorithm is as follows:
            go through the string character by character,
            if it's a bracket, add it to the stack.
            Keep count of the number of bracket fronts in a row.
            If we have a back bracket, we delete it and see
            if it matches the front one before it,
            if there is nothing before it or it's a different bracket type,
            the string fails the test.
            If it does match the one before,
            we take away the matching front bracket as well and minus one
            from frontsInARow.
            At the end we make sure frontsInARow is 0, so that each bracket
            has a back and not just a start.
        */
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