package imageclusteringclient

class ClusterInfoController {
        def clusterInfoService;//Create instance of service
    def getClusterInfo() {
        def result=[]
        //GetGMMService ggs = new GetGMMService()
        result = clusterInfoService.getClusterInfo()
        //result = ggs.getHBase()
        if(result!=null){
              render(view:'index',model:[obj1:result])
        }
        else{
            render "error reading file"
        }
    }
    
    def getImageList(){
        String rowKey = params['id']
        def imageList
        //GetGMMService ggs = new GetGMMService()
        imageList = clusterInfoService.getImageList(rowKey)
        if(imageList!=null){
             render(view:'drill',model:[obj2:imageList])
        }
    }
}
