package Calculator;

import Input.InputReader;
import Tokenization.Tokenize;
import Tokenization.Tokenizer;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        var read = new InputReader();
        var tok = new Tokenize();
        var calc = new Calculator(read, tok);
        calc.Run();
        /*System.out.println("heelo");
        System.out.println("Please enter desired expression");
        var input = new Scanner(System.in);
        var expression = input.nextLine();
        System.out.print(expression);*/


    }
}
