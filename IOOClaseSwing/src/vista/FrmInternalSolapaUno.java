package vista;

import javax.swing.*;
import java.awt.*;

public class FrmInternalSolapaUno extends JInternalFrame{
    private JButton button1;
    private JButton button2;
    private JPanel pnlPrincipal;

    public FrmInternalSolapaUno(String titulo)
    {
        super(titulo);
        this.setContentPane(pnlPrincipal);

        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }
}
