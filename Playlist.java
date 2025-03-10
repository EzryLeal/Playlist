import java.util.*;

public abstract class Playlist {
    protected List<Cancion> canciones;

    public Playlist() {
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }

    public void eliminarCancion(Cancion cancion) {
        this.canciones.remove(cancion);
    }

    public Cancion reproducirSiguiente() {
        if (!this.canciones.isEmpty()) {
            return this.canciones.remove(0);
        } else {
            return null;
        }
    }

    public void ordenarPorDuracion() {
        this.canciones.sort(Comparator.comparingInt(Cancion::getDuracion));
    }

    public void ordenarPorArtista() {
        this.canciones.sort(Comparator.comparing(Cancion::getArtista));
    }

    public void reproducirAleatorio() {
        Collections.shuffle(this.canciones);
    }

    public List<Cancion> getCanciones() {
        return this.canciones;
    }
}
