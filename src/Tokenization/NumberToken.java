package Tokenization;

public class NumberToken extends Token {

    private double value;
    public NumberToken(double value, TokenType tokenType)
    {
        this.setValue(value);
        this.type = tokenType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
