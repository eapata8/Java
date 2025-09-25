import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        int wins = 0, losses = 0, ties = 0;
        int round = 0;

        System.out.println("=== Jeu de cartes (console) ===");
        gameLoop:
        while (true) {
            round++;
            if (deck.numberLeft() < 15) {
                deck.shuffle();
                System.out.println("[Le paquet a été remélangé]");
            }

            Player player = new Player();
            Player dealer = new Player();

            try {
                player.add(deck.take());
                dealer.add(deck.take());
                player.add(deck.take());
                dealer.add(deck.take());
            } catch (IllegalStateException e) {
                System.out.println("Plus assez de cartes, remélange...");
                deck.shuffle();
                continue;
            }

            System.out.println("\n--- Manche " + round + " ---");

            // Tour du joueur
            boolean playerBusted = false;
            while (true) {
                System.out.println("Votre main (" + player.getHandTotal() + "):");
                for (int i = 0; i < player.totalCards(); i++) {
                    System.out.println("  " + player.getCard(i));
                }
                System.out.println("Carte visible du dealer: " + dealer.getCard(0));
                System.out.print("Taper 'h' pour piocher, 's' pour rester: ");
                String resp = in.nextLine().trim().toLowerCase();
                if (resp.startsWith("h")) {
                    try {
                        Card c = deck.take();
                        player.add(c);
                        System.out.println("Vous piochez: " + c);
                        if (player.getHandTotal() > 21) {
                            playerBusted = true;
                            System.out.println("Vous avez dépassé 21 (" + player.getHandTotal() + ")!");
                            break;
                        }
                    } catch (IllegalStateException e) {
                        System.out.println("Plus de cartes! Remélange...");
                        deck.shuffle();
                    }
                } else {
                    break;
                }
            }

            // Tour du dealer
            boolean dealerBusted = false;
            if (!playerBusted) {
                System.out.println("\nTour du dealer...");
                while (dealer.getHandTotal() < 17) {
                    try {
                        Card c = deck.take();
                        dealer.add(c);
                        System.out.println("Dealer pioche: " + c);
                    } catch (IllegalStateException e) {
                        System.out.println("Plus de cartes pour le dealer, remélange...");
                        deck.shuffle();
                    }
                }
                System.out.println("Main du dealer (" + dealer.getHandTotal() + "):");
                for (int i = 0; i < dealer.totalCards(); i++) {
                    System.out.println("  " + dealer.getCard(i));
                }
                if (dealer.getHandTotal() > 21) {
                    dealerBusted = true;
                    System.out.println("Dealer a dépassé 21!");
                }
            }

            // Détermination du résultat
            int pTotal = player.getHandTotal();
            int dTotal = dealer.getHandTotal();
            if (playerBusted) {
                losses++;
                System.out.println("Résultat: Vous perdez.");
            } else if (dealerBusted) {
                wins++;
                System.out.println("Résultat: Vous gagnez !");
            } else {
                if (pTotal > dTotal) {
                    wins++;
                    System.out.println("Résultat: Vous gagnez !");
                } else if (pTotal < dTotal) {
                    losses++;
                    System.out.println("Résultat: Vous perdez.");
                } else {
                    ties++;
                    System.out.println("Résultat: Égalité.");
                }
            }

            System.out.printf("Score: %d victoires / %d défaites / %d nuls%n", wins, losses, ties);
            System.out.print("Jouer une autre manche ? (y/n) ");
            String again = in.nextLine().trim().toLowerCase();
            if (!again.startsWith("y")) {
                System.out.println("Merci d'avoir joué. Au revoir.");
                break gameLoop;
            }
        }

        in.close();
    }
}