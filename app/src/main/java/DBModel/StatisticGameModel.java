package DBModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.Locale;

/**
 * Created by milson on 05.04.17.
 */

public class StatisticGameModel implements Comparable {
    private Long gameId;
    private Long playerWinId;
    private char winOS;

    public StatisticGameModel(){}

    public StatisticGameModel(ResultSet rs) throws SQLException{

    }

    public Long getGameId(){
        return  gameId;
    }

    public void setGameId(Long gameId){
        this.gameId = gameId;
    }

    public Long getPlayerWinId(){
        return playerWinId;
    }

    public void setPlayerWinId(Long playerWinId){
        this.playerWinId = playerWinId;
    }

    public char getWinOS(){
        return winOS;
    }

    public void setWinOS(char winOS){
        this.winOS = winOS;
    }

    /*public String getPlayerName(){
        try{
            DB db = new DB("test", "dev", "dev");
            db.connectToDB();
            String query = "select name from players where id = " + getPlayerWinId() + ";";
            ResultSet rs = db.getResultExecuteQuery(query);
            if(rs.next()){
                String playerWinName = rs.getString(1);
                return playerWinName;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }*/
    public String toString(Object obj){
        return playerWinId + " " + winOS;
    }

    public int compareTo(Object obj){
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }
}
