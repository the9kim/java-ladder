package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private final List<Player> players;

    private Players(List<Player> players) {

        validateNumberOfPlayers(players);
        this.players = players;
    }

    public static Players of(String[] names) {
        List<Player> players = new ArrayList<>();

        for (int playerPosition = 0; playerPosition < names.length; playerPosition++) {
            Player player = new Player(names[playerPosition], playerPosition);
            players.add(player);
        }

        return new Players(players);
    }

    private void validateNumberOfPlayers(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("[ERROR] 두 명 이상 입력해야 합니다.");
        }
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player findPlayer(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 사람입니다."));
    }
}
