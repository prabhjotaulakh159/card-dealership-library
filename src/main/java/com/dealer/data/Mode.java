package com.dealer.data;

/**
 * Determines if methods that read/write to sources should be done 
 * on test tables/files or production tables/files
 */
public enum Mode {
    PRODUCTION,
    TESTING;
}
