package imageclusteringclient
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

class ImageRenderController {
    
    def clusterInfoService
    
    def renderImage() {
        def imageName = params['id']
        def resultImage
        //render imageName
        //GetGMMService gg = new GetGMMService()
        //ClusterInfoService cis = new ClusterInfoService()
        resultImage = clusterInfoService.getImage(imageName)
        //resultImage = cis.getImage(imageName)
        //resultImage = gg.imageFetch(imageName)
        ImageIO.write(resultImage, "jpg", response.outputStream);
    }
    def renderAllImages(){
        //call a service to get result
    }
}
