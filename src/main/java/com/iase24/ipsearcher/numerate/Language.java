package com.iase24.ipsearcher.numerate;

import java.util.Arrays;

public enum Language {

    ru, en, fr;

    public static boolean isValidLanguage(String lang) {
        return Arrays.stream(Language.values()).anyMatch(language -> language.name().equalsIgnoreCase(lang));
    }
}
