package imageclusteringclient
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class GetGMMController {

    def index() {
        def result = [:] 
        GetGMMService ggs = new GetGMMService()
        result = ggs.getHBase()
//        List li=new ArrayList();
//        li.add("item1")
//        li.add("item2")
//        li.add("item3")
        if(result!=null){
            for(BufferedImage bi:result){
            
            ImageIO.write(bi, "jpg", response.outputStream);
            //            response.setHeader('Content-length', result.length)
            //            response.contentType = 'image/jpg' // or the appropriate image content type
            //            response.outputStream << result
            //            response.outputStream.flush()
            }
        }
        else{
            render "error reading file"
        }
        render "FUCK"
       
    }
}
