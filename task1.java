import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        task();
    }
    public static void task() {
        Scanner input = new Scanner(System.in);
        BufferedReader reader;
        DequeU<String> deq1 = new DequeU<>();
        while(true) {
            try {
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
        try {
            String line = reader.readLine();
            while(line != null)
            {
                deq1.addLast(line);
                line = reader.readLine();
            }
        }
        catch(IOException ioExc)
        {
            ioExc.printStackTrace();
        }

        DequeU<String> deq2 = new DequeU<>();
        deq2.addFirst(deq1.removeFirst());
        while(!deq1.isEmpty()) {
            String first = deq1.getFirst().toLowerCase();
            String second = deq2.getFirst().toLowerCase();
            boolean compareWithLast = false;

            if(deq1.getFirst().length() >= deq2.getFirst().length()) {
                for(int i = 0; i < second.length(); i++)
                {
                    if(first.charAt(i) < second.charAt(i))
                    {
                        deq2.addFirst(deq1.getFirst());// доавляем вначало второго дека первый элемент первого
                        deq1.removeFirst();
                        break;
                    }
                    if(first.charAt(i) > second.charAt(i))
                    {
                        compareWithLast = true;
                        break;
                    }
                }
            }
            else
            {
                for(int i = 0; i < first.length(); i++)
                {
                    if(first.charAt(i) < second.charAt(i))
                    {
                        deq2.addFirst(deq1.getFirst());
                        deq1.removeFirst();
                        break;
                    }
                    if(first.charAt(i) > second.charAt(i))
                    {
                        compareWithLast = true;
                        break;
                    }
                }
            }
            if(deq1.isEmpty()) {
                break;
            }
            if(compareWithLast)
            {
                second = deq2.getLast().toLowerCase(); // toLowerCase потому что аски разный
            }
            if(deq1.getFirst().length() >= deq2.getFirst().length() && compareWithLast)
            {
                for(int i = 0; i < second.length(); i++)
                {
                    if(first.charAt(i) > second.charAt(i))
                    {
                        deq2.addLast(deq1.getFirst());
                        deq1.removeFirst();
                        break;
                    }
                    if(first.charAt(i) < second.charAt(i))
                    {
                        deq1.addLast(deq2.removeLast());
                        break;
                    }
                }
            }
            else if(compareWithLast)
            {
                for(int i = 0; i < first.length(); i++)
                {
                    if(first.charAt(i) > second.charAt(i))
                    {
                        deq2.addLast(deq1.getFirst());
                        deq1.removeFirst();
                        break;
                    }
                    if(first.charAt(i) < second.charAt(i))
                    {
                        deq1.addLast(deq2.removeLast());
                        break;
                    }
                }
            }
        }
        System.out.println(deq2.toString());
    }
}
