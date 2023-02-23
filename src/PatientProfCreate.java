import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PatientProfCreate {

    public PatientProfCreate() {
        JFrame frame = new JFrame();
        JLabel AdminLabel = new JLabel("Admin ID");
        JTextField AdminID = new JTextField(10);
        JLabel FirstLabel = new JLabel("First Name");
        JTextField FirstName = new JTextField(10);
        JLabel LastLabel = new JLabel("Last Name");
        JTextField LastName = new JTextField(10);
        JLabel AddressLabel = new JLabel("Address");
        JTextField Address = new JTextField(10);
        JLabel PhoneLabel = new JLabel("Phone");
        JTextField Phone = new JTextField(10);
        JLabel CoPayLabel = new JLabel("Co-pay");
        JTextField Copay = new JTextField(10);
        JLabel InsurTypeLabel = new JLabel("Insurance");
        JTextField Insu = new JTextField(10);
        JLabel PatTypeLabel = new JLabel("Patient Type");
        JTextField Patt = new JTextField(10);
        JLabel MdContactLabel = new JLabel("Med Contact");
        JTextField MdContact = new JTextField(10);
        JLabel MdPhoneLabel = new JLabel("Med Phone");
        JTextField MdPhone = new JTextField(10);
        JLabel AllergyLabel = new JLabel("Allergies");
        JTextField Allergies = new JTextField(10);
        JLabel IllnessLabel = new JLabel("Illnesses");
        JTextField Illnesses = new JTextField(10);
        JButton select = new JButton("Select");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(AdminLabel);
        panel.add(AdminID);
        panel.add(FirstLabel);
        panel.add(FirstName);
        panel.add(LastLabel);
        panel.add(LastName);
        panel.add(AddressLabel);
        panel.add(Address);
        panel.add(PhoneLabel);
        panel.add(Phone);
        panel.add(CoPayLabel);
        panel.add(Copay);
        panel.add(InsurTypeLabel);
        panel.add(Insu);
        panel.add(PatTypeLabel);
        panel.add(Patt);
        panel.add(MdContactLabel);
        panel.add(MdContact);
        panel.add(MdPhoneLabel);
        panel.add(MdPhone);
        panel.add(AllergyLabel);
        panel.add(Allergies);
        panel.add(IllnessLabel);
        panel.add(Illnesses);
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
                int siz = inta.data.size();
                String ID = AdminID.getText();
                String Last = LastName.getText();
                String first = FirstName.getText();
                String addy = Address.getText();
                String phone = Phone.getText();
                Float cop = Float.parseFloat(Copay.getText());
                String ins = Insu.getText();
                String type = Patt.getText();
                String mdc = MdContact.getText();
                String mdp = MdPhone.getText();
                String alg = Allergies.getText();
                String ill = Illnesses.getText();
                MedCond meda = new MedCond(mdc, mdp, alg, ill);
                PatientProf pat1 = new PatientProf(ID, first, Last, addy, phone, cop, ins, type, meda);
                inta.data.add(pat1);
                if (siz < inta.data.size()) {
                    JOptionPane.showMessageDialog(null, "Profile Created");
                }
                try {
                    inta.writeAllPatientProf(file);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Create Profile");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PatientProfCreate();
    }
}
