
package Controlador;

import Modelo.UnidadSangre;
import Vista.frmInventario;
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
        
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public void addRowToTblInventario(){
        DefaultTableModel tblModel = (DefaultTableModel) vista.tbl_Inventario.getModel();
        ArrayList<UnidadSangre> lista;
        lista = modelo.getUnidadesSangre();
        Object rowData[] = new Object[3];
        for(int i = 0; i < lista.size(); i++){
            rowData[0] = lista.get(i).getGrupoSanguineo();
            rowData[1] = lista.get(i).getRh();
            rowData[2] = lista.get(i).getVolumen();
            tblModel.addRow(rowData);
        }
    }
}
