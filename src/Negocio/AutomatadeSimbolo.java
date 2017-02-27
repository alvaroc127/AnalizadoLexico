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
        boolean ban=true;
        for(int i=inicioCadena; i < linText.length()&&ban==true; i++){
                  if(!Character.isLetterOrDigit(linText.charAt(i))&& estado==1){
                  lexema+=linText.charAt(i);
                  estado=1;
                  estadoAcepta=true;
                  }else{
              posLectura[0]=i;
              estadoAcepta=false;
              ban=false;
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
    
    
    
}
