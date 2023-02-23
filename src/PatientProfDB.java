import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class PatientProfDB {
    public static ArrayList<PatientProf> data = new ArrayList<>();
    public static String filename;

    public PatientProfDB(String d) {
        data = new ArrayList<>();
        filename = d;
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

    public void writeAllPatientProf(String file) throws IOException {
        PrintWriter output = new PrintWriter(file);
        System.out.println(data.size());
        for (int i = 0; i < data.size(); i++) {
            output.println(data.get(i).getAdminID());
            output.println(data.get(i).getFirstName());
            output.println(data.get(i).getLastName());
            output.println(data.get(i).getAddress());
            output.println(data.get(i).getPhone());
            output.println(data.get(i).getCoPay());
            output.println(data.get(i).getInsuType());
            output.println(data.get(i).getPatientType());
            output.println(data.get(i).getMedCondInfo().getMdContact());
            output.println(data.get(i).getMedCondInfo().getMdPhone());
            output.println(data.get(i).getMedCondInfo().getAlgType());
            output.println(data.get(i).getMedCondInfo().getIllType());
        }
        output.close();
    }

    public void initializeDatabase(String file) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while (line != null) {
            PatientProf patient2 = new PatientProf(null, null, null, null, null, 0, null, null, new MedCond(null, null, null, null));
            for (int i = 0; i < 12; i++) {
                if (i == 0) {
                    patient2.updateID(line);
                    line = br.readLine();
                } else if (i == 1) {
                    patient2.updateFirstName(line);
                    line = br.readLine();
                } else if (i == 2) {
                    patient2.updateLastName(line);
                    line = br.readLine();
                } else if (i == 3) {
                    patient2.updateAddress(line);
                    line = br.readLine();
                } else if (i == 4) {
                    patient2.updatePhone(line);
                    line = br.readLine();
                } else if (i == 5) {
                    float a = Float.parseFloat(line);
                    patient2.updateCoPay(a);
                    line = br.readLine();
                } else if (i == 6) {
                    patient2.updateInsuType(line);
                    line = br.readLine();
                } else if (i == 7) {
                    patient2.updatePatientType(line);
                    line = br.readLine();
                } else if (i == 8) {
                    patient2.getMedCondInfo().updateMdContact(line);
                    line = br.readLine();
                } else if (i == 9) {
                    patient2.getMedCondInfo().updateMdPhone(line);
                    line = br.readLine();
                } else if (i == 10) {
                    patient2.getMedCondInfo().updateAlgType(line);
                    line = br.readLine();
                } else {
                    patient2.getMedCondInfo().updateIllType(line);
                    line = br.readLine();
                }
            }
            data.add(patient2);
        }
    }
}
