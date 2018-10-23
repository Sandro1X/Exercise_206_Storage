package BL;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
    private String[] colNames = {"ID", "Description", "Amount", "Place"};
    private ArrayList<Article> articles = new ArrayList<>();

    public void add(Article a){
        articles.add(a);
        fireTableRowsInserted(articles.size()-1, articles.size()-1);
    }
    
    public void change(int i, Article a){
        articles.get(i).setId(a.getId());
        articles.get(i).setDesc(a.getDesc());
        articles.get(i).setPlace(a.getPlace());
        articles.get(i).setAmount(a.getAmount());
        fireTableDataChanged();
    }
    
    public void delete(int i){
        articles.remove(i);
        fireTableDataChanged();
    }
    
    public ArrayList<Article> getArticles() {
        return articles;
    }
    
    @Override
    public int getRowCount() {
        return articles.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return articles.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
}
