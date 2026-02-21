# Dev Container Setup

### Build the applet (CAP file)
```bash
>ant applet
Buildfile: /workspaces/helloworld/build.xml
      [get] Destination already exists (skipping): /javacard/libs/ant-javacard.jar
      [get] Destination already exists (skipping): /javacard/libs/jcardsim-3.0.5.11.jar
      [get] Destination already exists (skipping): /javacard/libs/junit-4.13.2.jar
      [get] Destination already exists (skipping): /javacard/libs/junit-jupiter-api-5.8.2.jar
      [get] Destination already exists (skipping): /javacard/libs/junit-jupiter-engine-5.8.2.jar
      [get] Destination already exists (skipping): /javacard/libs/hamcrest-2.2.jar

applet:
 [javacard] ant-javacard v25.11.24.1
 [javacard] INFO: using JavaCard 3.0.5 SDK in /javacard/oracle_javacard_sdks/jc305u3_kit with JDK 8
 [javacard] INFO: setting package name to helloworld
 [javacard] Building CAP with 1 applet from package helloworld (AID: 0102030405)
 [javacard] helloworld.HelloWorldApplet 0102030405060708
  [compile] Compiling files from /workspaces/helloworld/src
  [compile] Compiling 1 source file to /tmp/jccpro1636309817063376453
  [compile] /workspaces/helloworld/src/HelloWorldApplet.java
   [verify] Verification of /tmp/jccpro3344312800603343839/helloworld/javacard/helloworld.cap passed
      [cap] CAP saved to /workspaces/helloworld/build/helloworld.cap

BUILD SUCCESSFUL
Total time: 1 second

```
Resulting cap file should be in `build/helloworld.cap` on the host system

