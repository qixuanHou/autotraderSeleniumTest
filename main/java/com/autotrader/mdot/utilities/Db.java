package com.autotrader.mdot.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Joseph Cox modified Code off http://en.wikibooks.org/wiki/Java_JDBC_using_SQLite/Example_base_class

/**
 * Database connection class & utilities *
 */

public class Db {

    //~ Instance fields ------------------------------------------------------------------------------------------------

    private Connection conn = null;
    private int iTimeout = 30;

    private String sDriver = "";
    private String sDriverToLoad;
    private Statement statement = null;
    private String sUrl = null;
    private String sUrlToLoad;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * This will connect to the database
     *
     * @param sUrlToLoad in value
     * @param sDriverToLoad in value
     *
     * @throws Exception on error
     */
    public Db(String sUrlToLoad, String sDriverToLoad) throws Exception {
        this.sDriverToLoad = sDriverToLoad;
        this.sUrlToLoad = sUrlToLoad;
        init(sDriverToLoad, sUrlToLoad);
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    // Gets the connection to use in the class
    public Connection getConnection() {
        return conn;
    }

    public void setConnection() throws Exception {
        Class.forName(sDriver);
        conn = DriverManager.getConnection(sUrl);
    }

    // This will set the driver passed in from constructor to variable sDriver
    private void setDriver(String sDriverVar) {
        sDriver = sDriverVar;
    }

    public Statement getStatement() {
        return statement;
    }

    // Sets the timeout for the query and checks connection
    public void setStatement() throws Exception {
        if (conn == null) {
            setConnection();
        }
        statement = conn.createStatement();
        statement.setQueryTimeout(iTimeout); // set timeout to 30 sec.
    }

    // This will set the url passed in from constructor to variable sUrl
    private void setUrl(String sUrlVar) {
        sUrl = sUrlVar;
    }

    /**
     * CLoses the connection to the database
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception ignore) {
            ;
        }
    }

    /**
     * Returns a result set that contains the information queried.
     *
     * @param instruction in value
     *
     * @return out value
     *
     * @throws SQLException on error
     */
    public ResultSet executeQry(String instruction) throws SQLException {
        return statement.executeQuery(instruction);
    }

    /**
     * Executes the given statement. Use this for adds,deletes,and creates when no additional information will be needed
     * in return.
     *
     * @param instruction in value
     *
     * @throws SQLException on error
     */
    public void executeStmt(String instruction) throws SQLException {
        statement.executeUpdate(instruction);
    }

    /**
     * processes an array of instructions e.g. a set of SQL command strings passed from a file NB you should ensure you
     * either handle empty lines in files by either removing them or parsing them out since they will generate spurious
     * SQLExceptions when they are encountered during the iteration....
     *
     * @param instructionSet in value
     *
     * @throws SQLException on error
     */
    public void executeStmt(String[] instructionSet) throws SQLException {
        for (int i = 0; i < instructionSet.length; i++) {
            executeStmt(instructionSet[i]);
        }
    }

    /**
     * TODO: Enter Javadoc
     *
     * @param sDriverVar in value
     * @param sUrlVar in value
     *
     * @throws Exception on error
     */
    public void init(String sDriverVar, String sUrlVar) throws Exception {
        setDriver(sDriverVar);
        setUrl(sUrlVar);
        setConnection();
        setStatement();

        // Use for troubleshooting database connections
        // System.out.println("Your connected");
    }
}