package vista.Socios;

import model.Socio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrmAgregarSocio extends JDialog{
  private JPanel panel1;
  private JTextField CuitTextField;
  private JTextField razonSocialTextField;
  private JTextField inicioActividadTextField;
  private JTextField actividadPrincipalTextField;
  private JComboBox TipoSocioCombo;
  private JTextField direccionTextField;
  private JTextField telefonoTextField;
  private JTextField emailTextField;
  private JTextField tamañoEmpresaTextField;
  private JButton guardarButton;

  public FrmAgregarSocio(Window owner) {
    super(owner, "");

    this.setContentPane(panel1);
    this.setSize(300, 300);
    //No permite volver a la pantalla anterior HASTA cerrar esta
    this.setModal(true);
    //Establezco el comportamiento a la hora de cerrarse
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //Que la pantalla inicie CENTRADA
    this.setLocationRelativeTo(null);

    guardarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String cuit = CuitTextField.getText();
        String razonSocial = razonSocialTextField.getText();
        String inicioActividad = inicioActividadTextField.getText();
        Socio nuevoSocio = new Socio();
      }
    });
  }

}
