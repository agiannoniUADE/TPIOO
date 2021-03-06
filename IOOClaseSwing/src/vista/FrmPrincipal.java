package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Operaciones.FrmNewOperaciones;
import vista.Operaciones.FrmOperaciones;
import vista.Socios.FrmNewSocios;

public class FrmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton combosButton;
    private JButton listasButton;
    private JButton tabsButton;
    private JButton gridsButton;
    private JPanel pnlTitulo;
    private JButton sociosButton;
   private JButton operacionesButton;

    private FrmPrincipal self;

    public FrmPrincipal(String titulo)
    {
        super(titulo);

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

        this.setContentPane(pnlPrincipal);
        this.setSize(400, 400);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        this.asociarEventos();

        this.self = this;

        gridsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmGridDemo frame = new FrmGridDemo(self);
                frame.setVisible(true);
            }
        });

    }

    private void asociarEventos()
    {
        listasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmListaDemo frame = new FrmListaDemo(self);
                frame.setVisible(true);
            }
        });

        tabsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmTabsDemo frame = new FrmTabsDemo(self, "Demo con TABS");
                frame.setVisible(true);
            }
        });
        combosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrmDemoCombo frame = new FrmDemoCombo(self);
                frame.setVisible(true);
            }
        });
        sociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                FrmNewSocios frame = null;
              try {
                frame = new FrmNewSocios();
              } catch (Exception e1) {
                e1.printStackTrace();
              }
              frame.setVisible(true);
            }
        });
      operacionesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
          FrmNewOperaciones frame = null;
          try {
            frame = new FrmNewOperaciones();
          } catch (Exception e1) {
            e1.printStackTrace();
          }
          frame.setVisible(true);
        }
      });
    }

}
