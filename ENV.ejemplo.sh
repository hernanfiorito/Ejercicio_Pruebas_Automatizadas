#!/bin/bash

JDK=/home/diego/Desa/tools/jdk1.8.0_162/
MAVEN=/home/diego/Desa/tools/apache-maven-3.5.0

# JAVA
export JAVA_HOME=$JDK
PATH=$JAVA_HOME/bin:$PATH

# Maven
MAVEN_HOME=$MAVEN
PATH=$MAVEN_HOME/bin:$PATH

# PhantomJS
# phantomjs.binary.path
# set OS to macos or linux
OS=linux
PATH=./webdriver/$OS/:$PATH

export PATH
