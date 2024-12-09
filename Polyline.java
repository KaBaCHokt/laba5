import java.util.List;
import java.util.LinkedHashSet;

public class Polyline {
    private final List<Line> lines;

    public Polyline(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        if (lines.isEmpty()) {
            return "Линия от {} до {}";
        }

        LinkedHashSet<Point> uniquePoints = new LinkedHashSet<>();
        uniquePoints.add(lines.get(0).getStart()); // Добавляем первую точку

        for (Line line : lines) {
            uniquePoints.add(line.getEnd()); // Добавляем конечные точки каждой линии
        }

        StringBuilder sb = new StringBuilder("Линия от ");
        boolean first = true;
        for (Point point : uniquePoints) {
            if (!first) {
                sb.append(" до ");
            }
            sb.append(point);
            first = false;
        }

        return sb.toString();
    }
}