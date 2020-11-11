package vista.Operaciones;

import Controllers.OperacionController;
import Controllers.SocioController;
import model.Operacion;
import model.Socio;
import vista.Socios.FrmSocios;
import vista.State;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FrmOperaciones extends JFrame {
  private JPanel panel1;
  private JPanel IzqPanel;
  private JPanel DerPanel;
  private JPanel BuscadorSecc;
  private JTextField textBuscar;
  private JButton ButtonBuscar;
  private JTabbedPane tabbedPaneDer;
  private JPanel TabGarantias;
  private JLabel TipoLabel;
  private JComboBox TipoComboBox;
  private JTextField FechatextField;
  private JTextField EstadotextField;
  private JTextField VencimientotextField;
  private JTextField MontotextField;
  private JTextField textField3;
  private JTextField textField5;
  private JPanel Tipo1Secc;
  private JTextField textField2;
  private JTextField textField4;
  private JPanel Tipo2Secc;
  private JPanel Tipo3Secc1;
  private JPanel Tipo3Secc2;
  private JTextField textField6;
  private JTextField textField7;
  private JTextField textField8;
  private JTextField textField9;
  private JTextField DesembolsotextField;
  private JPanel TiposPanel;
  private JPanel MontoDesembSecc;
  private JPanel FechaEstadoVencSecc;
  private JPanel ParamTipoSecc;
  private JComboBox comboBox1;
  private JPanel TabOps;
  private JPanel SeccABMIzq;
  private JButton ButtonAgregar;
  private JButton ButtonEditar;
  private JButton ButtonBorrar;
  private JList list1;
  private JTextField textField1;
  private JList list2;
  private JButton agregarButton;
  private JButton borrarButton;
  private JButton editarButton;
  private OperacionController operacionController;
  private FrmOperaciones self;
  private State State;

  public FrmOperaciones() throws Exception {

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
    this.setContentPane(panel1);
    this.setSize(1200, 400);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);
  }

}
