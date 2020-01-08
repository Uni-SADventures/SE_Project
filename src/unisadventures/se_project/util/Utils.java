/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unisadventures.se_project.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krist
 */
public class Utils {
     public static String loadFileAsString(String path){
        StringBuilder builder= new StringBuilder();
         try{
             BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(path), "UTF-8"));

                
             /*   BufferedReader br= new BufferedReader(new FileReader(path));*/
                String line;
                while((line = br.readLine()) !=null)
                    builder.append(line + "\n");
       
                br.close();
        } catch (IOException e) {
            e.printStackTrace() ;
        }
            
        return builder.toString();
        }
    
    public static int ParseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
    }
    
    }
    
}
