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
public abstract class Automata {
    
    protected String lexema="";
    protected int estado;
    protected boolean estadoAcepta;
    protected int estadoError;
    protected int inicioCadena=0;
    protected int posLectura[];
    protected TablaSimbolos tab;
    
    public Automata() {
    }

    public Automata(String lexema, int estado, boolean estadoAcepta, int estadoError, int inicioCadena, int[] posLectura) {
        this.lexema = lexema;
        this.estado = estado;
        this.estadoAcepta = estadoAcepta;
        this.estadoError = estadoError;
        this.inicioCadena = inicioCadena;
        this.posLectura = posLectura;
    }
    
    public Automata(int[] posLectura){
    this.posLectura=posLectura;
    }
    

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isEstadoAcepta() {
        return estadoAcepta;
    }

    public void setEstadoAcepta(boolean estadoAcepta) {
        this.estadoAcepta = estadoAcepta;
    }

    public int getEstadoError() {
        return estadoError;
    }

    public void setEstadoError(int estadoError) {
        this.estadoError = estadoError;
    }

    public int getInicioCadena() {
        return inicioCadena;
    }

    public void setInicioCadena(int inicioCadena) {
        this.inicioCadena = inicioCadena;
    }

    public int[] getPosLectura() {
        return posLectura;
    }

    public void setPosLectura(int[] posLectura) {
        this.posLectura = posLectura;
    }
    
     public abstract void WriteObjFile();
    public abstract boolean algoritmoDo(String clearline,int index);
    
}
