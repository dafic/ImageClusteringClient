package imageclusteringclient

class DataFetchController {

    def HBaseTable() { 
        DataFetchService dfs = new DataFetchService()
        dfs.createImageDatabase()
        //dfs.createHBaseTable()
    }
}
