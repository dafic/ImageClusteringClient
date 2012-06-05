package imageclusteringclient

class ConfigurationController {

    def HBaseConfig() {
        ConfigurationService cs = new ConfigurationService()
        cs.getConfig()
        }
}
