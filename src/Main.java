import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored){}

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login - EenBoordVolToekomst");
            frame.setContentPane(new LoginForm().getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();              // past grootte aan aan de inhoud
            frame.setSize(1000,700);
            frame.setLocationRelativeTo(null); // centreert het venster
            frame.setVisible(true);
        });
    }
}