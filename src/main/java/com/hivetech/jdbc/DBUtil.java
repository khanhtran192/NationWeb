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
    private static String INSERT_REGION = "INSERT INTO regions ( name, continent_id) VALUES( ?, ?);";
    private static String DELETE_REGION = "DELETE FROM regions WHERE region_id = ?;";

    public DBUtil() {
    }

    public void insertRegion(Region region){
        Connection connection = mysqlConnec.getConnection();
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_REGION)) {
//            preparedStatement1.setString(1, String.valueOf(region.getRegionID()));
            preparedStatement1.setString(1, region.getName());
            preparedStatement1.setString(2, String.valueOf(region.getContinentID()));
            preparedStatement1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Region> selectAll(){
//        Region region = new Region();
        List<Region> regions = new ArrayList<>();
        Connection connection = mysqlConnec.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REGION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int regionID = resultSet.getInt("region_id");
                String name = resultSet.getString("name");
                int continentID = resultSet.getInt("continent_id");
                regions.add(new Region(regionID, name, continentID));

//                region.setRegionID(resultSet.getInt("region_id"));
//                region.setName(resultSet.getString("name"));
//                region.setContinentID(resultSet.getInt("continent_id"));
//                regions.add(region);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regions;
    }

    public boolean deleteRegion(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection = mysqlConnec.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_REGION);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

}
