package co.edu.univalle.poe.mvc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label titulo;

    @FXML
    public void cambiarTextoAHola(){
        titulo.setText("Hola");
    }


    @FXML
    public void imprimirHola() {
        System.out.println("Hola");
    }

    @FXML
    public void imprimirChao() {
        System.out.println("chao");
    }
 }