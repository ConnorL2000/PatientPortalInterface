
public class PatientProf {
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float coPay;
    private String insuType;
    private String patientType;
    private MedCond medCondInfo;

    public PatientProf(String id, String fname, String lname, String add, String ph, float cop, String insut,String pat, MedCond mci) {
        adminID = id;
        firstName = fname;
        lastName = lname;
        address = add;
        phone = ph;
        coPay = cop;
        insuType = insut;
        patientType = pat;
        medCondInfo = mci;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public float getCoPay() {
        return coPay;
    }

    public String getInsuType() {
        return insuType;
    }

    public String getPatientType() {
        return patientType;
    }

    public MedCond getMedCondInfo() {
        return medCondInfo;
    }

    public void updateFirstName(String fname) {
        firstName = fname;
    }
    public void updateID(String ID) {
        adminID = ID;
    }

    public void updateLastName(String lname) {
        lastName = lname;
    }

    public void updateAddress(String add) {
        address = add;
    }

    public void updatePhone(String ph) {
        phone = ph;
    }

    public void updateCoPay(float cop) {
        coPay = cop;
    }

    public void updateInsuType(String insut) {
        insuType = insut;
    }

    public void updatePatientType(String pat) {
        patientType = pat;
    }

    public void updateMedCondInfo(MedCond mci,String re,String type){
        medCondInfo = mci;
        switch (type){
            case "mdContact":
                mci.updateMdContact(re);
            case "mdPhone":
                mci.updateMdContact(re);
            case "algType":
                mci.updateAlgType(re);
            case "illType":
                mci.updateIllType(re);
        }


    }
    @Override
    public String toString() {
        return adminID + " " + firstName + " " + lastName + " " + address + " " + phone + " " + coPay + " " + insuType + " " + patientType + " " + medCondInfo;
    }
    public static void main(String[] args) {
        MedCond med = new MedCond ("none", "none", "none", "none");
        PatientProf patient1 = new PatientProf("00001", "Velma", "Munira", "32 Brown Blvd", "8002341623", 20.0F, "Aetna","other", new MedCond ("none", "none", "none", "none") );

        System.out.println(patient1.getAdminID());
        System.out.println(patient1.getFirstName());
        System.out.println(patient1.getLastName());
        System.out.println(patient1.getAddress());
        System.out.println(patient1.getPhone());
        System.out.println(patient1.getCoPay());
        System.out.println(patient1.getInsuType());
        System.out.println(patient1.getPatientType());
        System.out.println(patient1.getMedCondInfo());

        patient1.updateFirstName("Amy");
        patient1.updateLastName("Peralta");
        patient1.updateAddress("76 Little Street");
        patient1.updatePhone("8609336276");
        patient1.updateCoPay(40.0F);
        patient1.updateInsuType("Private");
        patient1.updatePatientType("Adult");
        patient1.updateMedCondInfo(med,"Diabeties","illType");


        System.out.println(patient1.getFirstName());
        System.out.println(patient1.getLastName());
        System.out.println(patient1.getAddress());
        System.out.println(patient1.getPhone());
        System.out.println(patient1.getCoPay());
        System.out.println(patient1.getInsuType());
        System.out.println(patient1.getPatientType());
        System.out.println(patient1.getMedCondInfo().toString());


    }
}
