package vista.Operaciones;

import Controllers.OperacionController;
import Controllers.SocioController;
import Controllers.TipoOperacionController;
import model.*;
import modelo.ColorItem;
import utils.MiListaModel;
import vista.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class FrmNewOperaciones extends JFrame {
    private JButton DerbuscarButton;
    private JTextField BuscarDertextField;
    private JTextField BuscarIzqtextField;
    private JButton IzqbuscarButton;
    private JTextField FechatextField;
    private JTextField EstadotextField;
    private JTextField FechaDeVencimientotextField;
    private JTextField MontotextField;
    private JTextField CUITFirmantetextField;
    private JTextField FechadeCobrotextField;
    private JTextField TasaDeDescuentotextField;
    private JTextField BancotextField;
    private JTextField EntidadtextField;
    private JTextField TasatextField;
    private JTextField FechaDeAcreditaciontextField;
    private JComboBox CantidadCuotascomboBox;
    private JTextField SistemadeAmortizaciontextField;
    private JList list1;
    private JButton agregarButton;
    private JButton borrarButton;
    private JComboBox TipoDeOperacioncomboBox;
    private JList OperacionesList;
    private JPanel DerPanel;
    private JPanel IzqPanel;
    private JPanel DerListaPanel;
    private JLabel IDLabel;
    private JLabel Tipo1Label;
    private JLabel Tipo2Label;
    private JLabel Tipo3Label;
    private JPanel Tipo1Secc;
    private JPanel Tipo2Secc;
    private JPanel Tipo3Secc;
    private JPanel PrincipalPanel;
    private JPanel CertificadoSecc;
    private JTextField CertificadotextField;
    private JButton CertificadosacarButton;
    private JButton CertificadoagregarButton;
    private JTextField CUITtextField;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private JLabel CertificadoLabel;
    private JLabel EstadoLabel;
    private JLabel FechaLabel;
    private OperacionController operacionController;
    private TipoOperacionController tipoController;
    private FrmNewOperaciones self;
    private State State;
    private MiListaModel operacionesDelSocioModelo = new MiListaModel();

    public FrmNewOperaciones() throws Exception {

        //ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        //this.setIconImage(frameIcon.getImage());

        State = new State();
        State AgregarState = new State();
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
        this.setContentPane(PrincipalPanel);
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        IzqbuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionController controller;
            try {
                controller = OperacionController.getInstance();
                    Operacion operacionBuscada = controller.getOperacionSafely(Integer.parseInt(BuscarIzqtextField.getText()));

                    int Tipo = 0;
                    int id = operacionBuscada.getSubtipoOperacion().getTipoOperacion().getId();

                if (id == 1) {
                        Tipo = 1;
                        //Tipo1 operacionBuscadaTipoAdecuado = controller.getOperacionSafely(Integer.parseInt(BuscarIzqtextField.getText()));
                        Tipo1 operacionBuscadaTipoAdecuado = (Tipo1)operacionBuscada;
                        CUITtextField.setText(operacionBuscada.getSocioParticipe().getCuit());
                        EstadotextField.setText(operacionBuscada.getEstado().toString());
                        MontotextField.setText(String.valueOf(operacionBuscada.getMonto()));
                        FechatextField.setText(operacionBuscada.getFecha().toString());
                        FechaDeVencimientotextField.setText(operacionBuscada.getFechaVencimiento().toString());
                        TipoDeOperacioncomboBox.setSelectedIndex(operacionBuscada.getSubtipoOperacion().getId() - 1);
                       // CUITFirmantetextField.setText(operacionController.get);
                       // FechadeCobrotextField.setText();
                       // TasaDeDescuentotextField.setText();
                        Tipo1Secc.setVisible(true);
                        Tipo1Label.setVisible(true);
                        Tipo2Secc.setVisible(false);
                        Tipo2Label.setVisible(false);
                        Tipo3Secc.setVisible(false);
                        Tipo3Label.setVisible(false);
                    } else if (id == 2 ) {
                        Tipo = 2;
                        //Tipo2 operacionBuscadaTipoAdecuado = controller.getOperacionSafely(Integer.parseInt(BuscarIzqtextField.getText()));
                        Tipo2 operacionBuscadaTipoAdecuado = (Tipo2)operacionBuscada;
                        CUITtextField.setText(operacionBuscada.getSocioParticipe().getCuit());
                        EstadotextField.setText(operacionBuscada.getEstado().toString());
                        MontotextField.setText(String.valueOf(operacionBuscada.getMonto()));
                        FechatextField.setText(operacionBuscada.getFecha().toString());
                        FechaDeVencimientotextField.setText(operacionBuscada.getFechaVencimiento().toString());
                        TipoDeOperacioncomboBox.setSelectedIndex(operacionBuscada.getSubtipoOperacion().getId() - 1);
                        Tipo1Secc.setVisible(false);
                        Tipo1Label.setVisible(false);
                        Tipo2Secc.setVisible(true);
                        Tipo2Label.setVisible(true);
                        Tipo3Secc.setVisible(false);
                        Tipo3Label.setVisible(false);
                    } else if (id == 3) {
                        Tipo = 3;
                        //Tipo3 operacionBuscadaTipoAdecuado = controller.getOperacionSafely(Integer.parseInt(BuscarIzqtextField.getText()));
                        Tipo3 operacionBuscadaTipoAdecuado = (Tipo3)operacionBuscada;
                        CUITtextField.setText(operacionBuscada.getSocioParticipe().getCuit());
                        EstadotextField.setText(operacionBuscada.getEstado().toString());
                        MontotextField.setText(String.valueOf(operacionBuscada.getMonto()));
                        FechatextField.setText(operacionBuscada.getFecha().toString());
                        FechaDeVencimientotextField.setText(operacionBuscada.getFechaVencimiento().toString());
                        TipoDeOperacioncomboBox.setSelectedIndex(operacionBuscada.getSubtipoOperacion().getId() - 1);
                        Tipo1Secc.setVisible(false);
                        Tipo1Label.setVisible(false);
                        Tipo2Secc.setVisible(false);
                        Tipo2Label.setVisible(false);
                        Tipo3Secc.setVisible(true);
                        Tipo3Label.setVisible(true);
                    }

                    /*
                    CUITtextField.setText(operacionBuscada.getSocioParticipe().getCuit());
                    EstadotextField.setText(operacionBuscada.getEstado().toString());
                    MontotextField.setText(String.valueOf(operacionBuscada.getMonto()));
                    FechatextField.setText(operacionBuscada.getFecha().toString());
                    FechaDeVencimientotextField.setText(operacionBuscada.getFechaVencimiento().toString());
                    TipoDeOperacioncomboBox.setSelectedIndex(operacionBuscada.getSubtipoOperacion().getId() + 1);
        */
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        DerbuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    OperacionController controller = OperacionController.getInstance();
                    OperacionesList.setModel(operacionesDelSocioModelo);

                    List<Operacion> operaciones = controller.getOperacionPorSocio(Integer.parseInt(BuscarDertextField.getText()));

                    for (Operacion item : operaciones) {
                        operacionesDelSocioModelo.add((String.valueOf(item.getId())));;
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });

        TipoDeOperacioncomboBox.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = TipoDeOperacioncomboBox.getSelectedIndex();
                if (index > 0 && index <= 2 ) {
                    Tipo1Secc.setVisible(true);
                    Tipo1Label.setVisible(true);
                    Tipo2Secc.setVisible(false);
                    Tipo2Label.setVisible(false);
                    Tipo3Secc.setVisible(false);
                    Tipo3Label.setVisible(false);
                } else if (index > 2 && index <= 4) {
                    Tipo1Secc.setVisible(false);
                    Tipo1Label.setVisible(false);
                    Tipo2Secc.setVisible(true);
                    Tipo2Label.setVisible(true);
                    Tipo3Secc.setVisible(false);
                    Tipo3Label.setVisible(false);
                } else if (index == 5) {
                    Tipo1Secc.setVisible(false);
                    Tipo1Label.setVisible(false);
                    Tipo2Secc.setVisible(false);
                    Tipo2Label.setVisible(false);
                    Tipo3Secc.setVisible(true);
                    Tipo3Label.setVisible(true);
                }
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (State.getCurrent() != "Agregando") {
                    AgregarState.setCurrent("Agregando");
                    BuscarIzqtextField.setText("** Nueva Operacion **");

                    CUITtextField.setText("");
                    EstadotextField.setText("");
                    CertificadotextField.setText("");
                    FechatextField.setText("");
                    FechaDeVencimientotextField.setText("");
                    MontotextField.setText("");
                    CUITFirmantetextField.setText("");
                    FechadeCobrotextField.setText("");
                    TasaDeDescuentotextField.setText("");
                    BancotextField.setText("");
                    EntidadtextField.setText("");
                    TasatextField.setText("");
                    FechaDeAcreditaciontextField.setText("");
                    SistemadeAmortizaciontextField.setText("");
                    confirmarButton.setVisible(true);
                    cancelarButton.setVisible(true);
                    agregarButton.setVisible(false);
                    borrarButton.setVisible(false);
                    BuscarDertextField.setEnabled(false);
                    DerbuscarButton.setEnabled(false);
                    BuscarIzqtextField.setEnabled(false);
                    IzqbuscarButton.setEnabled(false);
                    EstadotextField.setVisible(false);
                    CertificadoSecc.setVisible(false);
                    CertificadoLabel.setVisible(false);
                    EstadoLabel.setVisible(false);
                }
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  //  OperacionController controller = OperacionController.getInstance();
                    //controller.bo
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OperacionController opscontroller = OperacionController.getInstance();
                    TipoOperacionController tipocontroller = TipoOperacionController.getInstance();

                    SubtipoOperacion subtipoOperacion = tipocontroller.getSubtipoOperacion(TipoDeOperacioncomboBox.getSelectedIndex() + 1);

                    float monto = Float.valueOf(MontotextField.getText());
                    LocalDate fechaIngreso = LocalDate.parse(FechatextField.getText(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    LocalDate fechaVencimiento =  LocalDate.parse(FechaDeVencimientotextField.getText(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    Operacion OperacionNueva = new Operacion(
                        monto,
                        fechaIngreso,
                        fechaVencimiento,
                        subtipoOperacion
                    );

                    opscontroller.AgregarOperacion(OperacionNueva,CUITtextField.getText());

                    confirmarButton.setVisible(false);
                    cancelarButton.setVisible(false);
                    agregarButton.setVisible(true);
                    borrarButton.setVisible(true);
                    BuscarDertextField.setEnabled(true);
                    DerbuscarButton.setEnabled(true);
                    BuscarIzqtextField.setEnabled(true);
                    IzqbuscarButton.setEnabled(true);
                    EstadotextField.setVisible(true);
                    CertificadoSecc.setVisible(true);
                    CertificadoLabel.setVisible(true);
                    EstadoLabel.setVisible(true);
                    AgregarState.setCurrent("Nada");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarButton.setVisible(false);
                cancelarButton.setVisible(false);
                agregarButton.setVisible(true);
                borrarButton.setVisible(true);
                BuscarDertextField.setEnabled(true);
                DerbuscarButton.setEnabled(true);
                BuscarIzqtextField.setEnabled(true);
                IzqbuscarButton.setEnabled(true);
                AgregarState.setCurrent("Nada");
                EstadotextField.setVisible(true);
                CertificadoSecc.setVisible(true);
                CertificadoLabel.setVisible(true);
                EstadoLabel.setVisible(true);
                BuscarIzqtextField.setText("");
            }
        });
    }

}

