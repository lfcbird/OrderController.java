package com.pm490.PM490.repository;

import com.pm490.PM490.model.Category;
import com.pm490.PM490.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
