/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imageclustering.client.conf;

import java.net.URL;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HConnectionManager;

/**
 *
 * @author bhanu
 */
public class GrailsConfiguration {
    
    public static Configuration getConfig() {
        Configuration hbaseConfig = HBaseConfiguration.create();
        final String configLocation = "Resources/";
        String[] configOverrides = new String[]{"core-site.xml", "hdfs-site.xml", "hbase-site.xml"};
        for (String conf : configOverrides) {
            String file = configLocation + conf;
            URL resource = HConnectionManager.class.getClassLoader().getResource(file);
            if (resource == null) {
                System.out.println("using default configuration, not found cluster configuration for hbase");
            }
            if (resource != null) {
                System.out.println("loading resource: " + resource.toString());
                hbaseConfig.addResource(file);
            }
        }
        System.out.println("config parameters");
        System.out.println("hbase.zookeeper.quorum:" + hbaseConfig.get("hbase.zookeeper.quorum"));
        return hbaseConfig;
    }
    
}
