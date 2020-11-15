package vista.Operaciones;

import Controllers.OperacionController;
import model.Accionista;
import model.Operacion;
import model.Tipo1;
import model.Tipo2;
import utils.MiListaModel;
import vista.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class FrmNewOperaciones extends JFrame {
    private JButton DerbuscarButton;
    private JTextField BuscarDertextField;
    private JTextField BuscarIzqtextField;
    private JButton IzqbuscarButton;
    private JTextField FechatextField;
    private JTextField EstadotextField;
    private JTextField FechaDeVencimientotextField;
    private JTextField MontotextField;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JComboBox comboBox1;
    private JTextField textField14;
    private JList list1;
    private JButton agregarButton;
    private JButton borrarButton;
    private JComboBox TipoDeOperacioncomboBox;
    private JList OperacionesList;
    private JPanel DerPanel;
    private JPanel IzqPanel;
    private JPanel DerListaPanel;
    private JLabel IDLabel;
    private JLabel Tipo1Label;
    private JLabel Tipo2Label;
    private JLabel Tipo3Label;
    private JPanel Tipo1Secc;
    private JPanel Tipo2Secc;
    private JPanel Tipo3Secc;
    private JPanel PrincipalPanel;
    private JPanel CertificadoSecc;
    private JTextField CertificadotextField;
    private JButton CertificadosacarButton;
    private JButton CertificadoagregarButton;
    private OperacionController operacionController;
    private FrmNewOperaciones self;
    private State State;
    private MiListaModel OperacionesDelSocioModelo = new MiListaModel();

    public FrmNewOperaciones() throws Exception {

        //ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        //this.setIconImage(frameIcon.getImage());

        State = new State();
        operacionController = new OperacionController();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        this.self = this;
        this.setContentPane(PrincipalPanel);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        IzqbuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BuscarIzqtextField.getText()
                //operacionController.
                // 0 -> Tipo1
                // 1 -> Tipo2
                // 2 -> Tipo3
                /*
                Operacion OpBuscada = new Operacion();
                if (TipoDeOperacioncomboBox.getSelectedIndex() == 0) {
                    try {
                        Tipo1 OperacionTipo1 = operacionController.buscarOperacion(Integer.parseInt(BuscarIzqtextField.getText()));
                        OpBuscada = operacionController.buscarOperacion(OperacionTipo1.getId());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else if (TipoDeOperacioncomboBox.getSelectedIndex() == 1) {
                    try {
                        Tipo2 OperacionTipo2 = operacionController.buscarOperacion(Integer.parseInt(BuscarIzqtextField.getText()));
                        operacionController.buscarOperacion(OperacionTipo2.getId());
                        OpBuscada = operacionController.buscarOperacion(OperacionTipo2.getId());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                } else if (TipoDeOperacioncomboBox.getSelectedIndex() == 2) {
                    try {
                        Tipo3 OperacionTipo3 = operacionController.buscarOperacion(Integer.parseInt(BuscarIzqtextField.getText()));
                        operacionController.buscarOperacion(OperacionTipo3.getId());
                        OpBuscada = operacionController.buscarOperacion(OperacionTipo3.getId());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                    */

            }
        });
        DerbuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                OperacionesList.setModel(OperacionesDelSocioModelo);

                Operaciones = operacionController.getOperacionPorSocio(Integer.parseInt(BuscarDertextField.getText()));

                for (Accionista item: SocioActual.getAccionistas()) {
                    AccionistasModelo.add(item.getCuit());
                }
*/
            }
        });
    }

}

