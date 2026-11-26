package co.edu.univalle.poe.mvc.model;

/*Este import es para poder usar el atributo letrasProbadas*/
import java.util.Set;

public class Partida {
    private Jugador jugador;
    private String palabraSecreta;
    private char[] letrasReveladas; /*Lo que va en casilla, el hueco o la letra*/
    private Set<Character> letrasProbadas; /*Letras ya intentadas*/
    private int intentosRestantes;
    private EstadoPartida estado;

    public Partida(Jugador jugador,String palabraSecreta) {
        this.jugador = jugador;
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.letrasReveladas = new char[this.palabraSecreta.length()];
    }



} /* Cierre clase Partida*/


