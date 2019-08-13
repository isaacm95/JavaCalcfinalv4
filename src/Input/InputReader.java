package Input;

import java.util.Scanner;

public class InputReader implements Reader{
    public String read(){
        System.out.println("Please enter desired expression: ");
        var input = new Scanner(System.in);
        return input.nextLine();

    }
}
