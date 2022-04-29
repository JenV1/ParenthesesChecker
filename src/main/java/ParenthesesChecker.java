import java.util.*;

public class ParenthesesChecker {

    public ParenthesesChecker() {
    }

    public boolean checkParentheses(String string) {

        Stack<String> parenthesesHolder = new Stack<>();
        List<String> possibleElements = new ArrayList<>();
        List<String> fronts = new ArrayList<>();
        List<String> backs = new ArrayList<>();

        Collections.addAll(fronts, "(","<","{","[");
        Collections.addAll(backs, ")",">","}","]");

        /*The algorithm is as follows:
            go through the string character by character,
            if it's a front bracket, add it to the stack.
            If we have a back bracket, we see
            if it matches the front one before it,
            if there is nothing before it or it's a different bracket type,
            the string fails the test.
            If it does match the one before,
            we take away the matching front bracket.
            At the end we make sure the stack is empty, so that each bracket
            has a back and not just a start.
        */

        for (int i = 0; i < string.length(); i++) {
            if (fronts.contains(string.substring(i,i+1))) {
                parenthesesHolder.push(string.substring(i, i + 1));
            } else if (backs.contains(string.substring(i,i+1))){
                int currentElement = backs.indexOf(string.substring(i, i + 1));
                if (parenthesesHolder.isEmpty()){
                    return false;
                }
                else if (parenthesesHolder.peek().equals(fronts.get(currentElement))) {
                    parenthesesHolder.pop();
                } else {
                    return false;
                }
            }
        }

        return parenthesesHolder.isEmpty();



    }


}