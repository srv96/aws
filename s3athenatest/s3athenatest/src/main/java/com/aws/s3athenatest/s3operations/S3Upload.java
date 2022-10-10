package com.aws.s3athenatest.s3operations;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

public class S3Upload {

    public static void main(String[] args) {

        Regions clientRegion = Regions.AP_SOUTH_1;
        String bucketName = "s3-srv96-tf-private";
        String fileObjKeyName = "data/worldcities.csv";
        String fileName = "C:\\code\\s3athenatest\\s3athenatest\\src\\main\\resources\\data\\worldcities.csv";

        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();
            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("title", "someTitle");
            request.setMetadata(metadata);
            s3Client.putObject(request);

        } catch (SdkClientException sce) {
            sce.printStackTrace();
        }
    }
}


