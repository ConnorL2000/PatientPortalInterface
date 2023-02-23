
public class MedCond {

    String mdContact;
    String mdPhone;
    String algType;
    String illType;

    public MedCond(String contact, String phone, String aType, String iType){
        mdContact = contact;
        mdPhone = phone;
        algType = aType;
        illType = iType;
    }

    public String getMdContact(){
        return mdContact;
    }

    public String getMdPhone(){
        return mdPhone;
    }

    public String getAlgType(){
        return algType;
    }

    public String getIllType(){
        return illType;
    }

    public void updateMdContact(String newContact){
        mdContact = newContact;
    }

    public void updateMdPhone(String newPhone){
        mdPhone = newPhone;
    }

    public void updateAlgType(String newAlgType){
        algType = newAlgType;
    }

    public void updateIllType(String newIllType){
        illType = newIllType;
    }
    @Override
    public String toString() {
        return mdContact + " " + mdPhone + " " + algType + " " + illType;
    }
    public static void main(String[] args){
        MedCond patient1 = new MedCond("Mary Test", "1357924680", "none", "none");

        System.out.println(patient1.getMdContact());
        System.out.println(patient1.getMdPhone());
        System.out.println(patient1.getAlgType());
        System.out.println(patient1.getIllType());

        patient1.updateMdContact("Susan Test");
        patient1.updateMdPhone("1234567890");
        patient1.updateAlgType("seafood");
        patient1.updateIllType("shellfish");

        System.out.println(patient1.getMdContact());
        System.out.println(patient1.getMdPhone());
        System.out.println(patient1.getAlgType());
        System.out.println(patient1.getIllType());

        patient1.updateMdContact("Johnny Test");

        System.out.println(patient1.getMdContact());
        System.out.println(patient1.getMdPhone());
        System.out.println(patient1.getAlgType());
        System.out.println(patient1.getIllType());

    }

}

