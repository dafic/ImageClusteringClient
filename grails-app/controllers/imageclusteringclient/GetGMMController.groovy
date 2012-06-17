package imageclusteringclient

class GetGMMController {

    def index() {
        GetGMMService ggs = new GetGMMService()
        ggs.getHBase()
    }
}
