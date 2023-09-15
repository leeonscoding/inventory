package com.leeonscoding.inventory.contact;

import com.leeonscoding.inventory.api.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/{type}")
    public ResponseEntity<HttpStatus> addContact(@NotNull @PathVariable ContactType type,
                                                 @RequestBody AddContactInput addContactInput) throws ApiException {
        long contactId = contactService.addContact(type, addContactInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{type}/{id}")
    public ResponseEntity<ContactOutput> getOne(@NotNull @PathVariable ContactType type,
                                                @NotNull @PathVariable long id) throws ApiException {
        Contact contact = contactService.getOne(type, id);
        return new ResponseEntity<>(new ContactOutput(contact), HttpStatus.OK);
    }

    @PutMapping("/{type}/{id}")
    public ResponseEntity<ContactOutput> editContact(@NotNull @PathVariable ContactType type,
                                                     @NotNull @PathVariable long id,
                                                     @RequestBody AddContactInput addContactInput) throws ApiException {
        contactService.editContact(type, id, addContactInput);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{type}/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@NotNull @PathVariable ContactType type,
                                                    @NotNull @PathVariable long id) throws ApiException {
        contactService.deleteContact(type, id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{type}")
    public ResponseEntity<ContactsOutput> list(@NotNull @PathVariable ContactType type,
                                               ContactListRequestParam contactListRequestParam) throws ApiException {
        List<Contact> contactList = contactService.list(type, contactListRequestParam);

        return new ResponseEntity<>(new ContactsOutput(contactList), HttpStatus.OK);
    }

}
