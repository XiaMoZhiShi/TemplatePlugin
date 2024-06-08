import io.papermc.paperweight.userdev.ReobfArtifactConfiguration
import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    `maven-publish`
    id("io.papermc.paperweight.userdev") version "1.7.1"
    id("xyz.jpenilla.run-paper") version "2.0.1" // Adds runServer and runMojangMappedServer tasks for testing
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0" // Generates plugin.yml
    id("io.github.goooler.shadow") version "8.1.7" // Shadow PluginBase
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }

    maven {
        url = uri("https://jitpack.io")
    }

    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }

    maven {
        url = uri("https://repo.md-5.net/content/groups/public/")
    }

    maven {
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }

    maven {
        url = uri("https://repo.dmulloy2.net/repository/public/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }

    maven {
        url = uri("https://repo.codemc.io/repository/maven-public/")
    }

    maven {
        url = uri("https://mvn.lumine.io/repository/maven-public")
    }

/*
    maven {
        url = uri("https://repo.majek.dev/releases")
    }*/
}

paperweight.reobfArtifactConfiguration = ReobfArtifactConfiguration.MOJANG_PRODUCTION

dependencies {
    paperweight.paperDevBundle("${project.property("minecraft_version")}")

    implementation("com.github.XiaMoZhiShi:PluginBase:${project.property("pluginbase_version")}")
    {
        exclude("com.google.code.gson", "gson")
    }
}

group = "ink.xiamomc.example"
version = "${project.property("project_version")}"
description = "Template Plugin"
java.sourceCompatibility = JavaVersion.VERSION_21

bukkit {
    load = BukkitPluginDescription.PluginLoadOrder.POSTWORLD
    main = "ink.xiamomc.example.TemplatePlugin"
    apiVersion = "1.20"
    authors = listOf("AUTHOR1", "AUTHOR2")
    depend = listOf("")
    softDepend = listOf("")
    version = "${project.property("project_version")}"
    prefix = "TemplatePlugin"
    name = "TemplatePlugin"

    // True if this plugin supports folia.
    foliaSupported = false

    commands {
        register("example_command")

        val featherMorphCommand = register("example2").get()
        featherMorphCommand.aliases = listOf("ex2");
    }

    val permissionRoot = "template."

    // Setup permissions that's default to True
    permissions {
        register(permissionRoot + "example1")
    }

    permissions.forEach {
        permission -> permission.default = BukkitPluginDescription.Permission.Default.TRUE
    }

    // OP Permissions
    val opPermsStrList = listOf(
            permissionRoot + "example_op_perm"
    );

    opPermsStrList.forEach {
        permStr -> permissions.register(permStr).get().default = BukkitPluginDescription.Permission.Default.OP;
    }

    // Default False Permissions
    var falsePerms = listOf(
        permissionRoot + "example_false"
    );

    falsePerms.forEach {
        perm -> permissions.register(perm).get().default = BukkitPluginDescription.Permission.Default.FALSE;
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])

        // Workaround for no normal artifact present
        artifact("build/libs/${rootProject.name}-${version}.jar")
    }
}

java {
    withSourcesJar()
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    minimize()
    relocate("xiamomc.pluginbase", "xiamomc.morph.shaded.pluginbase")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
