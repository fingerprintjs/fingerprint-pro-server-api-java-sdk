package com.fingerprint.example;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;

public class EnvUtil {
    private Dotenv dotenv;

    public EnvUtil() {
        // Load variables from .env if present, host environment variables still take precedence if present
        File envFile = new File(".env");
        if (envFile.exists()) {
            dotenv = Dotenv.configure().load();
        } else {
            System.out.println(".env file not found. Skipping dotenv loading.");
        }
    }

    public String getEnv(String key) {
        String value = System.getenv(key);
        if (value == null && dotenv != null) {
            value = dotenv.get(key);
        }
        return value;
    }
}
