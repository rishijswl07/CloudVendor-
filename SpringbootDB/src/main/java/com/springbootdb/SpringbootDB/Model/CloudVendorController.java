package com.springbootdb.SpringbootDB.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CloudVendor")
public class CloudVendorController
{

    @Autowired
    private CloudVendorService cloudVendorService;

   // CloudVendor cloudVendor;
        @GetMapping("/{vendorId}")
        public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
        {
            return cloudVendorService.getCloudVendor(vendorId);

        }
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails()
    {
        return cloudVendorService.getAllCloudVendors();

    }

        @PostMapping
        public ResponseEntity<CloudVendor> createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
        {

            return new ResponseEntity<CloudVendor>(cloudVendorService.createCloudVendor(cloudVendor), HttpStatus.CREATED);
        }
        @PutMapping
        public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
        {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor updated  successfully";
        }
        @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
    {
        return cloudVendorService.deleteCloudVendor(vendorId);
    }

    }


