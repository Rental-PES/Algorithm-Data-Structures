package RawStack;

public class StackUtilities{
    static boolean isOperator(char ch) {
        return (!(ch >= 'a' && ch <= 'z') &&
                !(ch >= '0' && ch <= '9') &&
                !(ch >= 'A' && ch <= 'Z'));
    }

    static int getPriority(char ch) {
        if (ch == '-' || ch == '+')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        return 0;
    }
    private static String toPostfix(String infix) {
        Stack operators = new Stack();
        char symbol;
        String postfix = "";
        for (int i = 0; i < infix.length(); ++i)
        //while there is input to be read
        {
            symbol = infix.charAt(i);
            //if it's an operand, add it to the string
            if (Character.isLetter(symbol))
                postfix = postfix + symbol;
            else if (symbol == '(')
            //push (
            {
                operators.push(symbol);
            } else if (symbol == ')')
            //push everything back to (
            {
                while (operators.peek() != '(') {
                    postfix = postfix + operators.pop();
                }
                operators.pop(); //remove '('
            } else
            //print operators occurring before it that have greater precedence
            {
                while (!operators.isEmpty() && !(operators.peek() == '(') && getPriority(symbol) <= getPriority(operators.peek()))
                    postfix = postfix + operators.pop();
                operators.push(symbol);
            }
        }
        while (!operators.isEmpty())
            postfix = postfix + operators.pop();
        return postfix;
    }

    public static void main(String[] args) {
        String test = "(A+B)*C-(D-E)*(F+G)";
        System.out.println(toPostfix(test));
    }
}
