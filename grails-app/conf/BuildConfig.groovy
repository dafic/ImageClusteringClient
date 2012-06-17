grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //        mavenCentral()
        //        mavenLocal()
        //        mavenRepo "http://snapshots.repository.codehaus.org"
        //        mavenRepo "http://repository.codehaus.org"
        //        mavenRepo "http://download.java.net/maven/2/"
        //        mavenRepo "http://repository.jboss.com/maven2/"

        mavenLocal()
//        mavenRepo "http://download.java.net/maven/2"
//        mavenRepo "http://people.apache.org/~rawson/repo"
//        mavenRepo "http://oss.sonatype.org/content/repositories/releases"
//
//        mavenRepo "http://snapshots.repository.codehaus.org"
//        mavenRepo "http://repository.codehaus.org"
//        mavenRepo "http://download.java.net/maven/2/"
//        mavenRepo "http://repository.jboss.com/maven2/"
        //maven repository for hadoop
        mavenRepo "http://repository.cloudera.com/content/repositories/releases/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
        
          runtime(
            [group: 'org.apache.hadoop', name: 'hadoop-core', version: '0.20.2-cdh3u4'],
            //[group: 'org.apache.hadoop', name: 'hadoop-examples', version: '0.20.2-cdh3u4'],
            //[group: 'org.apache.hadoop', name: 'hadoop-streaming', version: '0.20.2-cdh3u4'],
            //[group: 'org.apache.hadoop', name: 'hadoop-tools', version: '0.20.2-cdh3u4'],
            //[group: 'org.apache.hadoop', name: 'hadoop-mrunit', version: '0.20.2-cdh3u4'],
            //[group: 'org.apache.hadoop', name: 'hadoop-test', version: '0.90.4-cdh3u3'],
            [group: 'org.apache.hbase', name: 'hbase', version: '0.90.4-cdh3u3'],
            [group: 'org.apache.zookeeper', name: 'zookeeper', version: '3.3.4-cdh3u3']
            //[group: 'org.elasticsearch', name: 'elasticsearch', version: '0.19.1'],
            //logback configuration
            //'ch.qos.logback:logback-core:0.9.17', 'ch.qos.logback:logback-classic:0.9.17','org.slf4j:log4j-over-slf4j:1.5.8'
    )
    runtime('org.apache.hbase:hbase:0.90.4-cdh3u3'){
        excludes 'sl4j','log4j'
    }
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"
    }
}
