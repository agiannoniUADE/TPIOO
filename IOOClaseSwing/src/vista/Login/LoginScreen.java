package vista.Login;

import Controllers.UsuarioController;
import model.Usuario;
import vista.FrmPrincipal;
import vista.Socios.FrmABM;
import vista.Socios.FrmSocios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField userTextField1;
    private JPasswordField passwordField2;
    private JButton aceptarButton;
    private JButton nuevoUsuarioButton;
    private JPanel Jpanel2;
    private LoginScreen self;
    private FrmPrincipal principalFrame;

    public LoginScreen() throws Exception {

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


        this.setSize(1200,400);

        this.self = this;
        this.setContentPane(panel1);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        this.setIconImage(frameIcon.getImage());
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UsuarioController usuarioController = UsuarioController.getInstance();

                    if (usuarioController.verificarIngreso(userTextField1.getText(), passwordField1.getText())) {
                        FrmPrincipal frame = null;

                        try {
                            frame = new FrmPrincipal("Sampo");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        Usuario.loggedUser = userTextField1.getText();

                        frame.setVisible(true);

                        setVisible(false);
                        dispose();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(null,
                        "El usuario o contraseña es incorrecto",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    passwordField1.setText("");
                    userTextField1.setText("");
                }
            }


        });
        nuevoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    UsuarioController usuarioController = UsuarioController.getInstance();

                    String nombre = userTextField1.getText();
                    String password = passwordField1.getText();


                    Usuario nuevoUsuario = new Usuario(
                        nombre,
                        password
                    );

                    if (usuarioController.AgregarNuevoUsuario(nuevoUsuario) > usuarioController.getLastInsertId()) {
                        FrmPrincipal frame = null;
                        try {
                            frame = new FrmPrincipal("Sampo");
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        frame.setVisible(true);


                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) throws Exception {
        LoginScreen frame = new LoginScreen();
        frame.setVisible(true);
    }
}
