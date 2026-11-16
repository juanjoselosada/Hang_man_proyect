package co.edu.univalle.poe.mvc.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Path.of;

public class FilesManager {
    private static final Path RUTA_RECORD = Path.of("src", "main", "java", "co", "edu", "univalle", "poe", "mvc", "model", "record.txt");

    private BufferedWriter writer;
    private BufferedReader reader;

    // Hecho por la IA: descompone la palabra en cada una de sus letras (para el hangman).
    public char[] separar(String palabra) {
        char[] letras = new char[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = palabra.charAt(i);
        }

        return letras;
    }
}

