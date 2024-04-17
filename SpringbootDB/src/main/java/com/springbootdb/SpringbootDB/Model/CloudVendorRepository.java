package com.springbootdb.SpringbootDB.Model;

import com.springbootdb.SpringbootDB.Model.CloudVendor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface   CloudVendorRepository extends JpaRepository<CloudVendor, String>
{


}
