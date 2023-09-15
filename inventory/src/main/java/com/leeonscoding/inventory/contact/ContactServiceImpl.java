package com.leeonscoding.inventory.contact;

import com.leeonscoding.inventory.api.AddContactInput;
import com.leeonscoding.inventory.api.ApiException;
import com.leeonscoding.inventory.api.ContactListRequestParam;
import com.leeonscoding.inventory.api.Validator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{

    ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public long addContact(ContactType contactType, AddContactInput addContactInput) throws ApiException {
        if(addContactInput == null || !Validator.validateContactType(contactType)) {
            throw new ApiException("Bad parameters");
        }

        if(!Validator.phoneValidate(addContactInput.phone())) {
            throw new ApiException("Bad parameters");
        }

        Contact contact = Contact.builder()
                .contactType(contactType)
                .email(addContactInput.email())
                .phone(addContactInput.phone())
                .name(addContactInput.name())
                .build();

        Address address = Address.builder()
                .city(addContactInput.city() != null ? addContactInput.city() : "")
                .state(addContactInput.state() != null ? addContactInput.state() : "")
                .zip(addContactInput.zip() != null ? addContactInput.zip() : "")
                .street(addContactInput.street() != null ? addContactInput.street() : "")
                .build();

        contact.setAddress(address);

        return contactRepository.save(contact).getId();
    }

    @Override
    public void editContact(ContactType type, long id, AddContactInput addContactInput) throws ApiException {
        Contact contact = getOne(type, id);

        if(contact != null) {
            addContact(type, addContactInput);
        } else {
            throw new ApiException("Bad parameters");
        }

    }

    @Override
    public void deleteContact(ContactType type, long id) throws ApiException {
        Contact contact = getOne(type, id);

        if(contact != null) {
            contactRepository.delete(contact);
        } else {
            throw new ApiException("Bad parameters");
        }

    }

    @Override
    public Contact getOne(ContactType type, long id) throws ApiException {
        Optional<Contact> contact = contactRepository.findById(id);

        if(contact.isEmpty()) {
            throw new ApiException("Can't find item");
        }

        return contact.get();
    }

    @Override
    public List<Contact> list(ContactType type, ContactListRequestParam param) {
        int offset = param.offset();
        int limit = param.limit();
        String sort = param.sort();
        String order = param.order();
        String token = param.searchToken();

        Sort sortObj = Sort.sort(Contact.class).by(sort).descending();
        Pageable page = PageRequest.of(offset, limit, sortObj);

        List<Contact> contactList;

        if(!token.isEmpty()) {
            contactList = contactRepository
                    .findAll(
                            ContactSpecifications.emailLike(token)
                                    .or(ContactSpecifications.nameLike(token))
                                    .or(ContactSpecifications.phoneLike(token)),
                            page
                    ).stream().collect(Collectors.toList());
        } else {
            contactList = contactRepository.findAll(page)
                    .stream()
                    .collect(Collectors.toList());
        }

        return contactList;
    }
}
