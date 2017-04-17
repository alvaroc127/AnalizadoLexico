/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;


import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author felipe
 */
public class TablaSintactica {
    
    private Map<String,String> Tabla;
    private ControlArchivos contr;
    private ArrayList<String> colum;
    private ArrayList<String> simbols;
    
    

    public TablaSintactica() {
            Tabla=new HashMap<String,String>();
            contr=new ControlArchivos();
            colum=new ArrayList();
            simbols=new ArrayList();
    }

    public TablaSintactica(Map Tabla, ControlArchivos contr) {
        this.Tabla = Tabla;
        this.contr = contr;
    }
    
    
    
    
    public void loadTableofMe(File file){
    String lin="";
    String key="";
    String val="";
    File fil=new File(ControlArchivos.getAddreTablaSin());
    try{
    FileReader filre=new FileReader(fil);
    BufferedReader buff=new BufferedReader(filre);
    lin=buff.readLine();
    while((lin=buff.readLine())!=null){
        key=searchSimbol(lin);
        key+=colum.get(contr.getIndc_inSpaces(lin));
        val=searchGram(lin);
        Tabla.put(key, val);
        }
    }catch(IOException ex){
    ex.printStackTrace();
        }
    }
    
    
    public String searchSimbol(String line){
        int ind=0;
        String simb="";
        ind=line.indexOf(" ");
        simb=line.substring(0,ind);
        for(int i=0; i< simbols.size();i++){
            if(simb.equals(simbols.get(i))){
                simb=simbols.get(i);
            }
        }
    return simb;
    }
    
    public void loadColums(File file){
    colum=contr.readColunTabSint(file);
    }
    
    
    public void loadSimbol(File file){
    simbols=contr.readFilTabSintac(file);
    }
    
    public String searchGram(String line){
        int indiI=0;
        int indiF=0;
     indiI=line.indexOf("\"");
     indiF=line.indexOf("\"", indiI+1);
     return line.substring(indiI+1, indiF);
    }
    
    public boolean searchTerminal(String lin){
        boolean ban=false;
            for(int i=0;i<colum.size();i++){
                if(colum.get(i).equals(lin)){
                ban=true;
                }
            
        }
    return ban;
    }
    
    
    
    
    
    public String getGramatica(String key){
    return Tabla.get(key);
    }
    
    public String getSimbol(int ind){
    return simbols.get(ind);
    }
    
    public ArrayList<String> extracGramatic(String gramtic){
        int indiI=0, indiFi=0;
        boolean ban=false;
        ArrayList<String> gramatic=new ArrayList();
        if(gramtic!=null){
        while(indiFi < gramtic.length()&&false==ban){
            if(indiFi==0){
                indiI= gramtic.indexOf(" ");
                indiFi=gramtic.indexOf(" ", indiI+1);
                indiI=indiFi;
                indiFi=gramtic.indexOf(" ",indiI+1);
                if(indiFi==-1){
                    indiFi=gramtic.length();
                    ban=true;
                }
                gramatic.add(gramtic.substring(indiI+1, indiFi));
            }else{
                indiI=indiFi;
                indiFi=gramtic.indexOf(" ",indiI+1);
                if(indiFi==-1){
                    indiFi=gramtic.length();
                    ban=true;
                }
                gramatic.add(gramtic.substring(indiI+1, indiFi));
            }
        }
        }
        return gramatic;
    }
    
    
}
