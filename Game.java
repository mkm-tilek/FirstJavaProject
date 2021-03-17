package Model.Main;

import Model.Board;
import Model.Objects.Angela;
import Model.Objects.Enemies;
import Model.Objects.MoneyFruit;
import Model.Player;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //Player
        Player newPlayer = new Player();
        newPlayer.setSymbol('P');
        newPlayer.setMoney(0);
        newPlayer.setScore(0);
        newPlayer.setLife(3);
        newPlayer.setX(9);//9
        newPlayer.setY(8);//8
        newPlayer.setEnergy(300);

        Scanner scan = new Scanner(System.in);
        newPlayer.setScan(scan);

        System.out.println("Welcome!");
        // Create a Scanner object
        System.out.println("Enter you Player Name:");
        String userName = scan.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input
        newPlayer.setName(userName);

        // board
        Board board = new Board();
        board.initializeBoard();
        newPlayer.setPlayerOnStartLocation(board);//setting player on board
        //enemies
        Enemies enemies = new Enemies();
        enemies.setSymbol('E');
        enemies.setNumber(4);// 4 enemies
        enemies.SetNRandomEnemies(board);
        //money
        MoneyFruit money = new MoneyFruit();
        money.setSymbol('$');
        money.setNumber(10);
        money.SetNRandomFood(board);
        //NPC
        Angela NPC = new Angela();
        NPC.setSymbol('A');
        NPC.addOneRandomObject(board);
        board.printBoard();
        while (true) {
            if (board.WIN()) {
                newPlayer.getAllInfo();
                System.out.println("You Won!");
                System.out.println("Rerun to play again");
                return;
            } else if (newPlayer.getLife() <= 0) {
                System.out.println("Game over");
                System.out.println("Rerun to play again");
                return;
            }
            System.out.println("\nWhat do you want to do?");
            System.out.println("write 1,2 or 3");
            System.out.println("1-move");
            System.out.println("2-see my profile");
            System.out.println("3-go to shop");
            System.out.println("4-exit game");
            char ans = scan.nextLine().charAt(0);
            switch (ans) {
                case '1' -> {
                    if (newPlayer.getEnergy() <= 0) {
                        System.out.println("You can't move! Go to shop and buy food to get some energy ");
                    }
                    newPlayer.MoveSwitch(board);
                }
                case '2' -> newPlayer.getAllInfo();
                case '3' -> newPlayer.ShopSwitch();
                case '4' -> {
                    System.out.println("Thank you for playing! Bye!");
                    System.out.println("Rerun to play again");
                    return;
                }
            }
        }
    }
}
