plugins {
    id("java")
}

group = "org.union4dev.omni"
version = "unspecified"

repositories {
    mavenCentral()
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.marcloud.net/")
        name = "marCloud-Repository"
    }
}


dependencies {
    implementation(project(":"))
    implementation("org.lwjgl:lwjgl:2.9.4-nightly")
    implementation("org.lwjgl:util:2.9.4-nightly")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}