package id.akdev.KalkulatorPrefix3Digit;

public class Stack
{
    public String [] stack;
    public int maks;
    public int top;

    public Stack(int batasArray)
    {
        maks = batasArray;
        stack = new String[maks];
        top = -1;
    }

    public void push(String value)
    {
        stack[++top] = value;
    }

    public String pop()
    {
        return stack[top--];
    }

    public String peek()
    {
        return stack[top];
    }

    public boolean cekOperator(String opt)
    {
        if (opt.equals("+") || opt.equals("-") || opt.equals("*") || opt.equals("/"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
