plugins {
    kotlin("jvm") version "1.6.10"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.testng:testng:7.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.testng:testng:7.5")
    implementation("org.seleniumhq.selenium:selenium-java:4.1.2")
    api("org.seleniumhq.selenium:selenium-api:4.1.2")
    api("org.seleniumhq.selenium:selenium-chrome-driver:4.1.2")
    api("org.seleniumhq.selenium:selenium-remote-driver:4.1.2")
    api("org.seleniumhq.selenium:selenium-support:4.1.2")
   // implementation(group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.10.2')

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}


tasks.register("randomTask") {
    dependsOn("dependingTask")
    print("message from random task 1 ")

    exec{
        commandLine( "mkdir", "letsSee")
    }
}

tasks.register("dependingTask") {
    print("message from random task 2 ")// prints second ?
}

task("newTask"){
    dependsOn("dependingTask")
    doLast{
        task("doLastTask") {
            print(" doLast task print block ")
        }
    }
    doFirst{
        task("doFirstTask") {
            print(" doFirst task print block ")
        }
    }
}

task("testTask") {
    print("before doLast()")

     doFirst {
        print("hello doFirst")
    }

    doLast {
        print("hello doLast")
    }

    print ("after doLast()")
}

logger.info("some info")


