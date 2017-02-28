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
public class AutomataDigito extends Automata{

    public AutomataDigito() {
    }

    public AutomataDigito(String lexema, int estado, boolean estadoAcepta, int estadoError, int inicioCadena, int[] posLectura) {
        super(lexema, estado, estadoAcepta, estadoError, inicioCadena, posLectura);
    }

    public AutomataDigito(int[] posLectura) {
        super(posLectura);
        this.tab=new TablaSimbolos();
    }
    
    
    
    
    public boolean algoritAuto(String linText){
        boolean ban=true;
        for(int i=inicioCadena; i < linText.length()&&ban==true; i++){
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

    @Override
    public void WriteObjFile() {
        if(isKeyWord()){
            tab.writeFileObj(tab.getToken(lexema));
        }else{
            WriteTabSimbo();
            tab.writeFileObj(tab.getToken(lexema));
        }
    }
    
    private void WriteTabSimbo(){
        tab.writeTabSimbolDig(lexema);
    }

    
    
    public boolean isKeyWord(){
        boolean output=false;
        if(tab.searchKeyWord(lexema)){
            output=true;
        }
    return output;
    }
    
    
     public int getIndexOfline(){
    return posLectura[0];
    } 
    
     
     public void addSpace(){
    tab.writeFileObj(" ");
    }
    
    
    
}
