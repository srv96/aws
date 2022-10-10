package com.aws.s3athenatest.athena;

public class AthenaConstants {
    public static final String ATHENA_OUTPUT_BUCKET = "s3://s3-srv96-tf-private-analysis";
    public static final String ATHENA_SAMPLE_QUERY1 = "SELECT * FROM \"s3_data_analysis\".\"worldcities\" limit 10;";
    public static final String ATHENA_SAMPLE_QUERY2 = "SELECT * FROM \"s3_data_analysis\".\"worldcities\" where population > 30000000 limit 10;";
    public static final long SLEEP_AMOUNT_IN_MS = 3000;
    public static final String ATHENA_DEFAULT_DATABASE = "s3-data-analysis";
}