import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateFunc {
    public UpdateFunc(PatientProf A, String B, PatientProfDB C) {
        JFrame frame = new JFrame();

        JLabel AdminLabel = new JLabel("Admin ID");
        JLabel AdminID = new JLabel(A.getAdminID());
        JLabel LastLabel = new JLabel("Last Name");
        JLabel LastName = new JLabel(A.getLastName());
        JButton select = new JButton("Select");
        JLabel updatefield = new JLabel(B);
        JTextField field = new JTextField(10);


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(AdminLabel);
        panel.add(AdminID);
        panel.add(LastLabel);
        panel.add(LastName);
        panel.add(updatefield);
        panel.add(field);
        panel.add(select);


        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String x = B;
                String y = field.getText();
                if (x.equals("First Name")) {
                    A.updateFirstName(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Last Name")) {
                    A.updateLastName(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Address")) {
                    A.updateAddress(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Phone")) {
                    A.updatePhone(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Co Pay")) {
                    A.updateCoPay(Float.parseFloat(B));
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Insurance")) {
                    A.updateInsuType(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Patient Type")) {
                    A.updatePatientType(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Medical Contact")) {
                    A.getMedCondInfo().updateMdContact(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Medical Phone")) {
                    A.getMedCondInfo().updateMdPhone(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Allergies")) {
                    A.getMedCondInfo().updateAlgType(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                } else if (x.equals("Illnesses")) {
                    A.getMedCondInfo().updateIllType(y);
                    JOptionPane.showMessageDialog(null, "Profile Updated");
                }
                try {
                    C.writeAllPatientProf("src/data2102.txt");
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
}
