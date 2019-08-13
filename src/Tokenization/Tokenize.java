package Tokenization;

import java.util.ArrayList;

public class Tokenize implements Tokenizer {


    public ArrayList<Token> TokenizeExpression(String expression) {

        ArrayList<Token> tokens = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            //TODO: refactor to accomodate 2..3 think about splitting digit and . tokens
            if (isNumeric(c)) {
                var startIndex = i++;
                for (; i < expression.length() && isNumeric(expression.charAt(i)); i++) {
                }

                var length = i - startIndex;

                i--; //Decrement i to allow outer loop  to process the character

                // end position not the 'step'
                //if i=length minus one length = expression.length()

                if(i == expression.length()-1)
                {
                    var numberExpression = expression.substring(startIndex);
                    var numberToken = new NumberToken(Double.parseDouble(numberExpression), TokenType.digit);
                    tokens.add(numberToken);
                }
                else {

                    var numberExpression = expression.substring(startIndex, length);
                    var numberToken = new NumberToken(Double.parseDouble(numberExpression), TokenType.digit);
                    tokens.add(numberToken);
                }


            } else {
                OperatorToken operatorToken = null;
                switch (expression.charAt(i)) {
                    case '+':
                    case '-':
                        operatorToken = new OperatorToken(expression.charAt(i), 2, Associativity.Left, TokenType.operator);
                        break;
                    case '*':
                    case '/':
                        operatorToken = new OperatorToken(expression.charAt(i), 3, Associativity.Left, TokenType.operator);
                        break;
                    case '^':
                        operatorToken = new OperatorToken(expression.charAt(i), 4, Associativity.Right, TokenType.operator);
                        break;
                    case '(':
                        BracketToken leftBracketToken = new BracketToken(expression.charAt(i), TokenType.leftBracket);
                        tokens.add(leftBracketToken);
                        break;
                    case ')':
                        BracketToken rightBracketToken = new BracketToken(expression.charAt(i), TokenType.rightBracket);
                        tokens.add(rightBracketToken);
                        break;

                }
                if (operatorToken != null) {
                    tokens.add(operatorToken);
                }
            }
        }
        return tokens;
    }


    private static boolean isNumeric(char c) {
        return Character.isDigit(c) || c == '.';
    }
}


