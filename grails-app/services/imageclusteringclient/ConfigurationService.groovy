package imageclusteringclient
import org.apache.hadoop.conf.*
import org.apache.hadoop.hbase.*
import org.apache.hadoop.hbase.client.*


class ConfigurationService {

    private static Configuration getConfig() {
        Configuration hbaseConfig = HBaseConfiguration.create();
        final String configLocation = "Resources/hbase-conf/";
        String[] configOverrides = ["core-site.xml", "hdfs-site.xml", "hbase-site.xml"];
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
