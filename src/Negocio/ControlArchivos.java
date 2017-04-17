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
    private static String nameTabSin="/TablaProyecto.txt";
    private static String addresFile="";
    private static String adFileSourc="";
    private static String addreObjFile="";
    private static String addreTabSin="";
    
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
    
    public ArrayList<String> createArrayofLine(String line){
        String aux="";
        ArrayList<String> array=new ArrayList<String>();
        for(int i=0;i< line.length();i++){
            if(Character.isLetter(line.charAt(i))){
                aux+=line.charAt(i);
            }else{
               if(line.charAt(i)==' '){
               array.add(aux);
               aux="";
               }else{
               array.add(aux);
               aux="";
               aux+=line.charAt(i);
               if(i+1<line.length()){
                if(Character.isLetter(line.charAt(i+1))||line.charAt(i+1)==' '){
                   array.add(aux);
                   aux="";
                }
               }
               if(i+1==line.length()){
                   array.add(aux);
                }
               }
            }
        }
        array.add("$");
        return array;
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
               if(line.substring(0,line.indexOf("\t")).equals(lexm)){
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
    FileWriter fileWri=new FileWriter(ntabFil,true);
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
               if(line.substring(0,line.indexOf("\t")).equals(lexm)){
                   ban=true;
                   int from=line.indexOf("\t")+1;
                   int end=line.indexOf("\t",from);
                   token=line.substring(from,end);
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
    FileWriter fileWri=new FileWriter(ntabFil,true);
    BufferedWriter bufFil=new BufferedWriter(fileWri);
    try{
    bufFil.write(lexema+"\tid" + "\t0\n" );
    }catch(IOException ex){
        ex.printStackTrace();
        }finally{
        bufFil.close();
     }
    }
    
    public void writeinTableSimbolDig(String lexema) throws IOException{
    File ntabFil=new File(addresFile);
    FileWriter fileWri=new FileWriter(ntabFil,true);
    BufferedWriter bufFil=new BufferedWriter(fileWri);
    try{
    bufFil.write(lexema+"\tnum" + "\t0\n" );
    }catch(IOException ex){
        ex.printStackTrace();
        }finally{
        bufFil.close();
     }
    }
    
    public String getTextFileObj() throws  IOException{
    String stringFil;
    String finish="";
    File fil=new File(addreObjFile);
    FileReader filr=new FileReader(fil);
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
    
    
    public ArrayList<String> readColunTabSint(File fil){
        ArrayList<String> columas=new ArrayList<String>();
        columas.add(" ");
        addreTabSin=fil.getAbsolutePath();
        String lin="";
        int indiI=0;
        int indiFi=0;
        try{
        FileReader filRe=new FileReader(fil);
        BufferedReader buf=new BufferedReader(filRe);
        lin=buf.readLine();
            while(indiFi < lin.length()){
                if(indiFi==0){
                 indiI=lin.indexOf(" ");
                 columas.add(lin.substring(0,indiI));
                    indiFi=lin.indexOf(" ", indiI+1);
                }else{
                indiFi=lin.indexOf(" ", indiI+1);
                if(indiFi==-1)
                    indiFi=lin.length();
                columas.add(lin.substring(indiI+1, indiFi));
                indiI=indiFi;
                }
            }
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return columas;
    }
    
    
    
    public int getIndc_inSpaces(String line){
    int cont=0;
    boolean ban=true;
    for(int i=0; i< line.length()&&true==ban;i++){
        if(line.charAt(i)==' '){
            cont++;
            if(line.charAt(i+1)=='"'){
            ban=false;
            }
        }
    }
    return cont;
    }
    
    
    public ArrayList<String> readFilTabSintac(File file){
        ArrayList<String> simbol=new ArrayList();
        String lin="";
        int indi=0;
        try{
        FileReader filRe=new FileReader(file);
        BufferedReader buf=new BufferedReader(filRe);
        lin=buf.readLine();
        while((lin=buf.readLine())!=null){
            indi=lin.indexOf(" ");
            simbol.add(lin.substring(0,indi));
            }    
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return simbol;
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
    
    
    public static String getAddreTablaSin(){
    return addreTabSin;
    }
    
    
}
