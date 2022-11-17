
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
        System.out.println("Hola bb");
        Object rowData[] = new Object[3];
        for(int i = 0; i < lista.size(); i++){
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
    
    
}
