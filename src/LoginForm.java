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

        if (email.equals("test") && password.equals("test")) {
            openMainForm();
        } else {
            JOptionPane.showMessageDialog(mainPanel,
                    "Onjuiste combinatie van email/wachtwoord (dummy-check).",
                    "Fout",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openMainForm() {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);

        JFrame frame = new JFrame("Inloggen - BoordVolToekomst");
        frame.setContentPane(new HomeForm().getMainPanel());
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