import javax.swing.*;
import java.awt.*;

public class HomeForm {
    private JPanel mainPanel;
    private JPanel navPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JPanel contentPanel;
    private JPanel homeCard;
    private JPanel koelkastCard;
    private JPanel scanProductCard;
    private JPanel receptenCard;
    private JPanel profielCard;

    public HomeForm() {
        CardLayout cl = (CardLayout) contentPanel.getLayout();

        button1.addActionListener(e -> cl.show(contentPanel, "homeCard"));
        button2.addActionListener(e -> cl.show(contentPanel, "koelkastCard"));
        button3.addActionListener(e -> cl.show(contentPanel, "scanProductCard"));
        button4.addActionListener(e -> cl.show(contentPanel, "receptenCard"));
        button5.addActionListener(e -> cl.show(contentPanel, "profielCard"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
