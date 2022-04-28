import java.util.Stack;

public class ParenthesesChecker {

    public ParenthesesChecker() {
    }

    public boolean checkParentheses(String string) {

        Stack<String> parenthesesHolder = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                parenthesesHolder.push("(");
            } else if (string.charAt(i) == ')') {
                parenthesesHolder.push(")");
            }
        }

        int fronts = 0;
        int backs = 0;
        int beginningSize = parenthesesHolder.size();

        for (int i = 0; i < beginningSize; i++) {
            if (parenthesesHolder.peek().equals(")")) {
                parenthesesHolder.pop();
                backs++;
            } else if (parenthesesHolder.pop().equals("(") && backs >= fronts) {
                fronts++;
            }
        }

        return (parenthesesHolder.isEmpty() && (fronts == backs));
    }


}
