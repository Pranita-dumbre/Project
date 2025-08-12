package MarvellousPackerUnpacker;

import java.io.*;
import java.util.*;

public class MarvellousUnpaker
{
    private String PackName;

    public MarvellousUnpaker(String A)
    {
        this.PackName = A;
    }

    public void UnpackingActivity()
    {
        try
        { 
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("-----------------------Marvellous Packer Unpacker----------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("---------------------------Unpaking Activity---------------------------");
            System.out.println("-----------------------------------------------------------------------");

            String Header = null;
            File fobjnew = null;

            int FileSize = 0, iRet = 0, iCountFile = 0;

            File fobj = new File(PackName);

            //If Packed file is not present
            if(! fobj.exists())
            {
                System.out.println("Unable to access packed file");
                return;
            }

            System.out.println("Packed file is succesfully open");

            FileInputStream fiobj = new FileInputStream(fobj);
            

            //Buffer to read header
            byte HeaderBuffer[] = new byte[100];


            //Scan the pack file to extract the files from it
            while((iRet = fiobj.read(HeaderBuffer,0,100)) != -1)
            {
                //Conver byte array to stream
                Header = new  String(HeaderBuffer);

                Header = Header.trim();

                // Tokenize the header into to 2 parts
                String Tokens[] = Header.split(" ");

                fobjnew = new File(Tokens[0]);

                // Create new File to extract
                fobjnew.createNewFile();

                FileSize = Integer.parseInt(Tokens[1]);

                // Create new buffer to store the file data
                byte Buffer[] = new byte[FileSize];

                FileOutputStream foobj = new FileOutputStream(fobjnew);

                // Read the data from packed file
                fiobj.read(Buffer,0,FileSize);

                // Write the data into extracted file
                foobj.write(Buffer,0,FileSize);

                System.out.println("File Unpack with name "+Tokens[0]+" having size");

                iCountFile++;

                foobj.close();

            }//End of while

            System.out.println("------------------------------------------------------------------------");
            System.err.println("-----------------------Statistical Report-------------------------------");
            System.out.println("------------------------------------------------------------------------");

            System.out.println("Total number of file unpacked : "+iCountFile);

            System.out.println("------------------------------------------------------------------------");
            System.out.println("-----------------Thank you for using our application--------------------");
            System.out.println("------------------------------------------------------------------------");

            fiobj.close();

        }    
        catch(Exception eobj)
        {}
    }
}