/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author felipe
 */
public class AutomatadeSimbolo extends Automata{

    public AutomatadeSimbolo() {
    }

    public AutomatadeSimbolo(String lexema, int estado, boolean estadoAcepta, int estadoError, int inicioCadena, int[] posLectura) {
        super(lexema, estado, estadoAcepta, estadoError, inicioCadena, posLectura);
    }

    public AutomatadeSimbolo(int[] posLectura) {
        super(posLectura);
         this.tab=new TablaSimbolos();
    }    
    
    public boolean algoritAuto(String linText){
        estado=1;
        if(linText.isEmpty()==false){
            lexema+=linText.charAt(0);
            if(linText.length()>1){
            if(!Character.isLetterOrDigit(linText.charAt(1))){
                estadoAcepta=true;
                posLectura[0]=1;
                }else{
            estadoAcepta=false;
            posLectura[0]=1;
            }
            }else{
            estadoAcepta=false;
            posLectura[0]=1;
            }
        }
        return estadoAcepta;
    }
    
    
    
    @Override
    public void WriteObjFile() {
        if(isKeyWord()){
            tab.writeFileObj(tab.getToken(lexema));
        }else{
            System.out.println("simbolo desconocido");
        }
    }
    
    
    @Override
    public boolean algoritmoDo(String clearline, int index) {
                estado=1;
                  if(!Character.isLetterOrDigit(clearline.charAt(index))){
                  lexema+=clearline.charAt(index);
                  estado=1;
                  estadoAcepta=true;
                  }else{
              posLectura[0]=index;
              estadoAcepta=false;
                 }
        return estadoAcepta;
    }
    
    
    public boolean isKeyWord(){
        boolean output=false;
        if(tab.searchKeyWord(lexema)){
            output=true;
        }
    return output;
    }
       
    
    
    
    public void addSpace(){
    tab.writeFileObj(" ");
    }
    
    public int getIndexOfline(){
    return posLectura[0];
    } 

    public boolean IsSim(String cad, int inde){
        boolean ban=false;
        if(!Character.isLetterOrDigit(cad.charAt(inde))){
        ban=true;
        }
        return true;
    }
    
    
    
}
