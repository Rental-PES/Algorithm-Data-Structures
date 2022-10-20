package RawStack;

public class StackPostfix {
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

    static boolean isLeftBracket(char ch){
        return (ch == '(');
    }

    static boolean isRightBracket(char ch){
        return (ch == ')');
    }

    static String reverse(String param){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String expression = "6+2/3^2";
        expression = reverse(expression);
        String result = "";
        Stack stack = new Stack();

        int bracketLeft = 0;
        int bracketRight = 0;
        for (char ch : expression.toCharArray()){
            if (!isRightBracket(ch) && !isLeftBracket(ch) && !isOperator(ch)){
                result+=ch;
            }

            if (isLeftBracket(ch)) {
                bracketLeft +=1;
                stack.push(ch);
            }
            if (isRightBracket(ch)){
                bracketRight +=1;
                stack.push(ch);
            }
            if (bracketRight == bracketLeft && bracketLeft != 0 && bracketRight != 0){
                while (true){
                    Object popItem = stack.pop();
                    if (isRightBracket((Character) popItem)) break;
                    result+=popItem;
                }
            }


            if (isOperator(ch)){
                int priority = getPriority(ch);
                if (stack.isEmpty()) stack.push(ch);
                else {
                    if (priority == 3) result+=ch;
                    else {
                        Object popItem = stack.pop();
                        if (getPriority((Character) popItem) > getPriority(ch)){
                            result+=ch;
                        } else {
                            stack.push(popItem);
                        }
                    }
                }
            }



        }
        System.out.println(reverse(result));
        stack.printAll();


    }
}
