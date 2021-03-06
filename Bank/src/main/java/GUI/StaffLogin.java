
package GUI;

import Controller.CustomerC;
import Controller.StaffC;

import javax.swing.*;

public class StaffLogin extends javax.swing.JDialog implements AutoCloseable{
    public StaffLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public StaffLogin() {
        initComponents();
    }

    private void initComponents() {

        usernameLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Staff Log In");
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridLayout(3, 2, 2, 2));

        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username :");
        usernameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(usernameLabel);
        getContentPane().add(usernameText);

        passLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passLabel.setText("Password :");
        getContentPane().add(passLabel);
        getContentPane().add(passText);

        loginButton.setText("Log in");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);

        pack();
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {

        String username = null;
        String pass = null;
        StringBuilder warning = new StringBuilder();

        if (usernameText.getText().isEmpty()){
            warning.append("\tusername is empty\n");
        }else{
            username = usernameText.getText();
        }

        if (passText.getText().isEmpty()){
            warning.append("\tpassword is empty\n");
        }else{
            pass = passText.getText();
        }

        if (warning.length() > 0)
            JOptionPane.showMessageDialog(this, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
        else{
            StaffC staffC = new StaffC();
            this.dispose();
            try {
                staffC.login(username, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StaffLogin dialog = new StaffLogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private javax.swing.JButton cancelButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passText;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;

    @Override
    public void close() throws Exception {

    }
}