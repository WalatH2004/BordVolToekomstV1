import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login - BordVolToekomst");
            frame.setContentPane(new LoginForm().getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(1000,700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}