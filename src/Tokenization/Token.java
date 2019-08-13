package Tokenization;

public abstract class Token {
    public TokenType type;
    public int GetPrecedence(OperatorToken operatorObj){return operatorObj.getPrecedence();}
}
