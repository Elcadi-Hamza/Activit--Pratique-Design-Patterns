package exercice2;

import exercice2.NonStandard.NonStandard;
import exercice2.adapter.NonStandardFrameworkAdapter;
import exercice2.framework.DefaultFrameworkImpl;
import exercice2.framework.Framework;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String FRAMEWORK_PACKAGE = "exercice2.framework.";
    private static final String LEGACY_PACKAGE = "exercice2.NonStandard.";

    // Cree un objet a partir du nom simple de la classe + le prefixe du package
    private static Object instantiate(String packagePrefix, String simpleName) throws Exception {
        Class<?> cls = Class.forName(packagePrefix + simpleName.trim());
        return cls.getDeclaredConstructor().newInstance();
    }

    private static Framework loadFramework(String simpleName) throws Exception {
        Object o = instantiate(FRAMEWORK_PACKAGE, simpleName);
        if (!(o instanceof Framework)) {
            throw new IllegalArgumentException(simpleName + " n'implémente pas Framework");
        }
        return (Framework) o;
    }

    private static int[] readData(String line) {
        return Arrays.stream(line.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // implementation par defaut au demarrage
        Framework framework = new DefaultFrameworkImpl();
        Image image = new Image(new int[]{0, 1, 1, 5, 5, 5, 0, 2, 2, -3});

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("Image actuelle : " + image);
            System.out.println("Implémentation actuelle : " + framework.getClass().getSimpleName());
            System.out.println("1. Choisir une implémentation standard (ex : FrameworkImpl1)");
            System.out.println("2. Choisir l'ancienne implémentation (adaptateur)");
            System.out.println("3. Saisir une nouvelle image");
            System.out.println("4. Filtrer l'image");
            System.out.println("5. Compresser l'image");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1": {
                        System.out.print("Nom de la classe : ");
                        framework = loadFramework(sc.nextLine());
                        System.out.println("Implémentation chargée : " + framework.getClass().getSimpleName());
                        break;
                    }
                    case "2": {
                        System.out.print("Nom de l'ancienne classe (ex : ImplNonStandard) : ");
                        NonStandard legacy = (NonStandard) instantiate(LEGACY_PACKAGE, sc.nextLine());
                        System.out.print("Nom du filtre de l'ancienne implémentation (ex : negatives, double) : ");
                        String filterName = sc.nextLine().trim();
                        System.out.print("Classe utilisée pour la compression (ex : FrameworkImpl1) : ");
                        Framework compression = loadFramework(sc.nextLine());
                        framework = new NonStandardFrameworkAdapter(legacy, filterName, compression);
                        System.out.println("Ancienne implémentation chargée via l'adaptateur.");
                        break;
                    }
                    case "3": {
                        System.out.print("Valeurs séparées par des espaces : ");
                        image = new Image(readData(sc.nextLine()));
                        break;
                    }
                    case "4": {
                        System.out.println("Avant : " + image);
                        image.setData(framework.filter(image.getData()));
                        System.out.println("Après : " + image);
                        break;
                    }
                    case "5": {
                        System.out.println("Avant : " + image);
                        image.setData(framework.compresser(image.getData()));
                        System.out.println("Après : " + image);
                        break;
                    }
                    case "0":
                        System.out.println("Au revoir.");
                        return;
                    default:
                        System.out.println("Choix invalide.");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Classe introuvable : " + e.getMessage());
            } catch (ClassCastException e) {
                System.out.println("Cette classe n'est pas du type attendu.");
            } catch (NumberFormatException e) {
                System.out.println("Nombre invalide dans les données.");
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}