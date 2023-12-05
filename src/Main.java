import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    //Method of rounding decimals I found via Google
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        //Opens the files for later use
        File itemsFile = new File("items.txt");
        File totalFile = new File("total.txt");

        double subTotal = 0;
        double tax = 0;
        double finalTotal = 0;

        //Scans items.txt and does the calculations to find our later printed out doubles
        try {
            Scanner sc = new Scanner(itemsFile);

            while (sc.hasNextDouble()) {
                subTotal += sc.nextDouble();
            }
            tax = subTotal * 0.053;
            finalTotal = subTotal + tax;

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //Writes to total.txt the doubles we calculated in the last step
        try (FileWriter fileWriter = new FileWriter(totalFile, true)) {
            fileWriter.write("Sub-Total is: $" + df.format(subTotal) + "\nTax is : $" + df.format(tax)
                    + "\nFinal Total is : $" + df.format(finalTotal));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}