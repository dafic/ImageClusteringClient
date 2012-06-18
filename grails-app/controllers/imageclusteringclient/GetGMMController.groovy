package imageclusteringclient

class GetGMMController {

    def index() {
        def result;
        GetGMMService ggs = new GetGMMService()
        result = ggs.getHBase()
        if(result){
            render "file successfully read"
        }
        else{
            render "error reading file"
        }
    }
}
