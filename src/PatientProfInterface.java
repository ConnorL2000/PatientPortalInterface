import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PatientProfInterface {
    //@Override
    //public String toString() {
    //    return pat.getFirstName();
    //}
    String file;
    public final ArrayList<PatientProf> data = new ArrayList<>();
    int count;

    public PatientProfInterface(String fileName) {
        file = fileName;
    }

    public void deletePatientProf(PatientProf pat) {
        int i;
        int tell = 0;
        for (i = 0; i < data.size(); i++) {
            if (pat == data.get(i)) {
                data.remove(pat);
                System.out.println("Patient Deleted");
                tell = 1;
            }
        }
        if (tell == 0) {
            System.out.println("Patient Not Found");
        }
    }

    public int gen() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    public void findPatientProf(PatientProf pat) {
        for (int i = 0; i < data.size(); i++) {
            if (pat == data.get(i)) {
                System.out.println("Profile found");
            }
        }
    }

    public void updatePatientProf(PatientProf pat) {
        System.out.println("To update first name, type 1");
        System.out.println("To update last name, type 2");
        System.out.println("To Update an address, type 3");
        System.out.println("To update a phone number, type 4");
        System.out.println("To update copay, type 5");
        System.out.println("To update Insurance, type 6");
        System.out.println("To update patient type, type 7");
        System.out.println("To update a medical condition type 8");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String use;
        float cop;
        if (choice == 1) {
            sc.nextLine();
            System.out.println("Enter new name");
            use = sc.nextLine();
            pat.updateFirstName(use);
        }
        if (choice == 2) {
            sc.nextLine();
            System.out.println("Enter new name");
            use = sc.nextLine();
            pat.updateLastName(use);
        }
        if (choice == 3) {
            sc.nextLine();
            System.out.println("Enter new address");
            use = sc.nextLine();
            pat.updateAddress(use);
        }
        if (choice == 4) {
            sc.nextLine();
            System.out.println("Enter new phone number");
            use = sc.nextLine();
            pat.updatePhone(use);
        }
        if (choice == 5) {
            sc.nextLine();
            System.out.println("Enter new copay");
            cop = sc.nextFloat();
            pat.updateCoPay(cop);
        }
        if (choice == 6) {
            sc.nextLine();
            System.out.println("Enter new Insurance");
            use = sc.nextLine();
            pat.updateInsuType(use);
        }
        if (choice == 7) {
            sc.nextLine();
            System.out.println("Enter new Patient Type");
            use = sc.nextLine();
            pat.updatePatientType(use);
        }
        if (choice == 8) {
            System.out.println("To update mdContact, type 1");
            System.out.println("To update mdPhone, type 2");
            System.out.println("To Update allergies, type 3");
            System.out.println("To update illnesses, type 4");
            sc.nextLine();
            int choice2 = sc.nextInt();
            if (choice2 == 1) {
                sc.nextLine();
                System.out.println("Enter new mdContact");
                use = sc.nextLine();
                pat.getMedCondInfo().updateMdContact(use);
            }
            if (choice2 == 2) {
                sc.nextLine();
                System.out.println("Enter new mdPhone");
                use = sc.nextLine();
                pat.getMedCondInfo().updateMdPhone(use);
            }
            if (choice2 == 3) {
                sc.nextLine();
                System.out.println("Enter new Allergy");
                use = sc.nextLine();
                pat.getMedCondInfo().updateAlgType(use);
            }
            if (choice2 == 4) {
                sc.nextLine();
                System.out.println("Enter new Illness");
                use = sc.nextLine();
                pat.getMedCondInfo().updateIllType(use);
            }


        }
    }

    public void displayPatientProf(String firstName, String lastName, String admin) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getAdminID().equals(admin) && data.get(i).getFirstName().equals(firstName) && data.get(i).getLastName().equals(lastName)) {
                System.out.println(data.get(i));
            }
        }

    }

    public void displayAllPatientProf() {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    //private void writeToDB(){
//
//    }
    //   private void initDB(){
//
//    }
    public void createNewPatientProf() {
        System.out.println("Enter first name");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        System.out.println("Enter last name");
        String lastName = sc.nextLine();
        System.out.println("Enter address");
        String address = sc.nextLine();
        System.out.println("Enter phone number");
        String phone = sc.nextLine();
        System.out.println("Enter copay");
        float coPay = sc.nextFloat();
        sc.nextLine();
        System.out.println("Enter Insurance Type");
        String insuType = sc.nextLine();
        System.out.println("Enter Patient Type");
        String patientType = sc.nextLine();
        MedCond meda;
        meda = createNewMedCond();
        int ad = gen();
        String generatedString = Integer.toString(ad);

        PatientProf pat1 = new PatientProf(generatedString, firstName, lastName, address, phone, coPay, insuType, patientType, meda);
        data.add(pat1);

    }

    public MedCond createNewMedCond() {
        System.out.println("Enter Medical Contact");
        Scanner sc = new Scanner(System.in);
        String mdContact = sc.nextLine();
        System.out.println("Enter Contact");
        String mdPhone = sc.nextLine();
        System.out.println("Enter Allergy Type");
        String algType = sc.nextLine();
        System.out.println("Enter Illness Type");
        String illType = sc.nextLine();
        return new MedCond(mdContact, mdPhone, algType, illType);
    }

    public void getUserChoice() {
        System.out.println("To delete a profile type 1");
        System.out.println("To Find a profile type 2");
        System.out.println("To Update a profile type 3");
        System.out.println("To Display a profile type 4");
        System.out.println("To Display all profiles type 5");
        System.out.println("To Create a profile type 6");
        System.out.println("Enter 0 to Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        String f = "";
        String l = "";
        String admi = "";
        while (choice != 0) {
            if (choice == 1) {
                sc.nextLine();
                System.out.println("Enter first name");
                f = sc.nextLine();
                System.out.println("Enter Last name");
                l = sc.nextLine();
                System.out.println("Enter Admin ID");
                admi = sc.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getAdminID().equals(admi) && data.get(i).getFirstName().equals(f) && data.get(i).getLastName().equals(l)) {
                        deletePatientProf(data.get(i));
                    }
                }
            } else if (choice == 2) {
                sc.nextLine();
                System.out.println("Enter first name");
                f = sc.nextLine();
                System.out.println("Enter Last name");
                l = sc.nextLine();
                System.out.println("Enter Admin ID");
                admi = sc.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getAdminID().equals(admi) && data.get(i).getFirstName().equals(f) && data.get(i).getLastName().equals(l)) {
                        findPatientProf(data.get(i));
                    }
                }
            } else if (choice == 3) {
                sc.nextLine();
                System.out.println("Enter first name");
                f = sc.nextLine();
                System.out.println("Enter Last name");
                l = sc.nextLine();
                System.out.println("Enter Admin ID");
                admi = sc.nextLine();
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getAdminID().equals(admi) && data.get(i).getFirstName().equals(f) && data.get(i).getLastName().equals(l)) {
                        updatePatientProf(data.get(i));
                    }
                }
            } else if (choice == 4) {
                sc.nextLine();
                System.out.println("Enter first name");
                f = sc.nextLine();
                System.out.println("Enter Last name");
                l = sc.nextLine();
                System.out.println("Enter Admin ID");
                admi = sc.nextLine();
                displayPatientProf(f, l, admi);
            } else if (choice == 5) {
                displayAllPatientProf();
            } else if (choice == 6) {
                createNewPatientProf();
                displayAllPatientProf();
            } else if (choice == 7) {
                createNewMedCond();
            } else if (choice > 7 || choice < 0) {
                System.out.println("Re-choose");
            }
            System.out.println("\nTo delete a profile type 1");
            System.out.println("To Find a profile type 2");
            System.out.println("To Update a profile type 3");
            System.out.println("To Display a profile type 4");
            System.out.println("To Display all profiles type 5");
            System.out.println("To Create a profile type 6");
            System.out.println("To Create a Medical Condition type 7");
            System.out.println("Enter 0 to Exit\n");
            choice = sc.nextInt();
        }
        System.out.println("Goodbye!");
    }

    public static void main(String[] args) throws IOException {
        String file = "src/data2102.txt";
        PatientProfDB a = new PatientProfDB("src/data2102.txt");
        a.initializeDatabase(file);
        a.writeAllPatientProf(file);
    }
}
