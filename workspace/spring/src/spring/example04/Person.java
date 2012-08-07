package spring.example04;

public class Person {
    private String name;
    private Player player;

    public Person(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void listenMusic() {
        this.player.play();
    }
}
