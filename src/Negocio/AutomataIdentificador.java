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
public class AutomataIdentificador extends Automata{

    public AutomataIdentificador() {
    }

    public AutomataIdentificador(String lexema, int estado, boolean estadoAcepta, int estadoError, int inicioCadena, int[] posLectura) {
        super(lexema, estado, estadoAcepta, estadoError, inicioCadena, posLectura);
    }

    public AutomataIdentificador(int[] posLectura) {
        super(posLectura);
        this.tab=new TablaSimbolos();
        inicioCadena=0;
    }
    
    public boolean algoritAuto(String linText){
        estado=0;
        boolean ban=true;
        for(int i=inicioCadena; i < linText.length()&&ban==true; i++){
              if(Character.isLetter(linText.charAt(i))&& estado== 0){
                  lexema+=linText.charAt(i);
                  estado=1;
                  estadoAcepta=true;
              }else{
                  if(Character.isLetterOrDigit(linText.charAt(i))&& estado==1){
                  lexema+=linText.charAt(i);
                  estado=1;
                  estadoAcepta=true;
                  }else{
              posLectura[0]=i;
              estadoAcepta=false;
              ban=false;
                  }
              }
        }
        return estadoAcepta;
    }
    
    public void WriteTabSimbo(){
        tab.writeTabSimbolID(lexema);
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
            WriteTabSimbo();
            tab.writeFileObj(tab.getToken(lexema));
        }
    }
    
    public void addSpace(){
    tab.writeFileObj(" ");
    }
    
    public int getIndexOfline(){
    return posLectura[0];
    } 
    
    public void setInicad(int start){
    this.inicioCadena=start;
    }
    
    
}
