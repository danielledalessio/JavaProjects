/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import inputOutput.ConnectionData;
import inputOutput.XmlParser;
import java.sql.Connection;

/**
 *
 * @author danielledalessio
 */
public class Database {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //read in database and pass the location of XML file as argument
        XmlParser xml = new XmlParser("inputOutput/properties.xml");
        ConnectionData data = xml.getConnectionData();
    
        //create the connection using data from XML file
        PostgreSQLConnect connect = new PostgreSQLConnect(data);
        Connection dbConnect = connect.getConnection();
    }   
}
