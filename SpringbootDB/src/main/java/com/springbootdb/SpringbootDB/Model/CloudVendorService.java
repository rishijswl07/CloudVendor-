package com.springbootdb.SpringbootDB.Model;

import com.springbootdb.SpringbootDB.Model.CloudVendor;

import java.util.List;

public interface CloudVendorService
{
    public CloudVendor createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public CloudVendor getCloudVendor(String cloudVendor);
    public String deleteCloudVendor(String cloudVendor);
    public List<CloudVendor> getAllCloudVendors();
}
