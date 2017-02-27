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
public class AutomataLetra extends Automata{
    
    public AutomataLetra(){
    super();
    }

    public AutomataLetra(String lexema, int estado, boolean estadoAcepta, int estadoError, int inicioCadena, int[] posLectura) {
        super(lexema, estado, estadoAcepta, estadoError, inicioCadena, posLectura);
    }
    
    public AutomataLetra(int[] posLectura){
    this.posLectura=posLectura;
    this.tab=new TablaSimbolos();
    }
    
    
    public boolean algoritAuto(String linText){
        boolean ban=true;
        for(int i=0; i < linText.length()&&ban==true; i++){
              if(Character.isLetter(linText.charAt(i))){
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
    
    
    public boolean isKeyWord(){
        boolean output=false;
        if(tab.searchKeyWord(lexema)){
            output=true;
        }
    return output;
    }
       
    
    @Override
    public void WriteObjFile(){
        if(isKeyWord()){
            tab.writeFileObj(tab.getToken(lexema));
        }else{
            System.out.println("error lexico");
        }
    }
    
    public int getIndexOfline(){
    return posLectura[0];
    }
    
}
