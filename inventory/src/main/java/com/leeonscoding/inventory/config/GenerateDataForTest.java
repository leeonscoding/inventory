package com.leeonscoding.inventory.config;

import com.leeonscoding.inventory.api.AddContactInput;
import com.leeonscoding.inventory.contact.ContactService;
import com.leeonscoding.inventory.contact.ContactType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GenerateDataForTest implements CommandLineRunner {

    private ContactService contactService;

    public GenerateDataForTest(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 50; i++) {
            int phone = 10000+i;
            AddContactInput input = new AddContactInput("test_user"+i, "test_user_email"+i+"@mail.com", String.valueOf(phone), "", "", "", "");
            contactService.addContact(ContactType.CUSTOMER, input);
        }



    }
}
