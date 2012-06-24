/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imageclustering.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

/**
 *
 * @author bhanu
 */
public class ClusterAccess {

    public Set<String> scanCluster(String tableName, Configuration config) throws IOException {

        Set<String> rowKey = new HashSet<String>();
        HTable table = new HTable(config, tableName);
        Scan scan = new Scan();
        ResultScanner rs = table.getScanner(scan);
        Result r = null;
        while ((r = rs.next()) != null) {
            for (KeyValue kv : r.list()) {
                String clusterInfo = Bytes.toString(kv.getRow());
                String[] imageName = (Bytes.toString(kv.getValue())).split(",");//kun chai columnFamily ko kun chai qualifier
                String result = (clusterInfo + "," + imageName[0]);
                rowKey.add(result);
            }
        }
        return rowKey;
    }

    public String getCluster(String tableName, String rowKey, Configuration config) throws IOException {
        //Set<String> imageList = new HashSet<String>();
        String imageSet = null;
        HTable table = new HTable(config, tableName);
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = table.get(get);
        for (KeyValue kv : result.list()) {
            imageSet = Bytes.toString(kv.getValue());
        }
        return imageSet;
    }
}
