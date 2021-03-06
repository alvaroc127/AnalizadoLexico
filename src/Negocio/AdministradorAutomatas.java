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
import java.util.ArrayList;

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
           while((line=buffer.readLine())!= null){
                  clearString(line);
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
    
    public ArrayList<String> clearString(String line){
        ArrayList<String> texto=new ArrayList<String>();
        boolean ban=true;
        boolean ban1=true;
        int ini=0;
        for(int i=0;i<line.length()-1&&true==ban;i++){
            if(line.indexOf("\"", i)==-1 && line.indexOf(" ", i)==-1){
                texto.add(line.substring(i));
                ban=false;
            }else{
            if(line.charAt(i)==' '||line.charAt(i)=='"'){
                if(ini!=0){
              texto.add(line.substring(ini,i));
                }else{
                texto.add(line.substring(ini,i));
                }
              ini=i+1;
              if(line.charAt(i)=='"'){
                  ban1=true;
                for(int j= i+1;j<line.length()-1&&true==ban1;j++){
                        if(line.charAt(j)=='"'){
                        texto.add(line.substring(i, j+1));
                        ban1=false;
                        i=j;
                        }
                    }
                ini=i+1;
                }
             }
            }
        }
        System.out.println(texto.toString());
        return texto;
    }
    
    
}
