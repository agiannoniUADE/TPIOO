package vista.Socios;

import Controllers.SocioController;
import model.Socio;
import model.TipoSocio;
import vista.State;

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
    private JButton BorrarIzqButton;
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
    private JButton EditarIzqButton;
    private JButton AgregarIzqButton;
    private JButton BuscarButton;
    private JTextField Buscartext;
  private JButton AgregarDerButton;
  private JButton EditarDerButton;
  private JButton BorrarDerButton;
  private JButton CancelarIzqButton;
  private JButton ConfirmarIzqButton;
  private JButton CancelarDerButton;
  private JButton ConfirmarDerButton;
  private JLabel SocioIDLabel;
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


      BuscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
              Socio s = socioController.getSocioParticipe(Integer.parseInt(Buscartext.getText()));

              SocioIDLabel.setText(Buscartext.getText());
              Buscartext.setText("");
              TextFieldCUIT.setText(s.cuit);
              TextFieldRazonSocial.setText(s.razonSocial);
              TextFieldFechaInicioActividad.setText(s.fechaInicioActividad.toString());
              TextFieldActividadPrincipal.setText(s.actividadPrincipal);
              TextFieldDireccion.setText(s.direccion);
              TextFieldTelefono.setText(s.telefono);
              textFieldEmail.setText(s.email);

          } catch (Exception e1) {
            e1.printStackTrace();
            SocioIDLabel.setText(SocioIDLabel.getText() + " **No Existe**");
          }
        }
      });

      AgregarIzqButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (State.getCurrent() == "Standby" || State.getCurrent() == "Buscado") {
            State.setCurrent("Agregando");
            State.setEnv("Socios");
            BuscarButton.setEnabled(false);
            Buscartext.setEnabled(false);
            ConfirmarIzqButton.setEnabled(true);
            ConfirmarIzqButton.setVisible(true);
            CancelarIzqButton.setEnabled(true);
            CancelarIzqButton.setVisible(true);
            EditarIzqButton.setVisible(false);
            EditarIzqButton.setEnabled(false);
            BorrarIzqButton.setVisible(false);
            BorrarIzqButton.setEnabled(false);
            AgregarIzqButton.setVisible(false);
            AgregarIzqButton.setEnabled(false);

            SocioIDLabel.setText("");
            Buscartext.setText("** Nuevo Usuario **");
            TextFieldCUIT.setText("");
            TextFieldRazonSocial.setText("");
            TextFieldFechaInicioActividad.setText("");
            TextFieldActividadPrincipal.setText("");
            TextFieldDireccion.setText("");
            TextFieldTelefono.setText("");
            textFieldEmail.setText("");

          }

          }
        }
      );

      BorrarIzqButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            if (SocioIDLabel.getText() == "" || SocioIDLabel.getText() == null ) {
              JOptionPane.showMessageDialog(
                BorrarIzqButton,
                "No hay nada seleccionado para borrar");
            } else {
              int confirmado = JOptionPane.showConfirmDialog(
                BorrarIzqButton,
                "¿Esta seguro de que quiere borrar el Socio " + SocioIDLabel.getText() + "?");

              if (JOptionPane.OK_OPTION == confirmado)
                System.out.println("confirmado");
              else
                System.out.println("vale... no borro nada...");
            }
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        }
        });
      EditarIzqButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (State.getCurrent() == "Standby" || State.getCurrent() == "Buscado") {
              State.setCurrent("Editando");
              State.setEnv("Socios");
              Buscartext.setEnabled(false);
              BuscarButton.setEnabled(false);
              ConfirmarIzqButton.setEnabled(true);
              ConfirmarIzqButton.setVisible(true);
              CancelarIzqButton.setEnabled(true);
              CancelarIzqButton.setVisible(true);
              EditarIzqButton.setVisible(false);
              EditarIzqButton.setEnabled(false);
              BorrarIzqButton.setVisible(false);
              BorrarIzqButton.setEnabled(false);
              AgregarIzqButton.setVisible(false);
              AgregarIzqButton.setEnabled(false);

            }

      }});

      ConfirmarIzqButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (State.getEnv() == "Socios" && State.getCurrent() == "Agregando") {
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
              Buscartext.setText("oki doki");
              Buscartext.setEnabled(false);
              BuscarButton.setEnabled(true);
            } catch (Exception e1) {
              e1.printStackTrace();
            }
          }

          if (State.getCurrent() == "Agregando" || State.getCurrent() == "Editando") {
            PanelDer.setEnabled(true);
            PanelDer.setVisible(true);
          }

          State.standby();
          BuscarButton.setEnabled(true);
          ConfirmarIzqButton.setEnabled(false);
          ConfirmarIzqButton.setVisible(false);
          CancelarIzqButton.setEnabled(false);
          CancelarIzqButton.setVisible(false);
          EditarIzqButton.setVisible(true);
          EditarIzqButton.setEnabled(true);
          BorrarIzqButton.setVisible(true);
          BorrarIzqButton.setEnabled(true);
          AgregarIzqButton.setVisible(true);
          AgregarIzqButton.setEnabled(true);
        }
      });

      CancelarIzqButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          if (State.getEnv() == "Socios" && State.getCurrent() == "Agregando") {
            Buscartext.setEnabled(true);
            BuscarButton.setEnabled(true);
          }
          State.standby();
          BuscarButton.setEnabled(true);
          ConfirmarIzqButton.setEnabled(false);
          ConfirmarIzqButton.setVisible(false);
          CancelarIzqButton.setEnabled(false);
          CancelarIzqButton.setVisible(false);
          EditarIzqButton.setVisible(true);
          EditarIzqButton.setEnabled(true);
          BorrarIzqButton.setVisible(true);
          BorrarIzqButton.setEnabled(true);
          AgregarIzqButton.setVisible(true);
          AgregarIzqButton.setEnabled(true);


        }
      });

      //// BOTONES DERECHA ////


      BorrarDerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          try {
            if (tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) == "Contra Garantias" || tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) == "Lineas de Credito") {
              int confirmado = JOptionPane.showConfirmDialog(
                BorrarIzqButton,
                "¿Esta seguro de que quiere borrar en las " + tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) + " el ID XX ?");

              if (JOptionPane.OK_OPTION == confirmado)
                System.out.println("confirmado");
              else
                System.out.println("vale... no borro nada...");
            } else {
              JOptionPane.showMessageDialog(
                BorrarIzqButton,
                "No puede BORRAR " + tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) + " en este modulo");

            }
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      });
      EditarDerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) == "Contra Garantias" || tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) == "Lineas de Credito") {
            FrmABM frame = null;
            try {
              frame = new FrmABM(tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()),"m");
            } catch (Exception e1) {
              e1.printStackTrace();
            }
            frame.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(
              BorrarIzqButton,
              "No puede MODIFICAR " + tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) + " en este modulo");
          }
        }
      });
      AgregarDerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          if (tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) == "Contra Garantias" || tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) == "Lineas de Credito") {
            FrmABM frame = null;
            try {
              frame = new FrmABM(tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()),"a");
            } catch (Exception e1) {
              e1.printStackTrace();
            }
            frame.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(
              BorrarIzqButton,
              "No puede AGREGAR " + tabbedPaneDer.getTitleAt(tabbedPaneDer.getSelectedIndex()) + " en este modulo");
          }

        }
      });
    }};

