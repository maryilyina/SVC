package Clone;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

public class CloneControl {
	
	private static String config_dir_name = "svc_configurations";
	
	public static void cloneRepository(String source, String dest){
    	File src_folder = new File(source);
    	File dest_folder = new File(dest);
    	
    	if (!src_folder.exists()){
            System.out.println("Source directory does not exist");
            return;
            
        } else if (dest_folder.exists()){
            System.out.println("Destination directory already exists. Choose a new name");
            return;
             
        } else {
         	copyFolder(src_folder, dest_folder, config_dir_name);
         	//createConfigFolder(dest_folder, config_dir_name);
        }
    }
	
	private static void createConfigFolder(File dest_folder, String dir_name) {
    	File config_folder = new File(dest_folder + "/" + dir_name);
    	config_folder.mkdir();
    	
    	//create dbs
	}

	private static void copyFolder(File src, File dest, String blocked){
		if (src.isDirectory()){
		
			if (!dest.exists()){
			   dest.mkdirs();
			}
			
			if (!dest.canWrite()){
	            System.out.println("Don't have rights to write to destination directory");
	            return;
			}
			
			String files[] = src.list();
			
			for (String file : files){
				
    			if (!Objects.equals(file, blocked)){
    			    File src_file = new File(src, file);
    			    File dest_file = new File(dest, file);
    			    copyFolder(src_file, dest_file, blocked);
	    		}
				
			}
	   
	   } else if (src.isFile()){
		   copyFile(src, dest);
	   }
    	
	}
	
	private static void copyFile(File src, File dest){
		InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(src);
	        os = new FileOutputStream(dest);
	        
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	        
	    } catch (IOException e) {
            System.out.println("Error while copying file: " + src);
			e.printStackTrace();
		}
	    finally {
	        
	    	try {
				is.close();
		        os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
}
