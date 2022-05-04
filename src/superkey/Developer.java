package superkey;

public class Developer extends Employee {
    String mainLanguage;
    String[] skills;

    public Developer(String mainLanguage) {
        super();
    }
    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills != null ? skills : this.skills;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String[] getSkills() {
        return this.skills.clone();
    }

    @Override
    public String toString() {
        return String.format("Developer info%nName: %s%nEmail: %s%nExperience: %d%nMain Language: %s", super.getName(), super.getEmail(),super.getExperience(), this.mainLanguage);
    }
}
