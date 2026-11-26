package co.edu.univalle.poe.mvc.model;

/*Este import es para poder usar el atributo letrasProbadas*/
import java.util.Set;
/*import que sirve para la clase letrasProbadas. Funciona para que
no se puedan repetir letras, y saber cuales ya estan de forma sencilla*/
import java.util.HashSet;

public class Partida {
    private Jugador jugador;
    private String palabraSecreta;
    private char[] letrasReveladas;/*Lo que va en casilla, el hueco o la letra*/
    private Set<Character> letrasProbadas; /*Letras ya intentadas*/
    private int intentosRestantes;
    private EstadoPartida estado;

    public Partida(Jugador jugador,String palabraSecreta) {
        this.jugador = jugador;
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.letrasReveladas = new char[this.palabraSecreta.length()];
        this.letrasProbadas = new HashSet<>();
        for (int i = 0; i < this.palabraSecreta.length(); i++) {
            letrasReveladas[i] = '_'; /*Este for se hace para que cuando no
                                   hayan letras escritas, se escriba ese '_'*/
        }
        this.intentosRestantes = 6;
        this.estado = EstadoPartida.EN_CURSO;
    }

    private int revelarLetra(char letra) {

    }



} /* Cierre clase Partida*/


