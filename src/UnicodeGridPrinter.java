import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class UnicodeGridPrinter {

    public static void printGridFromDoc(String docUrl) throws Exception {
        URL url = new URL(docUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        Map<Point, Character> gridMap = new HashMap<>();
        int maxX = 0, maxY = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || !line.matches("\\d+\\s+\\S\\s+\\d+")) continue;

            String[] parts = line.split("\\s+");
            int x = Integer.parseInt(parts[0]);
            char ch = parts[1].charAt(0);
            int y = Integer.parseInt(parts[2]);

            gridMap.put(new Point(x, y), ch);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }
        reader.close();

        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                System.out.print(gridMap.getOrDefault(new Point(x, y), ' '));
            }
            System.out.println();
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        String docUrl = "https://docs.google.com/document/d/e/2PACX-1vRPzbNQcx5UriHSbZ-9vmsTow_R6RRe7eyAU60xIF9Dlz-vaHiHNO2TKgDi7jy4ZpTpNqM7EvEcfr_p/pub";
        printGridFromDoc(docUrl);
    }
}