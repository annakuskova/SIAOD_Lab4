import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        task();
    }
    public static void task()
    {
        Scanner input = new Scanner(System.in);
        StackU<String> stack = new StackU<>();
        BufferedReader reader;
        FileWriter writer;
        while(true)
        {
            try
            {
                System.out.print("Input path to file: ");
                String path = input.nextLine();
                reader = new BufferedReader(new FileReader(path));

                System.out.print("Output path to file: ");
                path = input.nextLine();
                input.close();
                writer = new FileWriter(path, false);
                break;
            }
            catch(IOException ioExc)
            {
                System.out.println("Wrong path to file");
            }
        }
        try
        {
            String newLine = reader.readLine();
            while(newLine != null)
            {
                stack.push(newLine);
                newLine = reader.readLine();
            }
            while(stack.peek() != null)
            {
                writer.write(stack.pop());
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ioExc)
        {
            ioExc.printStackTrace();
        }
    }
}
