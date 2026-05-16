package heroku;

public class Person {
    String lastName, firstName, due;

    public Person(String lastName, String firstName, String due) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.due = due;
    }

    public Person() {}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public Double getDue() {
        return Double.parseDouble(due.replace("$", ""));
    }
}