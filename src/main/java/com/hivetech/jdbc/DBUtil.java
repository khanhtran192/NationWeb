package com.hivetech.jdbc;

import com.hivetech.model.Region;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    static MySQLConnection mysqlConnec = new MySQLConnection();
    private static String SELECT_REGION = "SELECT * FROM regions;";
    private static String UPDATE_REGION = "UPDATE regions SET  name= ?, continent_id =? WHERE region_id = ?;";
    private static String INSERT_REGION = "INSERT INTO regions ( name, continent_id) VALUES( ?, ?);";
    private static String DELETE_REGION = "DELETE FROM regions WHERE region_id = ?;";
    private static String SEARCH_BY_NAME = "SELECT * FROM regions WHERE name = ?;";



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

    public boolean updateRegion(Region region) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = mysqlConnec.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_REGION);) {
            statement.setString(1, region.getName());
            statement.setInt(2, region.getContinentID());;

            statement.setInt(3, region.getRegionID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<Region> showPag(int start,int total){
//        int start = 0;
//        int total = 0;
        List<Region> regions=new ArrayList<Region>();
        try{
            Connection connection = mysqlConnec.getConnection();
            PreparedStatement ps=connection.prepareStatement("select * from regions limit "+(start-1)+","+total);
            ResultSet resultSet=ps.executeQuery();
            while(resultSet.next()){

                int regionID = resultSet.getInt("region_id");
                String name = resultSet.getString("name");
                int continentID = resultSet.getInt("continent_id");
                regions.add(new Region(regionID, name, continentID));

            }
            connection.close();
        }catch(Exception e){System.out.println(e);}
        return regions;
    }


    public List<Region> searchRegion (String nameSearch){
        List<Region> list = new ArrayList<>();
        Connection connection = mysqlConnec.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, nameSearch);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int regionID = resultSet.getInt("region_id");
                String name = resultSet.getString("name");
                int continentID = resultSet.getInt("continent_id");
                list.add(new Region(regionID, name, continentID));

//                region.setRegionID(resultSet.getInt("region_id"));
//                region.setName(resultSet.getString("name"));
//                region.setContinentID(resultSet.getInt("continent_id"));
//                regions.add(region);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list ;


    }



}
