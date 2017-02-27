/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author felipe
 */
public class TablaSimbolosVisual extends AbstractTableModel {
    private ArrayList<String> titulos=new ArrayList<String>();
    private ArrayList<Token> tokens=new ArrayList<Token>();

    public TablaSimbolosVisual() {
    }

    
    
    public TablaSimbolosVisual(ArrayList<Token> tokens) {
        this.tokens=tokens;
        titulos.add("lexema");
        titulos.add("token");
        titulos.add("boolean");
    }
    
    public void setArrayToken(ArrayList<Token> tokens){
    this.tokens=tokens;
    titulos.add("lexema");
        titulos.add("token");
        titulos.add("boolean");
    }
    
    
    
    
    
    @Override
    public int getRowCount() {
        return tokens.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Token tok=null;
        tok=tokens.get(rowIndex);
        switch(columnIndex){
            case 0: return tok.getLexema();
            case 1: return tok.getToken();
            case 2: return tok.getBool();
            default: return null;
        }
    }
  
    
     @Override
    public String getColumnName(int column){
        return titulos.get(column);
    }
}
