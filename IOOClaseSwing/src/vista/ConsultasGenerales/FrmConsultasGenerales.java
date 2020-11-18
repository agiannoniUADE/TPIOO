package vista.ConsultasGenerales;

import Controllers.OperacionController;
import Controllers.SocioController;
import Controllers.TipoOperacionController;
import model.TipoOperacion;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrmConsultasGenerales extends JFrame {

    private JTextField Param1textField;
    private JButton Ejecutarbutton;
    private JButton Guardarbutton;
    private JComboBox ConsultaComboBox;
    private JTextField Param2textField;
    private JLabel Param1Label;
    private JPanel Param1Secc;
    private JPanel BotonesButton;
    private JPanel Param2Secc;
    private JLabel ConsultaFieldText;
    private JPanel ConsultaPanel;
    private JPanel Param3Secc;
    private JLabel Param2Label;
    private JLabel Param3Label;
    private JTextField Param3textField;
    private JTable ConsultaTable;
    private JPanel IzqPanel;
    private JPanel DerPanel;
    private JPanel panel1;
    private FrmConsultasGenerales self;
    private int Selected;
    private OperacionController operacionController;
    private SocioController sociocontroller;
    private TipoOperacionController tipocontroller;


    public FrmConsultasGenerales() throws Exception {
        //ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        //this.setIconImage(frameIcon.getImage());
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
        this.setContentPane(panel1);
        //TODO silver.
        this.setSize(1200, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


        ConsultaComboBox.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //doSomething();
                Selected = ConsultaComboBox.getSelectedIndex();


                if(Selected == 0) {
                    //Get Comision por dia de operaciones de cheque
                    Param1Secc.setVisible(true);
                    Param1textField.setText("");
                    Param1Label.setText("Fecha");

                    Param2Secc.setVisible(true);
                    Param2textField.setText("");
                    Param2Label.setText("Operacion ID");

                    Param3Secc.setVisible(false);
                    Param3textField.setText("");
                    Param3Label.setText("");


                    //GetOperacionesAvaladas
                } else if (Selected == 1) {
                        Param1Secc.setVisible(true);
                        Param1textField.setText("");
                        Param1Label.setText("Operacion ID");

                        Param2Secc.setVisible(true);
                        Param2textField.setText("Fecha Desde");
                        Param2Label.setText("");

                        Param3Secc.setVisible(true);
                        Param3textField.setText("Fecha Hasta");
                        Param3Label.setText("");

                        //Valor promedio de la tasa de descuento y total operado de cheques y pagare
                } else if (Selected == 2) {
                        Param1Secc.setVisible(true);
                        Param1textField.setText("");
                        Param1Label.setText("Operacion ID");

                        Param2Secc.setVisible(false);
                        Param2textField.setText("");
                        Param2Label.setText("");

                        Param3Secc.setVisible(false);
                        Param3textField.setText("");
                        Param3Label.setText("");
                        //XConsulta de porcentaje de comision por tipo -> Get Comision x Socio x Tipo de Operacion
                } else if (Selected == 3) {
                        Param1Secc.setVisible(true);
                        Param1textField.setText("");
                        Param1Label.setText("ID del Socio");

                        Param2Secc.setVisible(true);
                        Param2textField.setText("");
                        Param2Label.setText("Tipo Operacion ID");

                        Param3Secc.setVisible(false);
                        Param3textField.setText("");
                        Param3Label.setText("");
                        //XConsulta de Saldo por mora -> get mora x socio x fecha
                } else if (Selected == 4) {
                        Param1Secc.setVisible(true);
                        Param1textField.setText("");
                        Param1Label.setText("Socio ID");

                        Param2Secc.setVisible(true);
                        Param2textField.setText("");
                        Param2Label.setText("Fecha");

                        Param3Secc.setVisible(false);
                        Param3textField.setText("");
                        Param3Label.setText("");
                        //Consulta consolidada del Riesgo vivo contra garantias -> Consulta consolidad x Socio
                } else if (Selected == 4) {
                        Param1Secc.setVisible(true);
                        Param1textField.setText("");
                        Param1Label.setText("Socio ID");

                        Param2Secc.setVisible(false);
                        Param2textField.setText("");
                        Param2Label.setText("");

                        Param3Secc.setVisible(false);
                        Param3textField.setText("");
                        Param3Label.setText("");
                }

            }
        });


        Ejecutarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Selected == 0) {
                    //Get Comision por dia de operaciones de cheque

                    //GetOperacionesAvaladas
                } else if (Selected == 1) {
                    try {
                        TipoOperacionController controller = TipoOperacionController.getInstance();
                        OperacionController controller2 = OperacionController.getInstance();

                        LocalDate Desde = LocalDate.parse(Param2textField.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        LocalDate Hasta = LocalDate.parse(Param3textField.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                        controller2.getOperacionesMonetizadasPorSocio(Integer.parseInt(Param1textField.getText()),Desde,Hasta);

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    //Valor promedio de la tasa de descuento y total operado de cheques y pagare
                } else if (Selected == 2) {

                    //XConsulta de porcentaje de comision por tipo -> Get Comision x Socio x Tipo de Operacion
                } else if (Selected == 3) {

                    //XConsulta de Saldo por mora -> get mora x socio x fecha
                } else if (Selected == 4) {

                    //Consulta consolidada del Riesgo vivo contra garantias -> Consulta consolidad x Socio
                } else if (Selected == 4) {

                }



/*
                try {
                    TipoOperacionController controller = TipoOperacionController.getInstance();
                    OperacionController controller2 = OperacionController.getInstance();

                    LocalDate Desde = LocalDate.parse(Param2textField.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    LocalDate Hasta = LocalDate.parse(Param3textField.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    controller2.getOperacionesMonetizadasPorSocio(Integer.parseInt(Param1textField.getText()),Desde,Hasta);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
 */
            }
        });
    }


}
