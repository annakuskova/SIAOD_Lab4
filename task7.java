import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class task7 {
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
        ArrayList<Integer> numbers = new ArrayList<>();
        try
        {
            String newLine = reader.readLine();
            while(newLine != null)
            {
                line += newLine + " ";
                newLine = reader.readLine();
            }
        }
        catch(IOException ioExc)
        {
            ioExc.printStackTrace();
        }
        String number = "";
        for(int i = 0; i < line.length(); i++)
        {
            if(line.charAt(i) == '-' && number.length() == 0 || Character.isDigit(line.charAt(i)))
            {
                number += line.charAt(i);
            }
            else
            {
                if(!number.equals("-") && number.length() != 0)
                {
                    numbers.add(Integer.parseInt(number));
                    number = "";
                }
            }
        }

        System.out.println("Source order of numbers is:");
        System.out.println(Arrays.toString(numbers.toArray()));
        DequeU<Integer> deq = new DequeU<>();
        for(int i = 0; i < numbers.size(); i++)
        {
            if(numbers.get(i) >= 0)
            {
                deq.addFirst(numbers.get(i));
            }
            else
            {
                deq.addLast(numbers.get(i));
            }
        }
        while(deq.getFirst() >= 0)
        {
            deq.addLast(deq.removeFirst());
        }
        while(deq.getSize() != 0)
        {
            if(deq.getFirst() < 0)
            {
                System.out.print(deq.removeFirst());
                System.out.print(" ");
            }
            if(deq.getFirst() >= 0)
            {
                System.out.print(deq.removeLast());
                System.out.print(" ");
            }
        }
    }
}
