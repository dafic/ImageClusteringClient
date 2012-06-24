package imageclusteringclient
import com.imageclustering.client.GetHBaseGMM
import org.apache.hadoop.conf.Configuration
import com.imageclustering.client.ClusterAccess
import com.imageclustering.client.ImageAccess
import com.imageclustering.client.conf.GrailsConfiguration

class ClusterInfoService {
    def tableName = "ClusterDatabase"
    
    def getClusterInfo() {
        def result = [:]
        ClusterAccess ca = new ClusterAccess()
        result = ca.scanCluster(tableName,GrailsConfiguration.getConfig())
        if(result){
            return result
        }
        else{
            return null
        }
    }
    
    def getImageList(String rowKey){
        ClusterAccess ca = new ClusterAccess()
        def listImage
        listImage = ca.getCluster(tableName,rowKey,GrailsConfiguration.getConfig())
        if(listImage){
            return listImage
        }
        else{
            return null
        }
    }
    
    def getImage(String rowKey){
        ImageAccess ia = new ImageAccess()
        def imageResult = ia.getImage("ImageDatabase",rowKey,GrailsConfiguration.getConfig())
        if(imageResult){
            return imageResult
        }
        else
        return null
    }
}
