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
public class Token {
    
    private String lexema;
    private String token;
    private int bool;

    public Token() {
    }

    public Token(String lexema, String token, int bool) {
        this.lexema = lexema;
        this.token = token;
        this.bool = bool;
    }

    
    
    
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getBool() {
        return bool;
    }

    public void setBool(int bool) {
        this.bool = bool;
    }
    
    public void extracToken(String line){
        for(int i= 0; i < line.length()-1;i++){
            i=loadLexema(line, i);
            i=loadToken(line, i);
            i=loadbool(line, i);
        }
    }
    
    
    public int loadLexema(String line, int ind){
        this.lexema= line.substring(ind,line.indexOf("\t"));
        return line.indexOf("\t")+1;
    }
    
    public int loadToken(String line, int ind){
        this.token= line.substring(ind,line.indexOf("\t", ind));
        return line.indexOf("\t", ind);
    }
    
    
    public int loadbool(String line, int ind){
    this.bool= Character.digit(line.charAt(ind+1),10);
    ind=line.length();
    return ind;
    }
    
    
}
