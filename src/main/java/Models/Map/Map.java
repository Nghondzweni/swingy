package Models.Map;

public class Map {

    public int x;
    public int y;
    public int level;
    public char[][] map;


    public  Map(int level){
        if (level == 0)
            this.level = ++level;
        else
            this.level = level;
        this.x = ((level -1)*5+10-(level % 2));
        this.y = ((level -1)*5+10-(level % 2));
        this.map = new char[x][y];
    }

    public void generateMap(int x, int y, char[][] map){
        int countX;
        int countY;
        for(countY = 0; countY < y; countY++){
            for(countX = 0; countX < x; countX++){
                map[countX][countY] = '0';
            }
        }
    }
}
