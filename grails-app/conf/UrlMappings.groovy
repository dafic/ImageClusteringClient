class UrlMappings {

    static mappings = {
		"/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

		"/"(controller:"ClusterInfo/getClusterInfo")
        //"/"(controller:"getGMM/index")
		"500"(view:'/error')
    }
}
