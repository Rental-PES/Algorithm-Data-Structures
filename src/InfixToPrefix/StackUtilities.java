package InfixToPrefix;


public class StackUtilities {
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
    static StringBuilder infixToPreFix(String expression){

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack stack = new Stack();

        char [] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            }
            else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (int i = 0; i <charsExp.length ; i++) {
            char c = charsExp[i];

            //check if char is operator or operand
            if(getPriority(c)>0){
                while(!stack.isEmpty() && getPriority(stack.peek())>=getPriority(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor "("
                result.append(c);
            }
        }

        for (int i = 0; i <= stack.size ; i++) {
            result.append(stack.pop());
        }
        return result.reverse();
    }

    public static void main(String[] args) {
        String test = "(A+B)*C-(D-E)*(F+G)";
        System.out.println(infixToPreFix(test));
    }
}
