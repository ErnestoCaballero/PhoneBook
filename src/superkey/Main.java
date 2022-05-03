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
    }
}
