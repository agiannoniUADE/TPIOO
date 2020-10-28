package vista;

import utils.MiListaModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmListaDemo extends JDialog{
    private JPanel pnlPrincipal;
    private JTextField txtPalabra;
    private JList listaPalabras;
    private JButton cargarItemButton;
    private JLabel lblListIndex;
    private JLabel lblValue;
    private MiListaModel unModelo = new MiListaModel();

    public FrmListaDemo(Window owner) {
        super(owner, "Demo de listas");

        this.setContentPane(pnlPrincipal);
        this.setSize(300, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);

        listaPalabras.setModel(unModelo);
        cargarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                unModelo.add(txtPalabra.getText());
            }
        });
        listaPalabras.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                lblListIndex.setText(String.valueOf(listaPalabras.getSelectedIndex()));
                lblValue.setText((String)listaPalabras.getSelectedValue());
            }
        });
    }
}
