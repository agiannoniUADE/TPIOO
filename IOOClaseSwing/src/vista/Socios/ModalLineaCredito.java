package vista.Socios;

import Controllers.SocioController;
import Controllers.TipoOperacionController;
import model.LineaDeCredito;
import model.SocioParticipe;
import model.TipoOperacion;
import vista.Login.LoginScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModalLineaCredito extends JFrame {
    private JTextField fechaTfield;
    private JTextField montoTextField;
    private JComboBox OperacionComboBox;
    private JButton guardarButton;
    private JPanel jPanel1;
    private ModalLineaCredito self;
    private String cuit;

    public ModalLineaCredito(String cuit) throws Exception {

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

        this.cuit = cuit;
        this.setSize(1200, 400);

        this.self = this;
        this.setContentPane(jPanel1);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                try {
                    float monto = Float.valueOf(montoTextField.getText());
                    LocalDate fecha = LocalDate.parse(fechaTfield.getText(), formato);
                    int idOperacion = OperacionComboBox.getSelectedIndex() + 1;

                    TipoOperacion tipo = TipoOperacionController.getInstance().getTipoOperacion(idOperacion);
                    LineaDeCredito linea = new LineaDeCredito();

                    linea.setFechaVigencia(fecha);
                    linea.setTipoOperacion(tipo);
                    linea.setMontoAsignado(monto);

                    SocioController socioController = SocioController.getInstance();
                    SocioParticipe socio = socioController.getSocioParticipe(cuit);
                    socio.setLineaDeCredito(linea);
                    socioController.updateSocio(socio);
                    JOptionPane.showMessageDialog(null, "La linea de credito se actualizo correctamente");

                    setVisible(false);
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }


            }
        });
    }

}
