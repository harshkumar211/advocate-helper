//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package dbhelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHandler {
    private static final String path = "jdbc:derby:";
    private static final String user = "dilip";
    private static final String pass = "sdilip";
    private String dbName = "AdvocateDB";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst = null;
    private static DBHandler db = null;
    private String query = null;
    HashMap<String, List<String>> tableAndColumnsMap = new HashMap();

    private DBHandler() {
    }

    public Connection getConnection() {
        try {
            this.openConnection();
            return this.con;
        } catch (Exception var2) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var2);
            return null;
        }
    }

    public static DBHandler getInstance() {
        if (db == null) {
            db = new DBHandler();
        }

        return db;
    }

    private Connection openConnection() throws Exception {
        if (this.isSet()) {
            String dbPath = "jdbc:derby:" + this.dbName + ";create=true";
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            this.con = DriverManager.getConnection(dbPath, "harsh", "sharsh");
            this.con.setAutoCommit(false);
            return this.con;
        } else {
            return null;
        }
    }

    private boolean closeConnection() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }

            if (this.pst != null) {
                this.pst.close();
            }

            if (this.con != null) {
                this.con.close();
            }

            return true;
        } catch (Exception var2) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, var2.getMessage(), var2);
            return false;
        }
    }

    boolean isSet() {
        return "jdbc:derby:" != null && "dilip" != null && "sdilip" != null && this.dbName != null;
    }

    public boolean insert(Object obj) {
        boolean res = false;
        String sql = "";

        boolean var4;
        try {
            if (obj != null) {
                String table = obj.getClass().getName().replace("dbhelper.", "");
                HashMap<String, Object> values = this.ContentValueCreator(obj);
                this.openConnection();
                sql = "INSERT INTO \"" + table + "\"(";
                String[] columns = (String[])values.keySet().toArray(new String[values.size()]);
                sql = sql + Arrays.toString(columns).replace("[", "").replace("]", "") + ") values(";
                Object[] vals = values.values().toArray();

                int i;
                for(i = 0; i < columns.length; ++i) {
                    sql = sql + "?,";
                }

                sql = sql.substring(0, sql.length() - 1);
                sql = sql + ")";
                System.out.println("SQL:" + sql);
                this.pst = this.con.prepareStatement(sql);

                for(i = 0; i < vals.length; ++i) {
                    this.pst.setObject(i + 1, vals[i]);
                }

                res = this.pst.execute();
                this.con.commit();
                return res;
            }

            var4 = false;
        } catch (Exception var12) {
            System.out.println("Query:" + sql);
            var12.printStackTrace();
            System.out.println("Error : " + var12.getMessage());
            return res;
        } finally {
            this.closeConnection();
        }

        return var4;
    }

    public boolean update(Object obj) {
        boolean res = false;

        boolean var3;
        try {
            if (obj != null) {
                String table = obj.getClass().getName().replace("dbhelper.", "");
                HashMap<String, Object> values = this.ContentValueCreator(obj);
                HashMap<String, Object> where = new HashMap();
                where.put("Id", obj.getClass().getMethod("getId", (Class[])null).invoke(obj, (Object[])null));
                this.openConnection();
                String sql = "UPDATE \"" + table + "\" SET ";
                String[] columns = (String[])values.keySet().toArray(new String[values.size()]);
                Object[] vals = values.values().toArray();

                for(int i = 0; i < columns.length; ++i) {
                    sql = sql + columns[i] + "=?,";
                }

                sql = sql.substring(0, sql.length() - 1);
                sql = sql + " WHERE ";
                String[] columnsWhere = (String[])where.keySet().toArray(new String[where.size()]);
                Object[] valsWhere = where.values().toArray();

                int i;
                for(i = 0; i < columnsWhere.length; ++i) {
                    sql = sql + columnsWhere[i] + "=? and";
                }

                sql = sql.substring(0, sql.length() - 4);
                sql = sql + "";
                System.out.println(sql);
                this.pst = this.con.prepareStatement(sql);

                for(i = 0; i < vals.length; ++i) {
                    this.pst.setObject(i + 1, vals[i]);
                }

                for(i = 0; i < valsWhere.length; ++i) {
                    this.pst.setObject(vals.length + i + 1, valsWhere[i]);
                }

                res = this.pst.execute();
                this.con.commit();
                return res;
            }

            var3 = false;
        } catch (Exception var15) {
            var15.printStackTrace();
            System.out.println("Error : " + var15.getMessage());
            return res;
        } finally {
            this.closeConnection();
        }

        return var3;
    }

    public ArrayList<SearchMaster> fetchSearchMasterRecords(String sno) {
        ArrayList<SearchMaster> masters = null;
        SearchMaster obj = null;
        this.rs = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("select * from \"SearchMaster\" where \"Sno\"=? order by \"Id\" asc");
            this.pst.setObject(1, sno);
            this.rs = this.pst.executeQuery();
            ArrayList<String> columns = new ArrayList();
            Method[] declaredMethods = SearchMaster.class.getDeclaredMethods();
            HashMap<String, Method> methods = new HashMap();
            Method[] var7 = declaredMethods;
            int var8 = declaredMethods.length;

            Method value;
            for(int var9 = 0; var9 < var8; ++var9) {
                value = var7[var9];
                String column = value.getName();
                if (column.startsWith("set")) {
                    columns.add(column.replace("set", ""));
                    methods.put(column.replace("set", ""), value);
                }
            }

            for(masters = new ArrayList(); this.rs.next(); masters.add(obj)) {
                obj = new SearchMaster();
                Iterator var17 = methods.entrySet().iterator();

                while(var17.hasNext()) {
                    Entry<String, Method> entry = (Entry)var17.next();
                    String key = (String)entry.getKey();
                    value = (Method)entry.getValue();
                    if (!key.equals("ApplicantInfo")) {
                        value.invoke(obj, this.rs.getObject(key));
                    }
                }

                ArrayList<ApplicantInfo> fetchApplicantInfoRecords = this.fetchApplicantInfoRecords("" + obj.getSno());
                if (fetchApplicantInfoRecords.size() > 0) {
                    ApplicantInfo applicantInfo = (ApplicantInfo)fetchApplicantInfoRecords.get(0);
                    obj.setApplicantInfo(applicantInfo);
                }
            }

            this.con.commit();
        } catch (Exception var15) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var15);
        } finally {
            this.closeConnection();
        }

        return masters;
    }

    public ArrayList<ApplicantInfo> fetchApplicantInfoRecords(String sno) {
        ArrayList<ApplicantInfo> masters = null;
        ApplicantInfo obj = null;
        this.rs = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("select * from \"ApplicantInfo\" where \"Sno\"=? order by \"Id\" asc");
            this.pst.setObject(1, sno);
            this.rs = this.pst.executeQuery();
            ArrayList<String> columns = new ArrayList();
            Method[] declaredMethods = ApplicantInfo.class.getDeclaredMethods();
            HashMap<String, Method> methods = new HashMap();
            Method[] var7 = declaredMethods;
            int var8 = declaredMethods.length;

            Method value;
            for(int var9 = 0; var9 < var8; ++var9) {
                value = var7[var9];
                String column = value.getName();
                if (column.startsWith("set")) {
                    columns.add(column.replace("set", ""));
                    methods.put(column.replace("set", ""), value);
                }
            }

            masters = new ArrayList();

            while(this.rs.next()) {
                obj = new ApplicantInfo();
                Iterator var13 = methods.entrySet().iterator();

                while(var13.hasNext()) {
                    Entry<String, Method> entry = (Entry)var13.next();
                    String key = (String)entry.getKey();
                    value = (Method)entry.getValue();
                    if (!key.equals("Properties") && !key.equals("ChannelHistories") && !key.equals("DocumentLists") && !key.equals("AabadiProperty")) {
                        value.invoke(obj, this.rs.getObject(key));
                    }
                }

                ArrayList<Property> properties = this.fetchPropertyRecords("" + obj.getSno());
                obj.setProperties(properties);
                ArrayList<ChannelHistory> channelHistories = this.fetchChannelHistoryRecords("" + obj.getSno());
                obj.setChannelHistories(channelHistories);
                ArrayList<AabadiProperty> aabadiProperty = this.fetchAabadiPropertyRecords("" + obj.getSno());
                obj.setAabadiProperty(aabadiProperty.size() > 0 ? (AabadiProperty)aabadiProperty.get(0) : null);
                ArrayList<DocumentList> documentLists = this.fetchDocumentListRecords("" + obj.getSno());
                obj.setDocumentLists(documentLists);
                masters.add(obj);
            }
        } catch (Exception var12) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var12);
        }

        return masters;
    }

    public ArrayList<Property> fetchPropertyRecords(String sno) {
        ArrayList<Property> masters = null;
        Property obj = null;
        ResultSet rs = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("select * from \"Property\" where \"Sno\"=? order by \"Id\" asc");
            System.out.println("select * from \"Property\" where \"Sno\"=? order by \"Id\" asc");
            System.out.println("" + sno);
            this.pst.setObject(1, sno);
            rs = this.pst.executeQuery();
            ArrayList<String> columns = new ArrayList();
            Method[] declaredMethods = Property.class.getDeclaredMethods();
            HashMap<String, Method> methods = new HashMap();
            Method[] var8 = declaredMethods;
            int var9 = declaredMethods.length;

            Method value;
            for(int var10 = 0; var10 < var9; ++var10) {
                value = var8[var10];
                String column = value.getName();
                if (column.startsWith("set")) {
                    columns.add(column.replace("set", ""));
                    methods.put(column.replace("set", ""), value);
                }
            }

            masters = new ArrayList();

            while(rs.next()) {
                obj = new Property();
                Iterator var23 = methods.entrySet().iterator();

                while(var23.hasNext()) {
                    Entry<String, Method> entry = (Entry)var23.next();
                    String key = (String)entry.getKey();
                    value = (Method)entry.getValue();
                    value.invoke(obj, rs.getObject(key));
                }

                masters.add(obj);
            }
        } catch (Exception var21) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var21);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException var20) {
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var20);
                }
            }

        }

        return masters;
    }

    public ArrayList<ChannelHistory> fetchChannelHistoryRecords(String sno) {
        ArrayList<ChannelHistory> masters = null;
        ChannelHistory obj = null;
        ResultSet rs = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("select * from \"ChannelHistory\" where \"Sno\"=? order by \"Id\" asc");
            this.pst.setObject(1, sno);
            rs = this.pst.executeQuery();
            ArrayList<String> columns = new ArrayList();
            Method[] declaredMethods = ChannelHistory.class.getDeclaredMethods();
            HashMap<String, Method> methods = new HashMap();
            Method[] var8 = declaredMethods;
            int var9 = declaredMethods.length;

            Method value;
            for(int var10 = 0; var10 < var9; ++var10) {
                value = var8[var10];
                String column = value.getName();
                if (column.startsWith("set")) {
                    columns.add(column.replace("set", ""));
                    methods.put(column.replace("set", ""), value);
                }
            }

            masters = new ArrayList();

            while(rs.next()) {
                obj = new ChannelHistory();
                Iterator var23 = methods.entrySet().iterator();

                while(var23.hasNext()) {
                    Entry<String, Method> entry = (Entry)var23.next();
                    String key = (String)entry.getKey();
                    value = (Method)entry.getValue();
                    value.invoke(obj, rs.getObject(key));
                }

                masters.add(obj);
            }
        } catch (Exception var21) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var21);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException var20) {
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var20);
                }
            }

        }

        return masters;
    }

    public ArrayList<AabadiProperty> fetchAabadiPropertyRecords(String sno) {
        ArrayList<AabadiProperty> masters = null;
        AabadiProperty obj = null;
        ResultSet rs = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("select * from \"AabadiProperty\" where \"Sno\"=? order by \"Id\" asc");
            this.pst.setObject(1, sno);
            rs = this.pst.executeQuery();
            ArrayList<String> columns = new ArrayList();
            Method[] declaredMethods = AabadiProperty.class.getDeclaredMethods();
            HashMap<String, Method> methods = new HashMap();
            Method[] var8 = declaredMethods;
            int var9 = declaredMethods.length;

            Method value;
            for(int var10 = 0; var10 < var9; ++var10) {
                value = var8[var10];
                String column = value.getName();
                if (column.startsWith("set")) {
                    columns.add(column.replace("set", ""));
                    methods.put(column.replace("set", ""), value);
                }
            }

            masters = new ArrayList();

            while(rs.next()) {
                obj = new AabadiProperty();
                Iterator var23 = methods.entrySet().iterator();

                while(var23.hasNext()) {
                    Entry<String, Method> entry = (Entry)var23.next();
                    String key = (String)entry.getKey();
                    value = (Method)entry.getValue();
                    value.invoke(obj, rs.getObject(key));
                }

                masters.add(obj);
            }
        } catch (Exception var21) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var21);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException var20) {
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var20);
                }
            }

        }

        return masters;
    }

    public ArrayList<DocumentList> fetchDocumentListRecords(String sno) {
        ArrayList<DocumentList> masters = null;
        DocumentList obj = null;
        ResultSet rs = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("select * from \"DocumentList\" where \"Sno\"=? order by \"Id\" asc");
            this.pst.setObject(1, sno);
            rs = this.pst.executeQuery();
            ArrayList<String> columns = new ArrayList();
            Method[] declaredMethods = DocumentList.class.getDeclaredMethods();
            HashMap<String, Method> methods = new HashMap();
            Method[] var8 = declaredMethods;
            int var9 = declaredMethods.length;

            Method value;
            for(int var10 = 0; var10 < var9; ++var10) {
                value = var8[var10];
                String column = value.getName();
                if (column.startsWith("set")) {
                    columns.add(column.replace("set", ""));
                    methods.put(column.replace("set", ""), value);
                }
            }

            masters = new ArrayList();

            while(rs.next()) {
                obj = new DocumentList();
                Iterator var23 = methods.entrySet().iterator();

                while(var23.hasNext()) {
                    Entry<String, Method> entry = (Entry)var23.next();
                    String key = (String)entry.getKey();
                    value = (Method)entry.getValue();
                    value.invoke(obj, rs.getObject(key));
                }

                masters.add(obj);
            }
        } catch (Exception var21) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var21);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException var20) {
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var20);
                }
            }

        }

        return masters;
    }

    public ArrayList<SearchResult> searchRecords(SearchResult sr) {
        ArrayList<SearchResult> masters = null;
        SearchResult obj = null;
        ResultSet rs = null;

        try {
            this.openConnection();
            String name = sr.getName();
            String adv = sr.getAdvocate();
            String bank = sr.getBank();
            String branch = sr.getBranch();
            String date = sr.getDateOfSearch();
            String refno = sr.getRefNo();
            String khasra = sr.getKhasraNo();
            String village = sr.getVillage();
            String sql = "select \"SearchMaster\".\"Sno\",\n\"SearchMaster\".\"SearchCategory\",\n        \"ApplicantInfo\".\"Name\",\n        \"ApplicantInfo\".\"Fh\",\n        \"ApplicantInfo\".\"FhName\",\n        \"Property\".\"KhasraNo\",\n        \"Property\".\"Village\",\n        \"SearchMaster\".\"DateOfSearch\",\n        \"SearchMaster\".\"RefNo\",\n        \"SearchMaster\".\"Advocate\",\n        \"SearchMaster\".\"Bank\",\n        \"SearchMaster\".\"Branch\" from \"SearchMaster\", \"ApplicantInfo\", \"Property\" \nwhere (\"SearchMaster\".\"Sno\"=\"Property\".\"Sno\" \nand \"Property\".\"Sno\"=\"ApplicantInfo\".\"Sno\") \nand (\n    LOWER(\"ApplicantInfo\".\"Name\") like('%" + name + "%') \n" + "    and LOWER(\"SearchMaster\".\"Advocate\") like ('%" + adv + "%') \n" + "    and LOWER(\"SearchMaster\".\"Bank\") like ('%" + bank + "%') \n" + "    and LOWER(\"SearchMaster\".\"Branch\") like ('%" + branch + "%')\n" + "    and LOWER(\"SearchMaster\".\"DateOfSearch\") like ('%" + date + "%')\n" + "    and LOWER(\"SearchMaster\".\"RefNo\") like ('%" + refno + "%')\n" + "    and LOWER(\"Property\".\"KhasraNo\") like ('%" + khasra + "%')\n" + "    and LOWER(\"Property\".\"Village\") like ('%" + village + "%') \n" + ") order by \"SearchMaster\".\"Sno\" desc";
            this.pst = this.con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            ArrayList<String> columns = new ArrayList();
            Method[] declaredMethods = SearchResult.class.getDeclaredMethods();
            HashMap<String, Method> methods = new HashMap();
            Method[] var17 = declaredMethods;
            int var18 = declaredMethods.length;

            Method value;
            for(int var19 = 0; var19 < var18; ++var19) {
                value = var17[var19];
                String column = value.getName();
                if (column.startsWith("set")) {
                    columns.add(column.replace("set", ""));
                    methods.put(column.replace("set", ""), value);
                }
            }

            masters = new ArrayList();

            while(rs.next()) {
                obj = new SearchResult();
                Iterator var32 = methods.entrySet().iterator();

                while(var32.hasNext()) {
                    Entry<String, Method> entry = (Entry)var32.next();
                    String key = (String)entry.getKey();
                    value = (Method)entry.getValue();
                    value.invoke(obj, rs.getObject(key));
                }

                masters.add(obj);
            }
        } catch (Exception var30) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var30);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException var29) {
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var29);
                }
            }

        }

        return masters;
    }

    public int fetchMaxNumber() {
        Integer number = null;
        this.rs = null;

        try {
            this.openConnection();
            String sql = "";
            sql = "select max(\"Sno\") from \"SearchMaster\"";
            this.pst = this.con.prepareStatement(sql);
            this.pst.execute();

            for(this.rs = this.pst.getResultSet(); this.rs.next(); number = this.rs.getInt(1)) {
                ;
            }

            this.con.commit();
        } catch (Exception var6) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var6);
        } finally {
            this.closeConnection();
        }

        return number;
    }

    public boolean updateWithSNO(String sno) {
        boolean res = false;

        try {
            this.openConnection();
            String sql = "UPDATE \"SearchMaster\" SET \"Sno\"=-" + sno + " WHERE \"Sno\"=" + sno;
            this.pst = this.con.prepareStatement(sql);
            System.out.println("SearchMaster Rows updated " + this.pst.executeUpdate());
            sql = "UPDATE \"ApplicantInfo\" SET \"Sno\"=-" + sno + " WHERE \"Sno\"=" + sno;
            this.pst = this.con.prepareStatement(sql);
            System.out.println("ApplicantInfo Rows updated " + this.pst.executeUpdate());
            sql = "UPDATE \"Property\" SET \"Sno\"=-" + sno + " WHERE \"Sno\"=" + sno;
            this.pst = this.con.prepareStatement(sql);
            System.out.println("Property Rows updated " + this.pst.executeUpdate());
            sql = "UPDATE \"ChannelHistory\" SET \"Sno\"=-" + sno + " WHERE \"Sno\"=" + sno;
            this.pst = this.con.prepareStatement(sql);
            System.out.println("ChannelHistory Rows updated " + this.pst.executeUpdate());
            sql = "UPDATE \"AabadiProperty\" SET \"Sno\"=-" + sno + " WHERE \"Sno\"=" + sno;
            this.pst = this.con.prepareStatement(sql);
            System.out.println("AabadiProperty Rows updated " + this.pst.executeUpdate());
            sql = "UPDATE \"DocumentList\" SET \"Sno\"=-" + sno + " WHERE \"Sno\"=" + sno;
            this.pst = this.con.prepareStatement(sql);
            System.out.println("DocumentList Rows updated " + this.pst.executeUpdate());
            res = true;
            this.con.commit();
        } catch (Exception var7) {
            var7.printStackTrace();
            System.out.println("Error : " + var7.getMessage());
        } finally {
            this.closeConnection();
        }

        return res;
    }

    public HashMap<String, Object> ContentValueCreator(Object object) {
        HashMap<String, Object> cv = new HashMap();
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        Method[] var4 = declaredMethods;
        int var5 = declaredMethods.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Method method = var4[var6];
            String methodName = method.getName();
            if (methodName.startsWith("get") && !methodName.equals("getId") && !methodName.equals("getApplicantInfo") && !methodName.equals("getAabadiProperty") && !method.getReturnType().getName().equals("java.util.ArrayList")) {
                String columnName = methodName.replace("get", "");
                Object columnValue = null;

                try {
                    columnValue = method.invoke(object, (Object[])null);
                } catch (Exception var12) {
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, (String)null, var12);
                }

                cv.put("\"" + columnName + "\"", columnValue);
            }
        }

        return cv;
    }

    public boolean isValidLogin() {
        boolean valid = false;
        ResultSet rs = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("select * from \"Login\" where \"Sno\"=1 and \"HDDSNO\"=?");
            this.pst.setString(1, getHDDAddress());
            rs = this.pst.executeQuery();
            if (rs.next()) {
                valid = true;
            } else {
                valid = false;
            }

            this.con.commit();
        } catch (Exception var7) {
            System.out.println("Error : " + var7);
            var7.printStackTrace();
        } finally {
            this.closeConnection();
        }

        return valid;
    }

    void createTableLogin() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("create table \"Login\"(\"Sno\" INTEGER,\"HDDSNO\" VARCHAR(100))");
            System.out.println("Update : " + this.pst.executeUpdate());
            this.pst = this.con.prepareStatement("insert into \"Login\"(\"Sno\",\"HDDSNO\") values(1,?)");
            this.pst.setString(1, getHDDAddress());
            this.pst.executeUpdate();
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    public void createLogin() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("insert into \"Login\"(\"Sno\",\"HDDSNO\") values(1,?)");
            this.pst.setString(1, getHDDAddress());
            this.pst.executeUpdate();
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    void createTableDocumentList() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("create table \"DocumentList\"\n(\n\"Id\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n\"Sno\" INTEGER,\n\"DocumentName\" VARCHAR(1000),\n\"IssuedBy\" VARCHAR(200),\n\"Date\" VARCHAR(100),\n\"IssuedTo\" VARCHAR(200),\n\"IssuedToCaption\" VARCHAR(100),\n\"IssuedByCaption\" VARCHAR(100),\n\"DocumentNumber\" VARCHAR(100),\n\"Samwat\" VARCHAR(100),\n\"Required\" VARCHAR(50)\n)");
            System.out.println("Update : " + this.pst.executeUpdate());
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    void createTableSearchMaster() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("create table \"SearchMaster\"\n(\n\"Id\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n\"Sno\" INTEGER,\n\"RefNo\" VARCHAR(20),\n\"DateOfSearch\" VARCHAR(20),\n\"Advocate\" VARCHAR(30),\n\"Bank\" VARCHAR(50),\n\"Branch\" VARCHAR(30),\n\"SubRegistrar\" VARCHAR(300),\n\"SearchType\" VARCHAR(20),\n\"MortgagedWith\" VARCHAR(20),\n\"MortgagedBank\" VARCHAR(100),\n\"MortgagedBranch\" VARCHAR(100),\n\"SearchPeriod\" VARCHAR(20),\n\"Flag\" VARCHAR(20),\n\"Remark\" VARCHAR(200),\n\"SearchCategory\" VARCHAR(20)\n)");
            System.out.println("Update : " + this.pst.executeUpdate());
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    void createTableApplicantInfo() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("create table \"ApplicantInfo\"\n(\n\"Id\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n\"Sno\" INTEGER,\n\"Name\" VARCHAR(200),\n\"Fh\" VARCHAR(20),\n\"FhName\" VARCHAR(200),\n\"SirName\" VARCHAR(30),\n\"Address\" VARCHAR(100),\n\"Age\" VARCHAR(10)\n)");
            System.out.println("Update : " + this.pst.executeUpdate());
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    void createTableChannelHistory() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("create table \"ChannelHistory\"\n(\n\"Id\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n\"Sno\" INTEGER,\n\"Psno\" INTEGER,\n\"Name\" VARCHAR(2000),\n\"DeedDate\" VARCHAR(500),\n\"Nature\" VARCHAR(200),\n\"Khasra\" VARCHAR(1000),\n\"Size\" VARCHAR(1000)\n)");
            System.out.println("Update : " + this.pst.executeUpdate());
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    void createTableProperty() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("create table \"Property\"\n(\n\"Id\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n\"Sno\" INTEGER,\n\"Psno\" INTEGER,\n\"HeldBy\" VARCHAR(20),\n\"Village\" VARCHAR(50),\n\"Tehsil\" VARCHAR(50),\n\"District\" VARCHAR(50),\n\"State\" VARCHAR(50),\n\"KhataNo\" VARCHAR(50),\n\"KhasraNo\" VARCHAR(200),\n\"Size\" VARCHAR(200),\n\"LandType\" VARCHAR(20),\n\"Jamabandi\" VARCHAR(100),\n\"Girdawari\" VARCHAR(100),\n\"Tldate\" VARCHAR(20),\n\"Owner\" VARCHAR(20),\n\"Share\" VARCHAR(20),\n\"Chain\" VARCHAR(5000),\n\"PatwariVillage\" VARCHAR(50),\n\"PatwariArea\" VARCHAR(50),\n\"Dlc\" DOUBLE,\n\"ShareCalculated\" DOUBLE\n)");
            System.out.println("Update : " + this.pst.executeUpdate());
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    void createTableAabadiProperty() {
        Object var1 = null;

        try {
            this.openConnection();
            this.pst = this.con.prepareStatement("create table \"AabadiProperty\"\n(\n\"Id\" INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),\n\"Sno\" INTEGER,\n\"Village\" VARCHAR(100),\n\"Tehsil\" VARCHAR(100),\n\"District\" VARCHAR(100),\n\"State\" VARCHAR(100),\n\"KhasraNo\" VARCHAR(100),\n\"PattaNo\" VARCHAR(100),\n\"MissalNo\" VARCHAR(100),\n\"BookNo\" VARCHAR(100),\n\"Size\" VARCHAR(100),\n\"East\" VARCHAR(100),\n\"West\" VARCHAR(100),\n\"North\" VARCHAR(100),\n\"South\" VARCHAR(100),\n\"ReceiptNumber\" VARCHAR(100),\n\"Dlc\" VARCHAR(100)\n)");
            System.out.println("Update : " + this.pst.executeUpdate());
            this.con.commit();
        } catch (Exception var6) {
            System.out.println("Error : " + var6);
            var6.printStackTrace();
        } finally {
            this.closeConnection();
        }

    }

    private void fillTableNameList() {
        ResultSet rs = null;
        ResultSet rsColumns = null;

        try {
            this.openConnection();
            this.tableAndColumnsMap = new HashMap();
            DatabaseMetaData metaData = this.con.getMetaData();
            rs = metaData.getTables("AdvocateDB", (String)null, "%", (String[])null);

            while(rs.next()) {
                String tableName = rs.getString(3);
                List<String> columns = new ArrayList();
                rsColumns = metaData.getColumns((String)null, (String)null, tableName, "%");

                while(rsColumns.next()) {
                    String column = rsColumns.getString(4);
                    columns.add(column);
                }

                this.tableAndColumnsMap.put(tableName, columns);
            }

            this.con.commit();
        } catch (Exception var15) {
            System.out.println("Error : " + var15);
            var15.printStackTrace();
        } finally {
            try {
                if (rsColumns != null) {
                    rsColumns.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception var14) {
                ;
            }

            this.closeConnection();
        }

    }

    private String getMACAddress() {
        String macAddr = null;

        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            System.out.print("Current MAC address : ");
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < mac.length; ++i) {
                sb.append(String.format("%02X%s", mac[i], i < mac.length - 1 ? "-" : ""));
            }

            System.out.println(sb.toString());
            macAddr = sb.toString();
        } catch (Exception var7) {
            var7.printStackTrace();
            macAddr = null;
        }

        return macAddr;
    }

    public static String getHDDAddress() throws IOException {
        String line = null;
        String serial = "";
        Process process = Runtime.getRuntime().exec("wmic diskdrive get serialnumber");

        BufferedReader in;
        for(in = new BufferedReader(new InputStreamReader(process.getInputStream())); in.readLine() != null; serial = serial + in.readLine()) {
            ;
        }

        in.close();
        return serial;
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Invalid Option, dont try to cheat");
        } else {
            DBHandler instance;
            if (args[0].equals("CTBLS")) {
                instance = getInstance();
                instance.createTableLogin();
                instance.createTableAabadiProperty();
                instance.createTableApplicantInfo();
                instance.createTableChannelHistory();
                instance.createTableDocumentList();
                instance.createTableProperty();
                instance.createTableSearchMaster();
                instance.fillTableNameList();
                instance.createLogin();
                System.out.println("Success..");
            } else if (args[0].equals("CLGN")) {
                instance = getInstance();
                instance.createLogin();
                System.out.println("Success..");
            } else {
                System.out.println("Invalid Option, dont try to cheat");
            }
        }

    }
}
