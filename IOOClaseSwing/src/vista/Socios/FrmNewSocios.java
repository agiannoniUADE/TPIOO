package vista.Socios;

import Controllers.SocioController;
import DAO.GenericDAO;
import model.*;
import utils.MiListaModel;
import vista.State;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class FrmNewSocios extends JFrame {
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
    private JPanel AccionistasPane;
    private JPanel ContragarantiasPane;
    private JPanel PrincipalPanel;
    private JPanel AccionistasSecc;
    private JTextField AccPorctextField;
    private JComboBox AccTipocomboBox;
    private JTextField AccionCUITtextField;
    private JTextField DocumentosNombretextField;
    private JTextField DocumentosUsuariotextField;
    private JButton agregarButton1;
    private JButton DocumentosborrarButton;
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
    private JLabel SocioTipoDescrLabel;
    private JLabel LineaDeCreditoLabel;
    private JButton aportesButton;
    private JPanel AportesSecc;
    private JTextField AporteFechaDeIniciotextField;
    private JTextField AporteMontotextField;
    private JButton AporteRealizarButton;
    private JButton AporteRetirarButton;
    private JPanel AportesABM;
    private JPanel AportesPane;
    private JButton accionesButton1;
    private JTextField AccionistasIDtextField;
    private JTextField AccionistasCUITtextField;
    private JTextField AccionesRazonSocialtextField;
    private JTextField AccionistasPorcentajetextField;
    private JButton AccionistasagregarButton;
    private JButton AccionistasborrarButton;
    private JPanel AccionistasButtonABM;
    private JPanel AccionistasABMSecc;
    private JList Documentoslist;
    private JList Accionistaslist;
    private JList Contragarantiaslist;
    private JList Aporteslist;
    private JLabel AccionesTipoSocio;
    private JTextField AccionesCantidadtextField;
    private JLabel AccionesPorcentaje;
    private JRadioButton DocumentoObligatorioRadioButton;
    private JLabel DocumentosIDLabel;
    private JComboBox DocumentosTipocomboBox;
    private JLabel DocumentoEstadoActualLabel;
    private JTextField DocumentoEstadoDeseadotextField;
    private JTable Accionistastable;
    private JLabel accionesTextField;
    private JTextField cantidadTextField;
    private JTextField porcentajeTextField;
    private JTextPane textPane1;
    private SocioController socioController;
    private State State;
    private FrmNewSocios self;
    private MiListaModel AccionistasModelo = new MiListaModel();
    private MiListaModel DocumentosModelo = new MiListaModel();

    private static Socio getSocioFrmfunc(String TipoDeSocio, String CUIT, SocioController Controller) {

        Socio SocioConsulta = new Socio();
        if (TipoDeSocio == "PARTICIPE") {
            try {
                SocioConsulta = Controller.getSocioParticipe(CUIT);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (TipoDeSocio == "PROTECTOR") {
            try {
                SocioConsulta = Controller.getSocioProtector(CUIT);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        if (SocioConsulta == null) {
            return null;
        }

        return SocioConsulta;

    }

    ;

    public FrmNewSocios() throws Exception {

        State = new State();
        State.standby();
        State StateAccionista = new State();
        StateAccionista.setCurrent("Oculto");
        State StateDocumentos = new State();
        StateDocumentos.setCurrent("Oculto");
        State StateContragarantias = new State();
        StateContragarantias.setCurrent("Oculto");
        State StateAportes = new State();
        StateAportes.setCurrent("Oculto");

        socioController = SocioController.getInstance();
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
        this.setSize(1200, 1400);
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
                if (State.getCurrent() == "Standby" || State.getCurrent() == "NoExiste") {
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

                        JOptionPane.showMessageDialog(
                            borrarButton,
                            "Socio Agregado.");
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
                    Socio s = new Socio();

                    if (TipoDeSociocomboBox.getSelectedItem().toString() == "Participe") {
                        s = socioController.getSocioParticipe(Integer.parseInt(BuscartextField.getText()));
                    } else if (TipoDeSociocomboBox.getSelectedItem().toString() == "Protector") {
                        s = socioController.getSocioProtector(Integer.parseInt(BuscartextField.getText()));
                    }

                    IDDescrLabel.setText(BuscartextField.getText());
                    BuscartextField.setText("");
                    CUITtextField.setText(s.getCuit());
                    RazonSocialtextField.setText(s.getRazonSocial());
                    FechaDeInicioDeActividadtextField.setText(s.getFechaInicioActividad().toString());
                    ActividadPrincipaltextField.setText(s.getActividadPrincipal());
                    DirecciontextField.setText(s.getDireccion());
                    TelefonotextField.setText(s.getTelefono());
                    EmailtextField.setText(s.getEmail());
                    accionesTextField.setText(String.valueOf(s.getAccion()));
                    EstadoDescrLabel.setText(s.getEstado().toString());
                    SocioTipoDescrLabel.setText(s.getTipoSocio().toString());
                    State.standby();

                    Accionistaslist.setListData(s.getAccionistas().toArray());

                    if (TipoDeSociocomboBox.getSelectedItem().toString() == "Participe") {
                        LineaDeCreditotextField.setVisible(true);
                        LineaDeCreditotextField.setEnabled(true);
                        LineaDeCreditoLabel.setVisible(true);
                        LineaDeCreditoLabel.setEnabled(true);
                        contragarantiasButton.setVisible(true);
                        contragarantiasButton.setEnabled(true);
                        aportesButton.setEnabled(false);
                        aportesButton.setVisible(false);
                        tabbedPane1.setEnabledAt(2, true);
                        tabbedPane1.setEnabledAt(3, false);
                        try {
                            Socio socioActual = socioController.getSocioParticipe(CUITtextField.getText());

                            Accionistaslist.setModel(AccionistasModelo);
                            Documentoslist.setModel(DocumentosModelo);

                            for (Accionista item : socioActual.getAccionistas()) {
                                AccionistasModelo.add(item.getCuit());
                            }

                            for (DocumentoRegistro item : socioActual.getDocumentosRegistro()) {
                                DocumentosModelo.add(item.getNombre());
                            }

                        } catch (Exception j) {
                            j.printStackTrace();
                        }

                    } else if (TipoDeSociocomboBox.getSelectedItem().toString() == "Protector") {
                        LineaDeCreditotextField.setVisible(false);
                        LineaDeCreditotextField.setEnabled(false);
                        LineaDeCreditoLabel.setVisible(false);
                        LineaDeCreditoLabel.setEnabled(false);
                        contragarantiasButton.setVisible(false);
                        contragarantiasButton.setEnabled(false);
                        aportesButton.setEnabled(true);
                        aportesButton.setVisible(true);
                        tabbedPane1.setEnabledAt(3, true);
                        tabbedPane1.setEnabledAt(2, false);
                        try {
                            Socio SocioActual = socioController.getSocioProtector(CUITtextField.getText());
                            Accionistaslist.setModel(AccionistasModelo);

                            for (Accionista item : SocioActual.getAccionistas()) {
                                AccionistasModelo.add(item.getCuit());
                            }

                            for (DocumentoRegistro item : SocioActual.getDocumentosRegistro()) {
                                DocumentosModelo.add(item.getNombre());
                            }

                        } catch (Exception k) {
                            k.printStackTrace();
                        }
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                    if (State.getEnv() != "Buscar" && State.getCurrent() != "NoExiste") {
                        if (TipoDeSociocomboBox.getSelectedItem().toString() == "Participe") {
                            IDDescrLabel.setText(BuscartextField.getText() + " **No Existe el SocioParticipe**");
                        } else if (TipoDeSociocomboBox.getSelectedItem().toString() == "Protector") {
                            IDDescrLabel.setText(BuscartextField.getText() + " **No Existe el SocioProtector**");
                        }

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

                if (SocioTipoDescrLabel.getText() == "Participe") {
                    try {
                        SocioVendedor = socioController.getSocioParticipe(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else if (SocioTipoDescrLabel.getText() == "Protector") {
                    try {
                        SocioVendedor = socioController.getSocioProtector(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }

                if (SocioTipoDescrLabel.getText() == "Participe") {
                    try {
                        SocioComprador = socioController.getSocioParticipe(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else if (SocioTipoDescrLabel.getText() == "Protector") {
                    try {
                        SocioComprador = socioController.getSocioProtector(Integer.parseInt(IDDescrLabel.getText()));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }

                try {
                    socioController.suscribirAcciones(SocioComprador, SocioVendedor, Integer.parseInt(AccionesCantidadtextField.getText()));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

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
        aportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (StateAportes.getCurrent() == "Oculto") {
                    AportesSecc.setVisible(true);
                    AportesSecc.setEnabled(true);
                    StateAportes.setCurrent("Visible");
                } else if (StateAportes.getCurrent() == "Visible") {
                    AportesSecc.setVisible(false);
                    AportesSecc.setEnabled(false);
                    StateAportes.setCurrent("Oculto");
                }
            }
        });


        AccionistasagregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cuit = AccionistasCUITtextField.getText();
                String razonSocial = AccionesRazonSocialtextField.getText();
                int porcentaje = 0; //Integer.parseInt(AccionistasPorcentajetextField.getText());

                Accionista nuevoAccionista = new Accionista(
                    cuit,
                    razonSocial,
                    porcentaje
                );

                try {

                    Socio SocioActual = socioController.getSocioParticipe(Integer.parseInt(IDDescrLabel.getText()));
                    SocioActual.agregarAccionista(nuevoAccionista);
                    socioController.updateSocio(SocioActual);

                    JOptionPane.showMessageDialog(
                        borrarButton,
                        "Accionista Agregado.");
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            }
        });

        Accionistaslist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                SocioController controller;
                try {
                    controller = SocioController.getInstance();


                    Socio socio = controller.getSocioByCuit(CUITtextField.getText());

                    String cuitAccionista = (String) Accionistaslist.getSelectedValue();

                    Accionista accionista = socio.getAccionista(cuitAccionista);

                    //seteo los texfield de accionostas

                    AccionCUITtextField.setText(cuitAccionista);
                    AccionesRazonSocialtextField.setText(accionista.getRazonSocial());
                    porcentajeTextField.setText(String.valueOf(accionista.getPorcentaje()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Documentoslist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                SocioController controller;
                try {
                    controller = SocioController.getInstance();


                    Socio socio = controller.getSocioByCuit(CUITtextField.getText());

                    String nombreDocumento = (String) Documentoslist.getSelectedValue();

                    DocumentoRegistro docu = socio.getDocuementosRegistroPorNombre(nombreDocumento);
                    DocumentosNombretextField.setText(docu.getNombre());
                    DocumentosUsuariotextField.setText(docu.getUsuario());

                    int indice = 0;

                    if (docu.getTipoDocumento() == TipoDocumento.CONTRATO_SOCIAL)
                        indice = 0;
                    else if (docu.getTipoDocumento() == TipoDocumento.MANIFESTACION_BIENES)
                        indice = 1;
                    else if (docu.getTipoDocumento() == TipoDocumento.BALANCE_CERTIFICADO)
                        indice = 2;

                    DocumentosTipocomboBox.setSelectedIndex(indice);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        suscribirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio socioComprador;
                Socio socioVendedor;
                try {
                    socioComprador = socioController.getSocioParticipe(Integer.parseInt(IDDescrLabel.getText()));
                    if (socioComprador == null) {
                        socioComprador = socioController.getSocioProtector(Integer.parseInt(IDDescrLabel.getText()));
                    }

                    socioVendedor = socioController.getSocioParticipe(AccionistasCUITtextField.getText());
                    if (socioVendedor == null) {
                        socioVendedor = socioController.getSocioProtector(AccionistasCUITtextField.getText());
                    }

                    socioController.suscribirAcciones(socioComprador, socioVendedor, Integer.parseInt(cantidadTextField.getText()));

                    setUI(socioComprador.getCuit());

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                AccionistasCUITtextField.setText("");
                cantidadTextField.setText("");
            }
        });


        /*retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Socio SocioComprador = new Socio();
                if (AccionesTipoSocio.getText() == "PARTICIPE") {
                    try {
                        SocioComprador = socioController.getSocioParticipe(AccionCUITtextField.getText());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else if (AccionesTipoSocio.getText() == "PROTECTOR") {
                    try {
                        SocioComprador = socioController.getSocioProtector(AccionCUITtextField.getText());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

                Socio SocioVendedor = new Socio();
                if (SocioTipoDescrLabel.getText() == "PARTICIPE") {
                    try {
                        SocioVendedor = socioController.getSocioParticipe(AccionCUITtextField.getText());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else if (SocioTipoDescrLabel.getText() == "PROTECTOR") {
                    try {
                        SocioVendedor = socioController.getSocioProtector(AccionCUITtextField.getText());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

                try {
                    socioController.suscribirAcciones(SocioComprador, SocioVendedor, Integer.parseInt(AccionesCantidadtextField.getText()));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });*/
        agregarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = DocumentosNombretextField.getText();
                String usuario = DocumentosUsuariotextField.getText();
                boolean obligatorio = DocumentoObligatorioRadioButton.isSelected();

                DocumentoRegistro DocumentoNuevo = new DocumentoRegistro(
                    nombre,
                    usuario,
                    obligatorio,
                    TipoDocumento.lookUp(DocumentosTipocomboBox.getSelectedItem().toString())
                );

                Socio SocioDoc = new Socio();
                if (SocioTipoDescrLabel.getText() == "PARTICIPE") {
                    try {
                        SocioDoc = socioController.getSocioParticipe(CUITtextField.getText());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else if (SocioTipoDescrLabel.getText() == "PROTECTOR") {
                    try {
                        SocioDoc = socioController.getSocioProtector(CUITtextField.getText());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

                SocioDoc.agregarDocumento(DocumentoNuevo);
                try {
                    socioController.updateSocio(SocioDoc);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        AccionistasborrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio SocioActual = new Socio();
                if (TipoDeSociocomboBox.getSelectedItem().toString() == "Participe") {
                    try {
                        SocioActual = socioController.getSocioParticipe(CUITtextField.getText());
                    } catch (Exception fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else if (TipoDeSociocomboBox.getSelectedItem().toString() == "Protector") {
                    try {
                        SocioActual = socioController.getSocioProtector(CUITtextField.getText());
                    } catch (Exception fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }

                SocioActual.removeAccionista(SocioActual.getAccionista(AccionistasCUITtextField.getText()));

                try {
                    socioController.updateSocio(SocioActual);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        DocumentosborrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio SocioActual = new Socio();
                if (TipoDeSociocomboBox.getSelectedItem().toString() == "Participe") {
                    try {
                        SocioActual = socioController.getSocioParticipe(CUITtextField.getText());
                    } catch (Exception fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else if (TipoDeSociocomboBox.getSelectedItem().toString() == "Protector") {
                    try {
                        SocioActual = socioController.getSocioProtector(CUITtextField.getText());
                    } catch (Exception fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }

                SocioActual.quitarDocumentoRegistro(SocioActual.getDocumentoRegistro(Integer.parseInt(DocumentosIDLabel.getText())));

                try {
                    socioController.updateSocio(SocioActual);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
    }

    private void setUI(String cuit) throws Exception {
        try {
            SocioController sc = SocioController.getInstance();
            Socio socio = sc.getSocioByCuit(cuit);
            if (socio == null) {
                throw new Exception("El Socio no existe");
            }

            IDDescrLabel.setText(BuscartextField.getText());
            BuscartextField.setText("");
            CUITtextField.setText(socio.getCuit());
            RazonSocialtextField.setText(socio.getRazonSocial());
            FechaDeInicioDeActividadtextField.setText(socio.getFechaInicioActividad().toString());
            ActividadPrincipaltextField.setText(socio.getActividadPrincipal());
            DirecciontextField.setText(socio.getDireccion());
            TelefonotextField.setText(socio.getTelefono());
            EmailtextField.setText(socio.getEmail());
            EstadoDescrLabel.setText(socio.getEstado().toString());
            SocioTipoDescrLabel.setText(socio.getTipoSocio().toString());
            State.standby();
            Accionistaslist.setListData(socio.getAccionistas().toArray());
            accionesTextField.setText(String.valueOf(socio.getAccion()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void setIU(Socio socio) {
        // TODO: place custom component creation code here
    }
}
