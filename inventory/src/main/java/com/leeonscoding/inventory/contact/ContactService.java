package com.leeonscoding.inventory.contact;

import com.leeonscoding.inventory.api.AddContactInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.ContactListRequestParam;

import java.util.List;

public interface ContactService {

    long addContact(ContactType contactType, AddContactInput addContactInput) throws ApiException;

    void editContact(ContactType type, long id, AddContactInput addContactInput) throws ApiException;

    void deleteContact(ContactType type, long id) throws ApiException;

    Contact getOne(ContactType type, long id) throws ApiException;

    List<Contact> list(ContactType type, ContactListRequestParam param) throws ApiException;

    long totalSize(ContactType type, ContactListRequestParam param) throws ApiException;
}
