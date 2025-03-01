// swift-tools-version: 6.0
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "KMPSampleSwiftPackage",
    products: [
        .library(
            name: "KMPSampleSwiftPackage",
            targets: ["KMPSampleSwiftPackage"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "KMPSampleLibrary",
            path: "KMPSampleLibrary.xcframework"
        ),
        .target(
            name: "KMPSampleSwiftPackage",
            dependencies: [
                "KMPSampleLibrary",
            ]
        ),
        .testTarget(
            name: "KMPSampleSwiftPackageTests",
            dependencies: [
                "KMPSampleSwiftPackage",
            ]
        ),
    ]
)
