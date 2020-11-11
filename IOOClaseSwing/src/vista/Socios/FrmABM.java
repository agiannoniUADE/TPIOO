package vista.Socios;

import javax.swing.*;

public class FrmABM extends JFrame {
  private JTextField Param1textField;
  private JTextField Param2textField;
  private JTextField Param3textField;
  private JTextField Param4textField;
  private JButton buttonDer;
  private JButton buttonIzq;
  private JLabel TituloLabel;
  private JLabel Param2Label;
  private JLabel Param1Label;
  private JLabel Param3Label;
  private JLabel Param4Label;
  private JPanel PrincipalPanel;
  private String tipo;
  private String accion;
  private FrmABM self;


  public FrmABM(String tipo, String accion) throws Exception {

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

    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);

    ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
    this.setIconImage(frameIcon.getImage());

    if (tipo == "Lineas de Credito" && accion == "a") {
      this.setSize(600,150);
        TituloLabel.setText("Nueva Linea de Credito");
        Param1Label.setText("Fecha de Vigencia (dd/mm/aaaa)");
        Param2Label.setText("Monto Asignado");
        Param3Label.setVisible(false);
        Param3textField.setVisible(false);
        Param4Label.setVisible(false);
        Param4textField.setVisible(false);
        buttonIzq.setText("Confirmar");
        buttonDer.setText("Cancelar");
    }

    if (tipo == "Lineas de Credito" && accion == "m") {
      this.setSize(600,150);
      TituloLabel.setText("Linea de Credito ID XX");
      Param1Label.setText("Fecha de Vigencia (dd/mm/aaaa)");
      Param2Label.setText("Monto Asignado");
      Param3Label.setVisible(false);
      Param3textField.setVisible(false);
      Param4Label.setVisible(false);
      Param4textField.setVisible(false);
      buttonIzq.setText("Confirmar");
      buttonDer.setText("Cancelar");
    }

    if (tipo == "Contra Garantias" && accion == "a") {
        this.setSize(300,150);
        TituloLabel.setText("Nueva Contra Garantia");
        Param1Label.setText("Tipo");
        Param2Label.setText("Monto");
        Param3Label.setVisible(false);
        Param3textField.setVisible(false);
        Param4Label.setVisible(false);
        Param4textField.setVisible(false);
        buttonIzq.setText("Confirmar");
        buttonDer.setText("Cancelar");
    }

    if (tipo == "Contra Garantias" && accion == "m") {
      this.setSize(300,150);
      TituloLabel.setText("Contra Garantia ID XX");
      Param1Label.setText("Tipo");
      Param2Label.setText("Monto");
      Param3Label.setVisible(false);
      Param3textField.setVisible(false);
      Param4Label.setVisible(false);
      Param4textField.setVisible(false);
      buttonIzq.setText("Confirmar");
      buttonDer.setText("Cancelar");
    }
  }
}
