package client.Raport;

import java.io.File;
import java.io.IOException;

public class ReportTXT implements Report {
    public ReportTXT()
    {

    }

    @Override
    public File createReport(String path, String name) throws IOException {
        File myFile=null;

        try{ myFile=new File(path+name+".txt");

            if (myFile.createNewFile())
            {
                System.out.println("################");
            }
            else
            {
                System.out.println("eroare");
            }
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myFile;
    }

}
