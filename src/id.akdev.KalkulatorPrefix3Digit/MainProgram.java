package id.akdev.KalkulatorPrefix3Digit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainProgram {
    public static double aritmatika(String operator, double angka1, double angka2)
    {
        double hasil = 0;
        switch (operator)
        {
            case "+":
                hasil = angka1 + angka2;
                break;
            case "-":
                hasil = angka1 - angka2;
                break;
            case "*":
                hasil = angka1 * angka2;
                break;
            case "/":
                hasil = angka1 / angka2;
                break;
        }
        return hasil;
    }

    public static void main(String[] args) throws IOException
    {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        do
        {
            System.out.print("$ ");
            String masukan = br.readLine();
            String[] op = masukan.split(" ");

            if (op.length == 1)
            {
                Stack kalkulator = new Stack(op.length);

                for (int i = 0; i < op.length; i++)
                {
                    kalkulator.push(op[i]);
                }

                if (kalkulator.pop().equalsIgnoreCase("stop"))
                {
                    System.exit(0);
                }
                else
                {
                    System.out.println("$ " + kalkulator.pop());
                }
            }
            else if (op.length == 5)
            {
                Stack kalkulator = new Stack(op.length);
                for (int i = 0; i < op.length; i++)
                {
                    kalkulator.push(op[i]);
                }

                try
                {
                    double angka3 = Double.valueOf(kalkulator.pop());
                    double angka2 = Double.valueOf(kalkulator.pop());
                    double angka1 = Double.valueOf(kalkulator.pop());
                    String opt2 = kalkulator.pop();
                    String opt1 = kalkulator.pop();

                    boolean proses = kalkulator.cekOperator(opt1) && kalkulator.cekOperator(opt2);

                    if (proses == true)
                    {
                        System.out.println("$ " + aritmatika(opt2, (aritmatika(opt1, angka1, angka2)), angka3));
                    }
                    else
                    {
                        System.out.println("$ Ekspresi Tidak Valid");
                    }
                }
                catch (Exception e)
                {
                    System.out.println("$ Ekspresi Tidak Valid");
                }
            }
            else
            {
                System.out.println("$ Ekspresi Tidak Valid");
            }
        }
        while(true);
    }
}
