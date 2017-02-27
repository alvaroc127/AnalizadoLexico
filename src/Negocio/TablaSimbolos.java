/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.IOException;

/**
 *
 * @author felipe
 */
public class TablaSimbolos {
    
    private ControlArchivos contFile;
    
    public TablaSimbolos(){
    contFile=new ControlArchivos();
    }
    
    
    public void crearTabla(){
        contFile.crearTabla();
    
    
    
    }
    
    
    
    public boolean searchKeyWord(String lexema){
        boolean out=false;
       try{
           out=contFile.searchinFile(lexema);
       }catch(IOException io){
       io.printStackTrace();
       }
        return out;
    }   
    
    public String getToken(String lexema){
        String out=null;
       try{
           out=contFile.searchToken(lexema);
       }catch(IOException io){
       io.printStackTrace();
       }
        return out;
    }
    
    public void writeFileObj(String line){
      try{
        contFile.writeFileObject(line);
        }catch(IOException ex){
        ex.printStackTrace();
        }
    }
    
    public void writeTabSimbolDig(String lexema){
    try{
        contFile.writeinTableSimbolDig(lexema);
    }catch(IOException ex){
        ex.printStackTrace();
        }
    }
    
    public void writeTabSimbolID(String lexema){
    try{
        contFile.writeinTableSimbolID(lexema);
    }catch(IOException ex){
        ex.printStackTrace();
        }
    }
    
    
    
    
}
