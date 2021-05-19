import java.util.ArrayList;
import java.util.Arrays;

public class StackU<E>
{

    private ArrayList<E> stack;
    private int size;

    public StackU()
    {
        stack = new ArrayList<>();
        size = 0;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void push(E element)
    {
        if(element != null)
        {
            this.stack.add(element);
            this.size++;
        }
    }

    public E peek()
    {
        if(size != 0)
        {
            return this.stack.get(this.size-1);
        }
        System.out.println("Stack is empty");
        return null;
    }

    public E pop()
    {
        if(size != 0)
        {
            E element = this.stack.get(this.size-1);
            this.stack.remove(this.size-1);
            this.size--;
            return element;
        }
        System.out.println("Stack is empty");
        return null;
    }

    public String toString()
    {
        return Arrays.toString(this.stack.toArray());
    }

    public int getSize()
    {
        return this.size;
    }

}