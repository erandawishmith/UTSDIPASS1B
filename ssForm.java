import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ssForm extends Records {
    private JPanel mainPanel;
    private JButton gotoServicesButton;
    private JTabbedPane tabbedPane1;
    private JButton gotoTechnicianButton;
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
    private JButton editbtn;
    private JTabbedPane tabbedPane3;
    private JTextField textField1;
    private JTextField textField4;
    private JButton SHOWButton;
    private JTextField textField5;
    private JTextField textField2;
    private JTextField textField3;
    private JTabbedPane tabbedPane2;
    private JButton btn1;

    private Services servicesList = new Services(); // Assuming Services is a class
    private Technicians technicianList = new Technicians(); // Assuming Technicians is a class

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
                Service service = servicesList.find(id);
                System.out.println(id);

                if (service != null) {
                    String model = service.model;
                    String date = service.date;
                    ServiceType type = service.serviceType;
                    Status status = service.status;
                    sevName.setText(service.getName());
                    sevModel.setText(model);
                    sevDate.setText(date);
                    sevType.setText(type.toString());
                    sevStatus.setText(status.toString());
//

                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Service not found with ID: " + id);
                }
            }
        });
        editbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(sevID.getText());
                    Service service = servicesList.find(id);

                    if (service != null) {
                        // Display the existing service details
//                        System.out.println("Existing service details:");
//                        System.out.println(service.toString());

                        String customerName = sevName.getText();
                        String vehicleModel = sevModel.getText();
                        String date = sevDate.getText();
                        String serviceType = sevType.getText();
                        System.out.println(customerName);

                        // Create a new Service instance with updated values
                        Service newService = new Service(id, customerName, vehicleModel, date, ServiceType.FULL_SERVICE, Status.Booked);

                        // Update the service in the servicesList
                        Service updatedService = servicesList.updateService(id-1, newService);

                        // Optional: Display a confirmation message
                        JOptionPane.showMessageDialog(mainPanel, "Service edited successfully!");
                        servicesList.show();
                    } else {
                        JOptionPane.showMessageDialog(mainPanel, "Service not found with ID: " + id);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Invalid ID. Please enter a valid integer.");
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




    //Technician


}
