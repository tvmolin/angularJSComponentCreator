package angularjs.component.creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Creator {
    
    
    protected void createFile(String path, String extension, String text) {
        try{
            File f = new File(path + extension);
            f.getParentFile().mkdirs(); 
            f.createNewFile();
            PrintWriter pw = new PrintWriter(f);
            BufferedWriter bw = new BufferedWriter(pw);  
            
            bw.write(text);            
            
            bw.flush();
            bw.close();
            
        }
        catch(IOException e){
            
        }
    }    
    
}
