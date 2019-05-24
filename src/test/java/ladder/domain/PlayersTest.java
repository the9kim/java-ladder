package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-17
 */
public class PlayersTest {
    @Test
    void create_생성() {
        Players players = Players.newInstance("name")
                .add("hello")
                .add("pobi")
                .add("crong");

        assertThat(players).isEqualTo(Players.newInstance("name, hello, pobi, crong"));
    }

    @Test
    void create_연속된_문자들로_생성() {
        Players players = Players.newInstance("name, hello, pobi, crong");
        assertThat(players).isEqualTo(Players.newInstance("name,hello,pobi,crong"));
    }

    @Test
    void create_add시_빈값_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance("");
        });
        System.out.println();
    }

    @Test
    void create_빈값만_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance("");
        });
    }

    @Test
    void create_스페이스_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance(" ");
        });
    }

    @Test
    void create_콤마_한개_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance(",");
        });
    }

    @Test
    void create_콤마_여러개_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance(", ,");
        });
    }

    @Test
    void create_콤마_앞에_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance(", hee");
        });
    }

    @Test
    void create_콤마_중간에_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance("hi, , hee");
        });
    }

    @Test
    void create_중복이_있는_예외() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance("hi, new, hi,hee");
        });
    }

    @Test
    void create_중복이_있는_예외_add로_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Players.newInstance("hi")
                    .add("new")
                    .add("hi ");
        });
    }

    @Test
    void iterator_확인() {
        Players players = Players.newInstance("pobi, crong, hi, new");
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
