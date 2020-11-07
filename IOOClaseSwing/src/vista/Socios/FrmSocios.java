package vista.Socios;

import Controllers.SocioController;
import model.Socio;
import model.TipoSocio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FrmSocios extends JFrame {

    private JPanel panel1;
    private JPanel PanelIzq;
    private JPanel SeccBuscador;
    private JPanel SeccABMIzq;
    private JPanel SeccTipoyTam;
    private JPanel SeccRSyCUIT;
    private JPanel SeccAPyFIA;
    private JPanel SeccDiryTel;
  private JPanel PanelDer;
    private JPanel TabLineasDeCredito;
    private JPanel TabContraGarantias;
    private JPanel TabAccionistas;
    private JTabbedPane tabbedPaneDer;
    private JButton ButtonEditar;
    private JTextArea textAreaMessage;
    private JTextField textFieldEmail;
    private JTextField TextFieldTelefono;
    private JTextField TextFieldDireccion;
    private JTextField TextFieldFechaInicioActividad;
    private JTextField TextFieldActividadPrincipal;
    private JTextField TextFieldCUIT;
    private JTextField TextFieldRazonSocial;
    private JComboBox comboBoxTamano;
    private JComboBox comboBoxTipo;
    private JButton ButtonBorrar;
    private JButton ButtonAgregar;
    private JButton ButtonBuscar;
    private JTextField textBuscar;
  private JButton agregarButton;
  private JButton borrarButton;
  private JButton editarButton;
  private SocioController socioController;


    private FrmSocios self;

    public FrmSocios() throws Exception {
        ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        this.setIconImage(frameIcon.getImage());

        socioController = new SocioController();
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
        this.setSize(1200,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

      ButtonAgregar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String cuit = TextFieldCUIT.getText();
          String razonSocial = TextFieldRazonSocial.getText();
          Date inicioActividad = new Date(TextFieldFechaInicioActividad.getText());
          String actividadPrincipal =  TextFieldActividadPrincipal.getText();
          TipoSocio tipoSocio = TipoSocio.lookUp(comboBoxTipo.getItemAt(comboBoxTipo.getSelectedIndex()).toString());
          String direccion = TextFieldDireccion.getText();
          String telefono = TextFieldTelefono.getText();
          String email = textFieldEmail.getText();
          String tamanioEmpresa = comboBoxTamano.getItemAt(comboBoxTamano.getSelectedIndex()).toString();

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
          try {
            socioController.AgregarNuevoSocio(nuevoSocio);
            textAreaMessage.append("oki doki");
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      });
      ButtonBuscar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            Socio s = socioController.getSocioParticipe(Integer.parseInt(textBuscar.getText()));

            TextFieldCUIT.setText(s.cuit);
            TextFieldRazonSocial.setText(s.razonSocial);
            TextFieldFechaInicioActividad.setText(s.fechaInicioActividad.toString());
            TextFieldActividadPrincipal.setText(s.actividadPrincipal);
            TextFieldDireccion.setText(s.direccion);
            TextFieldTelefono.setText(s.telefono);
            textFieldEmail.setText(s.email);

            textBuscar.setEnabled(false);
            ButtonBuscar.setText("Nueva busqueda");

          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      });
    }

}
