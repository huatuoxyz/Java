package spring.example03;

public class Person {
    private String name;
    private Player player;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void listenMusic() {
        this.player.play();
    }

}
