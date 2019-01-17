package ironpumper.utility;

import java.sql.*;

public class DataUtility {

    public static int extractData(String data) throws SQLException {
        int returnData =-1;

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ironpumper", "kanedu", "kanedu");
            PreparedStatement getData = con.prepareStatement("SELECT ID,"+ data +" FROM playerdata");
            ResultSet getDataRS = getData.executeQuery();
            while(getDataRS.next()){
                returnData = getDataRS.getInt(data);
            }
            getData.close();

        return returnData;
    }
    public static void updateData(String data, int value) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ironpumper", "kanedu", "kanedu");
        PreparedStatement addStrength = con.prepareStatement("UPDATE playerData SET "+data+" = "+value+" WHERE ID = 1");
        addStrength.execute();
        addStrength.close();
    }


}
