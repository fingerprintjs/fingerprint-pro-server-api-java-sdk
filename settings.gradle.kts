rootProject.name = "fingerprint-pro-server-api-sdk"
include("library")
include("examples")

rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}.gradle.kts"
    require(project.buildFile.isFile) {
        "${project.buildFile} must exist"
    }
}