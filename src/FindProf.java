import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FindProf {
    public FindProf() {
        JFrame frame = new JFrame();

        JLabel AdminLabel = new JLabel("Admin ID");
        JTextField AdminID = new JTextField(10);
        JLabel LastLabel = new JLabel("Last Name");
        JTextField LastName = new JTextField(10);
        JButton select = new JButton("Enter");


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
                PatientProfDB a = new PatientProfDB(file);
                try {
                    a.initializeDatabase(file);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                String ID = AdminID.getText();
                String Last = LastName.getText();
                for (int i = 0; i < a.data.size(); i++) {
                    if (a.data.get(i).getAdminID().equals(ID) && a.data.get(i).getLastName().equals(Last)) {
                        JOptionPane.showMessageDialog(null, a.data.get(i));
                    }
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Find Profile");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FindProf();
    }
}
