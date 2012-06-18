package imageclusteringclient
import com.imageclustering.client.conf.GrailsConfiguration
import org.apache.hadoop.conf.*
import org.apache.hadoop.hbase.*
import org.apache.hadoop.hbase.client.*

class ConfigurationController {

    def HBaseConfig(){
        Configuration config = GrailsConfiguration.getConfig()
        render "Configutarion Successful"
    }
}
