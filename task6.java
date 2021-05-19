import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        task();
    }
    public static void task()
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
            String newLine = reader.readLine();
            while(newLine != null)
            {
                line += newLine;
                newLine = reader.readLine();
            }
        }
        catch(IOException ioExc)
        {
            ioExc.printStackTrace();
        }
        System.out.println("Source text is:");
        System.out.println(line);

        StackU<Character> stack = new StackU<>();
        for(int i = 0; i < line.length(); i++)
        {
            if(stack.peek() == null)
            {
                stack.push(line.charAt(i));
            }
            else
            {
                String storage = "";
                if(Character.isDigit(line.charAt(i)))
                {
                    while(stack.peek() != null && Character.isDigit(stack.peek()))
                    {
                        storage += stack.pop();
                    }
                    stack.push(line.charAt(i));
                    for(int j = storage.length() - 1; j >= 0; j--)
                    {
                        stack.push(storage.charAt(j));
                    }
                }
                if(Character.isLetter(line.charAt(i)))
                {
                    while(stack.peek() != null && Character.isLetterOrDigit(stack.peek()))
                    {
                        storage += stack.pop();
                    }
                    stack.push(line.charAt(i));
                    for(int j = storage.length() - 1; j >= 0; j--)
                    {
                        stack.push(storage.charAt(j));
                    }
                }
                if(!Character.isDigit(line.charAt(i)) && !Character.isLetter(line.charAt(i)))
                {
                    while(stack.peek() != null)
                    {
                        storage += stack.pop();
                    }
                    stack.push(line.charAt(i));
                    for(int j = storage.length() - 1; j >= 0; j--)
                    {
                        stack.push(storage.charAt(j));
                    }
                }
            }
        }
        System.out.println("New order of symbols is:");
        System.out.println(stack.toString());
    }
}
