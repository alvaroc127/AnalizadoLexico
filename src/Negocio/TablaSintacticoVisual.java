/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
/**
 *
 * @author felipe
 */
public class TablaSintacticoVisual extends AbstractTableModel{
    private ArrayList<String> titulos=new ArrayList();
    private ArrayList estados=new ArrayList();
    
    
    public TablaSintacticoVisual() {
        titulos.add("pila");
        titulos.add("X");
        titulos.add("a");
        titulos.add("ae");
        titulos.add("X->Y1Y2...");
        titulos.add("salida");
    }

    public TablaSintacticoVisual(ArrayList estados){
        this.estados=estados;
        titulos.add("pila");
        titulos.add("X");
        titulos.add("a");
        titulos.add("ae");
        titulos.add("X->Y1Y2...");
        titulos.add("salida");
    }
    
    
    public void setArrayList(ArrayList  estados){
        this.estados=estados;
    }
    
    @Override
    public int getRowCount() {
        return estados.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList<String> estado=(ArrayList<String>)estados.get(rowIndex);
        switch(columnIndex){
            case 0: return estado.get(0);
            case 1: return estado.get(1);
            case 2: return estado.get(2);
            case 3: return estado.get(3);
            case 4: return estado.get(4);
            case 5: return estado.get(5);
            default : return null;
            
        }
    }
    
    @Override
    public String getColumnName(int column){
        return titulos.get(column);
    }

    
    
}
