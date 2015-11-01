-- install ojdbc to maven local repositories
mvn install:install-file -Dfile={path/to/ojdbc6.jar} -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.4 -Dpackaging=jar