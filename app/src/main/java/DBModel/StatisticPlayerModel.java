package DBModel;

/**
 * Created by milson on 05.04.17.
 */
/*
public class StatisticPlayerModel implements Comparable {
    private Long playerId;
    private String playerName;
    private int playerAge;
    private Long cityId;

    public StatisticPlayerModel() {}

    public StatisticPlayerModel(ResultSet rs) throws SQLException {
        setPlayerId(rs.getLong(1));
        setPlayerName(rs.getString(2));
        setPlayerAge(rs.getInt(3));
        setCityId(rs.getLong(4));

    }
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public int getPlayerAge(){
        return playerAge;
    }

    public void setPlayerAge(int playerAge){
        this.playerAge = playerAge;
    }

    public Long getCityId(){
        return cityId;
    }

    public void setCityId(Long cityId){
        this.cityId = cityId;
    }

    public String getCityName(){
        try {
            DB db = new DB("test", "dev", "dev");
            db.connectToDB();
            String query = "select city from city_lib where id = " + getCityId() + ";";
            ResultSet rs = db.getResultExecuteQuery(query);
            if(rs.next()){
                String cityName = rs.getString(1);
                return cityName;
            }
            return null;
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public String toString(){
        //return playerId + " " + playerName + " " + playerAge + " " + cityId;
        return playerName + " " + " " + playerAge + " " + cityId;
    }




    public int compareTo(Object obj) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }

}*/
