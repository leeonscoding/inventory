package com.leeonscoding.inventory.api;

import com.leeonscoding.inventory.contact.Contact;
import org.springframework.http.HttpStatus;

import java.util.List;

public record ContactsOutput(List<Contact> contacts) {
}
