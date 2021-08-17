group = "myapp"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withSourcesJar()
}

plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.14.1")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.14.1")
}

val mainClassName = "mypackage.Hello"
tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    manifest.attributes.apply {
        put("Class-Path", configurations.runtimeClasspath.get().asPath)
        put("Main-Class", mainClassName)
    }
}

tasks.test {
    useJUnitPlatform()
}