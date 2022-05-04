package superkey;

public class Main {

    public static void main(String[] args) {
        String[] skills = { "git", "Scala", "JBoss", "UML" };
        Developer developer = new Developer("Mary", "mary@email.com", 3, "Java", skills);

        String[] methods = { "neural networks", "decision tree", "bayesian algorithms" };
        DataAnalyst analyst = new DataAnalyst("John", "john@gmail.com", 2, true, methods);

        System.out.println(developer);
        System.out.println();

        System.out.println(analyst);

        System.out.println(developer.mainLanguage);

        System.out.println();
        Employee employee = new Employee("Albert", "einstein@email.com", 90);
        System.out.println(employee);

        System.out.println(employee.name);

        int[] arr = {1, 2, 3};

        try {

        } catch (IndexOutOfBoundsException e) {

        }
    }
}
