package vista.Socios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmSocios extends JDialog{
  private FrmSocios self;
  private JPanel panel1;
  private JButton agregarButton;
  private JButton buscarButton;

  public FrmSocios(Window owner) {
    super(owner, "");

    this.setContentPane(panel1);
    this.setSize(300, 300);
    self = this;
    //No permite volver a la pantalla anterior HASTA cerrar esta
    this.setModal(true);
    //Establezco el comportamiento a la hora de cerrarse
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //Que la pantalla inicie CENTRADA
    this.setLocationRelativeTo(null);
    buscarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {

      }
    });
    agregarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        FrmAgregarSocio frame = null;
        try {
          frame = new FrmAgregarSocio(self);
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        frame.setVisible(true);
      }
    });
  }


}
