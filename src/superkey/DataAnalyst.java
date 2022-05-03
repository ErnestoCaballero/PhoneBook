package superkey;

public class DataAnalyst extends Employee {
    boolean phd;
    String[] methods;

    public DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods != null ? methods : this.methods;
    }

    public boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }

    @Override
    public String toString() {
        return String.format("Analyst info%nName: %s%nEmail: %s%nExperience: %d%nHas PhD: %s", super.getName(), super.getEmail(),super.getExperience(), this.phd);
    }
}
