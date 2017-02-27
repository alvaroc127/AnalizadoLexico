/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ControlArchivos {
    
    private static String nameFile="/tablaSimbolos.txt";
    private static String nameObjFile="/ObjectFile.txt";
    private static String addresFile="";
    private static String adFileSourc="";
    private static String addreObjFile="";
    String tabINI="programa\tmain" + "\t1\n" +
                  "int\tint" + "\t1\n" +
                  "float\tfloat" + "\t1\n" +
                  "char\tchar" + "\t1\n" +
                  "leer\tread" + "\t1\n" +
                  "imprimir\tprint" + "\t1\n" +
                  "terminar\tend" + "\t1\n" +
                  "sino\telse" + "\t1\n"+
                  "si\tif" + "\t1\n" +
                  "hacer\tdo" + "\t1\n" +
                  "entonces\tthen" + "\t1\n"+ 
                  "retornar\treturn" + "\t1\n"+
                  "para\tfor" + "\t1\n" +
                  "publico\tpublic" + "\t1\n" +
                  "estatico\tstatic" + "\t1\n" +
                  "void\tvoid" + "\t1\n" +
                  "clase\tclass" + "\t1\n" +
                  "mientras\twhile" + "\t1\n" +
                  "\"\t\"" + "\t1\n" +
                  "+\t+" + "\t1\n"+
                  "-\t-" + "\t1\n"+
                  "*\t*" + "\t1\n" +
                  "/\t/" + "\t1\n" +
                  "=\t=" + "\t1\n" +
                  "%\t%" + "\t1\n"+
                   "<\t<" + "\t1\n" +
                   ">\t>" + "\t1\n" +
                    "[\t[" + "\t1\n" +
                    "]\t]" + "\t1\n" +
                    ".\t." + "\t1\n" +
                    ";\t;" + "\t1\n"+
                    ",\t," + "\t1\n" +
                    ":\t:" + "\t1\n" +
                    "'\t'" + "\t1\n" +
                    "(\t(" + "\t1\n" +
                    ")\t)" + "\t1\n" +
                    "{\t{" + "\t1\n" +
                    "}\t}" + "\t1\n" +
                    "$\t$" + "\t1\n"+
                    "&\t&" + "\t1\n"+
                    "&&\t&&" + "\t1\n"+
                    "|\t|" + "\t1\n"+
                    "||\t||" + "\t1\n";

    public ControlArchivos() {
        
    }
    
    
    
    public void crearTabla(){
    File ntabFil=new File(System.getProperty("user.home")+nameFile);
    try{
    FileWriter fileWri=new FileWriter(ntabFil);
    addresFile=System.getProperty("user.home")+nameFile;
    loadTabIni(fileWri);
    }catch(IOException ex){
    ex.printStackTrace();
        }
    }
    
    
    public void loadTabIni(FileWriter fil){
        BufferedWriter bufFil=new BufferedWriter(fil);
        try{
            bufFil.write(tabINI);
        }catch(IOException is){
        is.printStackTrace();
        }finally{
            try{
        bufFil.close();
            }catch(IOException ex){
            ex.printStackTrace();
            }
        }
    }
    
    
    public boolean searchinFile(String lexm) throws IOException{
        String line;
        File fil=new File(addresFile);
        FileReader filr=new FileReader(fil);
        BufferedReader buffer=new BufferedReader(filr);
        boolean ban=false;
    try{
           while((line=buffer.readLine())!= null && ban==false){
               if(line.contentEquals(lexm)){
               ban=true;
               }
           }
       }catch(IOException ex){
           ex.printStackTrace();
       }finally{
           try{
           filr.close();
           }catch(IOException ioex){
           ioex.printStackTrace();
           }
       }
    return ban;
    }
    
    
    public void writeFileObject(String line) throws  IOException{
    File ntabFil=new File(System.getProperty("user.home")+nameObjFile);
    FileWriter fileWri=new FileWriter(ntabFil);
    BufferedWriter bufFil=new BufferedWriter(fileWri);
    try{
    addreObjFile=System.getProperty("user.home")+nameObjFile;
    bufFil.write(line);
    }catch(IOException ex){
        ex.printStackTrace();
        
        }finally{
        bufFil.close();
     }
    
    
    }
    
    public String searchToken(String lexm) throws IOException{
        String line;
        String token=null;
        File fil=new File(addresFile);
        FileReader filr=new FileReader(fil);
        BufferedReader buffer=new BufferedReader(filr);
        boolean ban=false;
    try{
           while((line=buffer.readLine())!= null && ban==false){
               if(line.contentEquals(lexm)){
                   ban=true;
                   token=line.substring(line.indexOf("\t"),line.lastIndexOf("\t",line.indexOf("\t")));
               }
           }
       }catch(IOException ex){
           ex.printStackTrace();
       }finally{
           try{
           filr.close();
           }catch(IOException ioex){
           ioex.printStackTrace();
           }
       }
    return token;
    }

    
    
    public void writeinTableSimbolID(String lexema) throws IOException{
    File ntabFil=new File(addresFile);
    FileWriter fileWri=new FileWriter(ntabFil);
    BufferedWriter bufFil=new BufferedWriter(fileWri);
    try{
    bufFil.write(lexema+"\tid" + "\t0\r\n \n" );
    }catch(IOException ex){
        ex.printStackTrace();
        }finally{
        bufFil.close();
     }
    }
    
    public void writeinTableSimbolDig(String lexema) throws IOException{
    File ntabFil=new File(addresFile);
    FileWriter fileWri=new FileWriter(ntabFil);
    BufferedWriter bufFil=new BufferedWriter(fileWri);
    try{
    bufFil.write(lexema+"\tnum" + "\t0\r\n \n" );
    }catch(IOException ex){
        ex.printStackTrace();
        }finally{
        bufFil.close();
     }
    }
    
    
    
    public String getTextSourceFile(File file) throws  IOException{
    String stringFil;
    String finish="";
    FileReader filr=new FileReader(file);
    BufferedReader buffer=new BufferedReader(filr);
       try{
           while((stringFil=buffer.readLine())!= null){
               finish+=stringFil+"\n";
           }
       }catch(IOException ex){
           ex.printStackTrace();
       }finally{
           try{
           filr.close();
           }catch(IOException ioex){
           ioex.printStackTrace();
           }
       }
       return finish;
    }
    
    public ArrayList<Token> listToken() throws IOException{
        ArrayList<Token> tokens=new ArrayList<Token>();
    String line;
        File fil=new File(addresFile);
        FileReader filr=new FileReader(fil);
        BufferedReader buffer=new BufferedReader(filr);
        boolean ban=false;
    try{
           while((line=buffer.readLine())!= null && ban==false){
               if(!line.equals("\n")){
               Token tok=new Token();
               tok.extracToken(line);
               tokens.add(tok);
               }
           }
       }catch(IOException ex){
           ex.printStackTrace();
       }finally{
           try{
           filr.close();
           }catch(IOException ioex){
           ioex.printStackTrace();
           }
       }
    return tokens;
    }
    
    public static String getAddresFile() {
        return addresFile;
    }

    public void setAddresFile(String addresFile) {
        this.addresFile = addresFile;
    }

    public static String getAddreObjFile() {
        return addreObjFile;
    }

    public void setAddreObjFile(String addreObjFile) {
        this.addreObjFile = addreObjFile;
    }
    
    
    
    
}
