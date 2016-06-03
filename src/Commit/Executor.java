package Commit;

import java.io.*;

public class Executor {
 
    public static void runSystemCommand(String command) {
 
        String s = null;
 
        try {
             
            Process p = Runtime.getRuntime().exec(command);
             
            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(p.getInputStream()));
 
            BufferedReader stdError = new BufferedReader(new
                 InputStreamReader(p.getErrorStream()));
 
            while ((s = stdInput.readLine()) != null) {
                System.out.println("System command output: \n");
                System.out.println(s);
            }
             
            while ((s = stdError.readLine()) != null) {
                System.out.println("System command errors: " + s);
            }
             
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("System command exception: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}