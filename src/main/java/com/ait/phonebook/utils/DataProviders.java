package com.ait.phonebook.utils;

import com.ait.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addnewContactFromCSV() throws IOException {
        List<Object[]> list =new ArrayList<>();
        BufferedReader reader =new BufferedReader(new FileReader("src/test/resources/contacts.csv"));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1])
                    .setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});

            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addnewContact() {
        List<Object[]> list =new ArrayList<>();
        list.add(new Object[]{"Oliver1","Kan1","1223455667","o1email@gmail.com","Berlin","goalkeeper"});
        list.add(new Object[]{"Oliver2","Kan2","1223455668","jemail@gmail.com","Berlin","goalkeeper"});
        list.add(new Object[]{"Oliver3","Kan3","1223455669","email@gmail.com","Berlin","goalkeeper"});
        return list.iterator();
    }
}
