# J-CONV

This project provides a **CLI tool** that can convert images between different formats using Java, **Picocli** for the command-line interface, and **TwelveMonkeys ImageIO** for extended image format support (including WebP).

Additionally, a **native profile** has been configured to enable compilation into a native executable, leveraging **GraalVM** or other native image tools.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Building the Project](#building-the-project)
- [Usage](#usage)
- [Native Profile](#native-profile)
- [Dependencies](#dependencies)
- [Known Issues](#known-issues)
- [License](#license)

---

## Project Overview

This project provides a **CLI tool** for converting images from one format to another. The following formats are supported:
- JPG to PNG
- PNG to JPG
- WEBP to JPG

The application uses **Picocli** for parsing command-line arguments and **TwelveMonkeys ImageIO** for reading and writing various image formats, including WebP.

A **native profile** is also included for compiling the application into a native executable, making it efficient and fast for production environments.

---

## Features

- **Command-Line Interface (CLI)**: Users can specify input files and target formats via the command line.
- **Multiple Image Formats Supported**: Convert between JPG, PNG, and WEBP formats.
- **Native Image Compilation**: Compile the tool into a native executable using GraalVM.
- **Extensibility**: Easily add more image formats or functionalities.

---

## Technologies Used

- **Java**: Programming language for building the application.
- **Picocli**: CLI framework for parsing input arguments.
- **TwelveMonkeys ImageIO**: Image library to support additional formats like WebP.
- **Maven**: Dependency management and build automation.
- **GraalVM**: Native image compiler (optional for compiling the application into a native executable).

---

## Installation

To get started with this project, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/cli-image-converter.git
    cd cli-image-converter
    ```

2. **Install Maven**:
   Ensure you have **Maven** installed on your machine. You can download it from [here](https://maven.apache.org/download.cgi).

3. **Install GraalVM (optional)**:
   If you're planning to build a native image, install [GraalVM](https://www.graalvm.org/downloads/) and configure it as your JDK.

---

## Building the Project

### Default Build (JAR)
1. To build the project as a standard JAR, use:
    ```bash
    mvn clean package
    ```

This will produce a `cli-1.0-SNAPSHOT.jar` file in the `target` directory.

### Native Build (Optional)
To build the project as a native executable, use the `native` profile:

1. To activate the native profile, run:
    ```bash
    mvn clean package -P native
    ```

This will trigger GraalVM's **native-image** tool (if installed) to compile your application into a native executable.

---

## Usage

### Command-Line Interface

Once the application is built, you can use it via the command line. The syntax for running the converter is:

```bash
java -jar target/cli-1.0-SNAPSHOT.jar -i <input_image_path> -f <output_format>
```

### Arguments:

- `-i`: Input image file path (supports JPG, PNG, WebP).
- `-f`: Target output image format (`jpg`, `png`, `webp`).

### Example:

1. To convert a **WebP** image to **JPG**:
    ```bash
    java -jar target/cli-1.0-SNAPSHOT.jar -i path/to/image.webp -f jpg
    ```

2. To convert a **PNG** image to **JPG**:
    ```bash
    java -jar target/cli-1.0-SNAPSHOT.jar -i path/to/image.png -f jpg
    ```

3. To convert a **JPG** image to **PNG**:
    ```bash
    java -jar target/cli-1.0-SNAPSHOT.jar -i path/to/image.jpg -f png
    ```

---

## Native Profile

This project includes a **native profile** that enables GraalVM native compilation. By using GraalVM, the tool can be compiled into a highly optimized, fast native executable. To build the project as a native executable, you need to:

1. **Activate the native profile** by using the following command:
    ```bash
    mvn clean package -P native
    ```

2. This will compile the project into a **native image** (using GraalVM’s `native-image` tool).

### Requirements:
- **GraalVM**: Ensure that you have GraalVM installed and properly configured. You can follow the official [GraalVM installation guide](https://www.graalvm.org/docs/getting-started/) for setup instructions.

---

## Dependencies

### Key Dependencies:
- **Picocli**: A command-line argument parsing library.
    ```xml
    <dependency>
        <groupId>info.picocli</groupId>
        <artifactId>picocli</artifactId>
        <version>4.7.4</version>
    </dependency>
    ```

- **TwelveMonkeys ImageIO WebP**: For WebP support in Java's ImageIO.
    ```xml
    <dependency>
        <groupId>com.twelvemonkeys.imageio</groupId>
        <artifactId>imageio-webp</artifactId>
        <version>3.9.6</version>
    </dependency>
    ```

### Native Image Plugin (for GraalVM):
- **GraalVM Native Image** plugin (optional for native builds).
    ```xml
    <plugin>
        <groupId>org.graalvm.nativeimage</groupId>
        <artifactId>native-maven-plugin</artifactId>
        <version>0.9.10</version>
        <executions>
            <execution>
                <goals>
                    <goal>native-image</goal>
                </goals>
            </execution>
        </executions>
    </plugin>
    ```


