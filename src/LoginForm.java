import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

public class LoginForm {
    private JPanel mainPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton inloggenButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JPanel formPanel;
    private JLabel RegisterLabel;
    private JButton togglePasswordButton;
    private JLabel koelkastLabel;

    private boolean passwordVisible = false; // voor oogje

    public LoginForm() {

        // ------------------ LOGIN OP ENTER ------------------
        inloggenButton.addActionListener(e -> onLogin());

        mainPanel.registerKeyboardAction(
                e -> onLogin(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
        );

        // ------------------ FIX MAC BUTTON STYLE ------------------
        UIManager.put("Button.paintBorder", false);
        UIManager.put("Button.focus", new Color(0,0,0,0));
        UIManager.put("Button.select", new Color(0,0,0,0));

        // ------------------ LOGIN BUTTON STYLE ------------------
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        inloggenButton.setFont(buttonFont);

        inloggenButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        inloggenButton.setFocusPainted(false);
        inloggenButton.setBorderPainted(false);
        inloggenButton.setContentAreaFilled(true);
        inloggenButton.setOpaque(true);

        Color green = new Color(46, 125, 50);
        Color greenHover = new Color(66, 160, 70);

        inloggenButton.setBackground(green);
        inloggenButton.setForeground(Color.WHITE);

        // Hover-effect
        inloggenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                inloggenButton.setBackground(greenHover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                inloggenButton.setBackground(green);
            }
        });

        // ------------------ INPUT FOCUS KLEUREN ------------------
        Color highlightGreen = new Color(66, 160, 70);
        Color lightGray = new Color(200, 200, 200);

        emailField.setBorder(BorderFactory.createLineBorder(lightGray, 1));
        passwordField.setBorder(BorderFactory.createLineBorder(lightGray, 1));

        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                emailField.setBorder(BorderFactory.createLineBorder(highlightGreen, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                emailField.setBorder(BorderFactory.createLineBorder(lightGray, 1));
            }
        });

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setBorder(BorderFactory.createLineBorder(highlightGreen, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                passwordField.setBorder(BorderFactory.createLineBorder(lightGray, 1));
            }
        });

        // ------------------ WACHTWOORD-OOGJE ------------------
        passwordField.setEchoChar('•');  // standaard verbergen

        togglePasswordButton.setText("zien");
        togglePasswordButton.setFocusPainted(true);
        togglePasswordButton.setBorderPainted(true);
        togglePasswordButton.setContentAreaFilled(true);
        togglePasswordButton.setOpaque(true);

        togglePasswordButton.addActionListener(e -> togglePasswordVisibility());
    }

    // ------------------ TOGGLE WACHTWOORD ------------------
    private void togglePasswordVisibility() {
        if (passwordVisible) {
            // verbergen
            passwordField.setEchoChar('•');
            togglePasswordButton.setText("zien");
            passwordVisible = false;
        } else {
            // zichtbaar
            passwordField.setEchoChar((char) 0);
            togglePasswordButton.setText("verbergen");
            passwordVisible = true;
        }
    }

    // ------------------ LOGIN CHECK ------------------
    private void onLogin() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Vul zowel email als wachtwoord in.",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (email.equals("test") && password.equals("test")) {
            openMainForm();
        } else {
            JOptionPane.showMessageDialog(mainPanel,
                    "Onjuiste combinatie van email/wachtwoord (dummy-check).",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ------------------ OPEN MAIN FORM ------------------
    private void openMainForm() {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(mainPanel);

        JFrame frame = new JFrame("BordVolToekomst");
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
