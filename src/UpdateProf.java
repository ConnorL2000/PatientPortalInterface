import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateProf {
    public UpdateProf() {
        JFrame frame = new JFrame();

        JLabel AdminLabel = new JLabel("Admin ID");
        JTextField AdminID = new JTextField(10);
        JLabel LastLabel = new JLabel("Last Name:");
        JTextField LastName = new JTextField(10);
        JLabel fields = new JLabel("Update Field:");
        JComboBox field = new JComboBox();
        JButton select = new JButton("Select");

        field.addItem("First Name");
        field.addItem("Last Name");
        field.addItem("Address");
        field.addItem("Phone");
        field.addItem("Copay");
        field.addItem("Insurance");
        field.addItem("Patient Type");
        field.addItem("Medical Contact");
        field.addItem("Medical Phone");
        field.addItem("Allergies");
        field.addItem("Illnesses");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(AdminLabel);
        panel.add(AdminID);
        panel.add(LastLabel);
        panel.add(LastName);
        panel.add(fields);
        panel.add(field);
        panel.add(select);

        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String file = "src/data2102.txt";
                PatientProfDB inta = new PatientProfDB("src/data2102.txt");
                try {
                    inta.initializeDatabase(file);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String ID = AdminID.getText();
                String Last = LastName.getText();
                int siz = inta.data.size();
                String x = String.valueOf(field.getSelectedItem());
                Boolean succeed;
                PatientProf A;
                for (int i = 0; i < inta.data.size(); i++) {
                    if (inta.data.get(i).getAdminID().equals(ID) && inta.data.get(i).getLastName().equals(Last)) {
                        A = inta.data.get(i);
                        new UpdateFunc(A, x, inta);
                    }
                }
                try {
                    inta.writeAllPatientProf("src/data2102.txt");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Update Profile");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateProf();
    }
}
