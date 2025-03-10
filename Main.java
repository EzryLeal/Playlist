import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Playlist> playlists = new ArrayList<>();
        PlaylistConcreta currentPlaylist = null;

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear una nueva playlist");
            System.out.println("2. Seleccionar una playlist existente");
            System.out.println("3. Agregar una canción a la playlist");
            System.out.println("4. Eliminar una canción de la playlist");
            System.out.println("5. Reproducción de la canción");
            System.out.println("6. Ordenar canciones por duración");
            System.out.println("7. Ordenar canciones por artista");
            System.out.println("8. Reproducir canciones en orden aleatorio");
            System.out.println("9. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    currentPlaylist = new PlaylistConcreta();
                    playlists.add(currentPlaylist);
                    System.out.println("Nueva playlist creada y seleccionada.");
                    break;
                case 2:
                    System.out.println("Seleccione el número de la playlist:");
                    for (int i = 0; i < playlists.size(); i++) {
                        System.out.println((i + 1) + ". Playlist " + (i + 1));
                    }
                    int playlistIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir la nueva línea
                    if (playlistIndex >= 0 && playlistIndex < playlists.size()) {
                        currentPlaylist = (PlaylistConcreta) playlists.get(playlistIndex);
                        System.out.println("Playlist " + (playlistIndex + 1) + " seleccionada.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 3:
                    if (currentPlaylist != null) {
                        System.out.print("Ingrese el título de la canción: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese el artista de la canción: ");
                        String artista = scanner.nextLine();
                        System.out.print("Ingrese la duración de la canción (en minutos): ");
                        int duracion = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        currentPlaylist.agregarCancion(new CancionConcreta(titulo, artista, duracion));
                        System.out.println("Canción agregada a la playlist.");
                    } else {
                        System.out.println("No hay ninguna playlist seleccionada.");
                    }
                    break;
                case 4:
                    if (currentPlaylist != null) {
                        System.out.print("Ingrese el título de la canción a eliminar: ");
                        String titulo = scanner.nextLine();
                        Cancion aEliminar = null;
                        for (Cancion cancion : currentPlaylist.getCanciones()) {
                            if (cancion.getTitulo().equals(titulo)) {
                                aEliminar = cancion;
                                break;
                            }
                        }
                        if (aEliminar != null) {
                            currentPlaylist.eliminarCancion(aEliminar);
                            System.out.println("Canción eliminada de la playlist.");
                        } else {
                            System.out.println("Canción no encontrada.");
                        }
                    } else {
                        System.out.println("No hay ninguna playlist seleccionada.");
                    }
                    break;
                case 5:
                    if (currentPlaylist != null) {
                        System.out.println("Reproducción de la canción:");
                        for (Cancion cancion : currentPlaylist.getCanciones()) {
                            System.out.println(cancion.getTitulo() + " - " + cancion.getArtista() + " (" + cancion.getDuracion() + " minutos)");
                        }
                    } else {
                        System.out.println("No hay ninguna playlist seleccionada.");
                    }
                    break;
                case 6:
                    if (currentPlaylist != null) {
                        currentPlaylist.ordenarPorDuracion();
                        System.out.println("Canciones ordenadas por duración.");
                    } else {
                        System.out.println("No hay ninguna playlist seleccionada.");
                    }
                    break;
                case 7:
                    if (currentPlaylist != null) {
                        currentPlaylist.ordenarPorArtista();
                        System.out.println("Canciones ordenadas por artista.");
                    } else {
                        System.out.println("No hay ninguna playlist seleccionada.");
                    }
                    break;
                case 8:
                    if (currentPlaylist != null) {
                        currentPlaylist.reproducirAleatorio();
                        System.out.println("Reproducción aleatoria activada.");
                    } else {
                        System.out.println("No hay ninguna playlist seleccionada.");
                    }
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
    }
}
