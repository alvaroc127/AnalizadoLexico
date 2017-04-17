/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;


import java.util.Stack;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class AnalizadosSintactico {
    
    private TablaSintactica tabSint;
    private ControlArchivos contArch;
    private Stack<String> pila;
    private ArrayList<String> inputFile;
    private String error;
    private ArrayList estados;
    private File fileTable;
        

    public AnalizadosSintactico() {
        inputFile=new ArrayList();
        tabSint=new TablaSintactica();
        contArch=new ControlArchivos();
        pila=new Stack();
        estados=new ArrayList();
        error="?";
    }
    
    
    
    public void loadTable(File fil){
    this.fileTable=fil;
    tabSint.loadColums(fil);
    tabSint.loadSimbol(fil);
    tabSint.loadTableofMe(fil);
    }
    
    
    public void anlysiSin(){
    String line="";
    boolean ban=false;
    int indic=0;
    ArrayList<String> gramatic=new ArrayList();
    if(pila.isEmpty())
    {
        ini_Stack();
    }
    File fil=new File(ControlArchivos.getAddreObjFile());
    try{
    FileReader filre=new FileReader(fil);
    BufferedReader buff=new BufferedReader(filre);
    while((line=buff.readLine())!=null&&false==ban){
        inputFile=contArch.createArrayofLine(line);
        if(ban==true){
            error="?";
            ban=false;
            indic=0;
            gramatic.clear();
        }
        while(false==ban && !pila.peek().equals("$")){
        if(inputFile.get(indic).equals("$"))
            ban=true;
        if(tabSint.searchTerminal(pila.peek())||pila.peek().equals("$")){
               if(pila.peek().equals(inputFile.get(indic))){
                   createState(pila,pila.peek(),inputFile.get(indic),line,tabSint.getGramatica(pila.peek()+inputFile.get(indic)));
                   pila.pop();
                   ++indic;
               }else{
                   error="error en la entrada"+ line +"con la gramatica "+tabSint.getGramatica(pila.peek()+inputFile.get(indic));
                   createState(pila,pila.peek(),inputFile.get(indic),line,tabSint.getGramatica(pila.peek()+inputFile.get(indic)));
                   ban=true;
               }
            }else{
                gramatic=tabSint.extracGramatic(tabSint.getGramatica(pila.peek()+inputFile.get(indic)));
                if(!gramatic.isEmpty()){
                    createState(pila,pila.peek(),inputFile.get(indic),line,tabSint.getGramatica(pila.peek()+inputFile.get(indic)));
                    pila.pop();
                    for(int i=gramatic.size()-1;i>=0;i--){
                        pila.push(gramatic.get(i));
                    }
                    gramatic.clear();
                }else{
                    error="error de sintaxis";
                    createState(pila,pila.peek(),inputFile.get(indic),line,tabSint.getGramatica(pila.peek()+inputFile.get(indic)));
                    ban=true;
                }
            }
        }
    }
    
    }catch(IOException ex){
    ex.printStackTrace();
    }
    
    }
    
    
    public void ini_Stack(){
        pila.push("$");
        pila.push(tabSint.getSimbol(0));
    }
    
    
    
    
    public void getLineObjFile(){
    
    
    
    }
    
    public void createState(Stack<String> pila,String X,String a,String ae,String gram){
        ArrayList<String> estado=new ArrayList();
        String pil="";
        for(int i= pila.size()-1;i>=0;i--){
            pil+=" "+pila.get(i);
        }
        estado.add(pil);
        estado.add(X);
        estado.add(a);
        estado.add(ae);
        estado.add(gram);
        if(error.equals("?"))
        {
            estado.add("ok");
        }else{
        estado.add(error);
        }
        estados.add(estado);
    }
    
    public ArrayList getEstados(){
    return this.estados;
    }

    public void setFileTable(File fileTable) {
        this.fileTable = fileTable;
    }
    
    
    
}
