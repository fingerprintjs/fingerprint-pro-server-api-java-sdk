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
                "prepareCmd": "bash ./generate.sh -v ${nextRelease.version}",
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
                    "config.yaml",
                    "docs/**/*",
                    "src/**/*"
                ]
            }
        ],
        "@semantic-release/github"
    ]
}
