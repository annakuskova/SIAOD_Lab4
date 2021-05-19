import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task9 {
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
                char elem = stack.pop();
                char var = stack.peek();
                stack.push(elem);
                switch(var)
                {
                    case 'N':
                    {
                        if(stack.peek() == 'T')
                        {

                            i++;
                            stack.pop();
                            stack.pop();
                            stack.push('F');
                            break;
                        }
                        else
                        {
                            i++;
                            stack.pop();
                            stack.pop();
                            stack.push('T');
                            break;
                        }
                    }
                    case 'A':
                    {
                        if(stack.peek() == 'T')
                        {
                            stack.pop();
                            stack.pop();
                            if(stack.peek() == 'T')
                            {
                                i++;
                                stack.pop();
                                stack.push('T');
                                break;
                            }
                            else
                            {
                                i++;
                                stack.pop();
                                stack.push('F');
                                break;
                            }
                        }
                        else
                        {
                            stack.pop();
                            stack.pop();
                            i++;
                            stack.pop();
                            stack.push('F');
                            break;
                        }
                    }
                    case 'X':
                    {
                        char first = stack.peek();
                        stack.pop();
                        stack.pop();
                        char second = stack.peek();
                        if(first == second)
                        {
                            i++;
                            stack.pop();
                            stack.push('F');
                            break;
                        }
                        else
                        {
                            i++;
                            stack.pop();
                            stack.push('T');
                            break;
                        }
                    }
                    case 'O':
                    {
                        char first = stack.peek();
                        stack.pop();
                        stack.pop();
                        char second = stack.peek();
                        if(first == 'F' && second == 'F')
                        {
                            i++;
                            stack.pop();
                            stack.push('F');
                            break;
                        }
                        else
                        {
                            i++;
                            stack.pop();
                            stack.push('T');
                            break;
                        }
                    }
                }
            }
        }

        if(stack.peek() == 'T')
        {
            System.out.println("True");
            return true;
        }
        System.out.println("False");
        return false;
    }
}
