import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        System.out.println(task());
    }
    public static char task()
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
                char elem1 = stack.pop();
                stack.pop();
                char elem2 = stack.pop();
                char var = stack.pop();
                switch(var)
                {
                    case 'N':
                    {
                        if(elem1 > elem2)
                        {
                            i++;
                            stack.push(elem2);
                            break;
                        }
                        else
                        {
                            i++;
                            stack.push(elem1);
                            break;
                        }
                    }
                    case 'M':
                    {
                        if(elem1 > elem2)
                        {
                            i++;
                            stack.push(elem1);
                            break;
                        }
                        else
                        {
                            i++;
                            stack.push(elem2);
                            break;
                        }
                    }
                }
            }
        }
        if(Character.isDigit(stack.peek()))
        {
            System.out.println(stack.peek());
            return stack.peek();
        }
        return 0;

    }
}
