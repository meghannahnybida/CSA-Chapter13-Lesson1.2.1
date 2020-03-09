package youDoIt;

import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.Scanner;
public class ReadStateFile
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String fileName;
        System.out.print("Enter name of file to use >> ");
        fileName = input.nextLine();
        fileName = "C:\\Users\\mn145140\\Desktop\\CSA\\Chapter13-Lesson1.2\\src\\youDoIt\\InStateCusts.txt" + fileName;
        Path file = Paths.get(fileName);
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "          ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final String HOME_STATE = "WI";
        final String BALANCE_FORMAT = "0000.00";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter +
                HOME_STATE + delimiter + BALANCE_FORMAT + System.getProperty("line.separator");
        final int RECSIZE = s.length();
        byte data[] = s.getBytes();
        final String EMPTY_ACCT = "000";
        String[] array = new String[4];
        double balance;
        double total = 0;
        try
        {
            BasicFileAttributes attr =
                    Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("\nAttributes of the file:");
            System.out.println("Creation time " + attr.creationTime());
            System.out.println("Size " + attr.size());
        }
        catch(IOException e)
        {
            System.out.println("IO Exception");
        }
        try
        {
            InputStream iStream = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
            System.out.println("\nAll non-default records:\n");
            s = reader.readLine();
            while(s != null)
            {
                array = s.split(delimiter);
                if(!array[0].equals(EMPTY_ACCT))
                {
                    balance = Double.parseDouble(array[3]);
                    System.out.println("ID #" + array[0] + "  " + array[1] +
                            array[2] + "  $" + array[3]);
                    total += balance;
                }
                s = reader.readLine();
            }
            DecimalFormat df = new DecimalFormat("0000.00");
            System.out.println("Total of all balances is $" + df.format(total));
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
        try
        {
            FileChannel fc = (FileChannel)Files.newByteChannel(file, READ);
            ByteBuffer buffer = ByteBuffer.wrap(data);
            int findAcct;
            System.out.print("\nEnter account to seek >> ");
            findAcct = input.nextInt();
            fc.position(findAcct * RECSIZE);
            fc.read(buffer);
            s = new String(data);
            System.out.println("Desired record: " + s);
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
    }

}