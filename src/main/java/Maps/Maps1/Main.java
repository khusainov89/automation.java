package Maps.Maps1;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Logger logger = Logger.getLogger(Main.class);

    static Map<Person, Account> accountMap = new HashMap<>();

    public static void addAccount(Person person, Account account) {
        accountMap.put(person, account);
    }

    public static void removeAccount(Person person) {
        accountMap.remove(person);
    }

    public static void removePerson(Person person) {
        accountMap.remove(person);
    }

    public static void displayAccountMap() {
        for (Map.Entry<Person, Account> entry : accountMap.entrySet()) {
            Person person = entry.getKey();
            Account account = entry.getValue();
            logger.info("Person: " + person + ", Account: " + account);
        }
    }


    static Person person = new Person("Roman");
    static Person person1 = new Person("Ivan");
    static Person person2 = new Person("Ruslan");
    static Account account = new Account("instagram");
    static Account account1 = new Account("FB");
    static Account account2 = new Account("Vk");

    public static void main(String[] args) {
        addAccount(person, account);
        addAccount(person1, account1);
        addAccount(person2, account2);

        removeAccount(person2);

        removePerson(person1);

        displayAccountMap();

    }
}
