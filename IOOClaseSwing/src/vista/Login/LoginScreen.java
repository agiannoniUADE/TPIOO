package vista.Login;

import vista.FrmPrincipal;
import vista.Socios.FrmABM;
import vista.Socios.FrmSocios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JPasswordField passwordField2;
    private JButton aceptarButton;
    private JTextField SRGLoginTextField;
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

        this.self = this;
        this.setContentPane(panel1);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon frameIcon = new ImageIcon("C:\\Users\\Albondigor\\Desktop\\Nullicon.png");
        this.setIconImage(frameIcon.getImage());
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //todo login
                if(1 == 1){
                    FrmPrincipal frame = null;
                    try {
                        frame = new FrmPrincipal("fafafa");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    frame.setVisible(true);
                }
            }
        });
    }


    public static void main(String[] args) throws Exception {
        LoginScreen frame = new LoginScreen();
        frame.setVisible(true);
    }
}
