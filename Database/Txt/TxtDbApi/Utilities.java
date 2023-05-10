package Database.Txt.TxtDbApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utilities {
    
    public StringBuilder ReadFile(String path)
    {
        String str = "";
        StringBuilder result = new StringBuilder("");
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((str = br.readLine()) != null)
            {
                result.append(str).append("\n");
            }
            br.close();
        } catch (Exception e) {
            return new StringBuilder("");
        }

        return result;
    }

    public void WriteFile(String path, String text)
    {
        try (FileWriter fw = new FileWriter(path, false))
        {
            fw.write(text);
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}