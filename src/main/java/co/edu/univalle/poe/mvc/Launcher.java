package co.edu.univalle.poe.mvc;

import co.edu.univalle.poe.mvc.model.FilesManager;
import javafx.application.Application;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);
    }
}
