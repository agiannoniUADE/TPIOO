package vista.Socios;

import Controllers.SocioController;
import model.Socio;
import model.TipoSocio;
import vista.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    private JButton ButtonBorrar;
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
    private JButton ButtonEditarConfirmar;
    private JButton ButtonAgregarCancelar;
    private JButton ButtonBuscar;
    private JTextField textBuscar;
  private JButton agregarButton;
  private JButton borrarButton;
  private JButton editarButton;
  private JLabel StateLabel;
  private SocioController socioController;
  private State State;

    private FrmSocios self;

    public FrmSocios() throws Exception {
        ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        this.setIconImage(frameIcon.getImage());

        State = new State();
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

      ButtonAgregarCancelar.addActionListener(new ActionListener() {
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
            if (State.getCurrent() == "Buscado") {
              ButtonBuscar.setText("Buscar");
              textBuscar.setEnabled(true);
              State.standby();
            } else {
              Socio s = socioController.getSocioParticipe(Integer.parseInt(textBuscar.getText()));

              TextFieldCUIT.setText(s.cuit);
              TextFieldRazonSocial.setText(s.razonSocial);
              TextFieldFechaInicioActividad.setText(s.fechaInicioActividad.toString());
              TextFieldActividadPrincipal.setText(s.actividadPrincipal);
              TextFieldDireccion.setText(s.direccion);
              TextFieldTelefono.setText(s.telefono);
              textFieldEmail.setText(s.email);

              textBuscar.setEnabled(false);
              State.setCurrent("Buscado");
              State.setEnv("Socios");
              ButtonBuscar.setText("Nueva busqueda");
            }
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      });
      ButtonBorrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
          if (State.getEnv() == "Socios") {
            if (State.getCurrent() == "Editando") {
              //
            } else if (State.getCurrent() == "Borrando") {
              //
            }
            ButtonEditarConfirmar.setText("Editar");
            ButtonAgregarCancelar.setText("Agregar");
            ButtonBorrar.setVisible(true);
            State.standby();
          }
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        }
        });
      ButtonEditarConfirmar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            State.setCurrent("Editando");
            State.setEnv("Socios");
            StateLabel.setText(State.getCurrent());
            ButtonEditarConfirmar.setText("Confirmar");
            ButtonAgregarCancelar.setText("Cancelar");
            ButtonBorrar.setVisible(false);

          } catch (Exception e1) {
            e1.printStackTrace();
          }

      }});
      ButtonAgregarCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
          if (State.getCurrent() == "Standby") {
            State.setCurrent("Agregando");
            State.setEnv("Socios");
            StateLabel.setText(State.getCurrent());
            ButtonEditarConfirmar.setText("Confirmar");
            ButtonAgregarCancelar.setText("Cancelar");
            ButtonBorrar.setVisible(false);
            TextFieldCUIT.setText("");
            TextFieldRazonSocial.setText("");
            TextFieldFechaInicioActividad.setText("");
            TextFieldActividadPrincipal.setText("");
            TextFieldDireccion.setText("");
            TextFieldTelefono.setText("");
            textFieldEmail.setText("");

          } else if (State.getEnv() == "Socios") {
              if (State.getCurrent() == "Editando") {
                //
              } else if (State.getCurrent() == "Borrando") {
                //
              }
              ButtonEditarConfirmar.setText("Editar");
              ButtonAgregarCancelar.setText("Agregar");
              ButtonBorrar.setVisible(true);
              State.standby();
            }

          } catch (Exception e1) {
            e1.printStackTrace();
          }
          }

      });


      StateLabel.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
          super.componentResized(e);
          if (State.getCurrent() == "Standby") {
            StateLabel.setVisible(false);
          } else {
            StateLabel.setText(State.getCurrent());
            StateLabel.setVisible(true);
          }
        }
      });
    }};

