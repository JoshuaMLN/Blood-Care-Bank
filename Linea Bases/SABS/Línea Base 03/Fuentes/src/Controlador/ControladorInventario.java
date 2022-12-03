
package Controlador;

import Datos.Repositorio;
import Modelo.ConsultasSangre;
import Modelo.Sangre;
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
    private ArrayList<Sangre> modelo;
    
    public ControladorInventario(frmInventario vista, ArrayList<Sangre> modelo){
        this.vista = vista;
        this.modelo = modelo;
        
                
        //addRowToTblInventario();
        
        this.vista.btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                ControladorPrincipal controlador = new ControladorPrincipal(Repositorio.usuario_validado, new frmPrincipal());
                controlador.iniciar();
                vista.dispose();
            }
        }
        );

    }
    public void actualizarTabla() {
          this.vista.tbl_Inventario.setModel(ConsultasSangre.listar());
          this.vista.tbl_Inventario.getTableHeader().setReorderingAllowed(false);//para que no se mueva
          //ConsultasMascotas.llenar();
    }
    /*
    public void addRowToTblInventario(){
        DefaultTableModel tblModel = (DefaultTableModel) vista.tbl_Inventario.getModel();
        ArrayList<Sangre> lista = modelo;
        ArrayList<Sangre> listaOrdenada = calcVolumenTotal(lista);
        Object rowData[] = new Object[3];
        
        for(int i = 0; i < listaOrdenada.size(); i++){
            rowData[0] = listaOrdenada.get(i).getGrupoSanguineo();
            rowData[1] = listaOrdenada.get(i).getRh();
            rowData[2] = listaOrdenada.get(i).getVolumen();
            tblModel.addRow(rowData);
        }
    }
    */
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        actualizarTabla();
    }
    
    /*
    public ArrayList<Sangre> calcVolumenTotal(ArrayList<Sangre> unorderedList){
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
        
        ArrayList<Sangre> orderedList = new ArrayList<Sangre>();
        
        orderedList.add(new Sangre(volAPlus,"A","+"));
        orderedList.add(new Sangre(volANega,"A","-"));
        orderedList.add(new Sangre(volBPlus,"B","+"));
        orderedList.add(new Sangre(volBNega,"B","-"));
        orderedList.add(new Sangre(volABPlus,"AB","+"));
        orderedList.add(new Sangre(volABNega,"AB","-"));
        orderedList.add(new Sangre(volOPlus,"O","+"));
        orderedList.add(new Sangre(volONega,"O","-"));
        
        return orderedList;
    }
*/
}
