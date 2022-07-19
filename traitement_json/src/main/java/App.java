import bll.MovieManager;
import bo.Acteur;
import bo.Film;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MovieManager service = MovieManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("1 - Affichage de la filmographie d'un acteur");
            System.out.println("2 - Affichage du casting d’un film donné");
            System.out.println("3 - Affichage des films sortis entre 2 années données");
            System.out.println("4 - Affichage des films communs à 2 acteurs/actrices donnés");
            System.out.println("5 - Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting");
            System.out.println("6 - Affichage des acteurs communs à deux films donnés");
            System.out.println("7 - Quitter");
            choix = scanner.nextInt();

            if(choix == 1) {
                scanner.nextLine();
                System.out.println("De quel acteur souhaitez-vous voir les films ?");
                String acteur = scanner.nextLine();
                List<Film> filmList = service.getFilmsByActorName(acteur);
                System.out.println("Voici les films de " + acteur);
                for (Film film : filmList) {
                    System.out.println(film.getMedia().getNom() + " sortie en " + film.getMedia().getAnneeSortie());
                }
            } else if (choix == 2) {
                // A revoir
                scanner.nextLine();
                System.out.println("De quel film souhaitez-vous voir le casting ?");
                String film = scanner.nextLine();
                List<Acteur> listCasting = service.getCastingByFilmName(film);
                System.out.println("Voici le casting du film " + film);
                for (Acteur acteur : listCasting) {
                    System.out.println(acteur.getPersonne().getIdentite());
                }
            } else if (choix == 3) {
                scanner.nextLine();
                System.out.println("Vous avez choisis de rechercher des films entre deux années données");
                System.out.println("Première année :");
                String annee1 = scanner.nextLine();
                System.out.println("Deuxième année :");
                String annee2 = scanner.nextLine();
                List<Film> listFilm = service.getFilmBetweenTwoYears(annee1, annee2);
                System.out.println("Voici la liste de film entre " + annee1 + " et " + annee2);
                for (Film film : listFilm) {
                    System.out.println(film.getMedia().getNom() + " sortie en " + film.getMedia().getAnneeSortie());
                }
            } else if (choix == 4) {
                scanner.nextLine();
                System.out.println("Vous avez choisis de rechercher des films communs entre deux acteurs données");
                System.out.println("Premier acteur :");
                String acteur1 = scanner.nextLine();
                System.out.println("Second acteur :");
                String acteur2 = scanner.nextLine();
                //code
            } else if (choix == 5) {
                scanner.nextLine();
                System.out.println("Vous avez choisis d'afficher des films sortis entre 2 années données ainsi qu'un acteur en commun");
                System.out.println("Première année :");
                String annee1 = scanner.nextLine();
                System.out.println("Deuxième année :");
                String annee2 = scanner.nextLine();
                System.out.println("L'acteur :");
                String acteur = scanner.nextLine();
                //code
            } else if (choix == 6) {
                scanner.nextLine();
                System.out.println("Vous avez choisis d'afficher les acteurs communs à 2 films donnés");
                System.out.println("Premier film :");
                String film1 = scanner.nextLine();
                System.out.println("Second film :");
                String film2 = scanner.nextLine();
                //code
            } else if (choix == 7) {
                System.out.println("Aurevoir");
                scanner.close();
            }

        } while (choix != 7);
    }
}
