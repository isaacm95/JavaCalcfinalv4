package Tokenization;

public class OperatorToken extends Token {
    private char symbol;
    private int precedence;
    private Associativity associativity;


    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    public OperatorToken (char symbol, int precedence, Associativity associativity, TokenType tokenType)
    {
        this.symbol = symbol;
        this.precedence = precedence;
        this.associativity = associativity;
        this.type = tokenType;

    }

    public Associativity getAssociativity() {
        return associativity;
    }

    public void setAssociativity(Associativity associativity) {
        this.associativity = associativity;
    }
}
