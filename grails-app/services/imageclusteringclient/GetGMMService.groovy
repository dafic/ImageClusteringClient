package imageclusteringclient
import com.imageclustering.client.GetHBaseGMM;

class GetGMMService {

    def getHBase() {
        GetHBaseGMM ghg = new GetHBaseGMM()
        ghg.getGMM()
    }
}
