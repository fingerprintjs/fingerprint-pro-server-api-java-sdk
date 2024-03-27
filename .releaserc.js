module.exports = {

    "branches": [
        "main",
        {
            "name": "develop",
            "prerelease": true,
        }
    ],
    "plugins": [
        [
            "@semantic-release/commit-analyzer",
            {
                "config": "@fingerprintjs/conventional-changelog-dx-team",
                "releaseRules": "@fingerprintjs/conventional-changelog-dx-team/release-rules"            
            }
        ],
        [
            "@semantic-release/release-notes-generator",
            {
                "config": "@fingerprintjs/conventional-changelog-dx-team",
            }
        ],
        [
            "@semantic-release/changelog",
            {
                "changelogFile": "CHANGELOG.md"
            }
        ],
        [
            "@semantic-release/exec",
            {
                "prepareCmd": "bash ./scripts/generate.sh -v ${nextRelease.version}",
                "publishCmd": "bash ./gradlew publishToMavenLocal"
            }
        ],
        [
            "@semantic-release/git",
            {
                "assets": [
                    "CHANGELOG.md",
                    "README.md",
                    "config.json",
                    "build.gradle",
                    "pom.xml",
                    "config.yaml",
                    "./scripts/generate.sh",
                    "docs/**/*",
                    "src/**/*"
                ]
            }
        ],
        "@semantic-release/github"
    ]
}
