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
        int apariciones = 0;
        for (int i = 0; i < this.palabraSecreta.length(); i++) {
            if (this.palabraSecreta.charAt(i) == letra) {
                letrasReveladas[i] = letra;
                apariciones++;
            }
        }

        return apariciones;
    }

    private boolean letraValida(char letra) {
        return letra >= 'a' && letra <= 'z'; /*Lo que hace esta funcion y este
        return es si lo que esta ahi es valido devuelve un true, esto para
        saber que el caracter que escribiste no sea algo mas que una letra*/
    }

    private boolean letraYaProbada(char letra) {
        return this.letrasProbadas.contains(letra);/*Si letra ya esta contenida
        en letrasProbadas entonces devuelve un true, y asi se sabe si una
        letra es repetida o no*/
    }

    private void verificarVictoria() {
        for (int i = 0; i < letrasReveladas.length; i++) {
            if (letrasReveladas[i] == '_') {
                return;
            }
        }
        this.estado = EstadoPartida.VICTORIA;
    }

    public boolean estaTerminada() {
        return this.estado == EstadoPartida.VICTORIA || this.estado == EstadoPartida.DERROTA;
        /*Devuelve true si el estado es VICTORIA o DERROTA, si no, un false. Si el
        estado el valor es true, sabemos que la partida ya acabo*/
    }

    public ResultadoJugada procesarLetra(char letra) {
        // Si la partida ya terminó (victoria o derrota), no se procesa nada más.
        if (estaTerminada()) {
            return ResultadoJugada.PARTIDA_TERMINADA;
        }
        // Pasa la letra a minúscula para que 'A' y 'a' se traten igual.
        char letraNormalizada = Character.toLowerCase(letra);
        /* Si lo que tecleó no es una letra de la a a la z (un número, símbolo, etc.),
        se avisa y no se gasta intento*/
        if (!letraValida(letraNormalizada)) {
            return ResultadoJugada.DATO_INVALIDO;
        }
        // Si esa letra ya se había probado antes, se avisa y tampoco se gasta intento.
        if (letraYaProbada(letraNormalizada)) {
            return ResultadoJugada.LETRA_REPETIDA;
        }
        // Se guarda la letra como probada, para recordar que ya se intentó.
        letrasProbadas.add(letraNormalizada);
        // Intenta revelar la letra en la palabra. Devuelve cuántas casillas cambió.
        int apariciones = revelarLetra(letraNormalizada);
        /*Si cambió al menos una casilla, la letra estaba en la palabra: es un acierto.
        Después se revisa si con eso ya se completó la palabra*/
        if (apariciones > 0) {
            verificarVictoria();
            return ResultadoJugada.ACIERTO;
        }
        // Si no estaba en la palabra, es un fallo: se descuenta un intento.
        intentosRestantes--;
        // Si ya no quedan intentos, la partida se pierde.
        if (intentosRestantes == 0) {
            estado = EstadoPartida.DERROTA;
        }
        return ResultadoJugada.FALLO;
    }

    public String getPalabraEnmascarada() {
        // StringBuilder es como un texto que se va armando pieza por pieza.
        StringBuilder resultado = new StringBuilder();

        // Recorre cada casilla de la palabra, de la primera a la última.
        for (int i = 0; i < letrasReveladas.length; i++) {
            // Antes de cada casilla, excepto la primera, mete un espacio para separarlas.
            if (i > 0) {
                resultado.append(' ');
            }
            //Agrega el contenido de la casilla: '_' si está oculta, o la letra si ya se descubrió.
            resultado.append(letrasReveladas[i]);
        }

        // Convierte el StringBuilder en un String normal para poder devolverlo.
        return resultado.toString();
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public int getErrores() {
        // Los errores son los intentos que se perdieron: el total (6) menos los que quedan.
        return 6 - intentosRestantes;
    }

    public EstadoPartida getEstado() {
        return estado;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public Jugador getJugador() {
        return jugador;
    }

} /* Cierre clase Partida*/


