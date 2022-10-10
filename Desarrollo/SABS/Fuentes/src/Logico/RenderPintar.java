package Logico;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderPintar extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel labelResultado = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(value instanceof String){
            String Dato = (String) value;
            if(Dato.equals("Pendiente")){
                labelResultado.setBackground(Color.red);
                labelResultado.setForeground(Color.black);
            }
            else if(Dato.equals("En Proceso")){
                labelResultado.setBackground(Color.yellow);
                labelResultado.setForeground(Color.black);
            }
            else if(Dato.equals("Terminado")){
                labelResultado.setBackground(Color.green);
                labelResultado.setForeground(Color.black);
            }
        }
        
        return labelResultado;
    }
    
}
