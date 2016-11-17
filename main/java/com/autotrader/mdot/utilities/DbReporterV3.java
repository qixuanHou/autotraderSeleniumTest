package com.autotrader.mdot.utilities;

import org.testng.*;

import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import org.testng.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by josep on 12/11/2015.
 */
public class DbReporterV3 extends TestListenerAdapter implements ISuiteListener {

    String suiteTable = "trm_qa_1.SUITE";
    String testTable = "trm_qa_1.TEST";
    String methodTable = "trm_qa_1.METHODS";
    String stackTraceTable = "trm_qa_1.STACKTRACE";
    String paramTable = "trm_qa_1.PARAMETERS";
    String suiteStart;
    ArrayList<String> sqlArrayList =  new ArrayList();
    private Map<String, String> testParams;


    @Override
    public void onStart(ISuite iSuite) {

        Date suiteStartDate = new Date();
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.SSSSSS a");
        String dateFormatted = formatter.format(suiteStartDate);
        this.suiteStart = dateFormatted;


    }

    @Override
    public void onFinish(ISuite iSuite) {



        ArrayList<String> sqlStatements = new ArrayList<>();

        List<ITestContext> testClasses = getTestContexts();

        String SuiteSQL =
                "INSERT INTO " + suiteTable + " (suiteid,suitename,suitedate)"
                        + "Values (trm_qa_1.suiteid_sequence.NEXTVAL,'" + iSuite.getName() + "'," + "TO_TIMESTAMP ('" + suiteStart
                        + "','mm/dd/yyyy HH:MI:SS.FF AM')" + ")";

        sqlArrayList.add(SuiteSQL);

        for(int i = 0 ; i<getTestContexts().size();i++) {

            String TestSQL =
                    "INSERT INTO " + testTable + " (testid,testname,suite_suiteid_fk,teststartdate,testenddate)"
                            + "Values (trm_qa_1.testid_sequence.NEXTVAL,'" + getTestContexts().get(i).getName()
                            + "'," + "trm_qa_1.suiteid_sequence.CURRVAL" + "," + "TO_TIMESTAMP ('" + getFormattedDate(getTestContexts().get(i).getStartDate()) + "','mm/dd/yyyy HH:MI:SS.FF AM'),"
                            + "TO_TIMESTAMP ('" + getFormattedDate(getTestContexts().get(i).getEndDate()) + "','mm/dd/yyyy HH:MI:SS.FF AM'))";

            sqlArrayList.add(TestSQL);

            this.testParams = getTestContexts().get(i).getCurrentXmlTest().getTestParameters();
            if (testParams != null) {
                Iterator its = testParams.entrySet().iterator();
                while (its.hasNext()) {
                    Map.Entry pair = (Map.Entry) its.next();
                    String ParamSQL =
                            "INSERT INTO " + paramTable + " (paramid,paramname,paramvalue,test_testid_fk)"
                                    + "Values (trm_qa_1.paramid_sequence.NEXTVAL,'" + pair.getKey() + "','" + pair.getValue()
                                    + "',trm_qa_1.testid_sequence.CURRVAL)";

                    sqlArrayList.add(ParamSQL);
                    its.remove();
                }
            } else {

            }

            Set<ITestResult> passedTests = getTestContexts().get(i).getPassedTests().getAllResults();
            Set<ITestResult> failedTests = getTestContexts().get(i).getFailedTests().getAllResults();
            Set<ITestResult> skippedTests = getTestContexts().get(i).getSkippedTests().getAllResults();

            Iterator<ITestResult> passedTestsIterator = passedTests.iterator();
            Iterator<ITestResult> failedIterator = failedTests.iterator();
            Iterator<ITestResult> skippedTestsIterator = skippedTests.iterator();

            while (passedTestsIterator.hasNext()) {
                ITestResult currentResult = passedTestsIterator.next();
                sqlArrayList.add(buildMethodSql(currentResult.getName(),"Passed",calculateMethodTime(currentResult.getStartMillis(),currentResult.getEndMillis()),currentResult.getTestClass().getName(),methodTimeStamp(currentResult.getStartMillis())));

                passedTestsIterator.remove();
            }
            while (failedIterator.hasNext()) {
                ITestResult currentResult = failedIterator.next();
                sqlArrayList.add(buildMethodSql(currentResult.getName(),"Failed",calculateMethodTime(currentResult.getStartMillis(),currentResult.getEndMillis()),currentResult.getTestClass().getName(),methodTimeStamp(currentResult.getStartMillis())));
                sqlArrayList.add(buildStackTraceSql(currentResult.getThrowable() + ""));
                failedIterator.remove();
            }
            while (skippedTestsIterator.hasNext()) {
                ITestResult currentResult = skippedTestsIterator.next();
                sqlArrayList.add(buildMethodSql(currentResult.getName(),"Skipped",calculateMethodTime(currentResult.getStartMillis(),currentResult.getEndMillis()),currentResult.getTestClass().getName(),methodTimeStamp(currentResult.getStartMillis())));

                skippedTestsIterator.remove();
            }
        }

        try {
            insertIntoDB();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onFinish(ITestContext context)
    {

    }

    public String buildMethodSql(String methodName,String methodStatus,String methodTime,String className,String methodTimestamp)
    {
        String methodSQL =
                "INSERT INTO " + methodTable
                        + " (methodid,methodname,methodstatus,methodtime,test_testid_fk,classname,methodtimestamp)"
                        + "Values (trm_qa_1.methodid_sequence.NEXTVAL,'" + methodName + "','" + methodStatus
                        + "'," + methodTime + "," + "trm_qa_1.testid_sequence.CURRVAL,'" + className
                        + "'," + "TO_TIMESTAMP ('" + methodTimestamp + "','mm/dd/yyyy HH:MI:SS.FF AM'))";
        return  methodSQL;
    }

    public String buildStackTraceSql(String stackContent)
    {
        String stackTraceSql =
                "INSERT INTO " + stackTraceTable + " (stacktraceid,stackcontent,method_methodid_fk)"
                        + "Values (trm_qa_1.stacktraceid_sequence.NEXTVAL,q'$" + stackContent
                        + "$',trm_qa_1.methodid_sequence.CURRVAL)";
        return stackTraceSql;
    }

    public String calculateMethodTime(long startTime,long endTime)
    {

        String time =((double) (endTime - startTime)) / 1000 + "";

        return time;
    }

    public String methodTimeStamp(long startTime)
    {
        Date date = new Date(startTime);
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.SSSSSS a");
        String dateFormatted = formatter.format(date);
        return dateFormatted;
    }

    public void insertIntoDB() throws Exception {

//        Db db = new Db("jdbc:oracle:thin:JoeAfter/admin@localhost:1521:xe", "oracle.jdbc.driver.OracleDriver");
        Db db = new Db("jdbc:oracle:thin:qatool/aut0mati0n@qadbtd:1521:qatd", "oracle.jdbc.driver.OracleDriver");
        Connection connection = db.getConnection();
        Statement stmt = connection.createStatement();
        connection.setAutoCommit(false);


        for(String s: sqlArrayList)
        {
            stmt.addBatch(s);
//            System.out.println(s);
        }


        int[] count = stmt.executeBatch();
        connection.commit();
        db.closeConnection();

    }

    public String getFormattedDate(Date date)
    {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss.SSSSSS a");
        String dateFormatted = formatter.format(date);

        return dateFormatted;
    }

}
