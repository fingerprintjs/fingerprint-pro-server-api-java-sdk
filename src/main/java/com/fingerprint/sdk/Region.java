package com.fingerprint.sdk;

public enum Region {
    GLOBAL ("https://api.fpjs.io"),
    EUROPE ("https://eu.api.fpjs.io"),
    ASIA ("https://ap.api.fpjs.io");
    private final String url;

    Region(String s) {
        url = s;
    }

    public String toString() {
        return this.url;
    }
}
