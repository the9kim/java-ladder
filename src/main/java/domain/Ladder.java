package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomLineGenerator;

public class Ladder {

    private List<Line> lines;
    private final int numberOfWalls;
    private final Height height;

    public Ladder(int numberOfWalls, Height height) {
        this.numberOfWalls = numberOfWalls;
        this.height = height;
        makeLines();
    }

    public void makeLines() {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(this.numberOfWalls - 1, new RandomLineGenerator()));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
