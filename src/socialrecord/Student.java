package socialrecord;

/**
 *
 * @author Munyaradzi Nyamajiwa
 */
public class Student 
{
    private int id;
    private String firstNames, lastName, homeAddress, knownConditions;
    private int posInFam, noChildren, phoneNumber;
    private String parentsName, occupation;

    public Student(int id, String firstNames, String lastName, String homeAddress, String knownConditions, int posInFam, int noChildren, int phoneNumber, String parentsName, String occupation) 
    {
        this.id = id;
        this.firstNames = firstNames;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.knownConditions = knownConditions;
        this.posInFam = posInFam;
        this.noChildren = noChildren;
        this.phoneNumber = phoneNumber;
        this.parentsName = parentsName;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getKnownConditions() {
        return knownConditions;
    }

    public void setKnownConditions(String knownConditions) {
        this.knownConditions = knownConditions;
    }

    public int getPosInFam() {
        return posInFam;
    }

    public void setPosInFam(int posInFam) {
        this.posInFam = posInFam;
    }

    public int getNoChildren() {
        return noChildren;
    }

    public void setNoChildren(int noChildren) {
        this.noChildren = noChildren;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParentsName() {
        return parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
