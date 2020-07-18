package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void gettingAddress() {
        Address addressClient1 = new Address("Novosibirsk", "Lenina", 55, 84);
        Profile client1 = new Profile(addressClient1);
        Address addressClient2 = new Address("Moscow", "Tverskaya", 31, 5);
        Profile client2 = new Profile(addressClient2);
        List<Profile> profileClients = Arrays.asList(client1, client2);
        List<Address> rsl = Profiles.collect(profileClients);
        List<Address> expected = Arrays.asList(addressClient2, addressClient1);
        assertThat(rsl, is(expected));
    }

    @Test
    public void gettingAddressSort() {
        Address addressClient1 = new Address("Novosibirsk", "Lenina", 55, 84);
        Profile client1 = new Profile(addressClient1);
        Address addressClient2 = new Address("Moscow", "Tverskaya", 31, 5);
        Profile client2 = new Profile(addressClient2);
        Address addressClient3 = new Address("Moscow", "Tverskaya", 31, 5);
        Profile client3 = new Profile(addressClient3);
        List<Profile> profileClients = Arrays.asList(client1, client2, client3);
        List<Address> rsl = Profiles.collect(profileClients);
        List<Address> expected = Arrays.asList(addressClient2, addressClient1);
        assertThat(rsl, is(expected));
    }
}