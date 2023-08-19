rootProject.name = "strikes-and-gutters"

include(":database-service")
//include(":frontend-fusion-service")
//include(":identity-service")
//include(":commons-utils")
// Включайте другие модули, если есть

project(":database-service").projectDir = rootProject.projectDir.resolve("../database-service")
//project(":frontend-fusion-service").projectDir = rootProject.projectDir.resolve("frontend-fusion-service")
//project(":identity-service").projectDir = rootProject.projectDir.resolve("identity-service")
//project(":commons-utils").projectDir = rootProject.projectDir.resolve(":commons-utils")
