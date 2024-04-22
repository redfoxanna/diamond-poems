package com.redfoxanna.aws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.textract.model.S3Object;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.Document;
import software.amazon.awssdk.services.textract.model.DetectDocumentTextRequest;
import software.amazon.awssdk.services.textract.model.DetectDocumentTextResponse;
import software.amazon.awssdk.services.textract.model.Block;
import software.amazon.awssdk.services.textract.model.TextractException;
import software.amazon.awssdk.services.textract.model.BlockType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;


/**
 *
 * https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html
 */
public class Textract {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private TextractClient textractClient;

    /**
     * Instantiates a new Textract.
     */
    public Textract() {
        setClient();
    }

    /**
     * Instantiates a new Textract.
     *
     * @param tc the textract client
     */
    public Textract(TextractClient tc) {
        this.textractClient = tc;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public TextractClient getClient() {
        return textractClient;
    };

    /**
     * Sets client.
     */
    public void setClient() {
        // TODO: pull from properties
        try {
            Region region = Region.US_EAST_2;
            textractClient = TextractClient.builder()
                    .region(region)
                    .build();
        } catch (TextractException te) {
            logger.error("Failed to initialize textract client.", te);
        }
    }

    /**
     * Close the global textract client.
     */
    public void closeClient() {
        try {
            textractClient.close();
        } catch (TextractException te) {
            logger.error("Failed to close textract client.", te);
        }
    }

    /**
     * Gets s 3 text.
     *
     * @param textractClient the textract client
     * @param bucketName     the bucket name
     * @param docName        the doc name
     * @return the s 3 text
     */
    public ArrayList<String> getS3Text(TextractClient textractClient, String bucketName, String docName) {
        try {
            ArrayList<String> lines = new ArrayList<>();

            S3Object s3Object = S3Object.builder()
                    .bucket(bucketName)
                    .name(docName)
                    .build();

            // Create a Document object and reference the s3Object instance.
            Document myDoc = Document.builder()
                    .s3Object(s3Object)
                    .build();

            DetectDocumentTextRequest detectDocumentTextRequest = DetectDocumentTextRequest.builder()
                    .document(myDoc)
                    .build();

            DetectDocumentTextResponse textResponse = textractClient.detectDocumentText(detectDocumentTextRequest);
            for (Block block : textResponse.blocks()) {
                getRelevantBlockText(block, lines);
            }

            return lines;
        } catch (TextractException te) {
            logger.error("Failed to fetch s3 object.", te);
            return new ArrayList<>();
        }
    }

    /**
     * <a href="https://docs.aws.amazon.com/textract/latest/dg/API_Block.html">...</a>
     * @param block the block of text
     * @param lines the individual lines from that block
     */
    private void getRelevantBlockText(Block block, ArrayList<String> lines) {
        BlockType blockType = block.blockType();

        if (blockType == BlockType.LINE) {
            String blockText = block.text();
            lines.add(blockText);
        }
    }
}