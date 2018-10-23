package BL;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.white);
        Article art = (Article) value;
        
        switch(column){
            case 0: label.setText(art.getId()+"");break;
            case 1: label.setText(art.getDesc());break;
            case 2: label.setText(art.getAmount()+"");break;
            case 3: label.setText(art.getPlace()+"");break;
        }
        
        if(art.getAmount() < 1){
            label.setBackground(Color.red);
        }
        
        if(isSelected){
            label.setBackground(Color.GRAY);
        }
        return label;
    }
}
