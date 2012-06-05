package imageclusteringclient
import org.apache.hadoop.conf.*
import org.apache.hadoop.hbase.*
import org.apache.hadoop.hbase.client.*

class DataFetchService {

    def HBaseSchema(){
        Configuration config = HBaseConfiguration.create()
        config.set("hbase.master", "127.0.0.1:60000")
        HTable table = new HTable(config, "student")
        def colFam1 = "info"
        def colFam2 = "father"
        Put put = new Put("1".getBytes())
        put.add(colFam1.getBytes(),"name".getBytes(),"pradip")
        put.add(colFam2.getBytes(),"name".getBytes(),"narayan")
        table.put(put)
    }
}
