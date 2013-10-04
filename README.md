LTI 2.0 Building Block Prototype
=================

This project is a prototype Building Block integration demonstrating the viability of LTI 2.0 in Blackboard Learn.

### Building
To build the project, just run:

gradle build

### Deploying
If using the vagrant VM image provided by Blackboard, the build.gradle file is set up to deploy to localhost:9876. You can simply run:

gradle deployB2

To deploy to another Learn server, change the remoteServer and remoteInstance variables in build.gradle first.

