package com.springbootdb.SpringbootDB.Model;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CloudVendorServiceImpl implements CloudVendorService
{
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository)
    {
        this.cloudVendorRepository=cloudVendorRepository;

    }
    @Override
    public CloudVendor createCloudVendor(CloudVendor cloudVendor)
    {
        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor)
    {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId)
    {
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId)
    {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }
}
