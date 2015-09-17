LTI 2.0 Building Block Prototype
=================

This project is a prototype Building Block integration demonstrating the viability of LTI 2.0 in Blackboard Learn.

### Building
To build the project, just run:

gradle build

### Deploying
If using the vagrant VM image provided by Blackboard, set the following environment variables
GRADLE_DEPLOY_SERVER=localhost:9876
GRADLE_DEPLOY_INSTANCE=BBLEARN

so that the build.gradle file will deploy to localhost:9876. On an nix system you can simply run:


. ./env.vagrant
./gradlew deployB2

To deploy to another Learn server, change the GRADLE_DEPLOY_SERVER and GRADLE_DEPLOY_INSTANCE environment variables first.
