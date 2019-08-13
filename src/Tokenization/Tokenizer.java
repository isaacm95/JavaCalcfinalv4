package Tokenization;

import java.util.ArrayList;

public interface Tokenizer {
    ArrayList<Token> TokenizeExpression(String expression);
}
