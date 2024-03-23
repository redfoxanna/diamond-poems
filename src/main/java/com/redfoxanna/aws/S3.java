package com.redfoxanna.aws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.TextractException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class S3 {
    private final Logger log = LogManager.getLogger(this.getClass());

    private S3Client s3Client;

    /**
     * Instantiates a new S3.
     */
    public S3() {
        setClient();
    }

    /**
     * Instantiates a new S3 Client.
     *
     * @param s3c the tc
     */
    public S3(S3Client s3c) {
        this.s3Client = s3c;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public S3Client getClient() {
        return s3Client;
    }

    /**
     * Sets client.
     */
    public void setClient() {
        // TODO: pull from properties
        try {
            Region region = Region.US_EAST_2;
            s3Client = S3Client.builder()
                    .region(region)
                    .build();
        } catch (S3Exception s3e) {
            log.error("Failed to initialize s3 client.", s3e);
        }
    }

    /**
     * Close the global textract client.
     */
    public void closeClient() {
        try {
            s3Client.close();
        } catch (S3Exception s3e) {
            log.error("Failed to close s3 client.", s3e);
        }
    }

    // This example uses RequestBody.fromFile to avoid loading the whole file into
    // memory.
    public static void putS3Object(S3Client s3, String bucketName, String objectKey, String objectPath) {
        try {
            Map<String, String> metadata = new HashMap<>();
            metadata.put("x-amz-meta-myVal", "test");
            PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .metadata(metadata)
                    .build();

            s3.putObject(putOb, RequestBody.fromFile(new File(objectPath)));
            System.out.println("Successfully placed " + objectKey + " into bucket " + bucketName);

        } catch (S3Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}

