package vista.Socios;

import Controllers.SocioController;
import model.Socio;
import model.TipoSocio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
  private SocioController socioController = new SocioController();

  public FrmAgregarSocio(Window owner) throws Exception {
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
        Date inicioActividad = new Date(inicioActividadTextField.getText());
        String actividadPrincipal =  actividadPrincipalTextField.getText();
        TipoSocio tipoSocio = TipoSocio.lookUp(TipoSocioCombo.getItemAt(TipoSocioCombo.getSelectedIndex()).toString());
        String direccion = direccionTextField.getText();
        String telefono = telefonoTextField.getText();
        String email = emailTextField.getText();
        String tamanioEmpresa = tamañoEmpresaTextField.getText();

        Socio nuevoSocio = new Socio(
          cuit,
          tipoSocio,
          razonSocial,
          inicioActividad,
          actividadPrincipal,
          direccion,
          telefono,
          email,
          tamanioEmpresa);

        socioController.AgregarNuevoSocio(nuevoSocio);
      }
    });
  }
}
