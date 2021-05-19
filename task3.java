import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        task();
    }
    public static void task()
    {
        Scanner input = new Scanner(System.in);
        BufferedReader reader;
        ArrayList<StackU<Integer>> stacks = new ArrayList<StackU<Integer>>();
        stacks.add(new StackU<Integer>());
        stacks.add(new StackU<Integer>());
        stacks.add(new StackU<Integer>());
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
        try
        {
            ArrayList<Integer> disks = new ArrayList<>();
            String line = reader.readLine();
            String[] numbers;
            while(line != null)
            {
                line = line.trim();
                numbers = line.split(" ");
                for(int i = 0; i < numbers.length; i++)
                {
                    disks.add(Integer.parseInt(numbers[i]));
                }
                line = reader.readLine();

            }
            // сортируем
            //записывапем диски в первыйй стек
            Collections.sort(disks, Collections.reverseOrder());
            for(int i = 0; i < disks.size(); i++)
            {
                stacks.get(0).push(disks.get(i));
            }
        }
        catch(IOException ioExc)
        {
            ioExc.printStackTrace();
        }
        catch(NumberFormatException numExc)
        {
            System.out.println("Incorrect format of numbers in file");
        }
        System.out.println(stacks.get(0).toString());
        int count = stacks.get(0).getSize();
        hanoiTowers(count, 0, 2, 1, stacks);
        System.out.print(stacks.get(0).toString());
        System.out.print(stacks.get(1).toString());
        System.out.println(stacks.get(2).toString());
    }

    public static void hanoiTowers(int count, int start, int middle, int end, ArrayList<StackU<Integer>> stacks)
    {
        if(count > 0)
        {
            hanoiTowers(count-1, start, end, middle, stacks);
            stacks.get(middle).push(stacks.get(start).pop());
            hanoiTowers(count-1, end, middle , start, stacks);

        }
    }
}
