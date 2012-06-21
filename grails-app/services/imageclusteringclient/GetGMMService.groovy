package imageclusteringclient
import com.imageclustering.client.GetHBaseGMM;
import org.apache.hadoop.conf.Configuration;
import com.imageclustering.client.conf.GrailsConfiguration;

class GetGMMService {

    def getHBase() {
        
        def result = [:]
        GetHBaseGMM ghg = new GetHBaseGMM()
        result = ghg.scanTable("ImageDatabase",GrailsConfiguration.getConfig())
        //result = ghg.getGMM()
        if(result){
            return result
        }
        else{
            return null
        }
    }
}
