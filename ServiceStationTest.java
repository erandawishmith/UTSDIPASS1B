
import java.util.LinkedList;
import java.util.Scanner;

public class ServiceStationTest {
    private LinkedList<Service> services = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);
    private Services servicesList = new Services();

    public static void main(String[] args) {
        ServiceStationTest test = new ServiceStationTest();

        test.addTestServices();

        test.displayServices();

        test.editService();

        test.deleteService();

        test.displayServices();
    }

    private void addTestServices() {
        // Add some test services to the LinkedList
        services.add(new Service(1, "Akila", "Car Model", "2023-01-15", ServiceType.FULL_SERVICE, Status.Booked));
        services.add(new Service(2, "Alice ", "SUV Model", "2023-02-20", ServiceType.BODYWASH, Status.Finished));
        services.add(new Service(3, "Johnson", "Truck Model", "2023-03-25", ServiceType.OIL_CHANGE, Status.Processing));
    }

    private void displayServices() {
        System.out.println("List of Services:");
        for (Service service : services) {
            System.out.println(service);
        }
    }

    private void editService() {
        System.out.print("\nEnter the ID of the service to edit: ");
        int serviceId = scanner.nextInt();
        scanner.nextLine(); 

        Service serviceToEdit = findServiceById(serviceId);

        if (serviceToEdit != null) {
            System.out.println("Existing service details:");
            System.out.println(serviceToEdit);

            System.out.println("Enter new details:");
            Service newService = new Service(serviceToEdit.getId(),
                    In.readName("Customer Name"),
                    In.readName("Vehicle Model"),
                    In.readName("Date"),
                    getServiceTypeFromUser(),
                    getStatusFromUser());

            updateService(serviceId, newService);
            System.out.println("Service details updated successfully!");
        } else {
            System.out.println("Service not found with ID " + serviceId);
        }
    }


    private void deleteService() {
        System.out.print("\nEnter the ID of the service to delete: ");
        int serviceId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Service serviceToDelete = findServiceById(serviceId);

        if (serviceToDelete != null) {
            // Delete the service from the LinkedList
            services.remove(serviceToDelete);
            System.out.println("Service with ID " + serviceId + " deleted");
        } else {
            System.out.println("Service not found with ID " + serviceId);
        }
    }

    private Service findServiceById(int id) {
        for (Service service : services) {
            if (service.getId() == id) {
                return service;
            }
        }
        return null;
    }

    private void updateService(int id, Service newService) {
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getId() == id) {
                services.set(i, newService);
                break;
            }
        }
    }

    private ServiceType getServiceTypeFromUser() {
        System.out.println("Choose service type:");
        for (ServiceType type : ServiceType.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type.name());
        }
        int typeChoice = In.readInt("Enter the number for the service type") - 1;

        if (typeChoice >= 0 && typeChoice < ServiceType.values().length) {
            return ServiceType.values()[typeChoice];
        } else {
            System.out.println("Invalid service type choice. Defaulting to BASIC.");
            return ServiceType.BODYWASH;
        }
    }

    private Status getStatusFromUser() {
        System.out.println("Change Status:");
        for (Status type : Status.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type.name());
        }
        int typeChoice = In.readInt("Enter the number to change the Status") - 1;
        if (typeChoice >= 0 && typeChoice < Status.values().length) {
            return Status.values()[typeChoice];
        } else {
            System.out.println("Invalid service type choice. Defaulting to BASIC.");
            return Status.Booked;
        }
    }
}


