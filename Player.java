package Model;

import java.util.Scanner;

public class Player extends Point {
    private int score;
    private String name;//name
    private int life;
    private int money;
    private Scanner scan;
    private int energy;

    //setters and getters:

    public void setScan(Scanner scan) {
        this.scan = scan;
    }// to create scan once (optimizing)

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //METHODS:
    public void setPlayerOnStartLocation(Board board) {
        board.setObjectOnLocation(getX(), getY(), this);
    }

    public void getAllInfo() {
        System.out.println("Hello," + getName());
        System.out.println("You have:");
        System.out.println(getMoney() + "$");
        System.out.println(getLife() + " lives");
        System.out.println(getEnergy()+" energy");
        System.out.println("And your score is " + getScore());
    }


    public void move2(Board board) {
        if (board.getObjectOnLocation(getX() + 1, getY() - 1 + getX() % 2) == 'x') {
            System.out.println("Oups!Wall!You cant go there");
            score -= 50;
            return;
        }
        board.ClearLocation(getX(), getY());
        setY(getY() - 1 + getX() % 2);
        setX(getX() + 1);
        updatePosition(board);
    }

    public void move3(Board board) {
        if (board.getObjectOnLocation(getX() + 1, getY() + getX() % 2) == 'x') {
            System.out.println("Oups!Wall!You cant go there");
            score -= 50;
            return;
        }
        board.ClearLocation(getX(), getY());
        setY(getY() + getX() % 2);
        setX(getX() + 1);
        updatePosition(board);
    }

    public void move5(Board board) {
        if (board.getObjectOnLocation(getX() - 1, getY() + getX() % 2) == 'x') {
            System.out.println("Oups!Wall!You cant go there");
            score -= 50;
            return;
        }
        board.ClearLocation(getX(), getY());
        setY(getY() + getX() % 2);
        setX(getX() - 1);
        updatePosition(board);
    }

    public void move6(Board board) {
        if (board.getObjectOnLocation(getX() - 1, getY() - 1 + getX() % 2) == 'x') {
            System.out.println("Oups!Wall!You cant go there");
            score -= 50;
            return;
        }
        board.ClearLocation(getX(), getY());
        setY(getY() - 1 + getX() % 2);
        setX(getX() - 1);
        updatePosition(board);
    }

    public void move1(Board board) {
        if (board.getObjectOnLocation(getX(), getY() - 1) == 'x') {
            System.out.println("Oups!Wall!You cant go there");
            score -= 50;
            return;
        }
        board.ClearLocation(getX(), getY());
        setY(getY() - 1);
        updatePosition(board);
    }

    public void move4(Board board) {
        if (board.getObjectOnLocation(getX(), getY() + 1) == 'x') {
            System.out.println("Oups!Wall!You cant go there");
            score -= 50;
            energy -= 100;
            return;
        }
        board.ClearLocation(getX(), getY());
        setY(getY() + 1);
        updatePosition(board);
    }

    public void updatePosition(Board board) {
        char currentsymbol = board.getObjectOnLocation(getX(), getY());
        switch (currentsymbol) {
            case '$':
                this.money += 50;
                this.score += 100;
                break;
            case 'A':
                System.out.println("Hi, My name is Angela.Thank you for visiting me.\n Answer to Angela:");
//                Scanner scan = new Scanner(System.in);
                String answer = scan.nextLine();
//                System.out.println(answer);
                System.out.println("You made me really happy! I'm giving you one life as a gift.");
                this.life += 1;
                break;
            case ' ':
                break;
            case 'E':
                this.life -= 1;
                energy -= 100;
                break;
        }
        board.setObjectOnLocation(getX(), getY(), this);
        board.printBoard();
    }

    public void MoveSwitch(Board board) {
        System.out.println("\nWhere do you want to move?(1/2/3/4/5/6)");
        System.out.println("       _ _    \n" +
                "      /   \\     \n" +
                "  _ _/  1  \\_ _\n" +
                " /   \\     /   \\  \n" +
                "/  6  \\_ _/  2  \\\n" +
                "\\     /   \\     / \n" +
                " \\_ _/  P  \\_ _/  \n" +
                " /   \\     /   \\  \n" +
                "/  5  \\_ _/  3  \\ \n" +
                "\\     /   \\     /  \n" +
                " \\_ _/  4  \\_ _/ \n" +
                "     \\     /   \n" +
                "      \\_ _/   \n");
        String ans2 = scan.nextLine();
        switch (ans2) {
            case "1" -> move1(board);
            case "2" -> move2(board);
            case "3" -> move3(board);
            case "4" -> move4(board);
            case "5" -> move5(board);
            case "6" -> move6(board);
        }
    }

    public void ShopSwitch() {
        System.out.println("\nWelcome to shop!");
        System.out.println("What do you want to buy?: \n1-Banana, price:50$ energy:100");
        System.out.println("2- Chocolate bar, price:75 energy:150 \n3- Cupcake, price:100$ energy:300");
        System.out.println("If you don't have enough money it will be deducted as a loan(ex: you will have -50$)");
        String ans2 = scan.nextLine();
        switch (ans2) {
            case "1" -> {
                money -= 50;
                energy += 100;
            }
            case "2" -> {
                money -= 75;
                energy += 150;
            }
            case "3" -> {
                money -= 100;
                energy += 300;
            }
        }
    }
}


