package Parser;

import Tokenization.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static Tokenization.TokenType.leftBracket;
import static Tokenization.TokenType.rightBracket;

public class Process {
    public Queue<Token> Rpn;

    public Queue<Token> getRpn() {
        return Rpn;
    }

    public void setRpn(Queue<Token> rpn) {
        Rpn = rpn;
    }

    public int GetPrecedence(OperatorToken operatorObj)
    {
        return operatorObj.getPrecedence();
    }

    public Queue<Token> Parse(ArrayList<Token> tokens)
    {
        var Rpn = new LinkedList<Token>();
        Stack<Token> operators = new Stack<>();
        boolean bracketTopOfStack = false;
        for (var token:tokens
             ) {

            if (token.type == TokenType.digit)
            {

                {
                    Rpn.add(token);
                }
            }
            else if (token.type == TokenType.operator)
            {
                var currentOperator = (OperatorToken) token;
                if(operators.empty())
                {
                    operators.push(currentOperator);
                }
                else {
                    switch (operators.peek().type) {
                        case leftBracket:
                        case rightBracket:
                            operators.push(currentOperator);
                            bracketTopOfStack = true;
                            break;

                    }
                    if (bracketTopOfStack == false)
                    {
                        OperatorToken topOfStack = (OperatorToken) operators.peek();
                        if (((topOfStack.getPrecedence() > GetPrecedence(currentOperator)) ||
                                ((topOfStack.getPrecedence() == GetPrecedence(currentOperator)  &&
                                        topOfStack.getAssociativity() == Associativity.Left)))
                        && (topOfStack.getSymbol() != '('))
                        {
                            Rpn.add(operators.pop());
                            operators.push(currentOperator);
                        }
                        else
                        {
                            operators.push(currentOperator);
                        }
                    }
                    bracketTopOfStack = false;

                }
            }
            else if (token.type == rightBracket)
            {
                operators.push(token);
            }
            else if (token.type == leftBracket)
            {
                do {
                    Rpn.add(operators.pop());
                }while (operators.peek().type != leftBracket);
                operators.pop();
            }
        }

        while (operators.size() != 0)
        {
            Rpn.add(operators.pop());
        }

        return Rpn;
    }

    public double RpnOutputCalculated()
    {
        Stack<Token> evaluateStack = new Stack();
        for (var token:Rpn
             ) {
            if(token.type == TokenType.operator)
            {
                NumberToken temp2 = (NumberToken) evaluateStack.pop();
                NumberToken temp1 = (NumberToken) evaluateStack.pop();
                OperatorToken tempOperator = (OperatorToken) token;
                if(tempOperator.getSymbol() == '+')
                {
                    NumberToken result = new NumberToken(temp2.getValue() + temp1.getValue(), TokenType.digit);
                    evaluateStack.push(result);
                }
                if (tempOperator.getSymbol() == '-')
                {
                    NumberToken result = new NumberToken(temp1.getValue() - temp2.getValue(), TokenType.digit);
                    evaluateStack.push(result);
                }
                if (tempOperator.getSymbol() == '*')
                {
                    NumberToken result = new NumberToken(temp2.getValue() * temp1.getValue(), TokenType.digit);
                    evaluateStack.push(result);
                }
                if (tempOperator.getSymbol() == '/')
                {
                    NumberToken result = new NumberToken(temp1.getValue() / temp2.getValue(), TokenType.digit);
                    evaluateStack.push(result);
                }
                if (tempOperator.getSymbol() == '^')
                {
                    NumberToken result = new NumberToken(Math.pow(temp1.getValue(),temp2.getValue()), TokenType.digit);
                    evaluateStack.push(result);
                }

            }
            else if (token.type == TokenType.digit)
            {
                evaluateStack.push(token);
            }
        }
        NumberToken finalResult = (NumberToken) evaluateStack.pop();
        System.out.println("Result : ");
        System.out.print(finalResult.getValue());
        return finalResult.getValue();
    }
}
