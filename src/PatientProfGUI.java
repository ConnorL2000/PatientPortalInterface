import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PatientProfGUI {
    public static String filename;

    public PatientProfGUI(String file) {
        filename = file;
        JFrame frame = new JFrame();

        JRadioButton createProf = new JRadioButton("Create Profile");
        JRadioButton deleteProf = new JRadioButton("Delete Profile");
        JRadioButton updateProf = new JRadioButton("Update Profile");
        JRadioButton findProfile = new JRadioButton("Find Profile");
        JRadioButton displayAll = new JRadioButton("Display all Profiles");
        ButtonGroup group = new ButtonGroup();
        group.add(createProf);
        group.add(deleteProf);
        group.add(updateProf);
        group.add(findProfile);
        group.add(displayAll);

        JButton select = new JButton("Select");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(createProf);
        panel.add(deleteProf);
        panel.add(updateProf);
        panel.add(findProfile);
        panel.add(displayAll);
        panel.add(select);

        select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (createProf.isSelected()) {
                    new PatientProfCreate();
                } else if (deleteProf.isSelected()) {
                    new DeleteProf();
                } else if (updateProf.isSelected()) {
                    new UpdateProf();
                } else if (findProfile.isSelected()) {
                    new FindProf();
                } else {
                    new DisplayAll();
                }
            }
        });
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Integrated Patient System");
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        String file = "src/data2102.txt";
        new PatientProfGUI(file);
    }
}
