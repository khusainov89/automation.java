package Maps.Maps2;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    static Map<Person, List<Account>> peopleAccounts = new HashMap<>();

    public static void addPerson(Person person) {
        peopleAccounts.put(person, new ArrayList<>());
    }

    public static void addAccount(Person person, Account account) {
        if (peopleAccounts.containsKey(person)) {
            List<Account> accounts = peopleAccounts.get(person);
            accounts.add(account);
        } else {
            List<Account> accounts = new ArrayList<>();
            accounts.add(account);
            peopleAccounts.put(person, accounts);
        }
    }

    public static void removeAccount(Person person, Account account) {
        if (peopleAccounts.containsKey(person)) {
            List<Account> accounts = peopleAccounts.get(person);
            accounts.remove(account);
        }
    }

    public static void removePerson(Person person) {
        peopleAccounts.remove(person);
    }

    public static void displayPeopleAccounts() {
        for (Map.Entry<Person, List<Account>> entry : peopleAccounts.entrySet()) {
            Person person = entry.getKey();
            List<Account> accounts = entry.getValue();
            logger.info("Person: " + person);
            logger.info("Accounts: " + accounts);
            System.out.println();
        }
    }

    static Person person = new Person("Roman");
    static Person person1 = new Person("Ivan");
    static Person person2 = new Person("Ruslan");
    static Account account = new Account("instagram");
    static Account account1 = new Account("FB");
    static Account account2 = new Account("Vk");

    public static void main(String[] args) {
        addPerson(person);
        addPerson(person1);
        addPerson(person2);

        addAccount(person, account);
        addAccount(person, account1);
        addAccount(person, account2);
        addAccount(person1, account1);
        addAccount(person2, account2);

        removeAccount(person1, account1);

        removePerson(person1);

        displayPeopleAccounts();

    }


}
