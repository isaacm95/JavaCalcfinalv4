package Calculator;

import Input.InputReader;
import Input.Reader;
import Parser.Process;
import Tokenization.Token;
import Tokenization.Tokenizer;

import java.util.ArrayList;

public class Calculator {
    private Reader reader;
    private Tokenizer tokenizer;
    private double result;

    public Calculator (Reader reader, Tokenizer tokenizer){
        this.reader = reader;
        this.tokenizer = tokenizer;
    }

    public void Run(){
        var initalExpression = reader.read();
        var tokens = tokenizer.TokenizeExpression(initalExpression);
        Evaluate(tokens);
    }

    private void Evaluate(ArrayList<Token> tokens) {
        Process evaluate = new Process();
        evaluate.setRpn(evaluate.Parse(tokens));
        result = evaluate.RpnOutputCalculated();
    }

}
