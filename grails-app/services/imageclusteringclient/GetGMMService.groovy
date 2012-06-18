package imageclusteringclient
import com.imageclustering.client.GetHBaseGMM;

class GetGMMService {

    def getHBase() {
        def result;
        GetHBaseGMM ghg = new GetHBaseGMM()
        result = ghg.getGMM()
        if(result){
            return 1;
        }
        else{
            return 0;
        }
    }
}
