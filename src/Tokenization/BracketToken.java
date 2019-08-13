package Tokenization;

public class BracketToken extends Token {

    public char symbol;

    public char getSymbol()
    {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public BracketToken(char symbol, TokenType tokenType)
    {
        this.symbol = symbol;
        this.type = tokenType;
    }
}
