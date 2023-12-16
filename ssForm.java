import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ssForm {
    private JPanel mainPanel;
    private JButton gotoServicesButton;
    private JTabbedPane tabbedPane1;
    private JButton gotoTechnicianButton;
    private JTabbedPane tabbedPane2;
    private JTextField sevID;
    private JTextField sevName;
    private JTextField sevModel;
    private JTextField sevDate;
    private JTextField sevType;
    private JTextField sevStatus;
    private JTextField sevNameAdd;
    private JTextField sevModelAdd;
    private JTextField sevDateAdd;
    private JTextField sevTypeAdd;
    private JButton findID;
    private JButton btn1;

    public ssForm() {


        gotoServicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(1);
            }
        });


        }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ssForm");
        frame.setContentPane(new ssForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
