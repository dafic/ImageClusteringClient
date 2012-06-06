package imageclusteringclient
import com.imageclustering.client.conf.GrailsConfiguration
import com.imageclustering.client.HBaseSchema
import org.apache.hadoop.conf.*
import org.apache.hadoop.hbase.*
import org.apache.hadoop.hbase.client.*

class DataFetchService {

    def createHBaseTable(){
        
        HBaseSchema.createTable()
    }
    def createImageDatabase(){
        def tableName="abc";
        def colFamily=["Image","ImageInfo"];
//        colFamily.add("Image");
//        colFamily.add("ImageInfo");
        
        HBaseSchema.createHBaseTable1();
    }   
}
