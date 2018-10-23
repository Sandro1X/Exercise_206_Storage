package BL;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel implements Serializable {

    private String[] colNames = {"ID", "Description", "Amount", "Place"};
    private ArrayList<Article> articles = new ArrayList<>();

    public void add(Article a) {
        articles.add(a);
        fireTableRowsInserted(articles.size() - 1, articles.size() - 1);
    }

    public void change(int i, Article a) {
        articles.get(i).setId(a.getId());
        articles.get(i).setDesc(a.getDesc());
        articles.get(i).setPlace(a.getPlace());
        articles.get(i).setAmount(a.getAmount());
        fireTableDataChanged();
    }

    public void delete(int i) {
        articles.remove(i);
        fireTableDataChanged();
    }

    public void safe(File f) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        for (Article a : articles) {
            oos.writeObject(a);
        }
        oos.flush();
        oos.close();
    }

    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Article a;

            while ((a = (Article) ois.readObject()) != null) {
                articles.add(a);
            }
            ois.close();
        } catch (EOFException eof) {

        }
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
