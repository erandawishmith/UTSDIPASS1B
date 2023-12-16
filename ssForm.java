import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ssForm extends Records {
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
    private JButton submitButton;
    private JButton genReport;
    private JTextArea reporttxt;
    private JTextArea sevEdit;
    private JButton btn1;

    private Services servicesList = new Services(); // Assuming Services is a class

    public ssForm() {
//        go to services tab
        gotoServicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(1);
            }
        });


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = sevNameAdd.getText();
                String vehicleModel = sevModelAdd.getText();
                String date = sevDateAdd.getText();
                String serviceType = sevTypeAdd.getText();

                // Create a new Service instance
                Service service = new Service( ++id, customerName, vehicleModel, date, ServiceType.FULL_SERVICE, Status.Booked);

                // Add the service to the servicesList
                servicesList.add(service);

                // Optional: Display a confirmation message
                JOptionPane.showMessageDialog(mainPanel, "Service added successfully!");
                servicesList.show();
            }
        });
        genReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reporttxt.setText(servicesList.toString());

            }
        });


        findID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(sevID.getText());
                Service service = (Service) find(id);

                if (service != null){
                    sevEdit.setText(service.getName());
                }
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
