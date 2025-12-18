plugins {
    idea
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
    dependencies {
        classpath("io.soffa.gradle:soffa-gradle-plugin:2.3.2")
    }
}

allprojects {
    apply(plugin = "soffa.default-repositories")
    apply(plugin = "soffa.java17")
}

tasks.withType<Test>().configureEach {
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    forkEvery = 100
    reports.html.required.set(false)
    reports.junitXml.required.set(false)
}

tasks.withType<JavaCompile>().configureEach {
    options.isFork = true
}

fun isSnapshot(v: String) = v.endsWith("-SNAPSHOT")

val releasesUrl: Provider<String?>? = providers.gradleProperty("nexusReleasesUrl")

val nexusUser: String? = providers.gradleProperty("nexusUsername").orNull ?: System.getenv("NEXUS_USERNAME")
val nexusPass: String? = providers.gradleProperty("nexusPassword").orNull ?: System.getenv("NEXUS_PASSWORD")

subprojects {
    subprojects {
        plugins.withId("pmd") {
            tasks.withType<Pmd>().configureEach {
                enabled = false
            }
        }
    }

    plugins.withId("java") {

        apply(plugin = "maven-publish")

        extensions.configure<JavaPluginExtension>("java") {
            withSourcesJar()
            withJavadocJar()
        }

        tasks.matching { it.name == "bootJar" }.configureEach { enabled = false }
        tasks.matching { it.name == "jar" }.configureEach { enabled = true }

        extensions.configure<PublishingExtension>("publishing") {

            publications {
                create("mavenJava", MavenPublication::class.java) {
                    from(components.getByName("java"))

                    pom {
                        name.set(project.name)
                        description.set(providers.gradleProperty("description").orNull)
                        url.set(providers.gradleProperty("url").orNull)
                    }
                }
            }

            repositories {
                maven {
                    name = "nexus"
                    url = uri(releasesUrl?.get())

                    credentials {
                        username = nexusUser
                        password = nexusPass
                    }

                    authentication {
                        create("basic", BasicAuthentication::class.java)
                    }
                }
            }
        }
    }
}
