public class ServiceStation {
    private final char YES = 'Y';

    private Services servicesList = new Services();

    private Technicians techniciansList = new Technicians();

    public ServiceStation() {
        menu();
    }

    public static void main(String[] args) {
        new ServiceStation();
    }

    public void menu() {
        char action = readAction();
        switch (action) {
            case 'S':
                addService();
                break;
            case 'T':
                addTechnician();
                break;
            case 'E':
                edit();
                break;
            case 'R':
                report();
                break;
            case 'X':
                exit();
                break;
            case '?':
                help();
                break;
            case 'D':
                delete();
                break;
            default:
                error();
        }
    }

    private char readAction() {
        System.out.println("Please enter your choice (S, T, E, R, X, D, ?): ");
        return In.nextUpperChar();
    }

    private void addService() {
        servicesList.add();
        menu();
    }

    private void addTechnician() {
        techniciansList.add();
        menu();
    }

    private char editAction() {
        System.out.println("Please enter your choice (S,T): ");
        System.out.println("S:Service");
        System.out.println("T:Technician");
        return In.nextUpperChar();
    }

    private void edit() {
        switch (editAction()) {
            case 'S':
                editService();
                break;
            case 'T':
                editTechnician();
                break;
        }
    }

    private void editService() {
        servicesList.edit();
        menu();
    }

    private void editTechnician() {
        techniciansList.edit();
        menu();
    }

    private char readDeleteAction() {
        System.out.println("Please enter your choice (S,T): ");
        System.out.println("S:Service");
        System.out.println("T:Technician");
        return In.nextUpperChar();
    }

    private void delete() {
        switch (readDeleteAction()) {
            case 'S':
                deleteService();
                break;
            case 'T':
                deleteTechnician();
                break;
        }
    }

    private void deleteService() {
        servicesList.delete();
        menu();
    }

    private void deleteTechnician() {
        techniciansList.delete();
        menu();
    }

    private char readReportAction() {
        System.out.println("Please enter your choice (S,T): ");
        System.out.println("S:Service");
        System.out.println("T:Technician");
        return In.nextUpperChar();
    }

    private void report() {
        switch (readReportAction()) {
            case 'S':
                servicesList.show();
                break;
            case 'T':
                techniciansList.show();
        }
        menu();
    }

    private void exit() {
        if (!confirm())
            menu();
    }

    private boolean confirm() {
        System.out.println("Are you sure (y/n)?: ");
        return In.nextUpperChar() == YES;
    }

    private void help() {
        System.out.println("Welcome to Vehicle Service menu; enter");
        System.out.println("S for adding a service details");
        System.out.println("T for adding a technician details");
        System.out.println("E for edit details");
        System.out.println("R for get a report");
        System.out.println("D for delete");
        System.out.println("X to exit");
        System.out.println("? for help");
        menu();
    }

    private void error() {
        System.out.println("No action found. Try again");
        menu();
    }

    public void addServiceAutomatically(String customerName, String vehicleModel, String date, ServiceType serviceType, Status status) {
        System.out.println("Adding Service Automatically...");
        servicesList.addServiceAutomatically(customerName, vehicleModel, date, serviceType, status);
        menu();
    }
}
