
package Controlador;

import Datos.Repositorio;
import Modelo.UnidadSangre;
import Vista.frmInventario;
import Vista.frmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian S
 */
public class ControladorInventario {
    private frmInventario vista;
    private ArrayList<UnidadSangre> modelo;
    
    public ControladorInventario(frmInventario vista, ArrayList<UnidadSangre> modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
        
        addRowToTblInventario();
    }
    
    public void addRowToTblInventario(){
        DefaultTableModel tblModel = (DefaultTableModel) vista.tbl_Inventario.getModel();
        ArrayList<UnidadSangre> lista = modelo;
        ArrayList<UnidadSangre> listaOrdenada = calcVolumenTotal(lista);
        Object rowData[] = new Object[3];
        
        for(int i = 0; i < listaOrdenada.size(); i++){
            rowData[0] = lista.get(i).getGrupoSanguineo();
            rowData[1] = lista.get(i).getRh();
            rowData[2] = lista.get(i).getVolumen();
            tblModel.addRow(rowData);
        }
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public ArrayList<UnidadSangre> calcVolumenTotal(ArrayList<UnidadSangre> unorderedList){
        float volAPlus = 0, volBPlus = 0, volABPlus = 0, volOPlus = 0, volANega = 0, volBNega = 0, volABNega = 0, volONega = 0;
        
        for(int i = 0; i < unorderedList.size(); i++){
            String grupoSangre = unorderedList.get(i).getGrupoSanguineo();
            String rh = unorderedList.get(i).getRh();
            float volumen = unorderedList.get(i).getVolumen();
            
            if(grupoSangre.equals("A")){
                if(rh.equals("+")){
                    volAPlus += volumen;
                }
                else{
                    volANega += volumen;
                }
            }
            else if(grupoSangre.equals("B")){
                if(rh.equals("+")){
                    volBPlus += volumen;
                }
                else{
                    volBNega += volumen;
                }
            }
            else if(grupoSangre.equals("AB")){
                if(rh.equals("+")){
                    volABPlus += volumen;
                }
                else{
                    volABNega += volumen;
                }
            }
            else if(grupoSangre.equals("O")){
                if(rh.equals("+")){
                    volOPlus += volumen;
                }
                else{
                    volONega += volumen;
                }
            }
        }
        
        System.out.println(volONega);
        
        ArrayList<UnidadSangre> orderedList = new ArrayList<UnidadSangre>();
        
        orderedList.add(new UnidadSangre(volAPlus,"A","+"));
        orderedList.add(new UnidadSangre(volANega,"A","-"));
        orderedList.add(new UnidadSangre(volBPlus,"B","+"));
        orderedList.add(new UnidadSangre(volBNega,"B","-"));
        orderedList.add(new UnidadSangre(volABPlus,"AB","+"));
        orderedList.add(new UnidadSangre(volABNega,"AB","-"));
        orderedList.add(new UnidadSangre(volOPlus,"O","+"));
        orderedList.add(new UnidadSangre(volONega,"O","-"));
        
        return orderedList;
    }
}
