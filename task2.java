import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        task();
    }
    public static void task()
    {
        Scanner input = new Scanner(System.in);
        BufferedReader reader;
        DequeU<Character> deq = new DequeU<>();
        System.out.print("Input decoder string: "); //(расшифровывает)
        String decoder = input.nextLine().toLowerCase();
        for(int i = 0; i < decoder.length(); i++)
        {
            deq.addLast(decoder.charAt(i));
        }
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
            //заполняем строку содержимым файла
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
        System.out.println("Encoded message is:");
        System.out.println(line);

        //инициализируем новую строчку для расшифрованного сообщения
        String decodedMessage = "";
        line = line.toLowerCase();
        line = line.trim(); //убираем лишние пробелы
        boolean canDecode = true;
        int index = 0;
        while(decodedMessage.length() < line.length() && canDecode)
        {
            canDecode = false;
            if(line.charAt(index) == ' ')
            {
                index++;
                decodedMessage += " ";
            }
            for(int i = 0; i < deq.getSize(); i++)
            {
                if(deq.getFirst() == line.charAt(index))
                {
                    canDecode = true;
                    break;
                }
                deq.addLast(deq.removeFirst());
            }
            if(!canDecode)
            {
                System.out.println("Can't decode input message because of lack of symbols in decoder");
                break;
            }
            deq.addLast(deq.removeFirst());
            deq.addLast(deq.removeFirst());
            decodedMessage += deq.getFirst();
            index++;
        }
        if(canDecode)
        {
            System.out.println("Decoded message is:");
            System.out.println(decodedMessage);
        }
    }
}
