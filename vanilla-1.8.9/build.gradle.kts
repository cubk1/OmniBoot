plugins {
    `java`
}

group = "org.union4dev.omni"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.marcloud.net/")
        name = "marCloud-Repository"
    }
}

dependencies {
    implementation(project(":"))
    implementation(project(":omni-renderer"))
    implementation("io.netty:netty-all:4.0.23.Final")
    implementation("com.mojang:patchy:1.7.7")
    implementation("net.sf.jopt-simple:jopt-simple:4.6")
    implementation("org.lwjgl:lwjgl:2.9.4-nightly")
    implementation("org.lwjgl:util:2.9.4-nightly")
    implementation("net.java.jinput:jinput:2.0.5")
    implementation("com.mojang:icu4j-core-mojang:51.2")
    implementation("org.apache.httpcomponents:httpclient:4.3.3")
    implementation("org.apache.httpcomponents:httpcore:4.3.2")
    implementation("oshi:oshi-core:1.1")
    implementation("net.java.dev.jna:jna:3.4.0")
    implementation("net.java.dev.jna:platform:3.4.0")
    implementation("net.java.jutils:jutils:1.0.0")
    implementation("commons-logging:commons-logging:1.1.3")
    implementation("org.apache.commons:commons-compress:1.8.1")
    implementation("org.apache.logging.log4j:log4j-api:2.0-beta9")
    implementation("org.apache.logging.log4j:log4j-core:2.0-beta9")
    implementation("tv.twitch:twitch:6.5")
    implementation("com.google.guava:guava:17.0")
    implementation("org.apache.commons:commons-lang3:3.3.2")
    implementation("commons-io:commons-io:2.4")
    implementation("commons-codec:commons-codec:1.9")
    implementation("com.google.code.gson:gson:2.2.4")
    implementation("com.paulscode.sound:libraryjavasound:20101123")
    implementation("com.paulscode.sound:codecwav:20101023")
    implementation("com.paulscode.sound:soundsystem:20120107")
    implementation("com.paulscode.sound:codecjorbis:20101023")
    implementation("com.paulscode.sound:librarylwjglopenal:20100824")
    implementation("com.mojang:authlib:1.5.21")
}
