package com.asas.beerapp.util;

import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

public class Util {

    public static File getResourceFile(String filePath) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(filePath);
        Assertions.assertNotNull(resource, "Expected file " + filePath + " to exist in current path.");

        URI uri = null;
        try {
            uri = resource.toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assert uri != null;
        return new File(uri);
    }

    public static String readFile(String filePath) {
        try {
            return Files.readString(getResourceFile(filePath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
