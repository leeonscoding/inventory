package com.leeonscoding.inventory.api;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestParam;

public record ContactListRequestParam(
        @NotNull
        @RequestParam("offset")
        int offset,

        @NotNull
        @RequestParam("limit")
        int limit,

        @NotNull
        @RequestParam("sort")
        String sort,

        @NotNull
        @RequestParam("order")
        String order,

        @RequestParam("searchToken")
        String searchToken
        ) {}
