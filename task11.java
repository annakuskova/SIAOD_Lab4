import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        task();
    }
    public static boolean task()
    {
        Scanner input = new Scanner(System.in);
        BufferedReader reader;
        while(true)
        {
            try
            {
                System.out.print("Input path to file: ");
                String path = input.nextLine();
                input.close();
                reader = new BufferedReader(new FileReader(path));
                break;
            }
            catch(IOException ioExc)
            {
                System.out.println("Wrong path to file");
            }
        }
        String line = "";
        try
        {
            line = reader.readLine();
        }
        catch(IOException ioExc)
        {
            ioExc.printStackTrace();
        }
        StackU<Character> stack = new StackU<>();
        for(int i = 0; i < line.length();)
        {
            if(line.charAt(i) != ')')
            {
                if(line.charAt(i) != '(')
                {
                    stack.push(line.charAt(i));
                }
                i++;
            }

            else if(stack.getSize() != 0)
            {
                Character elem1 = stack.pop(); // элемент
                Character var = stack.pop(); // операция
                Character elem2 = stack.peek(); // элемент
                if(var == null || elem2 == null)
                {
                    break;
                }
                if((elem1 != 'x' && elem1 != 'y' && elem1 != 'z') || (elem2 != 'x' && elem2 != 'y' && elem2 != 'z'))
                {
                    break;
                }
                stack.push(var);
                stack.push(elem1);
                if(var == '+' || var == '-')
                {
                    i++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push('x');
                }
            }
        }
        if(stack.getSize() == 1 && (stack.peek() == 'x' || stack.peek() == 'y' || stack.peek() == 'z'))
        {
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;
    }
}
