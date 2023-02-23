import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteProf {
    public DeleteProf() {
        JFrame frame = new JFrame();

        JLabel AdminLabel = new JLabel("Admin ID");
        JTextField AdminID = new JTextField(10);
        JLabel LastLabel = new JLabel("Last Name");
        JTextField LastName = new JTextField(10);
        JButton select = new JButton("Select");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(AdminLabel);
        panel.add(AdminID);
        panel.add(LastLabel);
        panel.add(LastName);
        panel.add(select);

        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String file = "src/data2102.txt";
                PatientProfDB inta = new PatientProfDB(file);
                try {
                    inta.initializeDatabase(file);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String ID = AdminID.getText();
                String Last = LastName.getText();
                int siz = inta.data.size();
                for (int i = 0; i < inta.data.size(); i++) {
                    if (inta.data.get(i).getAdminID().equals(ID) && inta.data.get(i).getLastName().equals(Last)) {
                        inta.deletePatientProf(inta.data.get(i));
                    }
                    if (siz > inta.data.size()) {
                        JOptionPane.showMessageDialog(null, "Profile Deleted");
                    }

                }
                try {
                    inta.writeAllPatientProf(file);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Delete Profile");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DeleteProf();
    }
}
