package com.hivetech.jdbc;

import com.hivetech.model.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    static MySQLConnection mysqlConnec = new MySQLConnection();
    private static String SELECT_REGION = "SELECT * FROM regions;";
    private static String SELECT_BY_NAME = "SELECT * FROM ? WHERE name = ?;";
    private static String INSERT_REGION = "INSERT INTO region (region_id, name, continent_id) VALUES(?, ?, ?);";
    private static String DELETE_REGION = "DELETE FROM Region WHERE Id = ?;";

    public DBUtil() {
    }

    public void insertRegion(Region region){
        Connection connection = mysqlConnec.getConnection();
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_REGION)) {
            preparedStatement1.setString(1, String.valueOf(region.getRegionID()));
            preparedStatement1.setString(2, region.getName());
            preparedStatement1.setString(3, String.valueOf(region.getContinentID()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Region> selectAll(){
        Region reigon = new Region();
        List<Region> regions = new ArrayList<>();
        Connection connection = mysqlConnec.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REGION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
//                int id = resultSet.getInt("region_id");
//                String name = resultSet.getString("name");
//                int continentID = resultSet.getInt("continent_id");
//
                reigon.setRegionID(resultSet.getInt("region_id"));
                reigon.setName(resultSet.getString("name"));
                reigon.setContinentID(resultSet.getInt("continent_id"));
                regions.add(reigon);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regions;
    }
}
