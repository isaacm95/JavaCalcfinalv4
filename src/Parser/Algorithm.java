package Parser;

import Tokenization.Token;

import java.util.ArrayList;
import java.util.Queue;

public interface Algorithm {
    Queue<Token> Parse(ArrayList<Token> tokens);
    double RpnOutputCalculated();

}
