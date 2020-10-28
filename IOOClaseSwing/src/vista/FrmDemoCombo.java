package vista;

import modelo.ColorItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class FrmDemoCombo extends JDialog{
    private JPanel pnlPrincipal;
    private JComboBox comboBox1;
    private JComboBox cbColores;
    private JLabel lblItemIndex;
    private JLabel lblCodigoInterno;
    private JLabel lblSelectedValue;

    private List<ColorItem> colores = new ArrayList<ColorItem>();

    public FrmDemoCombo(Window owner)
    {
        super(owner, "Demo de combos");

        this.setContentPane(pnlPrincipal);
        this.setSize(300, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);


        colores.add(new ColorItem(10, "Verde"));
        colores.add(new ColorItem(20, "Rojo"));
        colores.add(new ColorItem(30, "Azul"));
        colores.add(new ColorItem(40, "Violeta"));
        colores.add(new ColorItem(50, "Amarillo"));

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        cbColores.setModel(model);


        cbColores.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                lblItemIndex.setText(String.valueOf(cbColores.getSelectedIndex()));
                ColorItem aux = (ColorItem) cbColores.getSelectedItem();
                lblCodigoInterno.setText(String.valueOf(aux.getCodigo()));
                lblSelectedValue.setText(aux.getDescripcion());

            }
        });
    }
}
