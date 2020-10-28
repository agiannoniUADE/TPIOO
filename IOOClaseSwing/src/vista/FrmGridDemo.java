package vista;

import modelo.UsuarioDAO;
import utils.MiTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGridDemo extends JDialog{
    private JPanel pnlPrincipal;
    private JTable tableUsuario;
    private JButton guardarButton;
    private JScrollBar scrollBar1;

    private MiTableModel miModelo = new MiTableModel();

    public FrmGridDemo(Window owner) {
        super(owner, "");

        this.setContentPane(pnlPrincipal);
        this.setSize(300, 300);

        //No permite volver a la pantalla anterior HASTA cerrar esta
        this.setModal(true);
        //Establezco el comportamiento a la hora de cerrarse
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Que la pantalla inicie CENTRADA
        this.setLocationRelativeTo(null);
        tableUsuario.setModel(miModelo);

        miModelo.add("1", "Usuario1", "rol1");
        miModelo.add("2", "Usuario2", "rol2");
        miModelo.add("3", "Usuario3", "rol3");
        miModelo.add("4", "Usuario4", "rol4");
        miModelo.add("5", "Usuario5", "rol5");
        miModelo.add("6", "Usuario6", "rol6");

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                try {
                    UsuarioDAO dao = new UsuarioDAO();
                    dao.saveAll(miModelo.getLista());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
