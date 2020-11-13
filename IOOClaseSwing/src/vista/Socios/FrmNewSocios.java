package vista.Socios;

import Controllers.SocioController;
import model.Socio;
import model.TipoSocio;
import vista.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class FrmNewSocios extends JFrame{
    private JTextField BuscartextField;
    private JButton buscarButton;
    private JTextField RazonSocialtextField;
    private JTextField CUITtextField;
    private JComboBox TipoDeSociocomboBox;
    private JComboBox TamanocomboBox;
    private JTextField TelefonotextField;
    private JTextField ActividadPrincipaltextField;
    private JTextField FechaDeInicioDeActividadtextField;
    private JTextField DirecciontextField;
    private JTextField EmailtextField;
    private JTextField LineaDeCreditotextField;
    private JButton editarButton;
    private JButton agregarButton;
    private JButton borrarButton;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private JLabel IDDescrLabel;
    private JLabel IDLabel;
    private JLabel EstadoDescrLabel;
    private JButton suscribirButton;
    private JButton retirarButton;
    private JButton postularseButton;
    private JTabbedPane tabbedPane1;
    private JButton borrarDerButton;
    private JButton editarDerButton1;
    private JButton agregarDerButton1;
    private JPanel DocumentosPane;
    private JPanel AccionistaPane;
    private JPanel ContragarantiasPane;
    private JPanel PrincipalPanel;
    private JPanel AccionistasSecc;
    private JTextField AccPorctextField;
    private JComboBox AccTipocomboBox;
    private JTextField AccIDtextField;
    private JTextField DocumentosIDtextField;
    private JTextField DocumentosEstadotextField;
    private JTextField DocumentosNombretextField;
    private JTextField DocumentosUsuariotextField;
    private JButton agregarButton1;
    private JButton borrarButton1;
    private JButton cambioDeEstadoButton;
    private JButton accionesButton;
    private JButton documentosButton;
    private JPanel DocumentosSecc;
    private JButton contragarantiasButton;
    private JPanel SocioABM;
    private JPanel ContragarantiasSecc;
    private JTextField ContragarantiasIDtextField;
    private JTextField ContragarantiasTipotextField;
    private JTextField ContragarantiasMontotextField;
    private JPanel IzqPanel;
    private JPanel seccABM;
    private JPanel AccionistasABM;
    private JPanel AccionistasPorcentaje;
    private JButton ContragarantiasagregarButton;
    private JButton ContragarantiasborrarButton;
    private JPanel ContragarantiasABM;
    private JPanel DerPanel;
    private SocioController socioController;
    private State State;
    private FrmNewSocios self;

    public FrmNewSocios() throws Exception {

        State = new State();
        State.standby();
        State StateAccionista = new State();
        StateAccionista.setCurrent("Oculto");
        State StateDocumentos = new State();
        StateDocumentos.setCurrent("Oculto");
        State StateContragarantias = new State();
        StateContragarantias.setCurrent("Oculto");

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
        this.setContentPane(PrincipalPanel);
        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (State.getCurrent() == "NoExiste") {
                    JOptionPane.showMessageDialog(
                        editarButton,
                        "El Socio No existe");
                } else if (State.getCurrent() == "Standby") {
                    State.setCurrent("Editando");
                    State.setEnv("Socios");
                    buscarButton.setEnabled(false);
                    BuscartextField.setEnabled(false);
                    confirmarButton.setEnabled(true);
                    confirmarButton.setVisible(true);
                    cancelarButton.setEnabled(true);
                    cancelarButton.setVisible(true);
                    editarButton.setVisible(false);
                    editarButton.setEnabled(false);
                    borrarButton.setVisible(false);
                    borrarButton.setEnabled(false);
                    agregarButton.setVisible(false);
                    agregarButton.setEnabled(false);
                }
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (State.getCurrent() == "Standby"|| State.getCurrent() == "NoExiste"){
                    State.setCurrent("Agregando");
                    State.setEnv("Socios");
                    buscarButton.setEnabled(false);
                    BuscartextField.setEnabled(false);
                    confirmarButton.setEnabled(true);
                    confirmarButton.setVisible(true);
                    cancelarButton.setEnabled(true);
                    cancelarButton.setVisible(true);
                    editarButton.setVisible(false);
                    editarButton.setEnabled(false);
                    borrarButton.setVisible(false);
                    borrarButton.setEnabled(false);
                    agregarButton.setVisible(false);
                    agregarButton.setEnabled(false);

                    IDDescrLabel.setText("");
                    BuscartextField.setText("** Nuevo Usuario **");
                    CUITtextField.setText("");
                    RazonSocialtextField.setText("");
                    FechaDeInicioDeActividadtextField.setText("");
                    ActividadPrincipaltextField.setText("");
                    DirecciontextField.setText("");
                    TelefonotextField.setText("");
                    EmailtextField.setText("");

                }
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (IDDescrLabel.getText() == "" || IDDescrLabel.getText() == null || State.getCurrent() == "NoExiste") {
                        JOptionPane.showMessageDialog(
                            borrarButton,
                            "No hay nada seleccionado para borrar");
                    } else {
                        int confirmado = JOptionPane.showConfirmDialog(
                            borrarButton,
                            "¿Esta seguro de que quiere borrar el Socio " + IDDescrLabel.getText() + "?");

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
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (State.getEnv() == "Socios" && State.getCurrent() == "Agregando") {
                    try {
                        String cuit = CUITtextField.getText();
                        String razonSocial = RazonSocialtextField.getText();
                        LocalDate inicioActividad = LocalDate.now();
                        String actividadPrincipal = ActividadPrincipaltextField.getText();
                        TipoSocio tipoSocio = TipoSocio.lookUp(TipoDeSociocomboBox.getItemAt(TipoDeSociocomboBox.getSelectedIndex()).toString());
                        String direccion = DirecciontextField.getText();
                        String telefono = TelefonotextField.getText();
                        String email = EmailtextField.getText();
                        String tamanioEmpresa = TamanocomboBox.getItemAt(TamanocomboBox.getSelectedIndex()).toString();

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
                        BuscartextField.setText("oki doki");
                        BuscartextField.setEnabled(false);
                        BuscartextField.setEnabled(true);
                        State.setCurrent("Agregado");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(
                            editarButton,
                            "Llene todos los campos o revise que esten correctamente completados");
                    }
                }

                if (State.getEnv() == "Socios" && State.getCurrent() == "Agregado" || State.getCurrent() == "Editando") {
                    buscarButton.setEnabled(true);
                    buscarButton.setEnabled(true);
                    BuscartextField.setText("");
                } else if (State.getCurrent() == "Agregando") {
                    //
                } else {
                    State.standby();
                    buscarButton.setEnabled(true);
                    confirmarButton.setEnabled(false);
                    confirmarButton.setVisible(false);
                    cancelarButton.setEnabled(false);
                    cancelarButton.setVisible(false);
                    editarButton.setVisible(true);
                    editarButton.setEnabled(true);
                    borrarButton.setVisible(true);
                    borrarButton.setEnabled(true);
                    agregarButton.setVisible(true);
                    agregarButton.setEnabled(true);
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (State.getEnv() == "Socios" && State.getCurrent() == "Agregando" || State.getCurrent() == "Editando") {
                    BuscartextField.setEnabled(true);
                    buscarButton.setEnabled(true);
                    BuscartextField.setText("");
                }
                State.standby();
                buscarButton.setEnabled(true);
                confirmarButton.setEnabled(false);
                confirmarButton.setVisible(false);
                cancelarButton.setEnabled(false);
                cancelarButton.setVisible(false);
                editarButton.setVisible(true);
                editarButton.setEnabled(true);
                borrarButton.setVisible(true);
                borrarButton.setEnabled(true);
                agregarButton.setVisible(true);
                agregarButton.setEnabled(true);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socio s = socioController.getSocioParticipe(Integer.parseInt(BuscartextField.getText()));

                    IDDescrLabel.setText(BuscartextField.getText());
                    BuscartextField.setText("");
                    CUITtextField.setText(s.getCuit());
                    RazonSocialtextField.setText(s.getRazonSocial());
                    FechaDeInicioDeActividadtextField.setText(s.getFechaInicioActividad().toString());
                    ActividadPrincipaltextField.setText(s.getActividadPrincipal());
                    DirecciontextField.setText(s.getDireccion());
                    TelefonotextField.setText(s.getTelefono());
                    EmailtextField.setText(s.getEmail());
                    // StatusLabelDesc.setText(s.getEstado().);
                    State.standby();

                } catch (Exception e1) {
                    e1.printStackTrace();
                    if (State.getEnv() != "Buscar" && State.getCurrent() != "NoExiste") {
                        IDDescrLabel.setText(BuscartextField.getText() + " **No Existe**");
                        State.setEnv("Buscar");
                        State.setCurrent("NoExiste");
                    } else {
                        State.standby();
                    }
                }
            }
        });



        suscribirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cuit = CUITtextField.getText();
                String razonSocial = RazonSocialtextField.getText();
                String id = IDDescrLabel.getText();

                // Socio s = socioController.getSocioParticipe(Integer.parseInt(BuscartextField.getText()));

                Socio SocioVendedor = new Socio();
                Socio SocioComprador = new Socio();

                if (AccTipocomboBox.getSelectedItem().toString() == "Participe") {
                    try {
                        SocioVendedor = socioController.getSocioParticipe(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else if (AccTipocomboBox.getSelectedItem().toString() == "Protector") {
                    try {
                        SocioVendedor = socioController.getSocioProtector(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }

                if (TipoDeSociocomboBox.getSelectedItem().toString() == "Participe") {
                    try {
                        SocioComprador = socioController.getSocioParticipe(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else if (TipoDeSociocomboBox.getSelectedItem().toString() == "Protector") {
                    try {
                        SocioComprador = socioController.getSocioProtector(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }

                try {
                    socioController.suscribirAcciones(SocioComprador,SocioVendedor, AccPorctextField.getSelectionEnd());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
        accionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (StateAccionista.getCurrent() == "Oculto") {
                    AccionistasSecc.setVisible(true);
                    AccionistasSecc.setEnabled(true);
                    StateAccionista.setCurrent("Visible");
                } else if (StateAccionista.getCurrent() == "Visible") {
                    AccionistasSecc.setVisible(false);
                    AccionistasSecc.setEnabled(false);
                    StateAccionista.setCurrent("Oculto");
                }

            }
        });
        documentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateDocumentos.getCurrent() == "Oculto") {
                    DocumentosSecc.setVisible(true);
                    DocumentosSecc.setEnabled(true);
                    StateDocumentos.setCurrent("Visible");
                } else if (StateDocumentos.getCurrent() == "Visible") {
                    DocumentosSecc.setVisible(false);
                    DocumentosSecc.setEnabled(false);
                    StateDocumentos.setCurrent("Oculto");
                }
            }
        });
        contragarantiasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateContragarantias.getCurrent() == "Oculto") {
                    ContragarantiasSecc.setVisible(true);
                    ContragarantiasSecc.setEnabled(true);
                    StateContragarantias.setCurrent("Visible");
                } else if (StateContragarantias.getCurrent() == "Visible") {
                    ContragarantiasSecc.setVisible(false);
                    ContragarantiasSecc.setEnabled(false);
                    StateContragarantias.setCurrent("Oculto");
                }
            }
        });
    }
}
