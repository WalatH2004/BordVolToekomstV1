import javax.swing.*;

public class LoginForm {
    private JPanel mainPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton inloggenButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;

    public LoginForm() {
        inloggenButton.addActionListener(e -> onLogin());
    }

    private void onLogin() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Vul zowel email als wachtwoord in.",
                    "Fout",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // SUPER SIMPEL: tijdelijke dummy-login
        // Optie 1: vaste gebruiker
        if (email.equals("test") && password.equals("test")) {
            openMainForm();
        } else {
            JOptionPane.showMessageDialog(mainPanel,
                    "Onjuiste combinatie van email/wachtwoord (dummy-check).",
                    "Fout",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Als je écht alles wilt toelaten voor nu, gebruik i.p.v. if/else:
        // openMainForm();
    }

    private void openMainForm() {
        // Huidig window (loginframe) pakken
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);

        // Nieuw hoofdscherm
        JFrame frame = new JFrame("Inloggen - BoordVolToekomst");
        frame.setContentPane(new MainForm().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if (currentFrame != null) {
            currentFrame.dispose();
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}