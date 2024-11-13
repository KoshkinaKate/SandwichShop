package com.FreshFit.utilities;
// save an order summary to a receipt file
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManager {
    //static - method can be called directly by using a class name. No need to create an Object
    public static void generateReceipt(String orderDetails) {
        String fileName = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(orderDetails);
            System.out.println("Thank you for the purchase, your receipt " + fileName + " was saved.");
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}
