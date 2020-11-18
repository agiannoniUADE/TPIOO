package utils;

import model.Accionista;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MiListaModel extends AbstractListModel {
    private List<String> items= new ArrayList<String>();

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public Object getElementAt(int i) {
        return items.get(i);
    }
    //Retorna el indice donde se encuentra el valor insertado
    public int add(String valor)
    {
        items.add(valor);
        fireContentsChanged(this, 0, items.size());

        return items.size()-1;
    }

    public void delAll() {
        items.clear();
    }
}
