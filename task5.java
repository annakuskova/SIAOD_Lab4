import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        System.out.println(task());
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
            String newLine = reader.readLine();
            while(newLine != null)
            {
                line += newLine + "\n";
                newLine = reader.readLine();
            }
        }
        catch(IOException ioExc)
        {
            ioExc.printStackTrace();
        }
        System.out.println("Program code is:");
        System.out.println(line);

        DequeU<Character> deq = new DequeU<>();
        for(int i = 0; i < line.length(); i++)
        {
            if(line.charAt(i) == '[')
            {
                deq.addLast('[');
            }
            if(line.charAt(i) == ']')
            {
                if(deq.getSize() != 0)
                {
                    deq.removeLast();
                }
                else
                {
                    System.out.println("Code is unbalanced. Some '[' expected");
                    return false;
                }
            }
        }
        if(deq.getSize() != 0)
        {
            System.out.println("Code is unbalanced. Some ']' expected");
            return false;
        }
        System.out.println("Code is balanced.");
        return true;
    }
}
