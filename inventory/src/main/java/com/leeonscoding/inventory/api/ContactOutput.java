package com.leeonscoding.inventory.api;

import com.leeonscoding.inventory.contact.Contact;
import org.springframework.http.HttpStatus;

public record ContactOutput(Contact contact) {
}
