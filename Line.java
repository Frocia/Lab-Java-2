public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Point getStart() { return start; }
    public Point getEnd() { return end; }
    public void setStart(Point start) { this.start = start; }
    public void setEnd(Point end) { this.end = end; }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }

    public int getLength() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}