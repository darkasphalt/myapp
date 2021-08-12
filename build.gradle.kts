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
    maven {
        url = uri("https://mvnrepository.com/artifact/com.microsoft.azure/azure-storage")
    }
}

dependencies {
    implementation("com.azure:azure-storage-blob:12.12.0")
}

val mainClassName = "mypackage.Hello"
tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    manifest.attributes.apply {
        put("Class-Path", configurations.runtimeClasspath.get().asPath)
        put("Main-Class", mainClassName)
    }

    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.test {
    useJUnitPlatform()
}