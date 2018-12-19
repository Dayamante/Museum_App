public class Profil {
    // fields
    private String image;
    private String firstName;
    private String lastName;
    private int phone;
    private String city;
    private int nbMuseum;
    private int level;
    // constructors
    public Profil(String image, String firstName, String lastName, int phone, String city, int nbMuseum, int level) {
        this.image = image;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.nbMuseum = nbMuseum;
        this.level = level;
    }
    // properties
    public String getImage() {
        return image;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public int getNbMuseum() {
        return nbMuseum;
    }

    public int getLevel() {
        return level;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNbMuseum(int nbMuseum) {
        this.nbMuseum = nbMuseum;
    }
}
