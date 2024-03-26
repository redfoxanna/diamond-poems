package com.redfoxanna.aws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import javax.ws.rs.ProcessingException;
import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

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
     * @param s3c the s3c
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
     * Close the global s3 client.
     */
    public void closeClient() {
        try {
            s3Client.close();
        } catch (S3Exception s3e) {
            log.error("Failed to close s3 client.", s3e);
        }
    }
    /**
     * Make key string.
     *
     * @param userName the userName in cognito
     * @return the string
     */
    public String makeKey(String userName) {
        String randomId = String.valueOf(UUID.randomUUID());

        LocalDate ld = LocalDate.now();

        return String.format("%s/%s/%s/%s/%s.jpg",
                ld.getYear(),
                ld.getMonthValue(),
                ld.getDayOfMonth(),
                userName,
                randomId);
    }

    // This example uses RequestBody.fromFile to avoid loading the whole file into
    // memory.
    public String putS3Object(S3Client s3, String bucketName, String objectKey, String objectPath) {
        try {
            PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            PutObjectResponse putObjectResponse = s3.putObject(putOb, RequestBody.fromFile(new File(objectPath)));
            return putObjectResponse.eTag();

        } catch (S3Exception e) {
            log.error("Failed to upload file to s3.", e);
            throw(new ProcessingException("Failed to write S3 Object"));
        }
    }
}

