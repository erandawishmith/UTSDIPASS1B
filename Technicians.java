public class Technicians extends Records {
    @Override
    public Technician find(int id) {
        return (Technician) super.find(id);
    }

    public void add() {
        System.out.println("Add Technician Details");
        Technician technician = new Technician(++id,
                In.readName("Technician Name"),
                In.readName("Technician Contact Number"),
                In.readName("Technician Level (Intern, Experienced)"));
        super.add(technician);
        System.out.println(technician.toString() + "'Technician Details Added Successfully !'");
    }

    public void edit() {
        int id = In.readInt("Enter Technician ID to edit: ");
        Technician technician = find(id);

        if (technician != null) {
            System.out.println("Existing Technician details:");
            System.out.println(technician.toString());

            Technician newTechnician = new Technician(id,
                    In.readName("Technician Name"),
                    In.readName("Technician Contact Number"),
                    In.readName("Technician Level (Intern, Experienced)"));

            Technician updatedTechnician = updateTechnician(id - 1, newTechnician);
            System.out.println("Technician Details Updated successfully");

        } else {
            System.out.println("Technician not found with ID " + id);
        }
    }

    public void delete() {
        int id = In.readInt("Enter technician ID to delete: ");
        deleteTechnician(id);
    }

    @Override
    public String toString() {
        return "\n" + super.toString();
    }

    public void deleteTechnician(int id) {
        Technician technicianToDelete = find(id);

        if (technicianToDelete != null) {
            super.records.remove(technicianToDelete);
            System.out.println("Technician ID " + id + " deleted");
        } else {
            System.out.println("Technician ID " + id + " not found");
        }
    }

    public Technician updateTechnician(int id, Technician newTechnician) {
        if (!super.records.isEmpty()) {
            if (id >= 0 && id < super.records.size()) {
                super.records.set(id, newTechnician);
                return (Technician) super.find(id);
            } else {
                System.out.println("Invalid technician ID for update");
            }
        } else {
            System.out.println("No technicians available for update");
        }

        return null;
    }
}
