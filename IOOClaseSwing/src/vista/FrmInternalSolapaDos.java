package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmInternalSolapaDos extends JInternalFrame{
    private JTextField txtNombre;
    private JButton saludarButton;
    private JPanel pnlPrincipal;

    public FrmInternalSolapaDos(String titulo)
    {
        super(titulo);
        this.setContentPane(pnlPrincipal);

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        saludarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Hola. Ahora se que tu nombre es:" + txtNombre.getText());
            }
        });
    }
}
