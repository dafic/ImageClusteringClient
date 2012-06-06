/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imageclustering.client;

import com.imageclustering.client.conf.GrailsConfiguration;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

/**
 *
 * @author bhanu
 */
public class HBaseSchema {

    public static void createTable() throws IOException {
        Configuration config = GrailsConfiguration.getConfig();
        if(config == null){
            System.out.println("config null");
        }
        HTable table = new HTable(config, Bytes.toBytes("student"));
        String colFam1 = "info";
        String colFam2 = "father";
        Put put = new Put("1".getBytes());
        put.add(colFam1.getBytes(), "name".getBytes(), "pradip".getBytes());
        put.add(colFam2.getBytes(), "name".getBytes(), "narayan".getBytes());
        table.put(put);
    }

    public static boolean createHBaseTable(String tablename, List<String> colFamily) {
        Configuration conf = GrailsConfiguration.getConfig();
        //conf.set("hbase.master", "127.0.0.1:60000");
        try {
            HBaseAdmin hbase = new HBaseAdmin(conf);
            HTableDescriptor desc = new HTableDescriptor(tablename);
            for (String cf : colFamily) {
                HColumnDescriptor hcd = new HColumnDescriptor(cf.getBytes());
                desc.addFamily(hcd);
            }
            hbase.createTable(desc);
        } catch (Exception e) {
            System.out.println("error creating table:" + tablename + "\n" + e);
            return false;
        }
        return true;
    }

    public static boolean createHBaseTable1() {
        Configuration conf = GrailsConfiguration.getConfig();
        String tablename = "abc";
        List<String> colFamily = new ArrayList<String>();
        colFamily.add("Image");
        colFamily.add("info");
        //conf.set("hbase.master", "127.0.0.1:60000");
        try {
            HBaseAdmin hbase = new HBaseAdmin(conf);
            HTableDescriptor desc = new HTableDescriptor(tablename);
            for (String cf : colFamily) {
                HColumnDescriptor hcd = new HColumnDescriptor(cf.getBytes());
                desc.addFamily(hcd);
            }
            hbase.createTable(desc);
        } catch (Exception e) {
            System.out.println("error creating table:" + tablename + "\n" + e);
            return false;
        }
        return true;
    }
}
