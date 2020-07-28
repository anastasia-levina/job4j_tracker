package ru.job4j.collection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, которые содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> prName = name -> name.getName().contains(key);
        Predicate<Person> prSurname = surname -> surname.getSurname().contains(key);
        Predicate<Person> prAddress = address -> address.getAddress().contains(key);
        Predicate<Person> prPhone = phone -> phone.getPhone().contains(key);
        Predicate<Person> combine = prName.or(prSurname).or(prAddress).or(prPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}