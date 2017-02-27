/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author felipe
 */
public class AdministradorAutomatas {
    
    private AutomataLetra autoLetra;
    private AutomataDigito autoDigito;
    private AutomataIdentificador autoID;
    private AutomatadeSimbolo autoSimbo;
    private ControlArchivos co;
    

    public AdministradorAutomatas() {
    }
    
    

    public AdministradorAutomatas(AutomataLetra autoLetra, AutomataDigito autoDigito, AutomataIdentificador autoID, AutomatadeSimbolo autoSimbo) {
        this.autoLetra = autoLetra;
        this.autoDigito = autoDigito;
        this.autoID = autoID;
        this.autoSimbo = autoSimbo;
        co=new ControlArchivos();
    }

    public AutomataLetra getAutoLetra() {
        return autoLetra;
    }

    public void setAutoLetra(AutomataLetra autoLetra) {
        this.autoLetra = autoLetra;
    }

    public AutomataDigito getAutoDigito() {
        return autoDigito;
    }

    public void setAutoDigito(AutomataDigito autoDigito) {
        this.autoDigito = autoDigito;
    }

    public AutomataIdentificador getAutoID() {
        return autoID;
    }

    public void setAutoID(AutomataIdentificador autoID) {
        this.autoID = autoID;
    }

    public AutomatadeSimbolo getAutoSimbo() {
        return autoSimbo;
    }

    public void setAutoSimbo(AutomatadeSimbolo autoSimbo) {
        this.autoSimbo = autoSimbo;
    }
    
    
    public void getLineFile(File fileCon) throws  IOException{
        String line;
        FileReader filr=new FileReader(fileCon);
        BufferedReader buffer=new BufferedReader(filr);
        boolean ban=false;
        boolean ban1=false;
    try{
           while((line=buffer.readLine())!= null && ban==false){ 
               do{
                   if(autoID.getInicioCadena()==0){
                   autoID.algoritAuto(line);
                   }else{
                   autoID.setInicioCadena(autoDigito.getIndexOfline());
                   autoID.algoritAuto(line);
                   }
                   if(autoID.getIndexOfline()==autoDigito.getIndexOfline()){
                   ban1=true;
                   }else{
                   autoID.WriteObjFile();
                   autoID.addSpace();
                   ban1=false;
                   }
               
                   if(line.charAt(autoID.getIndexOfline())=='\"'){
                   autoSimbo.setInicioCadena(searchquotes(line,autoID.getIndexOfline()));
                   co.writeFileObject(extracSequence(line,autoID.getIndexOfline(),searchquotes(line,autoID.getIndexOfline())));
                   autoSimbo.algoritAuto(line);
                   }else{
                       if(line.charAt(autoID.getIndexOfline())==' '){
                           autoSimbo.setInicioCadena(autoID.getIndexOfline()+1);
                           autoSimbo.algoritAuto(line);
                       }
                   }
                   if(autoID.getIndexOfline()+1== autoSimbo.getIndexOfline()){
                   ban1=true;
                   }else{
                   ban1=false;
                   autoSimbo.WriteObjFile();
                   autoSimbo.addSpace();
                   }
                   if(line.charAt(autoSimbo.getIndexOfline())=='\"'){
                    autoDigito.setInicioCadena(searchquotes(line,autoSimbo.getIndexOfline()));
                    co.writeFileObject(extracSequence(line,autoSimbo.getIndexOfline(),searchquotes(line,autoSimbo.getIndexOfline())));
                    autoDigito.algoritAuto(line);
                   }else{
                       if(line.charAt(autoSimbo.getIndexOfline())==' '){
                           autoDigito.setInicioCadena(autoSimbo.getIndexOfline()+1);
                           autoDigito.algoritAuto(line);
                       }
                   }
                   if(autoDigito.getIndexOfline()+1== autoSimbo.getIndexOfline()){
                   ban1=true;
                   }else{
                   ban1=false;
                   autoDigito.WriteObjFile();
                   autoDigito.addSpace();
                   }      
               }while(ban1==true);
                    //si es un simbolo autoletra.WriteOBjetFIle y autsimbolo.WritroBjeFIle
                
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
    }
    
   
    
    public int searchquotes(String line, int indi){
        //obtener los indices de inicio y fin de los pares de comillas
        // que existan en la linea Ej: imprimir("sdfasdf"+"a"+"b");
        //retornar le a los automatas donde deben leer la cadena
        int desplaza;
        desplaza=line.indexOf("\"", indi);
        return desplaza;
    }
    
    
    public String extracSequence(String line, int indic, int end){
        return line.substring(line.indexOf("\"", indic-1),end);
    }
    
    
    public String getTextSource(File file){
        String out=null;
        try{
        out=co.getTextSourceFile(file);
           }catch(IOException ex){
           ex.printStackTrace();
           }
        return out;
    }
    
    public ControlArchivos getContArch(){
    return co;
    }
    
    
    
    
}
