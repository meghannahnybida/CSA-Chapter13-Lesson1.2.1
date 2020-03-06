package practice;

import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class WriteEmployeeFile {

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        Path file = Paths.get("C:\\Users\\mn145140\\Desktop\\CSA\\Chapter-Thirteen\\src\\practice\\Employees.txt");
        String s = "";
        String delmiter = ",";
        int id;
        String name;
        double payRate;
        final int QUIT = 999;

        try{
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            System.out.print("Enter employee ID # >> ");
            id = input.nextInt();
            while (id != QUIT){
                System.out.print("Enter name for employee # " + id + " >>");
                input.nextLine();
                name = input.nextLine();
                System.out.print("Enter pay rate >> ");
                payRate = input.nextDouble();

                s = id + delmiter + name + delmiter + payRate;
                writer.write(s, 0, s.length());
                writer.newLine();
                System.out.print("Enter next ID number or " + QUIT + " to quit >> ");
                id = input.nextInt();
            }
            writer.close();
        }
        catch(Exception e){
            System.out.println("Message: " + e);
        }
    }
}
