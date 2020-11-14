package vista.ConsultasGenerales;

import Controllers.OperacionController;
import Controllers.SocioController;
import model.Operacion;
import vista.Operaciones.FrmOperaciones;
import vista.Socios.FrmSocios;


import javax.swing.*;

public class ConsultasGenerales extends JFrame {

    private OperacionController operacionController;

    private JTextField Param1textField;
    private JButton Ejecutarbutton;
    private JButton Guardarbutton;
    private JComboBox ConsultaComboBox;
    private JTextField Param2textField;
    private JLabel Param1Label;
    private JPanel Param1Secc;
    private JPanel BotonesButton;
    private JPanel Param2Secc;
    private JLabel ConsultaFieldText;
    private JPanel ConsultaPanel;
    private JPanel Param3Secc;
    private JLabel Param2Label;
    private JLabel Param3Label;
    private JTextField Param3textField;
    private JTable ConsultaTable;
    private JPanel IzqPanel;
    private JPanel DerPanel;
    private JPanel panel1;
    private ConsultasGenerales self;


    public ConsultasGenerales() throws Exception {
        //ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        //this.setIconImage(frameIcon.getImage());
        operacionController = OperacionController.getInstance();
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
        this.setContentPane(panel1);
        //TODO silver.
        this.setSize(1200, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }


}
