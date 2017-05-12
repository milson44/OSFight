package DBModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.Locale;

/**
 * Created by milson on 05.04.17.
 */

public class StatisticCityModel implements Comparable{
    private Long cityId;
    private String cityName;

    public StatisticCityModel() {}

    public StatisticCityModel(ResultSet rs) throws SQLException{
        setCityId(rs.getLong(1));
        setCityName(rs.getString(2));
    }

    public void setCityId(Long cityId){
        this.cityId = cityId;
    }

    public Long getCityId(){
        return cityId;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public String getCityName(){
        return cityName;
    }

    public int compareTo(Object obj){
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }
}
