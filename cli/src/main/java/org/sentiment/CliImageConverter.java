package org.sentiment;

import picocli.CommandLine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@CommandLine.Command(name = "CliImageConverter", mixinStandardHelpOptions = true, description = "Converts image files between formats!")
public class CliImageConverter implements Runnable {
    @CommandLine.Option(names = {"-i", "--input"}, required = true, description = "Input file path")
    private String inputFilePath;

    @CommandLine.Option(names = {"-f", "--format"}, required = true, description = "Format the image needs to be converted to.")
    private String targetFormat;


    public static void main(String[] args) {
        int exitCode = new CommandLine(new CliImageConverter()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        try {
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                throw new IOException("Input file does not exist");
            }
            String outputFilePath = getOutputFilePath(inputFilePath, targetFormat);
            convertImage(inputFile, outputFilePath, targetFormat);

            System.out.println("Successfully converted to: " + outputFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void convertImage(File inputFile, String outputFilePath, String format) throws IOException {
        BufferedImage image = ImageIO.read(inputFile);
        if (image == null) {
            throw new IOException("Failed to read input image");
        }
        File outputFile = new File(outputFilePath);
        boolean result = ImageIO.write(image, format, outputFile);

        if (!result) {
            throw new IOException("Failed to write image in " + format + "format");
        }
    }

    private String getOutputFilePath(String inputPath, String targetFormat) {
        int dotIndex = inputPath.lastIndexOf('.');
        String baseName = dotIndex > 0 ? inputPath.substring(0, dotIndex) : inputPath;
        return baseName + "." + targetFormat;
    }
}

