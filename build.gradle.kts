plugins {
    kotlin("jvm") version "1.6.10"
    java
    /* id("org.springframework.boot") version "2.5.2"
     id("org.sonarqube") version "3.3"*/

}

group = "org.example"
version = "1.0-SNAPSHOT"

project("sub-two"){
    task("subtwo"){
        print("I am ${project.name}")
    }
}

subprojects{
}

allprojects(){
    group = "org.example"
    version = "1.0-SNAPSHOT"

    task("allpro"){
        print("I am ${project.name}")
    }
    //repo dependencies
}

sourceSets {
    main {
        java {
        }
    }
}
repositories {
    mavenLocal() //  will try to find dependencies in maven root folder (.m2\repository)
    mavenCentral() // fetched dependencies from here
    maven {
        url = uri("https://repo.maven.apache.org/mcven2/") //or to look here
    }
/*
    flatDir{
        dirs ("letsSee")
    }*/
}

sourceSets {
    main {
        java {
            srcDirs("src")
        }
    }

}

val junitVersion = "5.6.0"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.testng:testng:7.1.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.1.2")
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-databind", version = "2.10.2") //another way

    runtimeOnly("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.testng:testng:7.5")

    api("org.testng:testng:7.5")
    api("org.seleniumhq.selenium:selenium-api:4.1.2")
    api("org.seleniumhq.selenium:selenium-chrome-driver:4.1.2")
    api("org.seleniumhq.selenium:selenium-remote-driver:4.1.2")
    api("org.seleniumhq.selenium:selenium-support:4.1.2")

}


// creating new tasks
tasks.register("randomTask") {
    dependsOn("dependingTask")
    print("message from random task 1 ")
    /*exec{
        commandLine( "mkdir", "letsSee")
    }*/
}


tasks.register("dependingTask") {
    print("message from random task 2 ")// prints second ?
}

task("newTask") {
    description = "this is a new tasks' description"
    dependsOn("dependingTask")
    doLast {
        task("doLastTask") {
            print(" doLast task print block ")
        }
    }
    doFirst {
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

    print("after doLast()")
}

//defining default tasks
defaultTasks("clean", "run")

task("cleans") {
    doLast {
        print("Default Cleaning!' ")
    }
}

task("run") {
    doLast {
        print("'Default Running!'")
    }
}

task("other") {
    doLast {
        print("I'm not a default task!")
    }
}

open class GreetingTask : DefaultTask() {
    @TaskAction
    fun greet() {
        println("Task with greetings")
    }
}
tasks.register<GreetingTask>("hello")


//build folder?
