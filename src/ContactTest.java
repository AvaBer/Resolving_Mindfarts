import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings("WeakerAccess")
public class ContactTest {

    private List<Contact> contactList;
    private String[] firstNames = {"Lucille", "Juan", "Rosemarie", "Lindsay", "Van", "Pamela", "Elaine", "Adrian", "Minnie", "Marion"};
    private String[] lastNames = {"Campbell", "Vasquez", "Rodriguez", "Mccormick", "Riley", "Cruz", "Williamson", "Walker", "Curtis", "Cook"};

    private Comparator<Contact> compareByFirstName = Comparator.comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER);
    private Consumer<Contact> printContact = System.out::println;
    private Consumer<List<Contact>> printContactList = list -> list.forEach(printContact);
    @SuppressWarnings("FieldCanBeLocal")
    private Consumer<List<Contact>> sortContactList = list -> list.sort(compareByFirstName);
    private Consumer<Contact> addContact = c -> contactList.add(c);
    public void asdContact(Contact c) {contactList.add(c);}

    public ContactTest() {
        this.contactList = populateContactList(new ArrayList<>(), 10);
        sortContactList.accept(contactList);
        testingGround();
    }

    @SuppressWarnings("All")
    private List<Contact> populateContactList(List<Contact> list, int amount) {
        for (int i = 0; i < amount; i++) {
            list.add(new Contact(firstNames[i], lastNames[i],
                    String.format("%s.%s@email.com", firstNames[i], lastNames[i]).toLowerCase()));
        }
        return list;
    }


    private void testingGround() {
//        printContact.accept(contactList.get(0));
//        contactList.forEach(System.out::println);
        addContact.accept(new Contact("a","a","a"));
        printContactList.accept(contactList);
    }

//    private void moreContactTests() {
//        Contact c1 = new Contact("gunnar", "carlsson");
//        Contact c2 = new Contact("gunnar", "carlsson");
//        System.out.println(c1.hashCode());
//        System.out.println(c2.hashCode());
//        System.out.println(c1.getClass());
//        System.out.println(c1.equals(c2));
//        System.out.println(c1.asObject().equals(c2));
//        Object o = someObject();
//        System.out.println(o.getClass());
//    }
//    private Object someObject() {
//        Object o;
//        if (System.currentTimeMillis() % 2 == 0)
//            o = new Contact("Modulus", "Even");
//        else o = "Gargamel";
//        return o;
//    }


}
