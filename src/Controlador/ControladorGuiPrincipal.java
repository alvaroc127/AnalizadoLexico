/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.AdministradorAutomatas;
import Negocio.AnalizadosSintactico;
import Negocio.TablaSimbolosVisual;
import Negocio.TablaSintacticoVisual;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ControladorGuiPrincipal {
    private AdministradorAutomatas AdminAuto;
    private File fil;
    private TablaSimbolosVisual tb;
    private AnalizadosSintactico analizadoSin;
    private  TablaSintacticoVisual tsv;
    
    
    
    public  ControladorGuiPrincipal(){
    
    }
    
    

    public ControladorGuiPrincipal(AdministradorAutomatas AdminAuto, File fil) {
        this.AdminAuto = AdminAuto;
        this.fil = fil;
    }
    
    public ControladorGuiPrincipal(AdministradorAutomatas AdminAuto){
    this.AdminAuto=AdminAuto;
    tb=new TablaSimbolosVisual();
    tsv=new TablaSintacticoVisual();
    analizadoSin=new AnalizadosSintactico();
    }
    
    public void loadFile(File fil){
    this.fil=fil;
    }
    
    
    public void StarALEX(){
        try{
        AdminAuto.getLineFile(fil);
        }catch(IOException EX){
        EX.printStackTrace();
        }
    }
    
    
    public String getTextSourceFile(){
    return AdminAuto.getTextSource(fil);
    }
    
    public void createTabIni(){
    AdminAuto.getContArch().crearTabla();
    }
    
    public void loadTable(){
        try{
            tb.setArrayToken(AdminAuto.getContArch().listToken());
            }catch(IOException ex){
            ex.printStackTrace();
            }
    }
    
    public TablaSimbolosVisual getTab(){
    return tb;
    }
    
    public String getTextObjFil(){
    return AdminAuto.getTextFileObj();
    }
    
    
    public String getPatchObjetFile(){
    return AdminAuto.getAdressObjFile();
    }
    
    public void startASINT(){
    analizadoSin.loadTable(fil);
    analizadoSin.anlysiSin();
    }
    
    public ArrayList getEstados(){
    return analizadoSin.getEstados();
    }
    
    public  void loadSinTab(ArrayList ele){
        tsv.setArrayList(ele);
    }
    
    public  TablaSintacticoVisual  getTableASINT(){
    return tsv;
    }
    
    
   
    
}
