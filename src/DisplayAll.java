import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DisplayAll {
    static int counter = 0;

    public DisplayAll() {
        JFrame frame = new JFrame();

        JLabel AdminLabel = new JLabel("Admin ID");
        JTextField AdminID = new JTextField(10);
        JButton select = new JButton("Enter");
        JLabel prof = new JLabel("");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(AdminLabel);
        panel.add(AdminID);
        panel.add(prof);
        panel.add(select);

        int track = 0;

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
                for (int i = 0; i < a.data.size(); i++) {
                    if (a.data.get(i).getAdminID().equals(ID)) {
                        JOptionPane.showMessageDialog(null, a.data.get(i));
                    }
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Display All Profile");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DisplayAll();
    }
}
