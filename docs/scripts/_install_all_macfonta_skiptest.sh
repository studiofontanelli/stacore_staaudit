#!/bin/sh


source ./_env.sh


export MVN_PROFILE=macfonta


java -version



COMMAND="mvn -f ../../pom.xml -s $MVN_SETTINGS -Dmaven.test.skip=true -P$MVN_PROFILE -Droot.dir.angular.fo=$ROOT_DIR_ANGULAR_FO -Droot.dir.angular.bo=$ROOT_DIR_ANGULAR_BO clean compile package install"




echo "BUILDING Front Office Angular project" 
pushd $PROJECT_DIR_ANGULAR_FO && ng build --configuration $MVN_PROFILE && popd

echo "BUILDING Back Office Angular project" 
pushd $PROJECT_DIR_ANGULAR_BO && ng build --configuration $MVN_PROFILE && popd

echo "$COMMAND" 


exec $COMMAND 













