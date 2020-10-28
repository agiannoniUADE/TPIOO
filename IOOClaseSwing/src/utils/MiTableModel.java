package utils;

import modelo.Usuario;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class MiTableModel extends AbstractTableModel {
    private List<Usuario> lista= new ArrayList<Usuario>();

    protected String[] columnNames = new String[] { "DNI", "Nombre", "Rol"};
    protected Class[] columnClasses = new Class[] { String.class, String.class, String.class};

    public String getColumnName(int col) { return columnNames[col]; }
    public Class getColumnClass(int col) { return columnClasses[col]; }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columnNames.length;
    }

    //	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stubç
        switch(columnIndex)
        {
            case 0: return lista.get(rowIndex).getDni();
            case 1: return lista.get(rowIndex).getNombre();
            case 2: return lista.get(rowIndex).getRol();
            default: return null;
        }
    }

    public int add(String dni, String nombre, String rol)
    {
        lista.add(new Usuario(dni, nombre, rol));
        fireTableDataChanged();
        return lista.size() -1;
    }

    public List<Usuario> getLista()
    {
        return this.lista;
    }

}
