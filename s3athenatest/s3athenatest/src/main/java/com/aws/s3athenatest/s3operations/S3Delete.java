package com.aws.s3athenatest.s3operations;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.IOException;
import java.util.ArrayList;

public class S3Delete {

    public static void main(String[] args) throws IOException {
        Regions clientRegion = Regions.AP_SOUTH_1;
        String bucketName = "s3-srv96-tf-private";

        AmazonS3 s3Client = null;
        try {
            s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();

            ArrayList<KeyVersion> keys = new ArrayList<KeyVersion>();
            try {
                ObjectListing objects = s3Client.listObjects("s3-srv96-tf-private");

                if (objects != null && objects.getObjectSummaries() != null) {
                    while (true) {
                        for (S3ObjectSummary summary : objects.getObjectSummaries()) {
                            System.out.println("Object Id :-" + summary.getKey());
                            keys.add(new KeyVersion(summary.getKey()));
                        }

                        if (objects.isTruncated()) {
                            objects = s3Client.listNextBatchOfObjects(objects);
                        } else {
                            break;
                        }
                    }
                }

            } catch (AmazonServiceException e) {
                e.getErrorMessage();
            }
            DeleteObjectsRequest multiObjectDeleteRequest = new DeleteObjectsRequest(bucketName).withKeys(keys).withQuiet(false);

            DeleteObjectsResult delObjRes = s3Client.deleteObjects(multiObjectDeleteRequest);
            int successfulDeletes = delObjRes.getDeletedObjects().size();
            System.out.println(successfulDeletes + " objects successfully deleted.");
        } catch (SdkClientException e) {
            e.printStackTrace();
        } finally {
            if (s3Client != null) {
                s3Client.shutdown();
            }
        }
    }
}


