package com.example.urshopmiddleware.controller;

import com.example.urshopmiddleware.security.Authority;

import java.util.Map;

public enum UserClientAuthorityMap {
    ;
    private static final Map<String, Authority> AUTHORITY_MAP=Map.of(
            "ROLE_CUSTOMER",Authority.ROLE_CUSTOMER,
            "ROLE_CASHIER",Authority.ROLE_CASHIER
    );

    public static Authority mapToAuthority(final String authority){
        return AUTHORITY_MAP.get(authority);
    }

    public static String mapToUserClientAuthority(final Authority authority){
        return AUTHORITY_MAP.entrySet().stream()
                .filter(stringAuthorityEntry -> stringAuthorityEntry.getValue().equals(authority))
                .findAny()
                .map(Map.Entry::getKey)
                .orElseThrow();
    }
}
