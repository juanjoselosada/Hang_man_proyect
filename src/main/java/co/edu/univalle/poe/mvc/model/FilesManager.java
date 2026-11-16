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

    public void separar(String linea) {

        String resultado = "";

        for (int i = 0; i < linea.length(); i++) {
            resultado += linea.charAt(i) + ",";
        }

        resultado = resultado.substring(0, resultado.length() - 1);

        System.out.println(resultado);
    }
}

